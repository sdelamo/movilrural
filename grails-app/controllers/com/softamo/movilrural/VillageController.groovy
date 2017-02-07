package com.softamo.movilrural

import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.NOT_FOUND
import grails.transaction.Transactional

class VillageController {

    static allowedMethods = [index: 'GET',
                             show: 'GET',
                             create: 'GET',
                             editFeaturedImage: 'GET',
                             edit: 'GET',
                             uploadFeaturedImage: 'POST',
                             save: 'POST',
                             update: 'PUT',
                             delete: 'DELETE']

    UploadVillageFeaturedImageService uploadVillageFeaturedImageService

    VillageGormService villageGormService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def (l, total) = villageGormService.list(params)
        respond l, model: [villageCount: total]
    }

    @Transactional(readOnly = true)
    def show(Village village) {
        respond village
    }

    @SuppressWarnings('GrailsMassAssignment')
    @SuppressWarnings('FactoryMethodName')
    @Transactional(readOnly = true)
    def create() {
        respond new Village(params)
    }

    @Transactional(readOnly = true)
    def editFeaturedImage(Village village) {
        respond village
    }

    @Transactional(readOnly = true)
    def addImage(Village village) {
        respond village
    }

    @Transactional(readOnly = true)
    def edit(Village village) {
        respond village
    }

    def uploadFeaturedImage(FeaturedImageCommand cmd) {

        if (cmd.hasErrors()) {
            respond(cmd.errors, model: [village: cmd], view: 'editFeaturedImage')
            return
        }

        def village = uploadVillageFeaturedImageService.uploadFeatureImage(cmd)
        if (village == null) {
            notFound()
            return
        }

        if (village.hasErrors()) {
            respond(village.errors, model: [village: village], view: 'editFeaturedImage')
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message',
                                       args: [message(code: 'village.label',
                                                      default: 'Village'), village.id])
                redirect village
            }
            '*' { respond village, [status: OK] }
        }
    }

    def uploadImage(ImageCommand cmd) {

        if (cmd.hasErrors()) {
            respond(cmd.errors, model: [village: cmd], view: 'addImage')
            return
        }

        def village = uploadVillageFeaturedImageService.uploadImage(cmd)
        if (village == null) {
            notFound()
            return
        }

        if (village.hasErrors()) {
            respond(village.errors, model: [village: village], view: 'addImage')
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message',
                        args: [message(code: 'village.label',
                                default: 'Village'), village.id])
                redirect village
            }
            '*' { respond village, [status: OK] }
        }
    }

    def save(VillageCreateCommand cmd) {
        if (cmd == null) {
            notFound()
            return
        }

        if (cmd.hasErrors()) {
            respond cmd.errors, model: [village: cmd], view: 'create'
            return
        }

        def village = villageGormService.save(cmd)

        if ( village == null ) {
            notFound()
            return
        }

        if ( village.hasErrors() ) {
            respond village.errors, model: [village: village], view: 'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message',
                                        args: [message(code: 'village.label',
                                                       default: 'Village'), village.id])
                redirect village
            }
            '*' { respond village, [status: CREATED] }
        }
    }

    def update(VillageUpdateCommand cmd) {
        if (cmd == null) {
            notFound()
            return
        }

        if (cmd.hasErrors()) {
            respond cmd.errors, model: [village: cmd], view: 'edit'
            return
        }

        def village = villageGormService.update(cmd)

        if ( village == null) {
            notFound()
            return
        }

        if ( village.hasErrors() ) {
            respond village.errors, model: [village: village], view: 'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message',
                                        args: [message(code: 'village.label',
                                                       default: 'Village'), village.id])
                redirect village
            }
            '*' { respond village, [status: OK] }
        }
    }

    def delete() {

        Long villageId = params.long('id')

        if ( !villageId ) {
            notFound()
            return
        }

        villageGormService.deleteById(villageId)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message',
                                        args: [message(code: 'village.label',
                                                       default: 'Village'), villageId])
                redirect action: 'index', method: 'GET'
            }
            '*' { render status: NO_CONTENT }
        }
    }


    def deleteFeaturedImageUrl(DeleteFeaturedImageUrlCommand cmd) {
        if ( !cmd ) {
            notFound()
            return
        }

        if (cmd.hasErrors()) {
            respond cmd.errors, view: 'show'
            return
        }

        Village village = villageGormService.deleteFeaturedImageUrl(cmd)
        if ( village == null) {
            notFound()
            return
        }

        redirect(action: 'show', id: village.id)
    }

    def deleteImageUrl(DeleteImageUrlCommand cmd) {
        if ( !cmd ) {
            notFound()
            return
        }

        if (cmd.hasErrors()) {
            respond cmd.errors, view: 'show'
            return
        }

        Village village = villageGormService.deleteImageUrl(cmd)
        if ( village == null) {
            notFound()
            return
        }

        redirect(action: 'show', id: village.id)
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message',
                                        args: [message(code: 'village.label',
                                                       default: 'Village'), params.id])
                redirect action: 'index', method: 'GET'
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
