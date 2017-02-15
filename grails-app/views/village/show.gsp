<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'village.label', default: 'Village')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-village" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <g:render template="/village/menu"/>
            </ul>
        </div>


        <div id="show-village" class="content scaffold-show" role="main" style="padding: 1em;">
            <h1><f:display bean="village" property="name" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:message code="village.latitude.label"/> <f:display bean="village" property="latitude" /><br/>
            <g:message code="village.longitude.label"/> <f:display bean="village" property="longitude" /><br/>
            <f:display property="about" bean="village"/>
            <hr />
            <g:if test="${village.featuredImageUrl}">
                <h3><g:message code="village.featuredImageUrl.label"/></h3>
                <a href="${village.featuredImageUrl}"><img src="${village.featuredImageUrl}" alt="${village.name}" width="400"/></a>
                <g:form method="DELETE" controller="village" action="deleteFeaturedImageUrl">
                    <g:hiddenField name="id" value="${village.id}"/>
                    <g:hiddenField name="version" value="${village.version}"/>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </g:form>
            </g:if>
            <hr />
            <g:if test="${village.imageUrls}">
                <h3><g:message code="village.imageUrls.label"/></h3>
                <ul>
                <g:each var="imageUrl" in="${village.imageUrls}">
                    <li><a href="${imageUrl}"><img src="${imageUrl}" alt="${village.name}" width="400"/></a>
                        <g:form method="DELETE" controller="village" action="deleteImageUrl">
                            <g:hiddenField name="id" value="${village.id}"/>
                            <g:hiddenField name="version" value="${village.version}"/>
                            <g:hiddenField name="imageUrl" value="${imageUrl}"/>
                            <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                        </g:form>
                    </li>
                </g:each>
                </ul>
            </g:if>

            <g:form resource="${this.village}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="editFeaturedImage" resource="${this.village}"><g:message code="village.featuredImageUrl.edit.label" default="Edit Featured Image" /></g:link>
                    <g:link class="edit" action="addImage" resource="${this.village}"><g:message code="village.image.add.label" default="Add Image" /></g:link>
                    <g:link class="edit" action="edit" resource="${this.village}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
