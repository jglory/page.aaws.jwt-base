클래스 구조도(Class Structure Diagram)은 객체 지향 시스템의 정적 구조를 모델링 하는 [UML(Unified Modeling Language)](https://en.wikipedia.org/wiki/Unified_Modeling_Language) 다이어그램의 한 유형입니다. 클래스 다이어그램은 시스템 내의 클래스들 간의 관계를 시각적으로 표현하며, 클래스의 속성(attributes), 메서드(operations), 그리고 클래스 간의 관계를 나타냅니다.

클래스 다이어그램의 주요 구성 요소는 다음과 같습니다:

1. 클래스(Class): 클래스는 사각형으로 표현되며, 일반적으로 세 부분으로 나뉩니다.
    
    - 상단 부분에는 클래스의 이름이 들어갑니다.
    - 중간 부분에는 클래스의 속성(또는 필드)이 명시됩니다.
    - 하단 부분에는 클래스가 수행할 수 있는 메서드(또는 함수)가 명시됩니다.
<br>

2. 관계(Relationship): 클래스 다이어그램에서는 클래스들 사이의 다양한 관계를 표현합니다.

- 집합 관계(Aggregation): 전체와 부분의 관계를 나타내며, 빈 다이아몬드로 표현되며 전체를 나타내는 클래스 쪽에 위치합니다. 집합은 부분 객체가 전체 객체에 속하지만, 생명 주기가 독립적임을 의미합니다. 즉, 전체 객체가 소멸해도 부분 객체는 계속 존재할 수 있습니다.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![[doc/_files/집합(Aggregation).png]]
    
- 합성 관계(Composition): 더 강한 형태의 집합 관계로, 전체가 부분을 소유하며, 부분은 전체 없이는 존재할 수 없습니다. 채워진 다이아몬드로 표현됩니다. 부분 객체의 생명 주기가 전체 객체에 의존적입니다. 즉, 전체 객체가 소멸하면 부분 객체도 함께 소멸합니다.
	
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![[doc/_files/합성(Composition).png]]

- 상속 관계(Inheritance): 한 클래스가 다른 클래스로부터 속성과 메서드를 상속받는 관계를 나타내며, 빈 삼각형 화살표로 표현됩니다.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![[doc/_files/상속(Inheritance).png]]

- 실현 관계(Realization): 인터페이스를 구현하는 클래스 간의 관계를 나타내며, 점선 화살표로 표현됩니다.


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![[doc/_files/실현(Realization).png]]

- 연관 관계(Association): 연관 관계는 두 클래스 사이의 관계를 나타내며, "A 클래스가 B 클래스를 알고 있다"는 의미입니다. 연관 관계가 있으면, 한 클래스의 객체가 다른 클래스의 객체와 연결될 수 있음을 나타냅니다.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![[doc/_files/연관(Association).png]]


- 의존 관계(Dependency): 한 클래스가 다른 클래스의 기능이나 행동에 의존할 때 사용되는 표현입니다. 보통 점선 화살표(dashed arrow)로 나타내며, 화살표의 머리는 의존 대상 클래스를 가리킵니다.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![[doc/_files/의존(Dependency).png]]
<br>

3. 멀티플리시티(Multiplicity): 관계의 양쪽 끝에 표시되며, 클래스 간의 관계에서 하나의 인스턴스가 다른 클래스의 몇 개의 인스턴스와 연관될 수 있는지를 나타냅니다. 예를 들어, "1..*"는 하나의 인스턴스가 0개 이상의 인스턴스와 연관될 수 있음을 의미합니다.
    

클래스 다이어그램은 시스템의 구조를 이해하고, 클래스 간의 관계를 분석하며, 시스템 설계를 문서화하는 데 유용합니다. 소프트웨어 개발 초기 단계에서 시스템의 전체적인 설계를 계획하고, 팀원 간의 커뮤니케이션을 돕는 데에도 중요한 역할을 합니다.
<br>
<br>

### 산출물 양식

![[doc/_files/양식/BBC. 클래스 구조도|BBC. 클래스 구조도]]

### 작성

- 본 문서는 정보 기술의 대상이 되는 클래스를 중심으로 관련된 클래스 간의 관계를 기술하여 주십시오. 
- 정보 기술의 대상이 되는 중심 클래스를 정하는 것은 매우 중요합니다. 소프트웨어 처리에 핵심이 되는 클래스를 선정하여 주십시오. 예를 들어, Controller, Service 가 해당이 되겠습니다. 그 외 필요에 따라 소프트웨어의 복잡성을 설명할 필요가 있는 클래스를 대상으로 하여 주십시오.
- 문서의 위치와 이름은 다음 규칙을 따르도록 합니다.
```
{{문서 폴더 루트}}/B 설계/B 애플리케이션 설계/C 클래스 구조도/{{문서 코드}} {{클래스명}}
```

| 문서 폴더        | 서비스 코드 | 구분 번호  | 클래스명           |
| ------------ | ------ | ------ | -------------- |
| abc/dev-docs | ABC    | 000001 | UserController |
일 경우 문서의 위치는 다음과 같습니다. 
```
abc/dev-docs/B 설계/B 애플리케이션 설계/C 클래스 구조도/IMA-BBC-000001 UserController
```
<br>

1. 문서 정보
	- '문서 코드' 항목은 부가적인 정보를 제외한 문서 코드 만을 기입하여 주십시오.
	- '관련문서' 항목은 해당 문서 열람 시 병행하여 비교 열람하기를 권장하는 문서의 목록입니다. [[BBC. 클래스 구조도 (Class Structure Diagram)#산출물 양식|산출물 양식]]을 참고하여 기입하여 주십시오.
	- '설명' 항목은 해당 문서의 설명을 기입하여 주십시오.
	- '태그' 항목은 특정 주제로 문서를 묶어주기 위하여 적어주는 정보입니다. [[BBC. 클래스 구조도 (Class Structure Diagram)#산출물 양식|산출물 양식]]을 참고하여 기입하여 주십시오.
<br>
2. 캔버스 뷰 링크
	캔버스 뷰 링크는 문서의 가독성을 높이기 위해 해당 문서를 캔버스 형태로 열람할 수 있도록 제공하는 캔버스의 링크입니다.
<br>
3. 본문
	- 해당 문서는 클래스의 구조에 대한 관점을 제공하는 문서로 가독성을 위해 대부분의 경우 속성(attribute), 행동(operation)은 기술하지 않습니다.
	- 정보 기술의 중심이 되는 클래스에 강조를 위해 배경색 `#86f986` 을 설정하여 주십시오.
	- 집합(Aggragation)과 합성(Composition) 관계의 경우 관계선에 관련된 멤버의 이름을 기술하여 주십시오.
	- DI(Dependency Injection)의 경우, 주입물과 주입 대상물이 되는 클래스는  연관(association)을 의미하는 실선으로 연결하고 행동(operation)을 파란 색 글씨로 `<<inject>>`라고 기술하여 주십시오.
	- 클래스가 포함된 패키지 또는 네임스페이스 정보를 기술하여 주십시오.
<br>
<br>

### 예시

[[doc/B 설계/B 애플리케이션 설계/C 클래스 구조도/Controller/com.xyzshop.api.XyzShopController|com.xyzshop.api.XyzShopController]]
<br>
