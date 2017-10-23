<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="adel" />
        <g:set var="entityName" value="${message(code: 'poi.label', default: 'Point of Interest')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <g:render template="/templates/mainmenu"/>
        <sec:ifAnyGranted roles='ROLE_VILLAGE_EDITOR,ROLE_VILLAGE_MANAGER, ROLE_RESTAURANT_EDITOR,ROLE_RESTAURANT_MANAGER, ROLE_HOTEL_EDITOR,ROLE_HOTEL_MANAGER,ROLE_POI_EDITOR,ROLE_POI_MANAGER'>
        <div class="nav" role="navigation">
            <ul>
                <g:render template="/village/menu"/>
            </ul>
        </div>
        </sec:ifAnyGranted>
        <div id="list-poi" class="content scaffold-list" role="main">
            <h1><g:message code="poi.list.label" default="Points of Interest" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${poiList}" properties="['name']"/>

            <b><g:message code="pagination.total" default="Total"/></b>: ${poiCount ?: 0}<br/>
            <g:if test="${(poiCount ?: 0) > (poiList?.size() ?: 0)}">
                <div class="pagination">
                    <g:paginate total="${poiCount ?: 0}" />
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