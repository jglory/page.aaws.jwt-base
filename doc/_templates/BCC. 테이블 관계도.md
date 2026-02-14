<%*
await tp.user.boot(tp, 'BCC', true);
%>

| 문서 코드  | <% tp.user.doc.id %>                                              |
| ------ | ----------------------------------------------------------------- |
| 데이터베이스 | {{데이터베이스}}                                                        |
| 관련 문서  | {{바운디드 컨텍스트 맵 문서 코드}}<br>{{개념 데이터 모델 문서 코드}}<br>{{테이블 정의서 문서 코드}} |
| 태그     | #설계 #테이블_관계도                                                      |
<br>
```plantuml

' hide the spot
hide circle

skinparam defaultFontName "Noto Sans CJK KR"

' avoid problems with angled crows feet
skinparam linetype ortho



entity t0 <<테이블 한글명>> {
  --
  * 컬럼명 '설명'
}

entity t1 <<테이블 한글명>> #lightblue {
  --
  * 컬럼명 '설명'
  --
  컬럼명 '설명'
  컬럼명 '설명'
}

entity t2 <<테이블 한글명>> {
  --
  컬럼명 '설명'
}

entity t3 <<테이블 한글명>> {
  --
  * 컬럼명 '설명'
  * 컬럼명 '설명'
}

entity t4 <<테이블 한글명>> {
  --
  컬럼명 '설명'
  컬럼명 '설명'
}

entity t5 <<테이블 한글명>> {
  --
  컬럼명 '설명'
  컬럼명 '설명'
}


t2 ||---o{ t5 : t2.fk - t5.fk
t2 ||---o{ t4 : t2.fk - t4.fk


t1 ||----o{ t3: t1.fk - t3.fk
t1 ||----o{ t5: t1.fk - t5.fk
t1 ||----o{ t4 : t1.fk - t4.fk

t1 ||---o{ t0 : t1.fk - t0.fk

```
