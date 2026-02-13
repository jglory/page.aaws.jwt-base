
| 문서 코드 | XYZ-CAB-000003                                                                                                                                      |
| ----- | --------------------------------------------------------------------------------------------------------------------------------------------------- |
| 관련 문서 |                                                                                                                                                     |
| 태그    | [#구현](app://obsidian.md/index.html#%EA%B5%AC%ED%98%84) [#DB_함수_명세서](app://obsidian.md/index.html#DB_%ED%95%A8%EC%88%98_%EB%AA%85%EC%84%B8%EC%84%9C) |

# sp_user_findUserByUserCredential

사용자의 인증정보와 일치하는 사용자 정보를 찾는다.
<br>

## 입력
| 파라미터명    | 타입           | 필수  <br>여부 | 기본 값 | 설명      |
| -------- | ------------ | :--------: | ---- | ------- |
| email    | varchar(512) |     o      |      | 사용자 이메일 |
| password | varchar(521) |     o      |      | 사용자 암호  |

<br>

## 출력
| 파라미터명    | 타입           | 필수  <br>여부 | 기본 값 | 설명         |
| -------- | ------------ | :--------: | ---- | ---------- |
| id       | bigint       |     o      |      | 사용자 정보 아이디 |
| email    | varchar(512) |     o      |      | 사용자 이메일    |
| password | varchar(521) |     o      |      | 사용자 암호     |

<br>

## 실행 코드
```sql
CREATE OR REPLACE PROCEDURE sp_user_findUserByUserCredential(
    p_user_id       IN VARCHAR2,        -- 입력: 사용자 ID
    p_password      IN VARCHAR2,        -- 입력: 사용자 비밀번호
    p_user_name     OUT VARCHAR2,       -- 출력: 사용자 이름
    p_user_email    OUT VARCHAR2        -- 출력: 사용자 이메일
)
IS
BEGIN
    -- 사용자 정보를 검색
    SELECT user_name, user_email
    INTO p_user_name, p_user_email
    FROM user_table
    WHERE user_id = p_user_id
      AND user_password = p_password;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        -- 데이터가 없을 경우 NULL 반환
        p_user_name := NULL;
        p_user_email := NULL;

    WHEN OTHERS THEN
        -- 다른 에러 처리
        RAISE_APPLICATION_ERROR(-20001, 'Unexpected error occurred: ' || SQLERRM);
END sp_user_findUserByUserCredential;
```

<br>