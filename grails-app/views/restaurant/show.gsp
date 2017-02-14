<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'restaurant.label', default: 'Restaurant')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-restaurant" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-restaurant" class="content scaffold-show" role="main" style="padding: 1em;">
            <h1><f:display bean="restaurant" property="name" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:message code="restaurant.latitude.label"/> <f:display bean="restaurant" property="latitude" /><br/>
            <g:message code="restaurant.longitude.label"/> <f:display bean="restaurant" property="longitude" /><br/>

            <g:if test="${restaurant?.type}">
                <g:message code="restaurant.type.label"/> <f:display bean="restaurant" property="type" /><br/>
            </g:if>
            <g:if test="${restaurant?.url}">
                <g:message code="restaurant.url.label"/> <f:display bean="restaurant" property="url" /><br/>
            </g:if>
            <g:if test="${restaurant?.email}">
                <g:message code="restaurant.email.label"/> <f:display bean="restaurant" property="email" /><br/>
            </g:if>
            <g:if test="${restaurant?.telephone}">
                <g:message code="restaurant.telephone.label"/> <f:display bean="restaurant" property="telephone" /><br/>
            </g:if>
            <g:if test="${restaurant?.category}">
                <g:message code="restaurant.category.label"/> <f:display bean="restaurant" property="category" /><br/>
            </g:if>
            <g:if test="${restaurant?.streetAddress}">
                <g:message code="restaurant.streetAddress.label"/> <f:display bean="restaurant" property="streetAddress" /><br/>
            </g:if>
            <g:if test="${restaurant?.locality}">
                <g:message code="restaurant.locality.label"/> <f:display bean="restaurant" property="locality" /><br/>
            </g:if>
            <g:if test="${restaurant?.postalCode}">
                <g:message code="restaurant.postalCode.label"/> <f:display bean="restaurant" property="postalCode" /><br/>
            </g:if>
            <g:if test="${restaurant?.province}">
                <g:message code="restaurant.province.label"/> <f:display bean="restaurant" property="province" /><br/>
            </g:if>
            <g:if test="${restaurant?.region}">
                <g:message code="restaurant.region.label"/> <f:display bean="restaurant" property="region" /><br/>
            </g:if>
            <g:if test="${restaurant?.countryName}">
                <g:message code="restaurant.countryName.label"/> <f:display bean="restaurant" property="countryName" /><br/>
            </g:if>
            <g:if test="${restaurant?.toprural}">
                <g:message code="restaurant.toprural.label"/> <f:display bean="restaurant" property="toprural" /><br/>
            </g:if>
            <g:if test="${restaurant?.facebook}">
                <g:message code="restaurant.facebook.label"/> <f:display bean="restaurant" property="facebook" /><br/>
            </g:if>
            <g:if test="${restaurant?.twitter}">
                <g:message code="restaurant.twitter.label"/> <f:display bean="restaurant" property="twitter" /><br/>
            </g:if>
            <g:if test="${restaurant?.googlePlus}">
                <g:message code="restaurant.googlePlus.label"/> <f:display bean="restaurant" property="googlePlus" /><br/>
            </g:if>
            <g:if test="${restaurant?.minube}">
                <g:message code="restaurant.minube.label"/> <f:display bean="restaurant" property="minube" /><br/>
            </g:if>
            <g:if test="${restaurant?.tuenti}">
                <g:message code="restaurant.tuenti.label"/> <f:display bean="restaurant" property="tuenti" /><br/>
            </g:if>
            <g:if test="${restaurant?.officialRanking}">
                <g:message code="restaurant.officialRanking.label"/> <f:display bean="restaurant" property="officialRanking" /><br/>
            </g:if>
            <g:if test="${restaurant?.places}">
                <g:message code="restaurant.places.label"/> <f:display bean="restaurant" property="places" /><br/>
            </g:if>

            <f:display property="about" bean="restaurant"/>
            <hr />
            <g:if test="${restaurant.featuredImageUrl}">
                <h3><g:message code="restaurant.featuredImageUrl.label"/></h3>
                <a href="${restaurant.featuredImageUrl}"><img src="${restaurant.featuredImageUrl}" alt="${restaurant.name}" width="400"/></a>
                <g:form method="DELETE" controller="restaurant" action="deleteFeaturedImageUrl">
                    <g:hiddenField name="id" value="${restaurant.id}"/>
                    <g:hiddenField name="version" value="${restaurant.version}"/>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </g:form>
            </g:if>
            <hr />
            <g:if test="${restaurant.imageUrls}">
                <h3><g:message code="restaurant.imageUrls.label"/></h3>
                <ul>
                <g:each var="imageUrl" in="${restaurant.imageUrls}">
                    <li><a href="${imageUrl}"><img src="${imageUrl}" alt="${restaurant.name}" width="400"/></a>
                        <g:form method="DELETE" controller="restaurant" action="deleteImageUrl">
                            <g:hiddenField name="id" value="${restaurant.id}"/>
                            <g:hiddenField name="version" value="${restaurant.version}"/>
                            <g:hiddenField name="imageUrl" value="${imageUrl}"/>
                            <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                        </g:form>
                    </li>
                </g:each>
                </ul>
            </g:if>

            <g:form resource="${this.restaurant}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="editFeaturedImage" resource="${this.restaurant}"><g:message code="restaurant.featuredImageUrl.edit.label" default="Edit Featured Image" /></g:link>
                    <g:link class="edit" action="addImage" resource="${this.restaurant}"><g:message code="restaurant.image.add.label" default="Add Image" /></g:link>
                    <g:link class="edit" action="edit" resource="${this.restaurant}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
