<!DOCTYPE html>
<html>
    <head>
        <sec:ifNotLoggedIn>
            <meta name="layout" content="adel" />
        </sec:ifNotLoggedIn>
        <sec:ifLoggedIn>
            <meta name="layout" content="main" />
        </sec:ifLoggedIn>
        <g:set var="entityName" value="${message(code: 'restaurant.label', default: 'Restaurant')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <sec:ifAnyGranted roles='ROLE_VILLAGE_EDITOR,ROLE_VILLAGE_MANAGER, ROLE_RESTAURANT_EDITOR,ROLE_RESTAURANT_MANAGER, ROLE_HOTEL_EDITOR,ROLE_HOTEL_MANAGER,ROLE_POI_EDITOR,ROLE_POI_MANAGER'>
        <div class="nav" role="navigation">
            <ul>
                <g:render template="/village/menu"/>
            </ul>
        </div>
        </sec:ifAnyGranted>
        <div id="show-restaurant" class="content scaffold-show" role="main" style="padding: 1em;">
            <h1><f:display bean="restaurant" property="name" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:message code="restaurant.latitude.label"/> <f:display bean="restaurant" property="latitude" /><br/>
            <g:message code="restaurant.longitude.label"/> <f:display bean="restaurant" property="longitude" /><br/>

            <g:if test="${restaurant?.url}">
                <b><g:message code="restaurant.url.label"/></b>: <a href="${restaurant?.url}"><f:display bean="restaurant" property="url" /></a><br/>
            </g:if>
            <g:if test="${restaurant?.email}">
                <b><g:message code="restaurant.email.label"/></b>: <f:display bean="restaurant" property="email" /><br/>
            </g:if>
            <g:if test="${restaurant?.telephone}">
                <b><g:message code="restaurant.telephone.label"/></b>: <f:display bean="restaurant" property="telephone" /><br/>
            </g:if>
            <g:if test="${restaurant?.category}">
                <b><g:message code="restaurant.category.label"/></b>: ${g.message(code: "restaurant.type.${restaurant?.category}")}<br/
            </g:if>
            <g:if test="${restaurant?.address?.streetAddress}">
                <b><g:message code="restaurant.address.streetAddress.label"/></b>: ${restaurant.address?.streetAddress}<br/>
            </g:if>
            <g:if test="${restaurant?.address?.locality}">
                <b><g:message code="restaurant.address.locality.label"/></b>: ${restaurant.address?.locality}<br/>
            </g:if>
            <g:if test="${restaurant?.address?.postalCode}">
                <b><g:message code="restaurant.address.postalCode.label"/></b>: ${restaurant.address?.postalCode}<br/>
            </g:if>
            <g:if test="${restaurant?.address?.province}">
                <b><g:message code="restaurant.address.province.label"/></b>: ${restaurant.address?.province}<br/>
            </g:if>
            <g:if test="${restaurant?.address?.region}">
                <b><g:message code="restaurant.address.region.label"/></b>: ${restaurant.address?.region}<br/>
            </g:if>
            <g:if test="${restaurant?.address?.countryName}">
                <b><g:message code="restaurant.address.countryName.label"/></b>: ${restaurant.address?.countryName}<br/>
            </g:if>
            <g:if test="${restaurant?.socialNetwork?.toprural}">
                <b><g:message code="restaurant.socialNetwork.toprural.label"/></b>: ${restaurant.socialNetwork?.toprural}<br/>
            </g:if>
            <g:if test="${restaurant?.socialNetwork?.facebook}">
                <b><g:message code="restaurant.socialNetwork.facebook.label"/></b>: ${restaurant.socialNetwork?.facebook}<br/>
            </g:if>
            <g:if test="${restaurant?.socialNetwork?.twitter}">
                <b><g:message code="restaurant.socialNetwork.twitter.label"/></b>: ${restaurant.socialNetwork?.twitter}<br/>
            </g:if>
            <g:if test="${restaurant?.socialNetwork?.googlePlus}">
                <b><g:message code="restaurant.socialNetwork.googlePlus.label"/></b>: ${restaurant.socialNetwork?.googlePlus}<br/>
            </g:if>
            <g:if test="${restaurant?.socialNetwork?.minube}">
                <b><g:message code="restaurant.socialNetwork.minube.label"/></b>: ${restaurant.socialNetwork?.minube}<br/>
            </g:if>
            <g:if test="${restaurant?.socialNetwork?.tuenti}">
                <b><g:message code="restaurant.socialNetwork.tuenti.label"/></b>: ${restaurant.socialNetwork?.tuenti}<br/>
            </g:if>
            <g:if test="${restaurant?.officialRanking}">
                <b><g:message code="restaurant.officialRanking.label"/></b>: <f:display bean="restaurant" property="officialRanking" /><br/>
            </g:if>

            <f:display property="about" bean="restaurant"/>
            <hr />
            <g:if test="${restaurant.featuredImageUrl}">
                <h3><g:message code="restaurant.featuredImageUrl.label"/></h3>
                <a href="${restaurant.featuredImageUrl}"><img src="${restaurant.featuredImageUrl}" alt="${restaurant.name}" width="400"/></a>
                <sec:ifAnyGranted roles='ROLE_RESTAURANT_EDITOR,ROLE_RESTAURANT_MANAGER'>
                <g:form method="DELETE" controller="restaurant" action="deleteFeaturedImageUrl">
                    <g:hiddenField name="id" value="${restaurant.id}"/>
                    <g:hiddenField name="version" value="${restaurant.version}"/>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </g:form>
                </sec:ifAnyGranted>
            </g:if>
            <hr />
            <g:if test="${restaurant.imageUrls}">
                <h3><g:message code="restaurant.imageUrls.label"/></h3>
                <ul style="list-style-type: none;">
                <g:each var="imageUrl" in="${restaurant.imageUrls}">
                    <li><a href="${imageUrl}"><img src="${imageUrl}" alt="${restaurant.name}" width="400"/></a>
                        <sec:ifAnyGranted roles='ROLE_RESTAURANT_EDITOR,ROLE_RESTAURANT_MANAGER'>
                        <g:form method="DELETE" controller="restaurant" action="deleteImageUrl">
                            <g:hiddenField name="id" value="${restaurant.id}"/>
                            <g:hiddenField name="version" value="${restaurant.version}"/>
                            <g:hiddenField name="imageUrl" value="${imageUrl}"/>
                            <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                        </g:form>
                        </sec:ifAnyGranted>
                    </li>
                </g:each>
                </ul>
            </g:if>
            <sec:ifAnyGranted roles='ROLE_RESTAURANT_EDITOR,ROLE_RESTAURANT_MANAGER'>
            <g:form resource="${this.restaurant}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.restaurant}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <g:link class="edit" action="editSocialNetwork" resource="${this.restaurant}"><g:message code="restaurant.socialNetwork.edit.label" default="Edit Social Network" /></g:link>
                    <g:link class="edit" action="editAddress" resource="${this.restaurant}"><g:message code="restaurant.address.edit.label" default="Edit Address" /></g:link>
                    <g:link class="edit" action="editFeaturedImage" resource="${this.restaurant}"><g:message code="restaurant.featuredImageUrl.edit.label" default="Edit Featured Image" /></g:link>
                    <g:link class="edit" action="addImage" resource="${this.restaurant}"><g:message code="restaurant.image.add.label" default="Add Image" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
            </sec:ifAnyGranted>
        </div>
    </body>
</html>
