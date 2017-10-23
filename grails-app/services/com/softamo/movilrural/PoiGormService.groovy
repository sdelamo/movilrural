package com.softamo.movilrural

import com.softamo.movilrural.place.AddressCommand
import com.softamo.movilrural.place.PlaceCreateCommand
import com.softamo.movilrural.place.PlaceUpdateCommand
import com.softamo.movilrural.place.SocialNetworkCommand
import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

class PoiGormService {

    @SuppressWarnings('GrailsMassAssignment')
    @SuppressWarnings('FactoryMethodName')
    @ReadOnly
    Poi createPoi(Map params) {
        new Poi(params)
    }

    @ReadOnly
    Poi findById(RetrieveGormEntityCommand cmd) {
        Poi.get(cmd?.id)
    }

    @ReadOnly
    List list(Map params) {
        [Poi.list(params), Poi.count()]
    }

    @Transactional
    Poi addImageUrl(Long id, Long version, String imageUrl) {
        Poi poi = Poi.get(id)
        if ( !poi ) {
            return null
        }
        if ( !poi.featuredImageUrl ) {
            return updateFeaturedImageUrl(id, version, imageUrl)
        }
        poi.version = version
        poi.addToImageUrls(imageUrl)
        poi.save()
    }

    @Transactional
    Poi updateFeaturedImageUrl(Long id, Long version, String featuredImageUrl) {
        Poi poi = Poi.get(id)
        if ( !poi ) {
            return null
        }
        poi.version = version
        poi.featuredImageUrl = featuredImageUrl
        poi.save()
    }

    @Transactional
    Poi save(PlaceCreateCommand cmd) {
        def poi = new Poi()
        poi.properties = cmd.properties
        poi.save()
    }

    @Transactional
    Poi update(PlaceUpdateCommand cmd) {
        Poi poi = Poi.get(cmd.id)
        poi.properties = cmd.properties
        poi.save()
    }

    @Transactional
    void deleteById(Long poiId) {
        def poi = Poi.get(poiId)
        poi?.delete()
    }

    @Transactional
    Poi deleteFeaturedImageUrl(DeleteFeaturedImageUrlCommand cmd) {
        Poi poi = Poi.get(cmd.id)
        if ( !poi ) {
            return null
        }
        poi.version = cmd.version
        poi.featuredImageUrl = null
        if ( poi.imageUrls ) {
            def imageUrl = poi.imageUrls.first()
            poi.featuredImageUrl = imageUrl
            poi.removeFromImageUrls(imageUrl)

        }
        poi.save()
    }

    @Transactional
    Poi deleteImageUrl(DeleteImageUrlCommand cmd) {
        Poi poi = Poi.get(cmd.id)
        if ( !poi ) {
            return null
        }
        poi.version = cmd.version
        poi.removeFromImageUrls(cmd.imageUrl)
        poi.save()
    }

    @Transactional
    Poi updateSocialNetwork(SocialNetworkCommand cmd) {
        Poi poi = Poi.get(cmd.id)
        if ( !poi ) {
            return null
        }
        poi.version = cmd.version
        def socialNetwork = PlaceService.createSocialNetwork(cmd)
        socialNetwork.save()
        poi.socialNetwork = socialNetwork
        poi.save()
    }

    @Transactional
    Poi updateAddress(AddressCommand cmd) {
        Poi poi = Poi.get(cmd.id)
        if ( !poi ) {
            return null
        }
        poi.version = cmd.version
        def address = PlaceService.createAddress(cmd)
        address.save()
        poi.address = address
        poi.save()
    }
}
