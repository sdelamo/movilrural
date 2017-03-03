<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'poi.label', default: 'Point of Interest')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
        <asset:stylesheet src="trix/trix.css"/>
    </head>
    <body>
        <a href="#edit-poi" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-poi" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.poi}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.poi}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.poi}" method="PUT">
                <g:hiddenField name="version" value="${this.poi?.version}" />
                <fieldset class="form">
                    <f:field bean="poi" property="name"/>
                    <f:field bean="poi" property="latitude"/>
                    <f:field bean="poi" property="longitude"/>
                    <f:field bean="poi" property="url"/>
                    <f:field bean="poi" property="email"/>
                    <f:field bean="poi" property="telephone"/>
                    <f:field bean="poi" property="category"/>
                    <f:field bean="poi" property="streetAddress"/>
                    <f:field bean="poi" property="locality"/>
                    <f:field bean="poi" property="postalCode"/>
                    <f:field bean="poi" property="province"/>
                    <f:field bean="poi" property="region"/>
                    <f:field bean="poi" property="countryName"/>
                    <f:field bean="poi" property="toprural"/>
                    <f:field bean="poi" property="facebook"/>
                    <f:field bean="poi" property="twitter"/>
                    <f:field bean="poi" property="googlePlus"/>
                    <f:field bean="poi" property="minube"/>
                    <f:field bean="poi" property="tuenti"/>
                    <f:field bean="poi" property="officialRanking"/>
                    <f:field bean="poi" property="places"/>

                    <div class="fieldcontain required">
                        <trix:editor name="about" value="${village?.about}"/>
                    </div>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
        <asset:javascript src="trix/trix.js"/>
    </body>
</html>
