<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'poi.label', default: 'Point of Interest')}" />
    <title><g:message code="default.edit.label" args="[entityName]" /></title>
</head>
<body>
<a href="#edit-poi" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="edit-poi" class="content scaffold-edit" role="main">
    <h1><g:message code="poi.image.add.label" default="Add Image" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${this.poi}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.poi}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:uploadForm name="uploadImage" action="uploadImage">
        <g:hiddenField name="id" value="${this.poi?.id}" />
        <g:hiddenField name="version" value="${this.poi?.version}" />
        <input type="file" name="imageFile" />
        <fieldset class="buttons">
            <input class="save" type="submit" value="${message(code: 'poi.featuredImage.upload.label', default: 'Upload')}" />
        </fieldset>
    </g:uploadForm>
</div>
</body>
</html>
