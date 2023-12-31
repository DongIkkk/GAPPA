package com.sixheadword.gappa.user;

import com.sixheadword.gappa.account.Account;
import com.sixheadword.gappa.account.repository.AccountRepository;
import com.sixheadword.gappa.loan.Loan;
import com.sixheadword.gappa.loan.repository.LoanRepository;
import com.sixheadword.gappa.loan.repository.LoanRepositoryImpl;
import com.sixheadword.gappa.user.request.CheckPhoneRequestDto;
import com.sixheadword.gappa.user.request.CheckPwRequestDto;
import com.sixheadword.gappa.user.response.CheckPhoneResponseDto;
import com.sixheadword.gappa.utils.JwtUtil;
import com.sixheadword.gappa.utils.RedisUtil;
import com.sixheadword.gappa.utils.SmsUtil;
import com.sixheadword.gappa.webAlarm.WebAlarm;
import com.sixheadword.gappa.webAlarm.WebAlarmRepository;
import com.sixheadword.gappa.webAlarm.dto.response.WebAlarmResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {

    @Value("{jwt.secret.key}")
    private String JwtSecretKey;

    private final SmsUtil smsUtil;
    private final RedisUtil redisUtil;
    private final BCryptPasswordEncoder encoder;
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final UserCustomRepository userCustomRepository;
    private final WebAlarmRepository webAlarmRepository;
    private final LoanRepository loanRepository;
    private final EntityManager em;

    private static final Long EXPIRATION_TIME = 5 * 60 * 1000L; // 문자인증만료시간(5분)

    // JPA로 사용자 더미데이터 Insert (현재 ddl-auto 설정 create, 후에 해당 메서드 제거 후 ddl-auto: validate 변경)
//    @PostConstruct
//    public void init() {
//        log.info("Insert User Dummy Data");
//
//        /*
//        insert into user (login_id, login_password, phone, name, address, pin_password, state, credit_score)
//        values
//        ("chlgksdbs", "1234", "01012345678", "갓한윤", "대전광역시", "1234", true, 100),
//        ("zosunny", "1234", "01022345678", "해린공주", "대전광역시", "1234", true, 100),
//        ("w8h0412", "1234", "01032345678", "악당동익", "대전광역시", "1234", true, 100),
//        ("gkfdkdle", "1234", "01042345678", "갓파쿠", "대전광역시", "1234", true, 100),
//        ("dragontig98", "1234", "01052345678", "김드래곤타이거", "대전광역시", "1234", true, 100),
//        ("junghun2581", "1234", "01062345678", "흥청망청", "대전광역시", "1234", true, 100);
//        */
//
//        User user1 = new User("chlgksdbs", encoder.encode("1234"), encoder.encode("123456"), "01062057949", "갓한윤", "대전광역시 유성구 덕명동", "101동 101호", "GappaMascot.png");
//        User user2 = new User("zosunny", encoder.encode("1234"), encoder.encode("123456"), "01093529734", "해린공주", "대전광역시 유성구 덕명동", "101동 102호", "GappaMascot.png");
//        User user3 = new User("w8h0412", encoder.encode("1234"), encoder.encode("123456"), "01089536705", "악당동익", "대전광역시 유성구 덕명동", "101동 103호", "GappaMascot.png");
//        User user4 = new User("gkfdkdle", encoder.encode("1234"), encoder.encode("123456"), "01073877808", "갓파쿠", "대전광역시 유성구 덕명동", "101동 104호", "GappaMascot.png");
//        User user5 = new User("dragontig98", encoder.encode("1234"), encoder.encode("123456"), "01034663046", "김드래곤타이거", "대전광역시 유성구 덕명동", "101동 105호", "GappaMascot.png");
//        User user6 = new User("junghun2581", encoder.encode("1234"), encoder.encode("123456"), "01024126237", "흥청망청", "대전광역시 유성구 덕명동", "101동 106호", "GappaMascot.png");
//
//        userRepository.save(user1);
//        userRepository.save(user2);
//        userRepository.save(user3);
//        userRepository.save(user4);
//        userRepository.save(user5);
//        userRepository.save(user6);
//
//        List<User> users = new ArrayList<>();
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//        users.add(user4);
//        users.add(user5);
//        users.add(user6);
//
//        for (int i = 0; i < users.size(); i++) {
//            String accountNumber1 = Integer.toString((int)(Math.random() * 899999) + 100000) + "-" + Integer.toString((int)(Math.random() * 89) + 10) + "-" + Integer.toString((int)(Math.random() * 899999) + 100000);
//            String accountNumber2 = Integer.toString((int)(Math.random() * 899999) + 100000) + "-" + Integer.toString((int)(Math.random() * 89) + 10) + "-" + Integer.toString((int)(Math.random() * 899999) + 100000);
//            String accountNumber3 = Integer.toString((int)(Math.random() * 899999) + 100000) + "-" + Integer.toString((int)(Math.random() * 89) + 10) + "-" + Integer.toString((int)(Math.random() * 899999) + 100000);
//            String accountNumber4 = Integer.toString((int)(Math.random() * 899999) + 100000) + "-" + Integer.toString((int)(Math.random() * 89) + 10) + "-" + Integer.toString((int)(Math.random() * 899999) + 100000);
//            String accountNumber5 = Integer.toString((int)(Math.random() * 899999) + 100000) + "-" + Integer.toString((int)(Math.random() * 89) + 10) + "-" + Integer.toString((int)(Math.random() * 899999) + 100000);
//            String accountNumber6 = Integer.toString((int)(Math.random() * 899999) + 100000) + "-" + Integer.toString((int)(Math.random() * 89) + 10) + "-" + Integer.toString((int)(Math.random() * 899999) + 100000);
//
//            Account account1 = new Account(accountNumber1, "KB국민은행", 1000000L, users.get(i));
//            Account account2 = new Account(accountNumber2, "KEB하나은행", 1000000L, users.get(i));
//            Account account3 = new Account(accountNumber3, "신한은행", 1000000L, users.get(i));
//            Account account4 = new Account(accountNumber4, "우리은행", 1000000L, users.get(i));
//            Account account5 = new Account(accountNumber5, "가파은행", 1000000L, users.get(i));
//            Account account6 = new Account(accountNumber6, "싸피은행", 1000000L, users.get(i));
//
//            accountRepository.save(account1);
//            accountRepository.save(account2);
//            accountRepository.save(account3);
//            accountRepository.save(account4);
//            accountRepository.save(account5);
//            accountRepository.save(account6);
//        }
//    }

    // 로그인
    public ResponseEntity<?> login(Map<String, String> request) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        JwtUtil jwtUtil = new JwtUtil();
        String loginId = request.get("loginId");
        String loginPassword = request.get("loginPassword");

        try {
            User user = userRepository.findByLoginId(loginId);
            if (user != null) {
                if (encoder.matches(loginPassword, user.getLoginPassword())) {
                    Map<String, Object> data = new HashMap<>();
                    data.put("token", jwtUtil.createJwt(Long.toString(user.getUserSeq()), JwtSecretKey));

                    resultMap.put("data", data);
                    resultMap.put("message", "로그인 완료");
                    status = HttpStatus.OK;
                } else {
                    resultMap.put("message", "비밀번호가 일치하지 않습니다.");
                    status = HttpStatus.BAD_REQUEST;
                }
            } else {
                resultMap.put("message", "아이디가 존재하지 않습니다.");
                status = HttpStatus.BAD_REQUEST;
            }
        } catch (Exception e) {
            resultMap.put("message", "로그인 실패");
            resultMap.put("error", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        // 인증과정 생략
        return new ResponseEntity<>(resultMap, status);
    }

    // 회원가입
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseEntity<?> setUserInfo(Map<String, String> request) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus httpStatus = null;
        JwtUtil jwtUtil = new JwtUtil();

        String loginId = request.get("loginId");
        String loginPassword = request.get("loginPassword");
        String phone = request.get("phone");
        String name = request.get("name");
        String address = request.get("address");
        String addressDetail = request.get("addressDetail");

        try {
            User user = new User(loginId, encoder.encode(loginPassword), phone, name, address, addressDetail, "GappaMascot.png");
            userRepository.save(user);

            String accountNumber1 = Integer.toString((int)(Math.random() * 899999) + 100000) + "-" + Integer.toString((int)(Math.random() * 89) + 10) + "-" + Integer.toString((int)(Math.random() * 899999) + 100000);
            String accountNumber2 = Integer.toString((int)(Math.random() * 899999) + 100000) + "-" + Integer.toString((int)(Math.random() * 89) + 10) + "-" + Integer.toString((int)(Math.random() * 899999) + 100000);
            String accountNumber3 = Integer.toString((int)(Math.random() * 899999) + 100000) + "-" + Integer.toString((int)(Math.random() * 89) + 10) + "-" + Integer.toString((int)(Math.random() * 899999) + 100000);
            String accountNumber4 = Integer.toString((int)(Math.random() * 899999) + 100000) + "-" + Integer.toString((int)(Math.random() * 89) + 10) + "-" + Integer.toString((int)(Math.random() * 899999) + 100000);
            String accountNumber5 = Integer.toString((int)(Math.random() * 899999) + 100000) + "-" + Integer.toString((int)(Math.random() * 89) + 10) + "-" + Integer.toString((int)(Math.random() * 899999) + 100000);
            String accountNumber6 = Integer.toString((int)(Math.random() * 899999) + 100000) + "-" + Integer.toString((int)(Math.random() * 89) + 10) + "-" + Integer.toString((int)(Math.random() * 899999) + 100000);

            Account account1 = new Account(accountNumber1, "KB국민은행", 1000000L, user);
            Account account2 = new Account(accountNumber2, "KEB하나은행", 1000000L, user);
            Account account3 = new Account(accountNumber3, "신한은행", 1000000L, user);
            Account account4 = new Account(accountNumber4, "우리은행", 1000000L, user);
            Account account5 = new Account(accountNumber5, "가파은행", 1000000L, user);
            Account account6 = new Account(accountNumber6, "싸피은행", 1000000L, user);

            accountRepository.save(account1);
            accountRepository.save(account2);
            accountRepository.save(account3);
            accountRepository.save(account4);
            accountRepository.save(account5);
            accountRepository.save(account6);

            Map<String, Object> data = new HashMap<>();
            data.put("token", jwtUtil.createJwt(Long.toString(user.getUserSeq()), JwtSecretKey));

            resultMap.put("data", data);
            resultMap.put("message", "회원가입 성공");
            httpStatus = HttpStatus.OK;
        } catch (Exception e) {
            resultMap.put("message", "회원가입 실패");
            resultMap.put("error", e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, httpStatus);
    }

    // 회원정보 수정
    public ResponseEntity<?> modifyUserInfo(Map<String, String> request, Long userSeq) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        String phone = request.get("phone");
        String address = request.get("address");
        String addressDetail = request.get("addressDetail");
        try {
            User user = em.find(User.class, userSeq);
            user.setPhone(phone);
            user.setAddress(address);
            user.setAddressDetail(addressDetail);

            resultMap.put("message", "회원정보 수정 성공");
            status = HttpStatus.OK;
        } catch (Exception e) {
            resultMap.put("message", "회원정보 수정 중 에러 발생");
            resultMap.put("error", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }

    // 회원 탈퇴
    public ResponseEntity<?> deleteUserInfo(Long userSeq) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        try {
            User user = em.find(User.class, userSeq);
            user.setState(false);
            user.setExpiredAt(LocalDateTime.now());

            resultMap.put("messsage", "회원 탈퇴 성공");
            status = HttpStatus.OK;
        } catch (Exception e) {
            resultMap.put("message", "회원 탈퇴 실패");
            resultMap.put("error", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }

    // 신용점수 조회
    public ResponseEntity<?> getUserCreditScore(Long userSeq) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        try {
            int creditScore = userRepository.selectUserCreditScore(userSeq);

            Map<String, Object> data = new HashMap<>();
            data.put("credit_score", creditScore);

            resultMap.put("data", data);
            resultMap.put("message", "신용점수 조회 성공");
            status = HttpStatus.OK;
        } catch (Exception e) {
            resultMap.put("message", "신용점수 조회 실패");
            resultMap.put("error", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }

    // 아이디 중복확인
    public ResponseEntity<?> checkIdDuplication(Map<String, String> request) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        String loginId = request.get("loginId");

        try {
            String existLoginId = userRepository.selectUserLoginIdByLoginId(loginId);

            if (existLoginId != null) {
                Map<String, Object> data = new HashMap<>();
                data.put("code", false);

                resultMap.put("data", data);
                resultMap.put("message", "이미 해당 아이디가 존재합니다.");
            } else {
                Map<String, Object> data = new HashMap<>();
                data.put("code", true);

                resultMap.put("data", data);
                resultMap.put("message", "아이디 중복확인 성공");
            }
            status = HttpStatus.OK;
        } catch (Exception e) {
            resultMap.put("message", "아이디 중복확인 에러");
            resultMap.put("error", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }

    // 전화번호 중복확인
    public CheckPhoneResponseDto checkPhoneDuplication(CheckPhoneRequestDto checkPhoneRequestDto){
        try{
            User user = userCustomRepository.findByPhone(checkPhoneRequestDto.getPhone());
            return CheckPhoneResponseDto.builder()
                        .result(true)
                        .build();
        }catch (Exception e){
            return CheckPhoneResponseDto.builder()
                    .result(false)
                    .build();
        }
    }

    // 간편 비밀번호 설정
    public ResponseEntity<?> setPinPassword(Map<String, String> request, String userSeq) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        try {
            redisUtil.setDataExpire(userSeq, encoder.encode(request.get("pinPassword")), EXPIRATION_TIME);
            resultMap.put("message", "간편 비밀번호 설정 성공, 확인 후 적용됩니다.");
            status = HttpStatus.OK;
        } catch (Exception e) {
            resultMap.put("message", "간편 비밀번호 설정 중 에러가 발생했습니다.");
            resultMap.put("error", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }

    // 간편 비밀번호 확인
    public ResponseEntity<?> checkPinPassword(Map<String, String> request, String userSeq) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        try {
            if (encoder.matches(request.get("pinPassword"), redisUtil.getData(userSeq))) {
                User user = em.find(User.class, Long.parseLong(userSeq));
                user.setPinPassword(encoder.encode(request.get("pinPassword")));

                resultMap.put("message", "간편 비밀번호 확인 완료");
                status = HttpStatus.OK;
            } else {
                resultMap.put("message", "간편 비밀번호가 일치하지 않습니다.");
                status = HttpStatus.BAD_REQUEST;
            }
        } catch (Exception e) {
            resultMap.put("message", "간편 비밀번호 확인 중 에러가 발생했습니다.");
            resultMap.put("error", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }

    // 아이디 찾기
    public ResponseEntity<?> findUserId(Map<String, String> request) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        String name = request.get("name");
        String phone = request.get("phone");

        try {
            String loginId = userRepository.selectUserLoginIdByNameAndPhone(name, phone);
            if (loginId != null) {
                Map<String, Object> data = new HashMap<>();
                data.put("login_id", loginId);

                resultMap.put("data", data);
                resultMap.put("message", "아이디 찾기 성공");
                status = HttpStatus.OK;
            } else {
                resultMap.put("message", "일치하는 아이디가 존재하지 않습니다.");
                status = HttpStatus.BAD_REQUEST;
            }
        } catch (Exception e) {
            resultMap.put("message", "아이디 찾기 중 에러 발생");
            resultMap.put("error", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }

    // 유저 조회
    public ResponseEntity<?> searchUserInfo(Long userSeq, Long loginUserSeq) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        try {
            Map<String, Object> data = new HashMap<>();
            User user = userRepository.findByUserSeq(userSeq);
            if (userSeq.equals(loginUserSeq)) { // 자기 자신의 유저 정보 조회
                List<Loan> borrowLoan = loanRepository.findByFromUser(user);
                int borrowCnt = 0;
                for (int i = 0; i < borrowLoan.size(); i++) {
                    if (borrowLoan.get(i).getStatus() == 'W' || borrowLoan.get(i).getStatus() == 'F') continue;
                    borrowCnt++;
                }

                List<Loan> lendLoan = loanRepository.findByToUser(user);
                int lendCnt = 0;
                for (int i = 0; i < lendLoan.size(); i++) {
                    if (lendLoan.get(i).getStatus() == 'W' || lendLoan.get(i).getStatus() == 'F') continue;
                    lendCnt++;
                }

                List<Loan> loans = loanRepository.findByFromUser(user);
                char loanStatus = 0;
                for (int i = 0; i < loans.size(); i++) {
                    if (loans.get(i).getStatus() == 'D') {          // 연체중
                        loanStatus = 'D';
                        break;
                    } else if (loans.get(i).getStatus() == 'O') {   // 진행중
                        loanStatus = 'O';
                    }
                }

                data.put("profileImg", user.getProfileImg());
                data.put("name", user.getName());
                data.put("phone", user.getPhone());
                data.put("creditScore", user.getCreditScore());
                data.put("address", user.getAddress());
                data.put("addressDetail", user.getAddressDetail());
                data.put("borrowCnt", borrowCnt);
                data.put("lendCnt", lendCnt);
                if (loanStatus == 0) {
                    data.put("status", 'C');
                } else {
                    data.put("status", loanStatus);
                }
                data.put("isMyProfile", true);
            } else {                            // 다른 사람의 유저 정보 조회
                Long overdueCnt = loanRepository.countLoanByRedemptionDateBeforeAndAndFromUser(LocalDateTime.now(), user);
                Long repaymentCnt = loanRepository.countLoanByUserSeq(userSeq);
                List<Loan> loans = loanRepository.findByFromUser(user);
                char loanStatus = 0;

                for (int i = 0; i < loans.size(); i++) {
                    if (loans.get(i).getStatus() == 'D') {          // 연체중
                        loanStatus = 'D';
                        break;
                    } else if (loans.get(i).getStatus() == 'O') {   // 진행중
                        loanStatus = 'O';
                    }
                }
                data.put("profileImg", user.getProfileImg());
                data.put("name", user.getName());
                data.put("phone", user.getPhone());
                data.put("creditScore", user.getCreditScore());
                data.put("address", user.getAddress());
                data.put("addressDetail", user.getAddressDetail());
                data.put("overdueCnt", overdueCnt);
                data.put("repaymentCnt", repaymentCnt);
                if (loanStatus == 0) {
                    data.put("status", 'C');
                } else {
                    data.put("status", loanStatus);
                }
                data.put("isMyProfile", false);
            }

            resultMap.put("data", data);
            resultMap.put("message", "유저 조회 성공");
            status = HttpStatus.OK;
        } catch (Exception e) {
            resultMap.put("message", "유저 조회 중 에러가 발생했습니다.");
            resultMap.put("error", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }

    // 비밀번호 재설정
    public ResponseEntity<?> updateUserPw(Map<String, String> request) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        String loginId = request.get("loginId");
        String loginPassword = request.get("loginPassword");

        try {
            User user = userRepository.findByLoginId(loginId);
            user.setLoginPassword(encoder.encode(loginPassword));

            resultMap.put("message", "비밀번호 재설정 완료! 다시 로그인 해주세요.");
            status = HttpStatus.OK;
        } catch (Exception e) {
            resultMap.put("message", "비밀번호 재설정 중 에러 발생");
            resultMap.put("error", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }

    // 알림 조회
    public ResponseEntity<?> selectUserAlarm(Long userSeq) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        try {
            List<WebAlarmResponseDto> webAlarmResponseDtos = new ArrayList<>();
            List<WebAlarm> webAlarms = webAlarmRepository.findAllByUserSeq(userSeq);

            webAlarms.forEach(webAlarm -> {
                WebAlarmResponseDto webAlarmResponseDto = WebAlarmResponseDto.builder()
                        .webAlarmSeq(webAlarm.getWebAlarmSeq())
                        .fromUserName(webAlarm.getFromUser().getName())
                        .fromUserProfileImg(webAlarm.getFromUser().getProfileImg())
                        .regDate(webAlarm.getRegDate())
                        .isRead(webAlarm.isRead())
                        .readDate(webAlarm.getReadDate())
                        .alarmCategory(webAlarm.getAlarmCategory())
                        .alarmContent(webAlarm.getAlarmContent())
                        .build();

                webAlarmResponseDtos.add(webAlarmResponseDto);
            });

            resultMap.put("data", webAlarmResponseDtos);
            resultMap.put("message", "알림 조회 성공");
            status = HttpStatus.OK;
        } catch (Exception e) {
            resultMap.put("message", "알림 조회 중 에러가 발생했습니다.");
            resultMap.put("error", e.getMessage());
            status = HttpStatus.BAD_REQUEST;
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

    // 비밀번호 찾기 인증
    public ResponseEntity<?> checkVerificationPw(CheckPwRequestDto dto) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        try {
            User user = userCustomRepository.findByLoginId(dto.getId()).orElse(null);

            if (user == null) {
                resultMap.put("message", "아이디를 찾을 수 없습니다.");
                status = HttpStatus.NOT_FOUND;
            } else {
                if (!user.getPhone().equals(dto.getPhone())) {
                    resultMap.put("message", "입력한 핸드폰 번호와 아이디가 일치하지 않습니다.");
                    status = HttpStatus.BAD_REQUEST;
                } else {
                    if (dto.getCode().equals(redisUtil.getData(dto.getPhone()))) {
                        resultMap.put("message", "인증성공");
                        status = HttpStatus.OK;
                    } else {
                        resultMap.put("message", "인증번호가 일치하지 않습니다.");
                        status = HttpStatus.BAD_REQUEST;
                    }
                }
            }
        } catch (Exception e) {
            resultMap.put("message", "인증번호 시간이 만료되었습니다.");
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(resultMap, status);
    }

    // 간편 비밀번호 유효성 검증
    public ResponseEntity<?> checkValidatePinPassword(Map<String, String> request, Long userSeq) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        String pinPassword = request.get("pinPassword");
        try {
            User user = em.find(User.class, userSeq);
            if (encoder.matches(pinPassword, user.getPinPassword())) {
                resultMap.put("message", "간편 비밀번호 확인 성공");
                status = HttpStatus.OK;
            } else {
                resultMap.put("message", "간편 비밀번호가 일치하지 않습니다.");
                status = HttpStatus.BAD_REQUEST;
            }
        } catch (Exception e) {
            resultMap.put("message", "간편 비밀번호 유효성 검증 중 에러 발생");
            resultMap.put("error", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }

    public ResponseEntity<?> checkSingleAlarm(Map<String, String> request, Long userSeq) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        Long webAlarmSeq = Long.parseLong(request.get("webAlarmSeq"));
        try {
            WebAlarm webAlarm = em.find(WebAlarm.class, webAlarmSeq);
            if (webAlarm.getToUser().getUserSeq().equals(userSeq)) {
                webAlarm.setRead(true);
                status = HttpStatus.OK;
            } else {
                status = HttpStatus.BAD_REQUEST;
            }
            resultMap.put("message", "알림 확인 완료");
        } catch (Exception e) {

            resultMap.put("message", "알림 확인 중, 에러 발생");
            resultMap.put("error", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }

    public ResponseEntity<?> checkAllAlarm(Long userSeq) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        try {
            User user = em.find(User.class, userSeq);
            List<WebAlarm> webAlarms = webAlarmRepository.findAllByToUser(user);
            webAlarms.forEach(webAlarm -> {
                if (!webAlarm.isRead()) webAlarm.setRead(true);
            });
            resultMap.put("message", "알림 확인 완료");
            status = HttpStatus.OK;
        } catch (Exception e) {

            resultMap.put("message", "알림 전체 확인 중, 에러 발생");
            resultMap.put("error", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }
}
