package com.softamo.movilrural.place.hotel

import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT

import com.softamo.movilrural.DeleteFeaturedImageUrlCommand
import com.softamo.movilrural.DeleteImageUrlCommand
import com.softamo.movilrural.FeaturedImageCommand
import com.softamo.movilrural.Hotel
import com.softamo.movilrural.HotelGormService
import com.softamo.movilrural.ImageCommand
import com.softamo.movilrural.place.PlaceCreateCommand
import com.softamo.movilrural.place.PlaceUpdateCommand
import com.softamo.movilrural.RetrieveGormEntityCommand
import com.softamo.movilrural.UploadHotelFeaturedImageService

import groovy.transform.CompileStatic
import groovy.transform.TypeCheckingMode

@CompileStatic
class HotelController {

    static allowedMethods = [index: 'GET',
                             show: 'GET',
                             create: 'GET',
                             editFeaturedImage: 'GET',
                             edit: 'GET',
                             uploadFeaturedImage: 'POST',
                             save: 'POST',
                             update: 'PUT',
                             delete: 'DELETE']

    UploadHotelFeaturedImageService uploadHotelFeaturedImageService

    HotelGormService hotelGormService

    @CompileStatic(TypeCheckingMode.SKIP)
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def (l, total) = hotelGormService.list(params)
        respond l, model: [hotelCount: total]
    }

    def show(RetrieveGormEntityCommand cmd) {
        respond hotelGormService.findById(cmd)
    }

    @SuppressWarnings('FactoryMethodName')
    def create() {
        respond hotelGormService.createHotel(params)
    }

    def editFeaturedImage(RetrieveGormEntityCommand cmd) {
        respond hotelGormService.findById(cmd)
    }

    def addImage(RetrieveGormEntityCommand cmd) {
        respond hotelGormService.findById(cmd)
    }

    def edit(RetrieveGormEntityCommand cmd) {
        respond hotelGormService.findById(cmd)
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    def uploadFeaturedImage(FeaturedImageCommand cmd) {

        if (cmd.hasErrors()) {
            respond(cmd.errors, model: [hotel: cmd], view: 'editFeaturedImage')
            return
        }

        def hotel = uploadHotelFeaturedImageService.uploadFeatureImage(cmd)
        if (hotel == null) {
            notFound()
            return
        }

        if (hotel.hasErrors()) {
            respond(hotel.errors, model: [hotel: hotel], view: 'editFeaturedImage')
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message',
                                       args: [message(code: 'hotel.label',
                                                      default: 'Hotel'), hotel.id])
                redirect hotel
            }
            '*' { respond hotel, [status: OK] }
        }
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    def uploadImage(ImageCommand cmd) {

        if (cmd.hasErrors()) {
            respond(cmd.errors, model: [hotel: cmd], view: 'addImage')
            return
        }

        def hotel = uploadHotelFeaturedImageService.uploadImage(cmd)
        if (hotel == null) {
            notFound()
            return
        }

        if (hotel.hasErrors()) {
            respond(hotel.errors, model: [hotel: hotel], view: 'addImage')
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message',
                        args: [message(code: 'hotel.label',
                                default: 'Hotel'), hotel.id])
                redirect hotel
            }
            '*' { respond hotel, [status: OK] }
        }
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    def save(PlaceCreateCommand cmd) {
        if (cmd == null) {
            notFound()
            return
        }

        if (cmd.hasErrors()) {
            respond cmd.errors, model: [hotel: cmd], view: 'create'
            return
        }

        def hotel = hotelGormService.save(cmd)

        if ( hotel == null ) {
            notFound()
            return
        }

        if ( hotel.hasErrors() ) {
            respond hotel.errors, model: [hotel: hotel], view: 'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message',
                                        args: [message(code: 'hotel.label',
                                                       default: 'Hotel'), hotel.id])
                redirect hotel
            }
            '*' { respond hotel, [status: CREATED] }
        }
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    def update(PlaceUpdateCommand cmd) {
        if (cmd == null) {
            notFound()
            return
        }

        if (cmd.hasErrors()) {
            respond cmd.errors, model: [hotel: cmd], view: 'edit'
            return
        }

        def hotel = hotelGormService.update(cmd)

        if ( hotel == null) {
            notFound()
            return
        }

        if ( hotel.hasErrors() ) {
            respond hotel.errors, model: [hotel: hotel], view: 'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message',
                                        args: [message(code: 'hotel.label',
                                                       default: 'Hotel'), hotel.id])
                redirect hotel
            }
            '*' { respond hotel, [status: OK] }
        }
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    def delete() {

        Long hotelId = params.long('id')

        if ( !hotelId ) {
            notFound()
            return
        }

        hotelGormService.deleteById(hotelId)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message',
                                        args: [message(code: 'hotel.label',
                                                       default: 'Hotel'), hotelId])
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

        Hotel hotel = uploadHotelFeaturedImageService.deleteFeaturedImageUrl(cmd)
        if ( hotel == null) {
            notFound()
            return
        }

        redirect(action: 'show', id: hotel.id)
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

        Hotel hotel = uploadHotelFeaturedImageService.deleteImageUrl(cmd)
        if ( hotel == null) {
            notFound()
            return
        }

        redirect(action: 'show', id: hotel.id)
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message',
                                        args: [message(code: 'hotel.label',
                                                       default: 'Hotel'), params.id])
                redirect action: 'index', method: 'GET'
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
