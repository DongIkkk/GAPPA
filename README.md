# 1:1 소액 대출 서비스 GAPPA

<p align="center">
<img src="https://github.com/DongHyun-Klm/Algorithm/assets/120110806/d63165ee-2ab1-44f5-aca2-dbed0e53210d"/>
</p>

### 🕰️ 프로젝트 기간

#### 23.08.21 ~ 23.10.06(6주)

---

### 🧑‍🤝‍🧑 멤버 구성

| [김정훈](https://github.com/hunsunsoo) | [김동익](https://github.com/DongIkkk) | [김동현](https://github.com/DongHyun-Klm) | [김용범](https://github.com/KyongBeom) | [조해린](https://github.com/zosunny) | [최한윤](https://github.com/chlgksdbs) |
| :------------------------------------: | :----------------------------------: | :------------------------------------: | :----------------------------------------: | :-------------------------------------: | :-------------------------------------: |
|      <img src="https://avatars.githubusercontent.com/u/107869536?v=4" width="100" height="100">       |     <img src="https://avatars.githubusercontent.com/u/110454344?v=4" width="100" height="100">      |      <img src="https://avatars.githubusercontent.com/u/120110806?v=4" width="100" height="100">       |        <img src="https://avatars.githubusercontent.com/u/122436476?v=4" width="100" height="100">         |       <img src="https://avatars.githubusercontent.com/u/104357560?v=4" width="100" height="100">       |       <img src="https://avatars.githubusercontent.com/u/96401350?v=4" width="100" height="100">       |
|  Front-End <br/> Team Leader  |         Front-End          |         Back-End <br/> Infra          |      Front-End       |      Back-End <br/> Infra       |           Back-End           |


---

### 0️⃣ 개요
> GAPPA는 주변 지인과 일어나는 대출에서 발생하는 문제를 해결하고자 <br>
> 은행보다 간편하고, 개인거래보다 안전한 1대1 소액 대출 서비스입니다.

### 1️⃣ 기획 의도

| 은행에서 대출받기 어려울 때 주변 지인과의 간편한 소액대출 |
| ------------------------------------------------------- |

| 프로필 확인을 통해 상대방의 신용도 및 안전 거래 보증 |
| ---------------------------------------- |

| 보안 키보드와 자체 인증서를 통한 개인정보 보호 |
| ---------------------------------------- |

| 개인거래에 취약한 법적 자료를 보충해주는 차용증 제공 |
| ---------------------------------------- |
---

### 2️⃣ 서비스 소개

#### 📌 주요 기능 : 자체 인증서를 통한 간편한 소액대출 
- 기존의 은행에 필요한 복잡한 절차를 간소화
- 연락처 또는 이름 검색을 통해 지인을 검색하고 친구 요청


#### 📌 주요 기능 : 대출 사기를 방지하기 위한 대비책 

- 대출 대상의 프로필을 통한 신용도를 확인하여 안전한 거래 대상인지 확인
- 차용증을 통해 대출 사기에 대한 법적 자료 보충 및 대비책을 제공
- 자체 보안키보드를 통한 사용자 비밀번호 탈취 방지
- 대출 일자에 따른 상태를 자동으로 업데이트 하며, 기한이 지난 대출 건에 대해 강제 이체 기능 제공

#### 📌 주요 기능 : 사용자 편의를 위한 추가적인 서비스 
- PWA 를 사용하여 모바일과 웹 호환
- FCM을 통해 사용자에게 발생한 이벤트를 즉각적으로 알림
- 대출 기한이 가까워지면, 스케줄러를 사용하여 주기적인 알림
- Spring Batch를 사용하여 대출 상태를 관리하며, 대출 기한이 가까워지면 자동 알림


---

### 3️⃣ 아키텍처
<p align="center">
<img src="https://github.com/DongHyun-Klm/Algorithm/assets/120110806/c95bf22f-9eda-439e-b58e-a78952678ef3"/>
</p>

---

### 4️⃣ 기술 소개

### ⚙️ 기술 스택

<div align=left>
<table>
    <tr>
        <td><b>Back-end</b></td>
        <td><img src="https://img.shields.io/badge/Java-11.0.18-007396?style=flat&logo=Java&logoColor=white"/>
<img src="https://img.shields.io/badge/Spring Boot-2.7.15-6DB33F?style=flat-square&logo=Spring Boot&logoColor=white"/>
<img src="https://img.shields.io/badge/Spring Security-3.0.4-6DB33F?style=flat-square&logo=Spring Security&logoColor=white"/>
<br>
<img src="https://img.shields.io/badge/MySQL-8.1-4479A1?style=flat-square&logo=MySQL&logoColor=white"/>
<img src="https://img.shields.io/badge/JPA-59666C?style=flat-square&logo=Hibernate&logoColor=white"/>
<img src="https://img.shields.io/badge/Gradle-C71A36?style=flat-square&logo=Gradle&logoColor=white"/>
<img src="https://img.shields.io/badge/JWT-000000?style=flat-square&logo=JSON Web Tokens&logoColor=white"/>

</td>
    </tr>
    <tr>
    <td><b>Front-end</b></td>
    <td>
<img src="https://img.shields.io/badge/Npm-6.14.18-CB3837?style=flat-square&logo=Npm&logoColor=white"/>
<img src="https://img.shields.io/badge/Node-14.21.3-339933?style=flat-square&logo=Node.js&logoColor=white"/>
<img src="https://img.shields.io/badge/React-18.2.0-61DAFB?style=flat-square&logo=React&logoColor=white"/>
<img src="https://img.shields.io/badge/Redux-8.1.2-764ABC?style=flat-square&logo=Redux&logoColor=white"/>
<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=javascript&logoColor=black"/>
<img src="https://img.shields.io/badge/JSON-000000?style=flat-square&logo=json&logoColor=white"/>
<img src="https://img.shields.io/badge/HTML5-E34F26?style=flat-square&logo=html5&logoColor=white"/>
<img src="https://img.shields.io/badge/CSS3-1572B6?style=flat-square&logo=css3&logoColor=white"/>
    </td>
    </tr>
    <tr>
    <td><b>Infra</b></td>
    <td>
<img src="https://img.shields.io/badge/AWS-232F3E?style=flat-square&logo=amazon aws&logoColor=white"/>
<img src="https://img.shields.io/badge/Docker-4479A1?style=flat-square&logo=Docker&logoColor=white"/>
<img src="https://img.shields.io/badge/NGINX-1.18.0(Ubuntu)-009639?style=flat-square&logo=NGINX&logoColor=white"/>
<img src="https://img.shields.io/badge/Jenkins-2.423-D24939?style=flat-square&logo=Jenkins&logoColor=white"/>
</td>
    <tr>
    <td><b>Tools</b></td>
    <td>
    <img src="https://img.shields.io/badge/Notion-333333?style=flat-square&logo=Notion&logoColor=white"/>
    <img src="https://img.shields.io/badge/GitLab-FCA121?style=flat-square&logo=GitLab&logoColor=white"/>
<img src="https://img.shields.io/badge/JIRA-0052CC?style=flat-square&logo=JIRA Software&logoColor=white"/>
    </td>
    </tr>
</table>
</div>　

---

### 5️⃣ 피그마

<p align="center">
<img src="https://github.com/DongHyun-Klm/Algorithm/assets/120110806/896b292c-3dc9-4cc4-995b-c8c679a5e26c"/>
</p>

### 6️⃣ ERD

<p align="center">
<img src="https://github.com/DongHyun-Klm/Algorithm/assets/120110806/16315274-d12b-496a-ad80-56d3c1688359"/>
</p>

---

### 7️⃣ 요구사항 정의서

<p align="center">
<img src="https://github.com/DongHyun-Klm/Algorithm/assets/120110806/3f4eee52-d9b1-445e-a0ed-f6ec6aff7405"/>
</p>

---

### 8️⃣ 서비스 화면

<h4>1-1. 랜딩페이지</h4>
<p>초기접속 시 1회 서비스 이용방법에 대한 안내를 확인할 수 있습니다.</p>
<h4>1-2. 로그인</h4>
<p>이전에 가입한 아이디와 비밀번호로 로그인할 수 있습니다.</p>
<p>키로거 공격 예방을 위해 자체 보안 키보드를 사용해 비밀번호를 입력합니다.</p>

<img src="https://github.com/hunsunsoo/GAPPA/assets/107869536/90e62947-5d37-461a-aa58-c3a762413b1a" height="400px" width="200px"/>

<h4>2-1. 내 프로필</h4>
<p>내 프로필과 대출현황에 따른 신뢰도를 확인할 수 있습니다.</p>
<h4>2-2. 프로필 수정</h4>
<p>내 프로필 정보를 수정할 수 있습니다.</p>
<h4>2-3. 대표 계좌 변경</h4>
<p>내가 보유한 계좌 중 대출 거래에 사용할 대표 계좌를 선택 및 변경할 수 있습니다.</p>


<img src="https://github.com/hunsunsoo/GAPPA/assets/107869536/ef3b78e4-bd59-4a64-9597-675e3c8676ac" height="400px" width="200px"/>

<h4>3-1. 자체 공인인증서 생성</h4>
<p>자체 공인인증서를 생성할 수 있습니다.</p>

<img src="https://github.com/hunsunsoo/GAPPA/assets/107869536/9b545180-4b34-4278-851c-c19d42ae5c23" height="400px" width="200px"/>

<h4>4-1. 대출 신청 과정</h4>
<p>대출 약관을 동의하고 순서대로 대출굼, 상환일자, 대출사유를 입력합니다.</p>
<p>대출을 요청할 지인을 선택하고 자체공동인증서를 활용해 대출 신청을 완료하면 해당 지인에게 알람이 전송됩니다.</p>

<img src="https://github.com/hunsunsoo/GAPPA/assets/107869536/9ec484bb-845b-4b9d-9f12-87f5dd91e79e" height="400px" width="200px"/>

<h4>5-1. 대출 및 대금 이력 확인</h4>
<p>전체/상환완료/대출중/연체중 등 현황별 대출 및 대금 이력을 확인할 수 있습니다.</p>
<h4>5-2. 대출중인 내역 상세조회</h4>
<p>현재 대출중인 대출 내역을 선택해 상세 정보를 조회할 수 있습니다.</p>
<h4>5-3. 상환하기</h4>
<p>상환하기 버튼을 누르고 상환금액을 설정해 해당 대출 건에 대해 일부 또는 전체 상환이 가능합니다.</p>

<img src="https://github.com/hunsunsoo/GAPPA/assets/107869536/bed06c43-18e1-4148-906f-3440c89c1ff7" height="400px" width="200px"/>

<h4>6-1. 차용증 생성</h4>
<p>현재 연체중인 대출 내역을 선택해 연체일에 따른 이자금액을 포함한 상세 정보를 조회할 수 있습니다.</p>
<h4>6-2. 차용증 PDF 다운</h4>
<p>차용증 생성하기 버튼을 눌러 해당 거래 내역에 대한 차용증을 확인하고 PDF로 다운로드도 가능합니다.</p>

<img src="https://github.com/hunsunsoo/GAPPA/assets/107869536/7314b514-be1a-4979-80e5-5a52ccaafda5" height="400px" width="200px"/>

<h4>7-1. 친구 신청</h4>
<p>핸드폰번호 또는 이름 검색을 통해 지인을 검색하고 친구 요청을 보내면 해당 지인에게 알람이 전송됩니다.</p>

<img src="https://github.com/hunsunsoo/GAPPA/assets/107869536/0496a0c4-3b4c-4b44-b33d-3566ed9bc813" height="400px" width="200px"/>

<h4>8-1. fcm </h4>
<p>fcm을 활용한 푸쉬알림 기능입니다.</p>
<p>알림함을 통해 확인할 수 있습니다.</p>

<img src="https://github.com/hunsunsoo/GAPPA/assets/107869536/6381216b-e62b-4bb6-b150-729bf0974a3d" height="400px" width="200px"/>
<img src="https://github.com/DongHyun-Klm/GAPPA/assets/120110806/6e012201-22f2-477a-9585-4b1a18b2ef96" height="400px" width="200px"/>


---

### 9️⃣ 프로젝트 폴더 구조

## BackEnd

```
📦BackEnd
 ┣ 📂gappa
 ┃ ┣ 📂gradle
 ┃ ┃ ┗ 📂wrapper
 ┃ ┃ ┃ ┣ 📜gradle-wrapper.jar
 ┃ ┃ ┃ ┗ 📜gradle-wrapper.properties
 ┃ ┣ 📂JenkinsFolder
 ┃ ┃ ┗ 📜Jenkinsfile
 ┃ ┣ 📂src
 ┃ ┃ ┣ 📂main
 ┃ ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┃ ┗ 📂sixheadword
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂gappa
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂account
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂request
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SetOthersPrimaryRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SetPrimaryReqeustDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GetAccountResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜GetOthersAccountResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AccountRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AccountRepositoryCustom.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AccountRepositoryImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Account.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AccountController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AccountService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂accountHistory
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂request
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SetAccountTransactionRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜GetAccountTransactionResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AccountHistoryRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AccountHistoryRepositoryCustom.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AccountHistoryRepositoryImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AccountHistory.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AccountHistoryController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AccountHistoryService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂allAccept
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AllAcceptController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂certificate
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂request
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CertificateEncodeDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CertificatePwDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CertificateController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CertificateService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Batch
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AfterPeriodLoanDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂itemProcessor
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AfterPeriodLoanProcessorCustom.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ItemProcessorConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂itemReader
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ItemReaderConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QueueItemReader.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂itemWriter
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AfterPeriodLoanWriterCustom.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ItemWriterConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂job
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜JobConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂step
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜StepConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthenticationConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EncrypterConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜JwtFilter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂creditRating
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CreditRating.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂FCM
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂request
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜FCMTokenDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FCMController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FCMInitializer.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜FCMService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂friendList
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂request
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜FriendDeleteListRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜FriendListResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FriendList.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FriendListController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FriendListRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜FriendListService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂friendRequest
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂request
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜FriendSearchFriendsUserDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜FriendRequestListResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FriendRequest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FriendRequestController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FriendRequestRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜FriendRequestService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂loan
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoanController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MoneyController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂request
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FailLoanRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoanInfoRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RedemptionRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SuccessLoanRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GetLoanOppResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GetLoanRequestResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜GetLoanResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoanRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoanRepositoryCustom.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LoanRepositoryImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoanService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MoneyService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Loan.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂loanHistory
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂request
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SetLoanTransactionRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GetLoanHistoryResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜GetLoanTransactionResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoanHistory.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Type.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoanHistoryRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoanHistoryRepositoryCustom.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LoanHistoryRepositoryImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoanHistoryController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LoanHistoryService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂messageAlarm
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MessageAlarm.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂terms
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Terms.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂termsHistory
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂domain
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜TermsHistory.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TermsHistoryId.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂user
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂request
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CheckPhoneRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CheckPwRequestDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CheckPhoneResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜User.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserCustomRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂utils
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BatchScheduler.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtUtil.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RedisUtil.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RSAUtil.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SmsUtil.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂webAlarm
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WebAlarmResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜WebAlarm.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜WebAlarmRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WebAlarmService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜GappaApplication.java
 ┃ ┃ ┃ ┗ 📂resources
 ┃ ┃ ┃ ┃ ┣ 📜application.yml
 ┃ ┃ ┃ ┃ ┗ 📜certification.json
 ┃ ┃ ┗ 📂test
 ┃ ┃ ┃ ┗ 📂java
 ┃ ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┃ ┗ 📂sixheadword
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂gappa
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂utils
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RedisUtilTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RSAUtilTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SmsUtilTest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜GappaApplicationTests.java
 ┃ ┣ 📜.gitignore
 ┃ ┣ 📜build.gradle
 ┃ ┣ 📜Dockerfile
 ┃ ┣ 📜gradlew
 ┃ ┣ 📜gradlew.bat
 ┃ ┗ 📜settings.gradle
 ┗ 📜.gitkeep
```

## FrontEnd

```
📦FrontEnd
 ┣ 📂public
 ┣ 📂src
 ┃ ┣ 📂components
 ┃ ┃ ┣ 📂404
 ┃ ┃ ┃ ┗ 📜NotFound.jsx
 ┃ ┃ ┣ 📂api
 ┃ ┃ ┃ ┗ 📜customAxios.js
 ┃ ┃ ┣ 📂Auth
 ┃ ┃ ┃ ┣ 📜AgreementPage.jsx
 ┃ ┃ ┃ ┣ 📜AgreementPage.module.css
 ┃ ┃ ┃ ┣ 📜BankBookPage.jsx
 ┃ ┃ ┃ ┣ 📜BankBookPage.module.css
 ┃ ┃ ┃ ┣ 📜branding.jsx
 ┃ ┃ ┃ ┣ 📜branding.module.css
 ┃ ┃ ┃ ┣ 📜Find.module.css
 ┃ ┃ ┃ ┣ 📜FindCheck.jsx
 ┃ ┃ ┃ ┣ 📜FindId.jsx
 ┃ ┃ ┃ ┣ 📜FindPassword.jsx
 ┃ ┃ ┃ ┣ 📜FindPasswordChange.jsx
 ┃ ┃ ┃ ┣ 📜Headers.jsx
 ┃ ┃ ┃ ┣ 📜Headers.module.css
 ┃ ┃ ┃ ┣ 📜Keyboard.jsx
 ┃ ┃ ┃ ┣ 📜Keyboard.module.css
 ┃ ┃ ┃ ┣ 📜LandingPage.jsx
 ┃ ┃ ┃ ┣ 📜LandingPage.module.css
 ┃ ┃ ┃ ┣ 📜LoginPage.jsx
 ┃ ┃ ┃ ┣ 📜LoginPage.module.css
 ┃ ┃ ┃ ┣ 📜MasterBankBookPage.jsx
 ┃ ┃ ┃ ┣ 📜MasterBankBookPage.module.css
 ┃ ┃ ┃ ┣ 📜PinPassword.jsx
 ┃ ┃ ┃ ┣ 📜PinPassword.module.css
 ┃ ┃ ┃ ┣ 📜PinPasswordCheckPage.jsx
 ┃ ┃ ┃ ┣ 📜PinPasswordCheckPage.module.css
 ┃ ┃ ┃ ┣ 📜PinPasswordConfirm.jsx
 ┃ ┃ ┃ ┣ 📜PinPasswordVerify.jsx
 ┃ ┃ ┃ ┣ 📜SignupForm.jsx
 ┃ ┃ ┃ ┣ 📜SignupPage.jsx
 ┃ ┃ ┃ ┗ 📜SignupPage.module.css
 ┃ ┃ ┣ 📂Certificate
 ┃ ┃ ┃ ┣ 📜Certificate.module.css
 ┃ ┃ ┃ ┣ 📜CertificatePage.jsx
 ┃ ┃ ┃ ┣ 📜CertIssuePage.jsx
 ┃ ┃ ┃ ┣ 📜CertIssuePage.module.css
 ┃ ┃ ┃ ┣ 📜koreanConverter.jsx
 ┃ ┃ ┃ ┣ 📜MyCertificate.module.css
 ┃ ┃ ┃ ┗ 📜MyCertificatePage.jsx
 ┃ ┃ ┣ 📂Common
 ┃ ┃ ┃ ┣ 📜Footer.jsx
 ┃ ┃ ┃ ┣ 📜Footer.module.css
 ┃ ┃ ┃ ┣ 📜Header.jsx
 ┃ ┃ ┃ ┣ 📜Header.module.css
 ┃ ┃ ┃ ┗ 📜HeaderSub.jsx
 ┃ ┃ ┣ 📂Friends
 ┃ ┃ ┃ ┣ 📜FriendsAddPage.jsx
 ┃ ┃ ┃ ┣ 📜FriendsAddPage.module.css
 ┃ ┃ ┃ ┣ 📜FriendsPage.jsx
 ┃ ┃ ┃ ┣ 📜FriendsPage.module.css
 ┃ ┃ ┃ ┣ 📜FriendsReqPage.jsx
 ┃ ┃ ┃ ┗ 📜FriendsReqPage.module.css
 ┃ ┃ ┣ 📂Home
 ┃ ┃ ┃ ┣ 📜AccountDetail.jsx
 ┃ ┃ ┃ ┣ 📜AccountDetail.module.css
 ┃ ┃ ┃ ┣ 📜HomeAccount.jsx
 ┃ ┃ ┃ ┣ 📜HomeAccount.module.css
 ┃ ┃ ┃ ┣ 📜HomePage.jsx
 ┃ ┃ ┃ ┣ 📜HomePage.module.css
 ┃ ┃ ┃ ┣ 📜NowTransaction.jsx
 ┃ ┃ ┃ ┗ 📜NowTranscation.module.css
 ┃ ┃ ┣ 📂Loan
 ┃ ┃ ┃ ┣ 📂Borrow
 ┃ ┃ ┃ ┃ ┣ 📜ReqAgreement.module.css
 ┃ ┃ ┃ ┃ ┣ 📜ReqAgreementPage.jsx
 ┃ ┃ ┃ ┃ ┣ 📜ReqBorrow.module.css
 ┃ ┃ ┃ ┃ ┣ 📜ReqBorrowPage.jsx
 ┃ ┃ ┃ ┃ ┣ 📜ReqChat.module.css
 ┃ ┃ ┃ ┃ ┣ 📜ReqChatPage.jsx
 ┃ ┃ ┃ ┃ ┣ 📜ReqFriends.module.css
 ┃ ┃ ┃ ┃ ┗ 📜ReqFriendsPage.jsx
 ┃ ┃ ┃ ┣ 📂History
 ┃ ┃ ┃ ┃ ┣ 📜HistoryBorrow.module.css
 ┃ ┃ ┃ ┃ ┣ 📜HistoryBorrowPage.jsx
 ┃ ┃ ┃ ┃ ┣ 📜HistoryDetail.module.css
 ┃ ┃ ┃ ┃ ┣ 📜HistoryDetailPage.jsx
 ┃ ┃ ┃ ┃ ┣ 📜HistoryLend.module.css
 ┃ ┃ ┃ ┃ ┗ 📜HistoryLendPage.jsx
 ┃ ┃ ┃ ┣ 📂Lend
 ┃ ┃ ┃ ┃ ┣ 📜LendCheckPage.jsx
 ┃ ┃ ┃ ┃ ┣ 📜LendCheckPage.module.css
 ┃ ┃ ┃ ┃ ┣ 📜LendCompletePage.jsx
 ┃ ┃ ┃ ┃ ┣ 📜LendCompletePage.module.css
 ┃ ┃ ┃ ┃ ┣ 📜LendListPage.jsx
 ┃ ┃ ┃ ┃ ┣ 📜LendListPage.module.css
 ┃ ┃ ┃ ┃ ┣ 📜LendPage.jsx
 ┃ ┃ ┃ ┃ ┣ 📜LendPage.module.css
 ┃ ┃ ┃ ┃ ┣ 📜LendSendPage.jsx
 ┃ ┃ ┃ ┃ ┗ 📜LendSendPage.module.css
 ┃ ┃ ┃ ┗ 📂Repayment
 ┃ ┃ ┃ ┃ ┣ 📜Repayment.module.css
 ┃ ┃ ┃ ┃ ┗ 📜RepaymentPage.jsx
 ┃ ┃ ┣ 📂Notification
 ┃ ┃ ┃ ┣ 📜FCM.jsx
 ┃ ┃ ┃ ┣ 📜FCMPage.module.css
 ┃ ┃ ┃ ┣ 📜NotificationPage.jsx
 ┃ ┃ ┃ ┗ 📜NotificationPage.module.css
 ┃ ┃ ┣ 📂Profile
 ┃ ┃ ┃ ┣ 📜MainAccountEdit.module.css
 ┃ ┃ ┃ ┣ 📜MainAccountEditPage.jsx
 ┃ ┃ ┃ ┣ 📜Profile.module.css
 ┃ ┃ ┃ ┣ 📜ProfileEdit.module.css
 ┃ ┃ ┃ ┣ 📜ProfileEditPage.jsx
 ┃ ┃ ┃ ┗ 📜ProfilePage.jsx
 ┃ ┃ ┗ 📂Sidebar
 ┃ ┃ ┃ ┣ 📜CustomerService.module.css
 ┃ ┃ ┃ ┣ 📜CustomerServicePage.jsx
 ┃ ┃ ┃ ┣ 📜GuidePage.jsx
 ┃ ┃ ┃ ┣ 📜GuidePage.module.css
 ┃ ┃ ┃ ┣ 📜Notice.module.css
 ┃ ┃ ┃ ┣ 📜NoticePage.jsx
 ┃ ┃ ┃ ┣ 📜QnA.module.css
 ┃ ┃ ┃ ┗ 📜QnAPage.jsx
 ┃ ┣ 📂fonts
 ┃ ┃ ┗ 📂The_Jamsil_TTF
 ┃ ┃ ┃ ┣ 📜Gwangyang Touching(TTF용).ttf
 ┃ ┃ ┃ ┣ 📜LINESeedKR-Bd.ttf
 ┃ ┃ ┃ ┣ 📜LINESeedKR-Rg.ttf
 ┃ ┃ ┃ ┣ 📜LINESeedKR-Th.ttf
 ┃ ┃ ┃ ┣ 📜The Jamsil 1 Thin.ttf
 ┃ ┃ ┃ ┣ 📜The Jamsil 2 Light.ttf
 ┃ ┃ ┃ ┣ 📜The Jamsil 3 Regular.ttf
 ┃ ┃ ┃ ┣ 📜The Jamsil 4 Medium.ttf
 ┃ ┃ ┃ ┣ 📜The Jamsil 5 Bold.ttf
 ┃ ┃ ┃ ┗ 📜The Jamsil 6 ExtraBold.ttf
 ┃ ┣ 📂store
 ┃ ┃ ┣ 📜authslice.js
 ┃ ┃ ┗ 📜index.js
 ┃ ┣ 📜App.css
 ┃ ┣ 📜App.js
 ┃ ┣ 📜App.test.js
 ┃ ┣ 📜firebase-messaging-sw.js
 ┃ ┣ 📜index.css
 ┃ ┣ 📜index.js
 ┃ ┣ 📜logo.svg
 ┃ ┣ 📜reportWebVitals.js
 ┃ ┣ 📜service-worker.js
 ┃ ┣ 📜serviceWorkerRegistration.js
 ┃ ┣ 📜setupProxy.js
 ┃ ┗ 📜setupTests.js
 ┣ 📜.gitignore
 ┣ 📜.gitkeep
 ┣ 📜404error.jpg
 ┣ 📜dockerfile
 ┣ 📜Jenkinsfile
 ┣ 📜package-lock.json
 ┣ 📜package.json
 ┣ 📜README.md
 ┗ 📜robots.txt
```
