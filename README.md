# backend-performance-improvement

**backend-performance-improvement** 는 성능을 개선하는 방법과 부하 관련 테스트 내용을 제공합니다. <br>
성능 개선을 위한 캐싱, 인덱스, 비동기처리 적용 후 부하 테스트, 모니터링을 통한 개선결과 및 올바른 적용 방안<br>적용 시 발생한 이슈처리
<br><br>

#### nGrinder 부하테스트
<img width="900" alt="nGrinder-test" src="https://github.com/user-attachments/assets/9548ce57-9331-4e19-b2cd-9347430ff72a" />

<br><br> 

#### Scouter 모니터링
<img width="1200" alt="Scouter-tool" src="https://github.com/user-attachments/assets/2fde9ed6-000f-41f5-87c6-3f417ad40382" />

<br><br>

## 🔧 **기술 스택**

- **프레임워크:** Spring Boot 3.3.2
- **ORM:** JPA / QueryDSL
- **언어:** Java 17
- **데이터베이스:** PostgreSQL/MySQL
- **API명세:** Swagger

<br><br>

## 🛠️ **주요 기능**
- **부하테스트:** ngrinder
- **모니터링:** 스카우트 모니터링
- **더미데이터**
- **캐싱 조회 성능 개선:** 어플리케이션 레벨 캐싱(Ehcache) 사용 
  -  🛠️ [부하테스트 및 성능개선(캐싱)](https://kodh.notion.site/15c0056a044880b9b3c5e37fb695bbb7?pvs=74)
  - 60000건의 데이터 조회 시 캐싱 전/후 부하테스트 및 개선결과
  - 페이징 조회 시 캐싱 전/후 부하테스트 및 개선결과(condition option)
- **인덱스 활용** 
  - 🛠️ [부하테스트 및 성능개선(인덱스)](https://kodh.notion.site/1680056a04488075b6f0d90ee08f4e78)
  - 카디널리티를 고려한 인덱스 적용
  - 인덱스 적용 전/후 부하테스트 및 개선결과
  - 실행계획 및 상황에 맞는 인덱스 적용
- **비동기 방식 적용 및 활용:** 
  - 🛠️ [동기/비동기 메일발송 부하테스트 성능개선/이슈처리](https://kodh.notion.site/16a0056a044880fc9d0af2c4c2ee1a06)
  - 메일 발송 API 동기/비동기 처리 부하테스트 및 개선결과
  - 비동기 적용 시 부하테스트 조건에 따른 이슈 해결
  - 요청에 따른 스레드풀 자원 고려, 설정 

## 💾️ **개선 및 부하테스트 정리**
- 💾 [백엔드 성능 개선 총 정리](https://kodh.notion.site/15a0056a044880ed85aeea31b4307329?pvs=74)
  - nGrinder, Scouter 초기설정
  - 부하테스트, 모니터링 개념
  - 캐싱, 인덱스, 비동기처리 적용 시 고려사항, 개선결과

<br>

