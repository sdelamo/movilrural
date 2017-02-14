<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'poin.label', default: 'Point of Interest')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-poin" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-poin" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.poin}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.poin}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.poin}" method="PUT">
                <g:hiddenField name="version" value="${this.poin?.version}" />
                <fieldset class="form">
                    <f:field bean="poin" property="name"/>
                    <f:field bean="poin" property="latitude"/>
                    <f:field bean="poin" property="longitude"/>
                    <f:field bean="poin" property="type"/>
                    <f:field bean="poin" property="url"/>
                    <f:field bean="poin" property="email"/>
                    <f:field bean="poin" property="telephone"/>
                    <f:field bean="poin" property="category"/>
                    <f:field bean="poin" property="streetAddress"/>
                    <f:field bean="poin" property="locality"/>
                    <f:field bean="poin" property="postalCode"/>
                    <f:field bean="poin" property="province"/>
                    <f:field bean="poin" property="region"/>
                    <f:field bean="poin" property="countryName"/>
                    <f:field bean="poin" property="toprural"/>
                    <f:field bean="poin" property="facebook"/>
                    <f:field bean="poin" property="twitter"/>
                    <f:field bean="poin" property="googlePlus"/>
                    <f:field bean="poin" property="minube"/>
                    <f:field bean="poin" property="tuenti"/>
                    <f:field bean="poin" property="officialRanking"/>
                    <f:field bean="poin" property="places"/>

                    <div class="fieldcontain required">
                        <trix:editor name="about" value="${village?.about}"/>
                    </div>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
