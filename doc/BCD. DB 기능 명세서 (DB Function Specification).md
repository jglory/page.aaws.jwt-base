DB 함수 명세서 문서는 함수의 구조, 사용법, 입력 및 출력 매개변수, 동작 방식, 제약 사항 등 다양한 정보를 포함하는 문서입니다. 명세서는 함수의 기능 만을 설명하는 것을 넘어, 구현 이유와 제약 조건 등을 함께 기록하여 함수에 대한 깊이 있는 이해를 제공합니다.

처리 함수 명세서는 다음 항목을 포함합니다.

- Java Mybatis 동적 쿼리문
- Database Function
- Database Stored Procedure

항목 별로 기술해야 할 문서의 요소는 다음과 같습니다.

<br>

### DB Function

1. 기본 정보
- 이름: Function 이름
- 설명: 역할과 목적을 간략히 설명
<br>
2. 입력
	입력 데이터의 상세한 정보
	
- 파라미터명: 파라미터의 이름을 기재합니다.
- 타입: 파라미터의 데이터 타입을 기재합니다.
- 필수 여부: 필수 여부를 기재합니다.
- 기본값: 기본값을 기재합니다.
- 설명: 파라미터에 대한 설명을 기재합니다.

3. 출력
출력 데이터의 상세한 정보

- 타입: 필드의 데이터 타입을 기재합니다.
- 설명: 필드에 대한 설명을 기재합니다.

4. 실행 코드
실행에 사용되는 소스 코드

<br>
<br>

### DB Stored Procedure

1. 기본 정보
- 이름: Stored Procedure 이름
- 설명: 역할과 목적을 간략히 설명
<br>
2. 입력
	입력 데이터의 상세한 정보
	
- 파라미터명: 파라미터의 이름을 기재합니다.
- 타입: 파라미터의 데이터 타입을 기재합니다.
- IN/OUT: in/out 여부를 기재합니다.
- 필수 여부: 필수 여부를 기재합니다.
- 기본값: 기본값을 기재합니다.
- 설명: 파라미터에 대한 설명을 기재합니다.

3. 출력
출력 데이터의 상세한 정보

- 컬럼명: 컬럼의 이름을 기재합니다.
- 타입: 컬럼의 데이터 타입을 기재합니다.
- 설명: 필드에 대한 설명을 기재합니다.

4. 실행 코드
실행에 사용되는 소스 코드

<br>

## 산출물 양식

### DB Function

![[doc/_files/양식/CAB. DB Function 양식|CAB. DB Function 양식]]
<br>
### DB Stored Procedure

![[doc/_files/양식/CAB. DB Stored Procedure 양식|Stored Procedure 양식]]
<br>
<br>


## 작성


### DB Function

![[doc/_files/양식/CAB. DB Function 작성|CAB. DB Function 작성]]
<br>

### DB Stored Procedure

![[doc/_files/양식/CAB. DB Stored Procedure 작성|CAB. DB Stored Procedure 작성]]

<br>
<br>

## 사례

- DB Function
	[[doc/B 설계/C 데이터 설계/D DB 기능 명세서/Oracle/XYZSHOP/Function/fn_user_getUserGradeName|XYZ-CAB-000003 fn_user_getUserGradeName]]

- DB Stored Procedure
	[[doc/B 설계/C 데이터 설계/D DB 기능 명세서/Oracle/XYZSHOP/Stored Procedure/sp_user_findUserByUserCredential|XYZ-CAB-000003 sp_user_findUserByUserCredential]]

<br>
