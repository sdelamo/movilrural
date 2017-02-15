<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'hotel.label', default: 'Hotel')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-hotel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-hotel" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
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
            <g:form action="updateSocialNetwork" method="POST">
                <g:hiddenField name="id" value="${this.hotel?.id}" />
                <g:hiddenField name="version" value="${this.hotel?.version}" />
                <fieldset class="form">
                    <div class="fieldcontain">
                        <label for="toprural"><g:message code="hotel.socialNetwork.toprural.label" default="Top Rural"/></label>
                        <input type="text" name="toprural" value="${hotel.socialNetwork?.toprural}" id="toprural">
                    </div>
                    <div class="fieldcontain">
                        <label for="facebook"><g:message code="hotel.socialNetwork.facebook.label" default="Facebook"/></label>
                        <input type="text" name="facebook" value="${hotel.socialNetwork?.facebook}" id="facebook">
                    </div>
                    <div class="fieldcontain">
                        <label for="twitter"><g:message code="hotel.socialNetwork.twitter.label" default="Twitter"/></label>
                        <input type="text" name="twitter" value="${hotel.socialNetwork?.twitter}" id="twitter">
                    </div>
                    <div class="fieldcontain">
                        <label for="googlePlus"><g:message code="hotel.socialNetwork.googlePlus.label" default="Google Plus"/></label>
                        <input type="text" name="googlePlus" value="${hotel.socialNetwork?.googlePlus}" id="googlePlus">
                    </div>
                    <div class="fieldcontain">
                        <label for="minube"><g:message code="hotel.socialNetwork.minube.label" default="Minube"/></label>
                        <input type="text" name="minube" value="${hotel.socialNetwork?.minube}" id="minube">
                    </div>
                    <div class="fieldcontain">
                        <label for="tuenti"><g:message code="hotel.socialNetwork.tuenti.label" default="Tuenti"/></label>
                        <input type="text" name="tuenti" value="${hotel.socialNetwork?.tuenti}" id="tuenti">
                    </div>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
