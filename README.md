
# 전자정부 프레임워크 기반 Spring Boot ToDo 프로젝트

## 📌 목표
전자정부 프레임워크(eGovFrame) 4.1.0과 Spring Boot 2.7.0 기반으로 ToDo 웹 애플리케이션 환경을 구축합니다.

- Spring Boot 2.7.0
- 전자정부프레임워크 4.1.0
- MyBatis
- WAR 배포
- Log4j
- Maven (pom.xml)

## 💡 주요 기능

- `real`/`staging`/`develop`/`local` 로 환경 분리
- 환경별 로깅 셋팅 
- 할 일(ToDo) 등록, 조회, 수정, 삭제 API 구현

## :floppy_disk: ERD
![image](https://github.com/user-attachments/assets/08b71dc3-0193-4f8e-83f8-a95405c6feb8)

## :wrench: 셋팅 방법
1. repository를 fork합니다.
2. fork한 repository를 local에 clone하고 작업합니다.

## 적용점

- boot 2.7.0 + egovFramework 4.1.0
  - egov의 mvc, cmmm, dataaccess, logging 적용
  - mybatis-spring-boot-starter 통해 트랜잭션 처리와 DB 커넥션 풀(HikariCP) 관련 설정 자동 추가
  - mvc 어노테이션 사용 / EgovAbstractServiceImpl 상속
  - mybatis 적용 및 mapper 사용
- maven 환경
- log4j2 설정
- jar 실행 (내장 tomcat 이용 ver)
- 환경별 프로파일 셋팅(로그 레벨 설정 및 로그 파일 프로파일 별 분리하여 저장)
  - intellj idea에 환경변수 설정하여 처리
- crud api 구현 및 간단 예외 처리 (수정 api는 부분 업데이트 적용 + api 테스트 완료)
- 기존 db 덤프하여 로컬 db 생성 및 포트 변경 후 실행 