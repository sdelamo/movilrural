package com.softamo.movilrural

import com.softamo.movilrural.place.AddressCommand
import com.softamo.movilrural.place.PlaceCreateCommand
import com.softamo.movilrural.place.PlaceUpdateCommand
import com.softamo.movilrural.place.SocialNetworkCommand
import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@GrailsCompileStatic
class HotelGormService {

    @SuppressWarnings('GrailsMassAssignment')
    @SuppressWarnings('FactoryMethodName')
    @ReadOnly
    Hotel createHotel(Map params) {
        new Hotel(params)
    }

    @ReadOnly
    Hotel findById(RetrieveGormEntityCommand cmd) {
        Hotel.get(cmd?.id)
    }

    @ReadOnly
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

    @Transactional
    Hotel updateSocialNetwork(SocialNetworkCommand cmd) {
        Hotel hotel = Hotel.get(cmd.id)
        if ( !hotel ) {
            return null
        }
        hotel.version = cmd.version
        def socialNetwork = PlaceService.createSocialNetwork(cmd)
        socialNetwork.save()
        hotel.socialNetwork = socialNetwork
        hotel.save()
    }

    @Transactional
    Hotel updateAddress(AddressCommand cmd) {
        Hotel hotel = Hotel.get(cmd.id)
        if ( !hotel ) {
            return null
        }
        hotel.version = cmd.version
        def address = PlaceService.createAddress(cmd)
        address.save()
        hotel.address = address
        hotel.save()
    }
}
