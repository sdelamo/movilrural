<%@ page import="com.softamo.movilrural.places.restaurants.RestaurantType" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'restaurant.label', default: 'Restaurant')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
        <asset:stylesheet src="trix/trix.css"/>
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
            <g:form resource="${this.restaurant}" method="PUT">
                <g:hiddenField name="version" value="${this.restaurant?.version}" />
                <fieldset class="form">
                    <f:field bean="restaurant" property="name"/>
                    <f:field bean="restaurant" property="latitude"/>
                    <f:field bean="restaurant" property="longitude"/>
                    <f:field bean="restaurant" property="url"/>
                    <f:field bean="restaurant" property="email"/>
                    <f:field bean="restaurant" property="telephone"/>
                    <div class="fieldcontain">
                        <label for="category"><g:message label="restaurant.category.label"/></label>

                        <g:select id="category"
                                  name='category'
                                  value="${restaurant?.category}"
                                  from="${RestaurantType.values()}"
                                  valueMessagePrefix="restaurant.type"/>
                    </div>                    <f:field bean="restaurant" property="officialRanking"/>

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
