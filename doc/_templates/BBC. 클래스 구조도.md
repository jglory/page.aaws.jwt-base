<%*
await tp.user.boot(tp, 'BBC', true);
%>

| 문서 코드 | <% tp.user.doc.id %>                         |
| ----- | -------------------------------------------- |
| 관련 문서 | {{개념 데이터 모델 문서 코드}}<br>{{바운디드 컨텍스트 맵 문서 코드}} |
| 태그    | #설계 #클래스_구조도                                 |
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
package "com.lotteimall.dto.entry" <<Rectangle>>  {
     class "UserInfo" as com.lotteimall.dto.entry.UserInfo   {
        
    }
    
}
package "com.lotteimall.api.controller.mylotte" <<Rectangle>>  {
     class "MyLotteController" as com.lotteimall.api.controller.mylotte.MyLotteController  #86f986 {
        
    }
    
}
package "com.lotteimall.api.repository.mylotte" <<Rectangle>>  {
     interface "MyLotteRepository" as com.lotteimall.api.repository.mylotte.MyLotteRepository   {
        
    }
     class "MyLotteRepositoryImpl" as com.lotteimall.api.repository.mylotte.MyLotteRepositoryImpl   {
        
    }
    
}
package "com.lotteimall.application.constant" <<Rectangle>>  {
     class "Const" as com.lotteimall.application.constant.Const   {
        
    }
    
}
package "com.mall.interfaces.dto.lottemembers" <<Rectangle>>  {
     class "LotteMembers" as com.mall.interfaces.dto.lottemembers.LotteMembers   {
        
    }
    
}
package "com.lotteimall.api.service.mylotte" <<Rectangle>>  {
     class "MyLotteServiceImpl" as com.lotteimall.api.service.mylotte.MyLotteServiceImpl   {
        
    }
     interface "MyLotteService" as com.lotteimall.api.service.mylotte.MyLotteService   {
        
    }
    
}

com.lotteimall.api.service.mylotte.MyLotteServiceImpl  --  com.lotteimall.api.controller.mylotte.MyLotteController #text:blue : <<inject>>
com.lotteimall.api.controller.mylotte.MyLotteController "1" o-- "1" com.lotteimall.api.service.mylotte.MyLotteService  : mylotteService
com.lotteimall.api.service.mylotte.MyLotteServiceImpl  ..|>  com.lotteimall.api.service.mylotte.MyLotteService 
com.lotteimall.api.controller.mylotte.MyLotteController  ....>  com.lotteimall.dto.entry.UserInfo 
com.lotteimall.api.controller.mylotte.MyLotteController  ....>  com.mall.interfaces.dto.lottemembers.LotteMembers
com.lotteimall.api.repository.mylotte.MyLotteRepository "1" o-- "1" com.lotteimall.api.service.mylotte.MyLotteService  : mylotteRepository
com.lotteimall.api.controller.mylotte.MyLotteController  ....>  com.lotteimall.application.constant.Const 
com.lotteimall.api.repository.mylotte.MyLotteRepositoryImpl  ..|>  com.lotteimall.api.repository.mylotte.MyLotteRepository 
com.lotteimall.api.repository.mylotte.MyLotteRepositoryImpl  --  com.lotteimall.api.service.mylotte.MyLotteServiceImpl #text:blue : <<inject>>
```
