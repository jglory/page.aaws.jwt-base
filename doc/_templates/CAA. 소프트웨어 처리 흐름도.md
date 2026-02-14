<%*
await tp.user.boot(tp, 'CAA', true);
%>

| 문서 코드     | <% tp.user.doc.id %>                                                              |
| --------- | --------------------------------------------------------------------------------- |
| 관련 문서     | {{화면설계서(SB) 화면코드}}/{{항목번호}}<br>{{소프트웨어 아키텍쳐 구성도 문서 코드}}<br>{{시스템 아키텍쳐 구성도 문서 코드}} |
| 애플리케이션 유형 | <% tp.user.doc.applicationType %>                                                 |
| 업무 구분     | <% tp.user.doc.jobType %>                                                         |
| 설명        | {{설명}}                                                                            |
| 태그        | #구현 #소프트웨어_처리_흐름도`#{{화면설계서(SB) 화면코드}}/{{항목번호}}`                                   |
<br>
```plantuml
skinparam shadowing true

skinparam defaultFontName "Noto Sans CJK KR"
skinparam defaultFontStyle plain

skinparam classBorderThickness 1
skinparam packageBorderThickness 0.5

skinparam ParticipantBorderColor #ab1040
skinparam ParticipantBackgroundColor #fefece
    
skinparam ActorBackgroundColor #fefece
skinparam ActorBorderColor #ab1040
    
skinparam BoundaryBackgroundColor #fefece
skinparam BoundaryBorderColor #ab1040
skinparam BoundaryFontColor Black

skinparam ControlBackgroundColor #fefece
skinparam ControlBorderColor #ab1040
skinparam ControlFontColor Black

skinparam EntityBackgroundColor #fefece
skinparam EntityBorderColor #ab1040
skinparam EntityFontColor Black

skinparam DatabaseBackgroundColor #fefece
skinparam DatabaseBorderColor #ab1040
skinparam DatabaseFontColor Black

skinparam CollectionsBackgroundColor #fefece
skinparam CollectionsBorderColor #ab1040
skinparam CollectionsFontColor Black

skinparam QueueBackgroundColor #fefece
skinparam QueueBorderColor #ab1040
skinparam QueueFontColor Black
    
skinparam sequence {
    LifeLineBorderColor #ab1040
    LifeLineBackgroundColor #fffff
    
    ArrowColor #ab1040
    ArrowFontColor #777777
}

' 참여자들
actor "actor" as User
participant "{{클래스명}}" as UserController <<{{패키지명}}>>
participant "{{클래스명}}" as UserService <<{{패키지명}}>>
participant "{{클래스명}}" as UserRepository <<{{패키지명}}>>

== {{작업명}} ==

User -> UserController : {{함수명}} ({{설명}})
activate User
  activate UserController
    UserController -> UserController : {{설명}}
    UserController -> UserService: {{함수명}} ({{설명}})
    activate UserService
      UserService ->]: {{소프트웨어 처리 흐름도 문서 코드}} ({{설명}})
      UserService <--]
      UserService ->]: {{외부서비스 식별자}} {{설명}}
      UserService <--]
      UserService -> UserService: {{설명}}
      UserService -> UserService: {{설명}}
      UserService -> UserRepository: {{함수명}} ({{설명}})
      activate UserRepository
        UserService <-- UserRepository: {{설명}}
      deactivate UserRepository

      UserController <-- UserService: {{설명}}
    deactivate UserService
    alt {{조건}}
      User <-- UserController: {{설명}}
    else
      User <-- UserController: {{설명}}
    end
  deactivate UserController
deactivate User

```
