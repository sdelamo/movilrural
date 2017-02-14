<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'poi.label', default: 'Point of Interest')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-poi" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-poi" class="content scaffold-show" role="main" style="padding: 1em;">
            <h1><f:display bean="poi" property="name" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:message code="poi.latitude.label"/> <f:display bean="poi" property="latitude" /><br/>
            <g:message code="poi.longitude.label"/> <f:display bean="poi" property="longitude" /><br/>

            <g:if test="${poi?.type}">
                <g:message code="poi.type.label"/> <f:display bean="poi" property="type" /><br/>
            </g:if>
            <g:if test="${poi?.url}">
                <g:message code="poi.url.label"/> <f:display bean="poi" property="url" /><br/>
            </g:if>
            <g:if test="${poi?.email}">
                <g:message code="poi.email.label"/> <f:display bean="poi" property="email" /><br/>
            </g:if>
            <g:if test="${poi?.telephone}">
                <g:message code="poi.telephone.label"/> <f:display bean="poi" property="telephone" /><br/>
            </g:if>
            <g:if test="${poi?.category}">
                <g:message code="poi.category.label"/> <f:display bean="poi" property="category" /><br/>
            </g:if>
            <g:if test="${poi?.streetAddress}">
                <g:message code="poi.streetAddress.label"/> <f:display bean="poi" property="streetAddress" /><br/>
            </g:if>
            <g:if test="${poi?.locality}">
                <g:message code="poi.locality.label"/> <f:display bean="poi" property="locality" /><br/>
            </g:if>
            <g:if test="${poi?.postalCode}">
                <g:message code="poi.postalCode.label"/> <f:display bean="poi" property="postalCode" /><br/>
            </g:if>
            <g:if test="${poi?.province}">
                <g:message code="poi.province.label"/> <f:display bean="poi" property="province" /><br/>
            </g:if>
            <g:if test="${poi?.region}">
                <g:message code="poi.region.label"/> <f:display bean="poi" property="region" /><br/>
            </g:if>
            <g:if test="${poi?.countryName}">
                <g:message code="poi.countryName.label"/> <f:display bean="poi" property="countryName" /><br/>
            </g:if>
            <g:if test="${poi?.toprural}">
                <g:message code="poi.toprural.label"/> <f:display bean="poi" property="toprural" /><br/>
            </g:if>
            <g:if test="${poi?.facebook}">
                <g:message code="poi.facebook.label"/> <f:display bean="poi" property="facebook" /><br/>
            </g:if>
            <g:if test="${poi?.twitter}">
                <g:message code="poi.twitter.label"/> <f:display bean="poi" property="twitter" /><br/>
            </g:if>
            <g:if test="${poi?.googlePlus}">
                <g:message code="poi.googlePlus.label"/> <f:display bean="poi" property="googlePlus" /><br/>
            </g:if>
            <g:if test="${poi?.minube}">
                <g:message code="poi.minube.label"/> <f:display bean="poi" property="minube" /><br/>
            </g:if>
            <g:if test="${poi?.tuenti}">
                <g:message code="poi.tuenti.label"/> <f:display bean="poi" property="tuenti" /><br/>
            </g:if>
            <g:if test="${poi?.officialRanking}">
                <g:message code="poi.officialRanking.label"/> <f:display bean="poi" property="officialRanking" /><br/>
            </g:if>
            <g:if test="${poi?.places}">
                <g:message code="poi.places.label"/> <f:display bean="poi" property="places" /><br/>
            </g:if>

            <f:display property="about" bean="poi"/>
            <hr />
            <g:if test="${poi.featuredImageUrl}">
                <h3><g:message code="poi.featuredImageUrl.label"/></h3>
                <a href="${poi.featuredImageUrl}"><img src="${poi.featuredImageUrl}" alt="${poi.name}" width="400"/></a>
                <g:form method="DELETE" controller="poi" action="deleteFeaturedImageUrl">
                    <g:hiddenField name="id" value="${poi.id}"/>
                    <g:hiddenField name="version" value="${poi.version}"/>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </g:form>
            </g:if>
            <hr />
            <g:if test="${poi.imageUrls}">
                <h3><g:message code="poi.imageUrls.label"/></h3>
                <ul>
                <g:each var="imageUrl" in="${poi.imageUrls}">
                    <li><a href="${imageUrl}"><img src="${imageUrl}" alt="${poi.name}" width="400"/></a>
                        <g:form method="DELETE" controller="poi" action="deleteImageUrl">
                            <g:hiddenField name="id" value="${poi.id}"/>
                            <g:hiddenField name="version" value="${poi.version}"/>
                            <g:hiddenField name="imageUrl" value="${imageUrl}"/>
                            <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                        </g:form>
                    </li>
                </g:each>
                </ul>
            </g:if>

            <g:form resource="${this.poi}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="editFeaturedImage" resource="${this.poi}"><g:message code="poi.featuredImageUrl.edit.label" default="Edit Featured Image" /></g:link>
                    <g:link class="edit" action="addImage" resource="${this.poi}"><g:message code="poi.image.add.label" default="Add Image" /></g:link>
                    <g:link class="edit" action="edit" resource="${this.poi}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
