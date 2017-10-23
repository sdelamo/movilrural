package com.softamo.movilrural.place.restaurant

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
import com.softamo.movilrural.Restaurant
import com.softamo.movilrural.RestaurantGormService
import com.softamo.movilrural.RetrieveGormEntityCommand
import com.softamo.movilrural.UploadRestaurantFeaturedImageService

import groovy.transform.CompileStatic
import groovy.transform.TypeCheckingMode

@CompileStatic
class RestaurantController {

    static allowedMethods = [index: 'GET',
                             show: 'GET',
                             create: 'GET',
                             editAddress: 'GET',
                             updateAddress: 'POST',
                             updateSocialNetwork: 'POST',
                             editSocialNetwork: 'GET',
                             editFeaturedImage: 'GET',
                             edit: 'GET',
                             uploadFeaturedImage: 'POST',
                             save: 'POST',
                             update: 'PUT',
                             delete: 'DELETE']

    UploadRestaurantFeaturedImageService uploadRestaurantFeaturedImageService

    RestaurantGormService restaurantGormService

    @CompileStatic(TypeCheckingMode.SKIP)
    def index(Integer max) {
        params.max = Math.min(max ?: 50, 100)
        def (l, total) = restaurantGormService.list(params)
        respond l, model: [restaurantCount: total]
    }

    def show(RetrieveGormEntityCommand cmd) {
        respond restaurantGormService.findById(cmd)
    }

    @SuppressWarnings('FactoryMethodName')
    def create() {
        respond restaurantGormService.createRestaurant(params)
    }

    def editAddress(RetrieveGormEntityCommand cmd) {
        respond restaurantGormService.findById(cmd)
    }

    def editSocialNetwork(RetrieveGormEntityCommand cmd) {
        respond restaurantGormService.findById(cmd)
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    def updateAddress(AddressCommand cmd) {
        if (cmd.hasErrors()) {
            respond(cmd.errors, model: [restaurant: cmd], view: 'editAddress')
            return
        }

        def restaurant = restaurantGormService.updateAddress(cmd)
        if (restaurant == null) {
            notFound()
            return
        }

        if (restaurant.hasErrors()) {
            respond(restaurant.errors, model: [restaurant: restaurant], view: 'editAddress')
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message',
                        args: [message(code: 'restaurant.label',
                                default: 'Restaurant'), restaurant.id])
                redirect restaurant
            }
            '*' { respond restaurant, [status: OK] }
        }
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    def updateSocialNetwork(SocialNetworkCommand cmd) {
        if (cmd.hasErrors()) {
            respond(cmd.errors, model: [restaurant: cmd], view: 'editSocialNetwork')
            return
        }

        def restaurant = restaurantGormService.updateSocialNetwork(cmd)
        if (restaurant == null) {
            notFound()
            return
        }

        if (restaurant.hasErrors()) {
            respond(restaurant.errors, model: [restaurant: restaurant], view: 'editSocialNetwork')
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message',
                        args: [message(code: 'restaurant.label',
                                default: 'Restaurant'), restaurant.id])
                redirect restaurant
            }
            '*' { respond restaurant, [status: OK] }
        }
    }

    def editFeaturedImage(RetrieveGormEntityCommand cmd) {
        respond restaurantGormService.findById(cmd)
    }

    def addImage(RetrieveGormEntityCommand cmd) {
        respond restaurantGormService.findById(cmd)
    }

    def edit(RetrieveGormEntityCommand cmd) {
        respond restaurantGormService.findById(cmd)
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    def uploadFeaturedImage(FeaturedImageCommand cmd) {

        if (cmd.hasErrors()) {
            respond(cmd.errors, model: [restaurant: cmd], view: 'editFeaturedImage')
            return
        }

        def restaurant = uploadRestaurantFeaturedImageService.uploadFeatureImage(cmd)
        if (restaurant == null) {
            notFound()
            return
        }

        if (restaurant.hasErrors()) {
            respond(restaurant.errors, model: [restaurant: restaurant], view: 'editFeaturedImage')
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message',
                                       args: [message(code: 'restaurant.label',
                                                      default: 'Restaurant'), restaurant.id])
                redirect restaurant
            }
            '*' { respond restaurant, [status: OK] }
        }
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    def uploadImage(ImageCommand cmd) {

        if (cmd.hasErrors()) {
            respond(cmd.errors, model: [restaurant: cmd], view: 'addImage')
            return
        }

        def restaurant = uploadRestaurantFeaturedImageService.uploadImage(cmd)
        if (restaurant == null) {
            notFound()
            return
        }

        if (restaurant.hasErrors()) {
            respond(restaurant.errors, model: [restaurant: restaurant], view: 'addImage')
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message',
                        args: [message(code: 'restaurant.label',
                                default: 'Restaurant'), restaurant.id])
                redirect restaurant
            }
            '*' { respond restaurant, [status: OK] }
        }
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    def save(PlaceCreateCommand cmd) {
        if (cmd == null) {
            notFound()
            return
        }

        if (cmd.hasErrors()) {
            respond cmd.errors, model: [restaurant: cmd], view: 'create'
            return
        }

        def restaurant = restaurantGormService.save(cmd)

        if ( restaurant == null ) {
            notFound()
            return
        }

        if ( restaurant.hasErrors() ) {
            respond restaurant.errors, model: [restaurant: restaurant], view: 'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message',
                                        args: [message(code: 'restaurant.label',
                                                       default: 'Restaurant'), restaurant.id])
                redirect restaurant
            }
            '*' { respond restaurant, [status: CREATED] }
        }
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    def update(PlaceUpdateCommand cmd) {
        if (cmd == null) {
            notFound()
            return
        }

        if (cmd.hasErrors()) {
            respond cmd.errors, model: [restaurant: cmd], view: 'edit'
            return
        }

        def restaurant = restaurantGormService.update(cmd)

        if ( restaurant == null) {
            notFound()
            return
        }

        if ( restaurant.hasErrors() ) {
            respond restaurant.errors, model: [restaurant: restaurant], view: 'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message',
                                        args: [message(code: 'restaurant.label',
                                                       default: 'Restaurant'), restaurant.id])
                redirect restaurant
            }
            '*' { respond restaurant, [status: OK] }
        }
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    def delete() {

        Long restaurantId = params.long('id')

        if ( !restaurantId ) {
            notFound()
            return
        }

        restaurantGormService.deleteById(restaurantId)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message',
                                        args: [message(code: 'restaurant.label',
                                                       default: 'Restaurant'), restaurantId])
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

        Restaurant restaurant = uploadRestaurantFeaturedImageService.deleteFeaturedImageUrl(cmd)
        if ( restaurant == null) {
            notFound()
            return
        }

        redirect(action: 'show', id: restaurant.id)
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

        Restaurant restaurant = uploadRestaurantFeaturedImageService.deleteImageUrl(cmd)
        if ( restaurant == null) {
            notFound()
            return
        }

        redirect(action: 'show', id: restaurant.id)
    }

    @CompileStatic(TypeCheckingMode.SKIP)
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message',
                                        args: [message(code: 'restaurant.label',
                                                       default: 'Restaurant'), params.id])
                redirect action: 'index', method: 'GET'
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
