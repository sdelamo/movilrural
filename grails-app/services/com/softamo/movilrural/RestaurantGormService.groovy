package com.softamo.movilrural

import com.softamo.movilrural.place.AddressCommand
import com.softamo.movilrural.place.PlaceCreateCommand
import com.softamo.movilrural.place.PlaceUpdateCommand
import com.softamo.movilrural.place.SocialNetworkCommand
import grails.compiler.GrailsCompileStatic
import grails.transaction.Transactional

@GrailsCompileStatic
class RestaurantGormService {

    @SuppressWarnings('GrailsMassAssignment')
    @SuppressWarnings('FactoryMethodName')
    @Transactional(readOnly = true)
    Restaurant createRestaurant(Map params) {
        new Restaurant(params)
    }

    @Transactional(readOnly = true)
    Restaurant findById(RetrieveGormEntityCommand cmd) {
        Restaurant.get(cmd?.id)
    }

    @Transactional(readOnly = true)
    List list(Map params) {
        [Restaurant.list(params), Restaurant.count()]
    }

    @Transactional
    Restaurant addImageUrl(Long id, Long version, String imageUrl) {
        Restaurant restaurant = Restaurant.get(id)
        if ( !restaurant ) {
            return null
        }
        if ( !restaurant.featuredImageUrl ) {
            return updateFeaturedImageUrl(id, version, imageUrl)
        }
        restaurant.version = version
        restaurant.addToImageUrls(imageUrl)
        restaurant.save()
    }

    @Transactional
    Restaurant updateFeaturedImageUrl(Long id, Long version, String featuredImageUrl) {
        Restaurant restaurant = Restaurant.get(id)
        if ( !restaurant ) {
            return null
        }
        restaurant.version = version
        restaurant.featuredImageUrl = featuredImageUrl
        restaurant.save()
    }

    @Transactional
    Restaurant save(PlaceCreateCommand cmd) {
        def restaurant = new Restaurant()
        restaurant.properties = cmd.properties
        restaurant.save()
    }

    @Transactional
    Restaurant update(PlaceUpdateCommand cmd) {
        Restaurant restaurant = Restaurant.get(cmd.id)
        restaurant.properties = cmd.properties
        restaurant.save()
    }

    @Transactional
    void deleteById(Long restaurantId) {
        def restaurant = Restaurant.get(restaurantId)
        restaurant?.delete()
    }

    @Transactional
    Restaurant deleteFeaturedImageUrl(DeleteFeaturedImageUrlCommand cmd) {
        Restaurant restaurant = Restaurant.get(cmd.id)
        if ( !restaurant ) {
            return null
        }
        restaurant.version = cmd.version
        restaurant.featuredImageUrl = null
        if ( restaurant.imageUrls ) {
            def imageUrl = restaurant.imageUrls.first()
            restaurant.featuredImageUrl = imageUrl
            restaurant.removeFromImageUrls(imageUrl)

        }
        restaurant.save()
    }

    @Transactional
    Restaurant deleteImageUrl(DeleteImageUrlCommand cmd) {
        Restaurant restaurant = Restaurant.get(cmd.id)
        if ( !restaurant ) {
            return null
        }
        restaurant.version = cmd.version
        restaurant.removeFromImageUrls(cmd.imageUrl)
        restaurant.save()
    }

    @Transactional
    Restaurant updateSocialNetwork(SocialNetworkCommand cmd) {
        Restaurant restaurant = Restaurant.get(cmd.id)
        if ( !restaurant ) {
            return null
        }
        restaurant.version = cmd.version
        def socialNetwork = PlaceService.createSocialNetwork(cmd)
        socialNetwork.save()
        restaurant.socialNetwork = socialNetwork
        restaurant.save()
    }

    @Transactional
    Restaurant updateAddress(AddressCommand cmd) {
        Restaurant restaurant = Restaurant.get(cmd.id)
        if ( !restaurant ) {
            return null
        }
        restaurant.version = cmd.version
        def address = PlaceService.createAddress(cmd)
        address.save()
        restaurant.address = address
        restaurant.save()
    }
}
