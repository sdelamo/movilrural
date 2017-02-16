<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'restaurant.label', default: 'Restaurant')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-restaurant" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <g:render template="/village/menu"/>
            </ul>
        </div>
        <div id="list-restaurant" class="content scaffold-list" role="main">
            <h1><g:message code="restaurant.list.label" default="Restaurants" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${restaurantList}" properties="['name']"/>

            <b><g:message code="pagination.total" default="Total"/></b>: ${restaurantCount ?: 0}<br/>
            <g:if test="${(restaurantCount ?: 0) > (restaurantList?.size() ?: 0)}">
                <div class="pagination">
                    <g:paginate total="${restaurantCount ?: 0}" />
                </div>
            </g:if>
        </div>
        <div class="nav" role="navigation">
            <ul>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
    </body>
</html>