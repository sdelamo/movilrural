package com.softamo.movilrural.place.poi

import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT

import com.softamo.movilrural.place.AddressCommand
import com.softamo.movilrural.place.SocialNetworkCommand

import com.softamo.movilrural.DeleteFeaturedImageUrlCommand
import com.softamo.movilrural.DeleteImageUrlCommand
import com.softamo.movilrural.FeaturedImageCommand
import com.softamo.movilrural.ImageCommand
import com.softamo.movilrural.place.PlaceCreateCommand
import com.softamo.movilrural.place.PlaceUpdateCommand
import com.softamo.movilrural.Poi
import com.softamo.movilrural.PoiGormService
import com.softamo.movilrural.RetrieveGormEntityCommand
import com.softamo.movilrural.UploadPoiFeaturedImageService

import groovy.transform.CompileStatic
import groovy.transform.TypeCheckingMode

@CompileStatic
class PoiController {

    static allowedMethods = [index: 'GET',
                             show: 'GET',
                             create: 'GET',
                             editFeaturedImage: 'GET',
                             editAddress: 'GET',
                             updateAddress: 'POST',
                             updateSocialNetwork: 'POST',
                             editSocialNetwork: 'GET',
                             edit: 'GET',
                             uploadFeaturedImage: 'POST',
                             save: 'POST',
                             update: 'PUT',
                             delete: 'DELETE']

    UploadPoiFeaturedImageService uploadPoiFeaturedImageService

    PoiGormService poiGormService

    @CompileStatic(TypeCheckingMode.SKIP)
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def (l, total) = poiGormService.list(params)
        respond l, model: [poiCount: total]
    }

    def show(RetrieveGormEntityCommand cmd) {
        respond poiGormService.findById(cmd)
    }

    @SuppressWarnings('FactoryMethodName')
    def create() {
        respond poiGormService.createPoi(params)
    }

    def editFeaturedImage(RetrieveGormEntityCommand cmd) {
        respond poiGormService.findById(cmd)
    }

    def editAddress(RetrieveGormEntityCommand cmd) {
        respond poiGormService.findById(cmd)
    }

    def editSocialNetwork(RetrieveGormEntityCommand cmd) {
        respond poiGormService.findById(cmd)
    }

    def addImage(RetrieveGormEntityCommand cmd) {
        respond poiGormService.findById(cmd)
    }

    def edit(RetrieveGormEntityCommand cmd) {
        respond poiGormService.findById(cmd)
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    def updateAddress(AddressCommand cmd) {
        if (cmd.hasErrors()) {
            respond(cmd.errors, model: [poi: cmd], view: 'editAddress')
            return
        }

        def poi = poiGormService.updateAddress(cmd)
        if (poi == null) {
            notFound()
            return
        }

        if (poi.hasErrors()) {
            respond(poi.errors, model: [poi: poi], view: 'editAddress')
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message',
                        args: [message(code: 'poi.label',
                                default: 'Poi'), poi.id])
                redirect poi
            }
            '*' { respond poi, [status: OK] }
        }
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    def updateSocialNetwork(SocialNetworkCommand cmd) {
        if (cmd.hasErrors()) {
            respond(cmd.errors, model: [poi: cmd], view: 'editSocialNetwork')
            return
        }

        def poi = poiGormService.updateSocialNetwork(cmd)
        if (poi == null) {
            notFound()
            return
        }

        if (poi.hasErrors()) {
            respond(poi.errors, model: [poi: poi], view: 'editSocialNetwork')
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message',
                        args: [message(code: 'poi.label',
                                default: 'Poi'), poi.id])
                redirect poi
            }
            '*' { respond poi, [status: OK] }
        }
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    def uploadFeaturedImage(FeaturedImageCommand cmd) {

        if (cmd.hasErrors()) {
            respond(cmd.errors, model: [poi: cmd], view: 'editFeaturedImage')
            return
        }

        def poi = uploadPoiFeaturedImageService.uploadFeatureImage(cmd)
        if (poi == null) {
            notFound()
            return
        }

        if (poi.hasErrors()) {
            respond(poi.errors, model: [poi: poi], view: 'editFeaturedImage')
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message',
                                       args: [message(code: 'poi.label',
                                                      default: 'Poi'), poi.id])
                redirect poi
            }
            '*' { respond poi, [status: OK] }
        }
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    def uploadImage(ImageCommand cmd) {

        if (cmd.hasErrors()) {
            respond(cmd.errors, model: [poi: cmd], view: 'addImage')
            return
        }

        def poi = uploadPoiFeaturedImageService.uploadImage(cmd)
        if (poi == null) {
            notFound()
            return
        }

        if (poi.hasErrors()) {
            respond(poi.errors, model: [poi: poi], view: 'addImage')
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message',
                        args: [message(code: 'poi.label',
                                default: 'Poi'), poi.id])
                redirect poi
            }
            '*' { respond poi, [status: OK] }
        }
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    def save(PlaceCreateCommand cmd) {
        if (cmd == null) {
            notFound()
            return
        }

        if (cmd.hasErrors()) {
            respond cmd.errors, model: [poi: cmd], view: 'create'
            return
        }

        def poi = poiGormService.save(cmd)

        if ( poi == null ) {
            notFound()
            return
        }

        if ( poi.hasErrors() ) {
            respond poi.errors, model: [poi: poi], view: 'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message',
                                        args: [message(code: 'poi.label',
                                                       default: 'Poi'), poi.id])
                redirect poi
            }
            '*' { respond poi, [status: CREATED] }
        }
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    def update(PlaceUpdateCommand cmd) {
        if (cmd == null) {
            notFound()
            return
        }

        if (cmd.hasErrors()) {
            respond cmd.errors, model: [poi: cmd], view: 'edit'
            return
        }

        def poi = poiGormService.update(cmd)

        if ( poi == null) {
            notFound()
            return
        }

        if ( poi.hasErrors() ) {
            respond poi.errors, model: [poi: poi], view: 'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message',
                                        args: [message(code: 'poi.label',
                                                       default: 'Poi'), poi.id])
                redirect poi
            }
            '*' { respond poi, [status: OK] }
        }
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    def delete() {

        Long poiId = params.long('id')

        if ( !poiId ) {
            notFound()
            return
        }

        poiGormService.deleteById(poiId)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message',
                                        args: [message(code: 'poi.label',
                                                       default: 'Poi'), poiId])
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

        Poi poi = uploadPoiFeaturedImageService.deleteFeaturedImageUrl(cmd)
        if ( poi == null) {
            notFound()
            return
        }

        redirect(action: 'show', id: poi.id)
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

        Poi poi = uploadPoiFeaturedImageService.deleteImageUrl(cmd)
        if ( poi == null) {
            notFound()
            return
        }

        redirect(action: 'show', id: poi.id)
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message',
                                        args: [message(code: 'poi.label',
                                                       default: 'Poi'), params.id])
                redirect action: 'index', method: 'GET'
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
