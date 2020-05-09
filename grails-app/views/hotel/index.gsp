<!DOCTYPE html>
<html>
    <head>
        <sec:ifNotLoggedIn>
            <meta name="layout" content="adel" />
        </sec:ifNotLoggedIn>
        <sec:ifLoggedIn>
            <meta name="layout" content="main" />
        </sec:ifLoggedIn>
        <g:set var="entityName" value="${message(code: 'hotel.label', default: 'Hotel')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <sec:ifAnyGranted roles='ROLE_VILLAGE_EDITOR,ROLE_VILLAGE_MANAGER, ROLE_RESTAURANT_EDITOR,ROLE_RESTAURANT_MANAGER, ROLE_HOTEL_EDITOR,ROLE_HOTEL_MANAGER,ROLE_POI_EDITOR,ROLE_POI_MANAGER'>
        <div class="nav" role="navigation">
            <ul>
                <g:render template="/village/menu"/>
            </ul>
        </div>
        </sec:ifAnyGranted>
        <div id="list-hotel" class="content scaffold-list" role="main">
            <h1><g:message code="hotel.list.label" default="Hotels" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${hotelList}" properties="['name']"/>

            <b><g:message code="pagination.total" default="Total"/></b>: ${hotelCount ?: 0}<br/>
            <g:if test="${(hotelCount ?: 0) > (hotelList?.size() ?: 0)}">
                <div class="pagination">
                    <g:paginate total="${hotelCount ?: 0}" />
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