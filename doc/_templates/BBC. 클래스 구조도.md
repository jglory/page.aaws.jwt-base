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
'skinparam linetype ortho

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

'hide circle
hide empty fields
hide empty methods

package com.fasterxml.jackson.databind <<Rectangle>> {
	class "ObjectMapper" as com.fasterxml.jackson.databind.ObjectMapper {
	}
}

package org.springframework.security.authentication <<Rectangle>> {
	interface "AuthenticationManager" as org.springframework.security.authentication.AuthenticationManager {}
}

package org.springframework.security.oauth2.server.resource.web <<Rectangle>> {
	interface "BearerTokenResolver" as org.springframework.security.oauth2.server.resource.web.BearerTokenResolver {}
}

package org.springframework.security.web.authentication <<Rectangle>> {
	interface "AuthenticationFailureHandler" as org.springframework.security.web.authentication.AuthenticationFailureHandler {
	}
	
	interface "AuthenticationSuccessHandler" as org.springframework.security.web.authentication.AuthenticationSuccessHandler {
	}
}

package org.springframework.security.web.context <<Rectangle>> {
	class "NullSecurityContextRepository" as org.springframework.security.web.context.NullSecurityContextRepository {
	}
}

package page.aaws.api.v1.auth.dto <<Rectangle>> {
	record "LoginRequest" as page.aaws.api.v1.auth.dto.LoginRequest {
	}
}

package page.aaws.global.security.jwt.filter <<Rectangle>>  {
	class "JsonUsernamePasswordAuthenticationFilter" as page.aaws.global.security.jwt.filter.JsonUsernamePasswordAuthenticationFilter<T extends JsonUsernamePasswordAuthenticationRequest> {
	}
	
	class "JwtAuthenticationFilter" as page.aaws.global.security.jwt.filter.JwtAuthenticationFilter {
	}
	
	class "JwtReissueAuthenticationFilter" as page.aaws.global.security.jwt.filter.JwtReissueAuthenticationFilter {
	}
	
	class "JwtAuthenticationFilterFailureHandler" as page.aaws.global.security.jwt.filter.JwtAuthenticationFilterFailureHandler {
	}
	
	class "JwtAuthenticationFilterSuccessHandler" as page.aaws.global.security.jwt.filter.JwtAuthenticationFilterSuccessHandler {
	}
}

package page.aaws.global.security.jwt.model <<Rectangle>> {
	interface "JsonUsernamePasswordAuthenticationRequest" as page.aaws.global.security.jwt.model.JsonUsernamePasswordAuthenticationRequest {}
}

page.aaws.global.security.jwt.model.JsonUsernamePasswordAuthenticationRequest <|-- page.aaws.api.v1.auth.dto.LoginRequest

org.springframework.security.authentication.AuthenticationManager "1" -----o "1" page.aaws.global.security.jwt.filter.JsonUsernamePasswordAuthenticationFilter

page.aaws.api.v1.auth.dto.LoginRequest "1" --* "1" page.aaws.global.security.jwt.filter.JsonUsernamePasswordAuthenticationFilter

com.fasterxml.jackson.databind.ObjectMapper "1" -----o page.aaws.global.security.jwt.filter.JsonUsernamePasswordAuthenticationFilter

org.springframework.security.web.authentication.AuthenticationFailureHandler <|... page.aaws.global.security.jwt.filter.JwtAuthenticationFilterFailureHandler
org.springframework.security.web.authentication.AuthenticationSuccessHandler <|... page.aaws.global.security.jwt.filter.JwtAuthenticationFilterSuccessHandler

page.aaws.global.security.jwt.filter.JwtAuthenticationFilterFailureHandler "1" --o "1" page.aaws.global.security.jwt.filter.JsonUsernamePasswordAuthenticationFilter
page.aaws.global.security.jwt.filter.JwtAuthenticationFilterSuccessHandler "1" --o "1" page.aaws.global.security.jwt.filter.JsonUsernamePasswordAuthenticationFilter

org.springframework.security.web.context.NullSecurityContextRepository "1" -----* "1" page.aaws.global.security.jwt.filter.JsonUsernamePasswordAuthenticationFilter

org.springframework.security.oauth2.server.resource.web.BearerTokenResolver "1" o---- "1" page.aaws.global.security.jwt.filter.JwtAuthenticationFilter

org.springframework.security.oauth2.server.resource.web.BearerTokenResolver "1" o---- "1" page.aaws.global.security.jwt.filter.JwtReissueAuthenticationFilter
```
