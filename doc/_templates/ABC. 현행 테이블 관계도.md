<%*
await tp.user.boot(tp, 'ABC', true);
%>

| 문서 코드 | <% tp.user.doc.id %>                                     |
| ----- | -------------------------------------------------------- |
| 관련 문서 | {{현행 소프트웨어 아키텍쳐 구성도 문서 코드}}<br>{{현행 시스템 아키텍쳐 구성도 문서 코드}} |
| 태그    | #분석 #현행_테이블_관계도                                          |



<br>



[[<% tp.user.canvas.path %>|캔버스 뷰]]



<br>



```plantuml

' hide the spot
hide circle

skinparam defaultFontName "Noto Sans CJK KR"

' avoid problems with angled crows feet
skinparam linetype ortho

skinparam class {     
  BackgroundColor<<to>> #EEEEEE
  BackgroundColor<<t1>> lightblue
  BackgroundColor<<t2>> #EEEEEE
  BackgroundColor<<t3>> #EEEEEE
  BackgroundColor<<t4>> #EEEEEE
  BackgroundColor<<t5>> #EEEEEE
}

entity "테이블명 '설명'" as t0 <<t0>> {
  --
  * 컬럼 '설명'
}

entity "테이블명 '설명'" as t1 <<t1>> {
  --
  * 컬럼 '설명'
  --
  컬럼 '설명'
  컬럼 '설명'
}

entity "테이블명 '설명'" as t2 <<t2>> {
  --
  컬럼 '설명'
}

entity "테이블명 '설명'" as t3 <<t3>> {
  --
  * 컬럼 '설명'
  * 컬럼 '설명'
}

entity "테이블명 '설명'" as t4 <<t4>> {
  --
  컬럼 '설명'
  컬럼 '설명'
}

entity "테이블명 '설명'" as t5 <<t5>> {
  --
  컬럼 '설명'
  컬럼 '설명'
}


t2 ||---o{ t5 : t2.fk - t5.fk
t2 ||---o{ t4 : t2.fk - t4.fk


t1 ||---o{ t3: t1.pk - t3.fk
t1 ||----o{ t5: t1.pk - t5.fk
t1 ||----o{ t4 : t1.pk - t4.fk

t1 ||---o{ t0 : t0.pk - t1.pk

```


