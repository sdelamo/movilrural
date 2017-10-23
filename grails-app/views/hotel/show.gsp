<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="adel" />
        <g:set var="entityName" value="${message(code: 'hotel.label', default: 'Hotel')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
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
        <div id="show-hotel" class="content scaffold-show" role="main" style="padding: 1em;">
            <h1><f:display bean="hotel" property="name" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>

            <b><g:message code="hotel.latitude.label"/></b>: <f:display bean="hotel" property="latitude" /><br/>
            <b><g:message code="hotel.longitude.label"/></b>: <f:display bean="hotel" property="longitude" /><br/>

            <g:if test="${hotel?.url}">
                <b><g:message code="hotel.url.label"/></b>: <f:display bean="hotel" property="url" /><br/>
            </g:if>
            <g:if test="${hotel?.email}">
                <b><g:message code="hotel.email.label"/></b>: <f:display bean="hotel" property="email" /><br/>
            </g:if>
            <g:if test="${hotel?.telephone}">
                <b><g:message code="hotel.telephone.label"/></b>: <f:display bean="hotel" property="telephone" /><br/>
            </g:if>
            <g:if test="${hotel?.category}">
                <b><g:message code="hotel.category.label"/></b>: ${g.message(code: "hotel.type.${hotel?.category}")}<br/>
            </g:if>

            <g:if test="${hotel?.officialRanking}">
                <b><g:message code="hotel.officialRanking.label"/></b>: ${g.message(code: "hotel.category.${hotel?.officialRanking}")}<br/>
            </g:if>

            <g:if test="${hotel?.address?.streetAddress}">
                <b><g:message code="hotel.address.streetAddress.label"/></b>: ${hotel?.address?.streetAddress}<br/>
            </g:if>
            <g:if test="${hotel?.address?.locality}">
                <b><g:message code="hotel.address.locality.label"/></b>: ${hotel?.address?.locality}<br/>
            </g:if>
            <g:if test="${hotel?.address?.postalCode}">
                <b><g:message code="hotel.address.postalCode.label"/></b>: ${hotel?.address?.postalCode}<br/>
            </g:if>
            <g:if test="${hotel?.address?.province}">
                <b><g:message code="hotel.address.province.label"/></b>: ${hotel?.address?.province}<br/>
            </g:if>
            <g:if test="${hotel?.address?.region}">
                <b><g:message code="hotel.address.region.label"/></b>: ${hotel?.address?.region}<br/>
            </g:if>
            <g:if test="${hotel?.address?.countryName}">
                <b><g:message code="hotel.address.countryName.label"/></b>: ${hotel?.address?.countryName}<br/>
            </g:if>
            <g:if test="${hotel?.socialNetwork?.toprural}">
                <b><g:message code="hotel.socialNetwork.toprural.label"/></b>: ${hotel.socialNetwork?.toprural}<br/>
            </g:if>
            <g:if test="${hotel?.socialNetwork?.facebook}">
                <b><g:message code="hotel.socialNetwork.facebook.label"/></b>: ${hotel.socialNetwork?.facebook}<br/>
            </g:if>
            <g:if test="${hotel?.socialNetwork?.twitter}">
                <b><g:message code="hotel.socialNetwork.twitter.label"/></b>: ${hotel.socialNetwork?.twitter}<br/>
            </g:if>
            <g:if test="${hotel?.socialNetwork?.googlePlus}">
                <b><g:message code="hotel.socialNetwork.googlePlus.label"/></b>: ${hotel.socialNetwork?.googlePlus}<br/>
            </g:if>
            <g:if test="${hotel?.socialNetwork?.minube}">
                <b><g:message code="hotel.socialNetwork.minube.label"/></b>: ${hotel.socialNetwork?.minube}<br/>
            </g:if>
            <g:if test="${hotel?.socialNetwork?.tuenti}">
                <b><g:message code="hotel.socialNetwork.tuenti.label"/></b>: ${hotel.socialNetwork?.tuenti}<br/>
            </g:if>
            <g:if test="${hotel?.officialRanking}">
                <b><g:message code="hotel.officialRanking.label"/></b>: <f:display bean="hotel" property="officialRanking" /><br/>
            </g:if>
            <g:if test="${hotel?.places}">
                <g:message code="hotel.places.label"/> <f:display bean="hotel" property="places" /><br/>
            </g:if>

            <f:display property="about" bean="hotel"/>
            <hr />
            <g:if test="${hotel.featuredImageUrl}">
                <h3><g:message code="hotel.featuredImageUrl.label"/></h3>
                <a href="${hotel.featuredImageUrl}"><img src="${hotel.featuredImageUrl}" alt="${hotel.name}" width="400"/></a>
                <sec:ifAnyGranted roles='ROLE_HOTEL_EDITOR,ROLE_HOTEL_MANAGER'>
                    <g:form method="DELETE" controller="hotel" action="deleteFeaturedImageUrl">
                    <g:hiddenField name="id" value="${hotel.id}"/>
                    <g:hiddenField name="version" value="${hotel.version}"/>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </g:form>
                </sec:ifAnyGranted>
            </g:if>
            <hr />
            <g:if test="${hotel.imageUrls}">
                <h3><g:message code="hotel.imageUrls.label"/></h3>
                <ul style="list-style-type: none;">
                <g:each var="imageUrl" in="${hotel.imageUrls}">
                    <li><a href="${imageUrl}"><img src="${imageUrl}" alt="${hotel.name}" width="400"/></a>
                    <sec:ifAnyGranted roles='ROLE_HOTEL_EDITOR,ROLE_HOTEL_MANAGER'>
                        <g:form method="DELETE" controller="hotel" action="deleteImageUrl">
                            <g:hiddenField name="id" value="${hotel.id}"/>
                            <g:hiddenField name="version" value="${hotel.version}"/>
                            <g:hiddenField name="imageUrl" value="${imageUrl}"/>
                            <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                        </g:form>
                    </sec:ifAnyGranted>
                    </li>
                </g:each>
                </ul>
            </g:if>
<sec:ifAnyGranted roles='ROLE_HOTEL_EDITOR,ROLE_HOTEL_MANAGER'>
            <g:form resource="${this.hotel}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.hotel}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <g:link class="edit" action="editSocialNetwork" resource="${this.hotel}"><g:message code="hotel.socialNetwork.edit.label" default="Edit Social Network" /></g:link>
                    <g:link class="edit" action="editAddress" resource="${this.hotel}"><g:message code="hotel.address.edit.label" default="Edit Address" /></g:link>
                    <g:link class="edit" action="editFeaturedImage" resource="${this.hotel}"><g:message code="hotel.featuredImageUrl.edit.label" default="Edit Featured Image" /></g:link>
                    <g:link class="edit" action="addImage" resource="${this.hotel}"><g:message code="hotel.image.add.label" default="Add Image" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
</sec:ifAnyGranted>
        </div>
    </body>
</html>
