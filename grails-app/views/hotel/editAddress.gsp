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
            <g:form action="updateAddress" method="POST">
                <g:hiddenField name="id" value="${this.hotel?.id}" />
                <g:hiddenField name="version" value="${this.hotel?.version}" />
                <fieldset class="form">
                    <div class="fieldcontain">
                        <label for="streetAddress"><g:message code="hotel.address.streetAddress.label" default="Street"/></label>
                        <input type="text" name="streetAddress" value="${hotel.address?.streetAddress}" id="streetAddress">
                    </div>
                    <div class="fieldcontain">
                        <label for="locality"><g:message code="hotel.address.locality.label" default="Locality"/></label>
                        <input type="text" name="locality" value="${hotel.address?.locality}" id="locality">
                    </div>
                    <div class="fieldcontain">
                        <label for="postalCode"><g:message code="hotel.address.postalCode.label" default="Postal Code"/></label>
                        <input type="text" name="postalCode" value="${hotel.address?.postalCode}" id="postalCode">
                    </div>
                    <div class="fieldcontain">
                        <label for="province"><g:message code="hotel.address.province.label" default="Province"/></label>
                        <input type="text" name="province" value="${hotel.address?.province}" id="province">
                    </div>
                    <div class="fieldcontain">
                        <label for="region"><g:message code="hotel.address.region.label" default="Region"/></label>
                        <input type="text" name="region" value="${hotel.address?.region}" id="region">
                    </div>
                    <div class="fieldcontain">
                        <label for="countryName"><g:message code="hotel.address.countryName.label" default="Country Name"/></label>
                        <input type="text" name="countryName" value="${hotel.address?.countryName}" id="countryName">
                    </div>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
