<!DOCTYPE html>
<html>
    <head>
        <sec:ifNotLoggedIn>
            <meta name="layout" content="adel" />
        </sec:ifNotLoggedIn>
        <sec:ifLoggedIn>
            <meta name="layout" content="main" />
        </sec:ifLoggedIn>
        <g:set var="entityName" value="${message(code: 'village.label', default: 'Village')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
    <span class="cat-tags-links">
        <span class="cat-links">
            <g:link controller="village" action="index"><g:message code="village.index" default="Villages"/></g:link>
            <span> &rarr; </span>
            <b><f:display bean="village" property="name" /></b>
        </span>
    </span>

    <sec:ifAnyGranted roles='ROLE_VILLAGE_EDITOR,ROLE_VILLAGE_MANAGER, ROLE_RESTAURANT_EDITOR,ROLE_RESTAURANT_MANAGER, ROLE_HOTEL_EDITOR,ROLE_HOTEL_MANAGER,ROLE_POI_EDITOR,ROLE_POI_MANAGER'>
        <div class="nav" role="navigation">
            <ul>
                <g:render template="menu"/>
            </ul>
        </div>
    </sec:ifAnyGranted>
        <div id="show-village" class="content scaffold-show" role="main" style="padding: 1em;">
            <h1><f:display bean="village" property="name" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:message code="village.latitude.label"/> <f:display bean="village" property="latitude" /><br/>
            <g:message code="village.longitude.label"/> <f:display bean="village" property="longitude" /><br/>
            ${village.about.encodeAsRaw()}
            <hr />
            <g:if test="${village.featuredImageUrl}">
                <h3><g:message code="village.featuredImageUrl.label"/></h3>
                <a href="${village.featuredImageUrl}"><img src="${village.featuredImageUrl}" alt="${village.name}" width="400"/></a>
                <sec:ifAnyGranted roles='ROLE_VILLAGE_EDITOR,ROLE_VILLAGE_MANAGER'>
                    <g:form method="DELETE" controller="village" action="deleteFeaturedImageUrl">
                        <g:hiddenField name="id" value="${village.id}"/>
                        <g:hiddenField name="version" value="${village.version}"/>
                        <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                    </g:form>
                </sec:ifAnyGranted>
            </g:if>
            <hr />
            <g:if test="${village.imageUrls}">
                <h3><g:message code="village.imageUrls.label"/></h3>
                <ul style="list-style-type: none;">
                <g:each var="imageUrl" in="${village.imageUrls}">
                    <li><a href="${imageUrl}"><img src="${imageUrl}" alt="${village.name}" width="400"/></a>
                    <sec:ifAnyGranted roles='ROLE_VILLAGE_EDITOR,ROLE_VILLAGE_MANAGER'>
                        <g:form method="DELETE" controller="village" action="deleteImageUrl">
                            <g:hiddenField name="id" value="${village.id}"/>
                            <g:hiddenField name="version" value="${village.version}"/>
                            <g:hiddenField name="imageUrl" value="${imageUrl}"/>
                            <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                        </g:form>
                    </sec:ifAnyGranted>
                    </li>
                </g:each>
                </ul>
            </g:if>

            <sec:ifAnyGranted roles='ROLE_VILLAGE_EDITOR,ROLE_VILLAGE_MANAGER'>

            <g:form resource="${this.village}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="editFeaturedImage" resource="${this.village}"><g:message code="village.featuredImageUrl.edit.label" default="Edit Featured Image" /></g:link>
                    <g:link class="edit" action="addImage" resource="${this.village}"><g:message code="village.image.add.label" default="Add Image" /></g:link>
                    <g:link class="edit" action="edit" resource="${this.village}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>

            </sec:ifAnyGranted>
        </div>
    </body>
</html>
