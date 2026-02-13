
| 문서 코드 | {{서비스코드}}-BBC-{{구분번호}}                                            |
| ----- | ----------------------------------------------------------------- |
| 관련 문서 | {{[[../../AAC. 바운디드 컨텍스트 맵 (Bounded Context Map)\|바운디드 컨텍스트 맵]] 문서 코드}} |
| 설명    | {{설명}}                                                            |
| 태그    | `#설계` `#클래스_구조도`                                                  |
<br>

`[[B 설계/B 애플리케이션 설계/C 클래스 구조도/canvas/{{서비스코드}}-BBC-{{구분번호}}|캔버스 뷰]]`

<br>

```plantuml
set namespaceSeparator none

skinparam defaultFontName "Noto Sans CJK KR"
skinparam shadowing true
skinparam linetype ortho

skinparam classBorderThickness 1
skinparam packageBorderThickness 1.5
skinparam packageBorderThickness 0.5

skinparam class {
    BackgroundColor #fefece
    BorderColor #ab1040
    ArrowFontName Impact
    ArrowColor #ab1040
    ArrowFontColor #777777
}

hide circle


hide empty fields
hide empty methods
package "com.abc.dto.entry" <<Rectangle>>  {
     class "UserInfo" as com.abc.dto.entry.UserInfo   {
        
    }
    
}
package "com.abc.api.controller" <<Rectangle>>  {
     class "MyController" as com.abc.api.controller.MyController  #86f986 {
        
    }
    
}
package "com.abc.api.repository" <<Rectangle>>  {
     interface "MyRepository" as com.abc.api.repository.MyRepository   {
        
    }
     class "MyRepositoryImpl" as com.abc.api.repository.MyRepositoryImpl   {
        
    }
    
}
package "com.abc.application.constant" <<Rectangle>>  {
     class "Const" as com.abc.application.constant.Const   {
        
    }
    
}
package "com.abc.dto.member" <<Rectangle>>  {
     class "Member" as com.abc.dto.member.Member   {
        
    }
    
}
package "com.abc.api.service" <<Rectangle>>  {
     class "MyServiceImpl" as com.abc.api.service.MyServiceImpl   {
        
    }
     interface "MyService" as com.abc.api.service.MyService   {
        
    }
    
}

com.abc.api.service.MyServiceImpl  --  com.abc.api.controller.MyController #text:blue : <<inject>>
com.abc.api.controller.MyController "1" o-- "1" com.abc.api.service.MyService  : myService
com.abc.api.service.MyServiceImpl  ..|>  com.abc.api.service.MyService 
com.abc.api.controller.MyController  ....>  com.abc.dto.entry.UserInfo 
com.abc.api.controller.MyController  ....>  com.abc.dto.member.Member
com.abc.api.repository.MyRepository "1" o-- "1" com.abc.api.service.MyService  : myRepository
com.abc.api.controller.MyController  ....>  com.abc.application.constant.Const 
com.abc.api.repository.MyRepositoryImpl  ..|>  com.abc.api.repository.MyRepository 
com.abc.api.repository.MyRepositoryImpl  --  com.abc.api.service.MyServiceImpl #text:blue : <<inject>>
```


