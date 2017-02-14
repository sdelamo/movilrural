<sec:ifAnyGranted roles='ROLE_VILLAGE_EDITOR,ROLE_VILLAGE_MANAGER'>
    <li><g:link class="list" controller="village" action="index"><g:message code="village.list.label"/></g:link></li>
</sec:ifAnyGranted>
<sec:ifAnyGranted roles='ROLE_RESTAURANT_EDITOR,ROLE_RESTAURANT_MANAGER'>
    <li><g:link class="list"  controller="restaurant" action="index"><g:message code="restaurant.list.label"/></g:link></li>
</sec:ifAnyGranted>
<sec:ifAnyGranted roles='ROLE_HOTEL_EDITOR,ROLE_HOTEL_MANAGER'>
    <li><g:link class="list" controller="hotel" action="index"><g:message code="hotel.list.label"/></g:link></li>
</sec:ifAnyGranted>
<sec:ifAnyGranted roles='ROLE_POI_EDITOR,ROLE_POI_MANAGER'>
    <li><g:link  class="list" controller="poi" action="index"><g:message code="poi.list.label"/></g:link></li>
</sec:ifAnyGranted>