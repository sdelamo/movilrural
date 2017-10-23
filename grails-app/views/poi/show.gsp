<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="adel" />
        <g:set var="entityName" value="${message(code: 'poi.label', default: 'Point of Interest')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav" role="navigation">
            <ul>
                <g:render template="/village/menu"/>
            </ul>
        </div>
        <div id="show-poi" class="content scaffold-show" role="main" style="padding: 1em;">
            <h1><f:display bean="poi" property="name" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:if test="${poi?.latitude}">
                <g:message code="poi.latitude.label"/> <f:display bean="poi" property="latitude" /><br/>
            </g:if>
            <g:if test="${poi?.longitude}">
                <g:message code="poi.longitude.label"/> <f:display bean="poi" property="longitude" /><br/>
            </g:if>
            <g:if test="${poi?.url}">
                <b><g:message code="poi.url.label"/></b> <f:display bean="poi" property="url" /><br/>
            </g:if>
            <g:if test="${poi?.email}">
                <b><g:message code="poi.email.label"/></b> <f:display bean="poi" property="email" /><br/>
            </g:if>
            <g:if test="${poi?.telephone}">
                <b><g:message code="poi.telephone.label"/></b> <f:display bean="poi" property="telephone" /><br/>
            </g:if>
            <g:if test="${poi?.category}">
                <b><g:message code="poi.category.label"/></b> <f:display bean="poi" property="category" /><br/>
            </g:if>
            <g:if test="${poi?.address?.streetAddress}">
                <b><g:message code="poi.address.streetAddress.label"/></b> ${poi.address?.streetAddress}<br/>
            </g:if>
            <g:if test="${poi?.address?.locality}">
                <b><g:message code="poi.address.locality.label"/></b> ${poi.address?.locality}<br/>
            </g:if>
            <g:if test="${poi?.address?.postalCode}">
                <b><g:message code="poi.address.postalCode.label"/></b> ${poi.address?.postalCode}<br/>
            </g:if>
            <g:if test="${poi?.address?.province}">
                <b><g:message code="poi.address.province.label"/></b> ${poi.address?.province}<br/>
            </g:if>
            <g:if test="${poi?.address?.region}">
                <b><g:message code="poi.address.region.label"/></b> ${poi.address?.region}<br/>
            </g:if>
            <g:if test="${poi?.address?.countryName}">
                <b><g:message code="poi.address.countryName.label"/></b> ${poi.address?.countryName}<br/>
            </g:if>
            <g:if test="${poi?.socialNetwork?.toprural}">
                <b><g:message code="poi.socialNetwork.toprural.label"/></b> ${poi.socialNetwork?.toprural}<br/>
            </g:if>
            <g:if test="${poi?.socialNetwork?.facebook}">
                <b><g:message code="poi.socialNetwork.facebook.label"/></b> ${poi.socialNetwork?.facebook}<br/>
            </g:if>
            <g:if test="${poi?.socialNetwork?.twitter}">
                <b><g:message code="poi.socialNetwork.twitter.label"/></b> ${poi.socialNetwork?.twitter}<br/>
            </g:if>
            <g:if test="${poi?.socialNetwork?.googlePlus}">
                <b><g:message code="poi.socialNetwork.googlePlus.label"/></b> ${poi.socialNetwork?.googlePlus}<br/>
            </g:if>
            <g:if test="${poi?.socialNetwork?.minube}">
                <b><g:message code="poi.socialNetwork.minube.label"/></b> ${poi.socialNetwork?.minube}<br/>
            </g:if>
            <g:if test="${poi?.socialNetwork?.tuenti}">
                <b><g:message code="poi.socialNetwork.tuenti.label"/></b> ${poi.socialNetwork?.tuenti}<br/>
            </g:if>
            <g:if test="${poi?.officialRanking}">
                <b><g:message code="poi.officialRanking.label"/></b> <f:display bean="poi" property="officialRanking" /><br/>
            </g:if>

            <f:display property="about" bean="poi"/>
            <hr />
            <g:if test="${poi.featuredImageUrl}">
                <h3><g:message code="poi.featuredImageUrl.label"/></h3>
                <a href="${poi.featuredImageUrl}"><img src="${poi.featuredImageUrl}" alt="${poi.name}" width="400"/></a>
                <sec:ifAnyGranted roles='ROLE_VILLAGE_EDITOR,ROLE_VILLAGE_MANAGER'>
                <g:form method="DELETE" controller="poi" action="deleteFeaturedImageUrl">
                    <g:hiddenField name="id" value="${poi.id}"/>
                    <g:hiddenField name="version" value="${poi.version}"/>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </g:form>
                </sec:ifAnyGranted>
            </g:if>
            <hr />
            <g:if test="${poi.imageUrls}">
                <h3><g:message code="poi.imageUrls.label"/></h3>
                <ul>
                <g:each var="imageUrl" in="${poi.imageUrls}">
                    <li><a href="${imageUrl}"><img src="${imageUrl}" alt="${poi.name}" width="400"/></a>
                    <sec:ifAnyGranted roles='ROLE_POI_EDITOR,ROLE_POI_MANAGER'>
                        <g:form method="DELETE" controller="poi" action="deleteImageUrl">
                            <g:hiddenField name="id" value="${poi.id}"/>
                            <g:hiddenField name="version" value="${poi.version}"/>
                            <g:hiddenField name="imageUrl" value="${imageUrl}"/>
                            <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                        </g:form>
                    </sec:ifAnyGranted>
                    </li>
                </g:each>
                </ul>
            </g:if>
<sec:ifAnyGranted roles='ROLE_POI_EDITOR,ROLE_POI_MANAGER'>
            <g:form resource="${this.poi}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.poi}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <g:link class="edit" action="editAddress" resource="${this.poi}"><g:message code="poi.address.edit.label" default="Edit Address" /></g:link>
                    <g:link class="edit" action="editFeaturedImage" resource="${this.poi}"><g:message code="poi.featuredImageUrl.edit.label" default="Edit Featured Image" /></g:link>
                    <g:link class="edit" action="addImage" resource="${this.poi}"><g:message code="poi.image.add.label" default="Add Image" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
</sec:ifAnyGranted>
        </div>
    </body>
</html>
