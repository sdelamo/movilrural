package com.softamo.movilrural

import com.softamo.movilrural.place.PlaceCreateCommand
import com.softamo.movilrural.place.PlaceUpdateCommand
import grails.compiler.GrailsCompileStatic
import grails.transaction.Transactional

@GrailsCompileStatic
class HotelGormService {

    @SuppressWarnings('GrailsMassAssignment')
    @SuppressWarnings('FactoryMethodName')
    @Transactional(readOnly = true)
    Hotel createHotel(Map params) {
        new Hotel(params)
    }

    @Transactional(readOnly = true)
    Hotel findById(RetrieveGormEntityCommand cmd) {
        Hotel.get(cmd?.id)
    }

    @Transactional(readOnly = true)
    List list(Map params) {
        [Hotel.list(params), Hotel.count()]
    }

    @Transactional
    Hotel addImageUrl(Long id, Long version, String imageUrl) {
        Hotel hotel = Hotel.get(id)
        if ( !hotel ) {
            return null
        }
        if ( !hotel.featuredImageUrl ) {
            return updateFeaturedImageUrl(id, version, imageUrl)
        }
        hotel.version = version
        hotel.addToImageUrls(imageUrl)
        hotel.save()
    }

    @Transactional
    Hotel updateFeaturedImageUrl(Long id, Long version, String featuredImageUrl) {
        Hotel hotel = Hotel.get(id)
        if ( !hotel ) {
            return null
        }
        hotel.version = version
        hotel.featuredImageUrl = featuredImageUrl
        hotel.save()
    }

    @Transactional
    Hotel save(PlaceCreateCommand cmd) {
        def hotel = new Hotel()
        hotel.properties = cmd.properties
        hotel.save()
    }

    @Transactional
    Hotel update(PlaceUpdateCommand cmd) {
        Hotel hotel = Hotel.get(cmd.id)
        hotel.properties = cmd.properties
        hotel.save()
    }

    @Transactional
    void deleteById(Long hotelId) {
        def hotel = Hotel.get(hotelId)
        hotel?.delete()
    }

    @Transactional
    Hotel deleteFeaturedImageUrl(DeleteFeaturedImageUrlCommand cmd) {
        Hotel hotel = Hotel.get(cmd.id)
        if ( !hotel ) {
            return null
        }
        hotel.version = cmd.version
        hotel.featuredImageUrl = null
        if ( hotel.imageUrls ) {
            def imageUrl = hotel.imageUrls.first()
            hotel.featuredImageUrl = imageUrl
            hotel.removeFromImageUrls(imageUrl)

        }
        hotel.save()
    }

    @Transactional
    Hotel deleteImageUrl(DeleteImageUrlCommand cmd) {
        Hotel hotel = Hotel.get(cmd.id)
        if ( !hotel ) {
            return null
        }
        hotel.version = cmd.version
        hotel.removeFromImageUrls(cmd.imageUrl)
        hotel.save()
    }
}
