<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="adel" />
        <g:set var="entityName" value="${message(code: 'village.label', default: 'Village')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <sec:ifAnyGranted roles='ROLE_VILLAGE_EDITOR,ROLE_VILLAGE_MANAGER, ROLE_RESTAURANT_EDITOR,ROLE_RESTAURANT_MANAGER, ROLE_HOTEL_EDITOR,ROLE_HOTEL_MANAGER,ROLE_POI_EDITOR,ROLE_POI_MANAGER'>
            <div class="nav" role="navigation">
                <ul>
                    <g:render template="menu"/>
                </ul>
            </div>
        </sec:ifAnyGranted>
    <div id="list-village" class="content scaffold-list" role="main">
            <h1><g:message code="village.list.label" default="Villages" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${villageList}" properties="['name']"/>

            <b><g:message code="pagination.total" default="Total"/></b>: ${villageCount ?: 0}<br/>
            <div class="pagination">
                <g:paginate total="${villageCount ?: 0}" />
            </div>
        </div>
        <div class="nav" role="navigation">
            <ul>
                <sec:ifAnyGranted roles='ROLE_VILLAGE_EDITOR,ROLE_VILLAGE_MANAGER'>
                    <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                </sec:ifAnyGranted>
            </ul>
        </div>
    </body>
</html>