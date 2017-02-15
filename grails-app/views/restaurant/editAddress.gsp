<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'restaurant.label', default: 'Restaurant')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-restaurant" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-restaurant" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.restaurant}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.restaurant}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form action="updateAddress" method="POST">
                <g:hiddenField name="id" value="${this.restaurant?.id}" />
                <g:hiddenField name="version" value="${this.restaurant?.version}" />
                <fieldset class="form">
                    <div class="fieldcontain">
                        <label for="streetAddress"><g:message code="restaurant.address.streetAddress.label" default="Street"/></label>
                        <input type="text" name="streetAddress" value="${restaurant.address?.streetAddress}" id="streetAddress">
                    </div>
                    <div class="fieldcontain">
                        <label for="locality"><g:message code="restaurant.address.locality.label" default="Locality"/></label>
                        <input type="text" name="locality" value="${restaurant.address?.locality}" id="locality">
                    </div>
                    <div class="fieldcontain">
                        <label for="postalCode"><g:message code="restaurant.address.postalCode.label" default="Postal Code"/></label>
                        <input type="text" name="postalCode" value="${restaurant.address?.postalCode}" id="postalCode">
                    </div>
                    <div class="fieldcontain">
                        <label for="province"><g:message code="restaurant.address.province.label" default="Province"/></label>
                        <input type="text" name="province" value="${restaurant.address?.province}" id="province">
                    </div>
                    <div class="fieldcontain">
                        <label for="region"><g:message code="restaurant.address.region.label" default="Region"/></label>
                        <input type="text" name="region" value="${restaurant.address?.region}" id="region">
                    </div>
                    <div class="fieldcontain">
                        <label for="countryName"><g:message code="restaurant.address.countryName.label" default="Country Name"/></label>
                        <input type="text" name="countryName" value="${restaurant.address?.countryName}" id="countryName">
                    </div>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
