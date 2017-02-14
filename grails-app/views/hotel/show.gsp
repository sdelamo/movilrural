<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'hotel.label', default: 'Hotel')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-hotel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-hotel" class="content scaffold-show" role="main" style="padding: 1em;">
            <h1><f:display bean="hotel" property="name" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:message code="hotel.latitude.label"/> <f:display bean="hotel" property="latitude" /><br/>
            <g:message code="hotel.longitude.label"/> <f:display bean="hotel" property="longitude" /><br/>

            <g:if test="${hotel?.type}">
                <g:message code="hotel.type.label"/> <f:display bean="hotel" property="type" /><br/>
            </g:if>
            <g:if test="${hotel?.url}">
                <g:message code="hotel.url.label"/> <f:display bean="hotel" property="url" /><br/>
            </g:if>
            <g:if test="${hotel?.email}">
                <g:message code="hotel.email.label"/> <f:display bean="hotel" property="email" /><br/>
            </g:if>
            <g:if test="${hotel?.telephone}">
                <g:message code="hotel.telephone.label"/> <f:display bean="hotel" property="telephone" /><br/>
            </g:if>
            <g:if test="${hotel?.category}">
                <g:message code="hotel.category.label"/> <f:display bean="hotel" property="category" /><br/>
            </g:if>
            <g:if test="${hotel?.streetAddress}">
                <g:message code="hotel.streetAddress.label"/> <f:display bean="hotel" property="streetAddress" /><br/>
            </g:if>
            <g:if test="${hotel?.locality}">
                <g:message code="hotel.locality.label"/> <f:display bean="hotel" property="locality" /><br/>
            </g:if>
            <g:if test="${hotel?.postalCode}">
                <g:message code="hotel.postalCode.label"/> <f:display bean="hotel" property="postalCode" /><br/>
            </g:if>
            <g:if test="${hotel?.province}">
                <g:message code="hotel.province.label"/> <f:display bean="hotel" property="province" /><br/>
            </g:if>
            <g:if test="${hotel?.region}">
                <g:message code="hotel.region.label"/> <f:display bean="hotel" property="region" /><br/>
            </g:if>
            <g:if test="${hotel?.countryName}">
                <g:message code="hotel.countryName.label"/> <f:display bean="hotel" property="countryName" /><br/>
            </g:if>
            <g:if test="${hotel?.toprural}">
                <g:message code="hotel.toprural.label"/> <f:display bean="hotel" property="toprural" /><br/>
            </g:if>
            <g:if test="${hotel?.facebook}">
                <g:message code="hotel.facebook.label"/> <f:display bean="hotel" property="facebook" /><br/>
            </g:if>
            <g:if test="${hotel?.twitter}">
                <g:message code="hotel.twitter.label"/> <f:display bean="hotel" property="twitter" /><br/>
            </g:if>
            <g:if test="${hotel?.googlePlus}">
                <g:message code="hotel.googlePlus.label"/> <f:display bean="hotel" property="googlePlus" /><br/>
            </g:if>
            <g:if test="${hotel?.minube}">
                <g:message code="hotel.minube.label"/> <f:display bean="hotel" property="minube" /><br/>
            </g:if>
            <g:if test="${hotel?.tuenti}">
                <g:message code="hotel.tuenti.label"/> <f:display bean="hotel" property="tuenti" /><br/>
            </g:if>
            <g:if test="${hotel?.officialRanking}">
                <g:message code="hotel.officialRanking.label"/> <f:display bean="hotel" property="officialRanking" /><br/>
            </g:if>
            <g:if test="${hotel?.places}">
                <g:message code="hotel.places.label"/> <f:display bean="hotel" property="places" /><br/>
            </g:if>

            <f:display property="about" bean="hotel"/>
            <hr />
            <g:if test="${hotel.featuredImageUrl}">
                <h3><g:message code="hotel.featuredImageUrl.label"/></h3>
                <a href="${hotel.featuredImageUrl}"><img src="${hotel.featuredImageUrl}" alt="${hotel.name}" width="400"/></a>
                <g:form method="DELETE" controller="hotel" action="deleteFeaturedImageUrl">
                    <g:hiddenField name="id" value="${hotel.id}"/>
                    <g:hiddenField name="version" value="${hotel.version}"/>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </g:form>
            </g:if>
            <hr />
            <g:if test="${hotel.imageUrls}">
                <h3><g:message code="hotel.imageUrls.label"/></h3>
                <ul>
                <g:each var="imageUrl" in="${hotel.imageUrls}">
                    <li><a href="${imageUrl}"><img src="${imageUrl}" alt="${hotel.name}" width="400"/></a>
                        <g:form method="DELETE" controller="hotel" action="deleteImageUrl">
                            <g:hiddenField name="id" value="${hotel.id}"/>
                            <g:hiddenField name="version" value="${hotel.version}"/>
                            <g:hiddenField name="imageUrl" value="${imageUrl}"/>
                            <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                        </g:form>
                    </li>
                </g:each>
                </ul>
            </g:if>

            <g:form resource="${this.hotel}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="editFeaturedImage" resource="${this.hotel}"><g:message code="hotel.featuredImageUrl.edit.label" default="Edit Featured Image" /></g:link>
                    <g:link class="edit" action="addImage" resource="${this.hotel}"><g:message code="hotel.image.add.label" default="Add Image" /></g:link>
                    <g:link class="edit" action="edit" resource="${this.hotel}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
