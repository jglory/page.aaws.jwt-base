
| 문서 코드 | XYZ-CAB-000003                                                                                                                                      |
| ----- | --------------------------------------------------------------------------------------------------------------------------------------------------- |
| 관련 문서 |                                                                                                                                                     |
| 태그    | [#구현](app://obsidian.md/index.html#%EA%B5%AC%ED%98%84) [#DB_함수_명세서](app://obsidian.md/index.html#DB_%ED%95%A8%EC%88%98_%EB%AA%85%EC%84%B8%EC%84%9C) |

# fn_user_getUserGradeName

사용자 정보 아이디에 해당하는 사용자의 등급 코드를 정보명으로 돌려준다. 
<br>

## 입력
| 파라미터명    | 타입           | 필수  <br>여부 | 기본 값 | 설명         |
| -------- | ------------ | :--------: | ---- | ---------- |
| id       | bigint       |     o      |      | 사용자 정보 아이디 |

<br>

## 출력
| 타입           | 필수  <br>여부 | 기본 값 | 설명       |
| ------------ | :--------: | ---- | -------- |
| varchar(100) |     o      |      | 사용자 등급 명 |

<br>

## 실행 코드
```sql
CREATE OR REPLACE FUNCTION fn_user_getUserGradeName(p_user_id IN NUMBER)
RETURN VARCHAR2
IS
    v_grade_name VARCHAR2(100);
BEGIN
    -- 사용자 등급 이름을 검색
    SELECT g.grade_name
    INTO v_grade_name
    FROM user_table u
    JOIN grade_table g ON u.grade_id = g.grade_id
    WHERE u.user_id = p_user_id;

    -- 검색된 등급 이름 반환
    RETURN v_grade_name;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        -- 데이터가 없을 경우 기본값 반환
        RETURN 'Unknown Grade';
    WHEN OTHERS THEN
        -- 다른 에러 처리
        RETURN 'Error Occurred';
END fn_user_getUserGradeName;
```