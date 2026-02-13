
| 문서 코드 | XYZ-BBC-000001                                                |
| ----- | ------------------------------------------------------------- |
| 관련 문서 | [[../../../../A 분석/A 업무 분석/C 바운디드 컨텍스트 맵/바운디드 컨텍스트 맵\|XYZ-AAC-000001]] |
| 태그    | #설계 #클래스_구조도                                                  |
<br>

[[canvas/XYZ-BBC-000001.canvas|캔버스 뷰]]

<br>


```plantuml
set namespaceSeparator none

skinparam defaultFontName "Noto Sans CJK KR"
skinparam shadowing true
skinparam linetype ortho

skinparam defaultFontStyle plain

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
package "com.xyzshop.api.repository.order" <<Rectangle>>  {
     class "OrderDao" as com.xyzshop.api.repository.order.OrderDao   {
        
    }
    
}
package "com.xyzshop.application.constant" <<Rectangle>>  {
     class "Const" as com.xyzshop.application.constant.Const   {
        
    }
    
}
package "com.xyzshop.api.dto.order.response" <<Rectangle>>  {
     class "OrderResponseDto" as com.xyzshop.api.dto.order.response.OrderResponseDto   {
        
    }
    
}
package "com.xyzshop.api.dto.order.request" <<Rectangle>>  {
     class "OrderRequestDto" as com.xyzshop.api.dto.order.request.OrderRequestDto   {
        
    }
    
}
package "com.xyzshop.api.service.member" <<Rectangle>>  {
     class "MemberServiceImpl" as com.xyzshop.api.service.member.MemberServiceImpl   {
        
    }
     interface "MemberService" as com.xyzshop.api.service.member.MemberService   {
        
    }
    
}
package "com.xyzshop.api.repository.member" <<Rectangle>>  {
     class "MemberDao" as com.xyzshop.api.repository.member.MemberDao   {
        
    }
    
}
package "com.xyzshop.base.config" <<Rectangle>>  {
     class "Config" as com.xyzshop.base.config.Config   {
        
    }
    
}
package "com.xyzshop.api.service.order" <<Rectangle>>  {
     class "OrderServiceImpl" as com.xyzshop.api.service.order.OrderServiceImpl   {
        
    }
     interface "OrderService" as com.xyzshop.api.service.order.OrderService   {
        
    }
    
}
package "com.xyzshop.api" <<Rectangle>>  {
     interface "Controller" as com.xyzshop.api.Controller   {
        
    }
     class "XyzShopController" as com.xyzshop.api.XyzShopController  #86f986 {
        
    }
    
}

com.xyzshop.api.XyzShopController  ....>  com.xyzshop.api.dto.order.response.OrderResponseDto 
com.xyzshop.api.service.order.OrderServiceImpl  --  com.xyzshop.api.XyzShopController #text:blue : <<inject>>
com.xyzshop.api.XyzShopController "1" o-- "1" com.xyzshop.api.service.order.OrderService  : orderService
com.xyzshop.api.XyzShopController  ....>  com.xyzshop.base.config.Config 
com.xyzshop.api.XyzShopController  ..|>  com.xyzshop.api.Controller 
com.xyzshop.api.XyzShopController "1" o-- "1" com.xyzshop.api.service.member.MemberService  : memberService
com.xyzshop.api.XyzShopController  ....>  com.xyzshop.application.constant.Const 
com.xyzshop.api.XyzShopController  ....>  com.xyzshop.api.dto.order.request.OrderRequestDto 
com.xyzshop.api.service.member.MemberServiceImpl  ..|>  com.xyzshop.api.service.member.MemberService 
com.xyzshop.api.service.order.OrderServiceImpl "1" o-- "1" com.xyzshop.api.repository.order.OrderDao  : orederDao
com.xyzshop.api.service.order.OrderServiceImpl  ..|>  com.xyzshop.api.service.order.OrderService 
com.xyzshop.api.service.member.MemberServiceImpl "1" o-- "1" com.xyzshop.api.repository.member.MemberDao  : memberDao
com.xyzshop.api.service.member.MemberServiceImpl  --  com.xyzshop.api.XyzShopController #text:blue : <<inject>>
```
