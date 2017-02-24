<%@ page import="com.softamo.movilrural.places.hotels.HotelType" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'hotel.label', default: 'Hotel')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-hotel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="hotel.list.label" default="Hotels" /></g:link></li>
            </ul>
        </div>
        <div id="create-hotel" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.hotel}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.hotel}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form action="save">
                <fieldset class="form">
                    <f:field bean="hotel" property="name"/>
                    <f:field bean="hotel" property="latitude"/>
                    <f:field bean="hotel" property="longitude"/>
                    <f:field bean="hotel" property="url"/>
                    <f:field bean="hotel" property="email"/>
                    <f:field bean="hotel" property="telephone"/>
                    <div class="fieldcontain">
                        <label for="category">Categoría</label>

                        <g:select id="category"
                                  name='category'
                                  value="${hotel?.category}"
                                  from="${HotelType.values()}"
                                  valueMessagePrefix="hotel.type"/>
                    </div>

                    <f:field bean="hotel" property="category"/>
                    <f:field bean="hotel" property="officialRanking"/>
                    <f:field bean="hotel" property="places"/>

                    <div class="fieldcontain required">
                        <trix:editor name="about" value="${village?.about}"/>
                    </div>

                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
