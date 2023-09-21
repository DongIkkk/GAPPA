package com.sixheadword.gappa.user;

import com.sixheadword.gappa.utils.JwtUtil;
import com.sixheadword.gappa.utils.RedisUtil;
import com.sixheadword.gappa.utils.SmsUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    @Value("{jwt.secret.key}")
    private String JwtSecretKey;

    private final SmsUtil smsUtil;
    private final RedisUtil redisUtil;
    private final UserRepository userRepository;
    private static final int EXPIRATION_TIME = 300000; // 문자인증만료시간(5분)

    // 로그인
    public ResponseEntity<?> login(Map<String, String> request) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        JwtUtil jwtUtil = new JwtUtil();

        try {
            User user = userRepository.findByLoginIdAndLoginPassword(request.get("loginId"), request.get("loginPassword"));
            resultMap.put("token", jwtUtil.createJwt(user.getName(), JwtSecretKey));
            resultMap.put("message", "로그인 완료");
            status = HttpStatus.OK;
        } catch (Exception e) {
            resultMap.put("message", "로그인 실패");
            resultMap.put("error", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        // 인증과정 생략
        return new ResponseEntity<>(resultMap, status);
    }

    // 신용점수 조회
    public ResponseEntity<?> getUserCreditScore(String loginId) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        try {
            /*
            ** 신용점수 조회 로직 구현 필요
             */
            resultMap.put("login_id", loginId);
            resultMap.put("message", "신용점수 조회 성공");
            status = HttpStatus.OK;
        } catch (Exception e) {
            resultMap.put("message", "신용점수 조회 실패");
            resultMap.put("error", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }

    // 휴대폰 인증번호 메세지 전송
    public ResponseEntity<?> sendVerificationCode(Map<String, String> request) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        String phoneNumber = request.get("phoneNumber");
        Random rand = new Random();
        int number = rand.nextInt(1000000);
        String strNumber = String.format("%06d", number);
        redisUtil.setDataExpire(phoneNumber, strNumber, EXPIRATION_TIME);
        try {
            smsUtil.sendSMS(phoneNumber, smsUtil.makeSmsContent(strNumber));
            resultMap.put("message", "전송완료");
            status = HttpStatus.OK;
        } catch (Exception e) {
            resultMap.put("message", "전송 실패");
            resultMap.put("exception", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(resultMap, status);
    }

    // 휴대폰 인증번호 확인
    public ResponseEntity<?> checkVerificationCode(Map<String, String> request) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        String phoneNumber = request.get("phoneNumber");
        String code = request.get("code");
        boolean verified = code.equals(redisUtil.getData(phoneNumber));
        if (verified) {
            resultMap.put("message", "인증완료");
            status = HttpStatus.ACCEPTED;
        } else {
            resultMap.put("message", "인증실패");
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(resultMap, status);
    }
}