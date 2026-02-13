
| 문서 코드     | {{서비스코드}}-BBE-{{구분번호}}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| --------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 관련 문서     | {{[시스템 아키텍쳐 구성도](../../BAB.%20시스템%20아키텍쳐%20구성도%20(System%20Architecture%20Diagram).md) 문서 코드}}<br>{{[소프트웨어 아키텍쳐 구성도](../../BAA.%20소프트웨어%20아키텍쳐%20구성도%20(Software%20Architecture%20Diagram).md) 문서 코드}}<br>{{[API 명세서](../../BBD.%20API%20명세서%20(API%20Specification).md) 문서 코드}}<br>{{[시스템 처리 흐름도](../../BBE.%20시스템%20처리%20흐름도%20(Processing%20Sequence%20Diagram).md) 문서 코드}}<br>{{[소프트웨어 처리 흐름도](../../CAA.%20소프트웨어%20처리%20흐름도%20(Software%20Processing%20Sequence%20Diagram).md) 문서 코드}}<br>{{화면설계서(SB) 화면코드}}/{{항목번호}}<br>ITSM/{{ITSM 업무번호}}<br>ITSM/{{ITSM 업무번호}}<br>      : |
| 애플리케이션 유형 | {{애플리케이션 유형}}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
| 업무 구분     | {{업무 구분}}/.../{{업무 구분}}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| 설명        | {{설명}}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| 태그        | `#설계` `#시스템_처리_흐름도` `#{{화면설계서(SB) 화면코드}}/{{항목번호}}` `#ITSM/{{업무번호}}` `#ITSM/{{업무번호}}` `#{{애플리케이션 유형}}` `#{{업무 구분}}` `#{{업무 구분}}`                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
<br>

`[[canvas/{{서비스코드}}-BBE-{{구분번호}}|캔버스 뷰]]`
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

actor "USER" as USER
actor "ADMIN" as Admin

box "middleware" #LightBlue
  boundary " " as APIGATEWAY
end box

participant "WEB" as WEB
participant "API" as API

queue "QUEUE" as QUEUE
database "CACHE" as CACHE
database "DATABASE" as DATABASE



== {{작업}} ==
USER -> WEB: {{설명}}
activate USER
activate WEB
WEB -> API: {{설명}}
activate API
API ->]: {{시스템 처리 흐름도 문서코드}} ({{설명}})
API <--]
API ->]: {{외부서비스 식별자}} ({{설명}})
API <--]
API -> API: {{설명}}
API -> API: {{설명}}
API -> CACHE: {{설명}}
activate CACHE
API <-- CACHE: {{설명}}
deactivate CACHE

opt {{조건}}
    API -> DATABASE: {{설명}}
    activate DATABASE
    API <-- DATABASE: {{설명}}
    deactivate DATABASE
end

WEB <-- API: {{설명}}

deactivate API
alt {{조건}}
    USER <-- WEB: {{설명}}
else
    USER <-- WEB: {{설명}}
end
deactivate WEB
deactivate USER


```
<br>
<br>
