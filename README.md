# SpringBoot에서 JWT token을 이용한 인증
## 프로젝트 설명

SpringBoot Security를 이용한 인증 연습 프로젝트
유저의 회원가입의 중복검사, 아이디 비밀번호 암호화와 비밀번호 체크
로그인시 JWT Token발급 권한부여, filterchain을 통해 접근제어등을 연습한 프로젝트입니다

## EndPoint
- join
```
POST /api/v1/users/join
```