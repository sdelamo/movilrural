package com.softamo.movilrural

import com.softamo.movilrural.village.VillageCreateCommand
import com.softamo.movilrural.village.VillageUpdateCommand
import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@GrailsCompileStatic
class VillageGormService {

    @SuppressWarnings('GrailsMassAssignment')
    @SuppressWarnings('FactoryMethodName')
    @ReadOnly
    Village createVillage(Map params) {
        new Village(params)
    }

    @ReadOnly
    Village findById(RetrieveGormEntityCommand cmd) {
        Village.get(cmd?.id)
    }

    @ReadOnly
    List list(Map params) {
        [Village.list(params), Village.count()]
    }

    @Transactional
    Village addImageUrl(Long id, Long version, String imageUrl) {
        Village village = Village.get(id)
        if ( !village ) {
            return null
        }
        if ( !village.featuredImageUrl ) {
            return updateFeaturedImageUrl(id, version, imageUrl)
        }
        village.version = version
        village.addToImageUrls(imageUrl)
        village.save()
    }

    @Transactional
    Village updateFeaturedImageUrl(Long id, Long version, String featuredImageUrl) {
        Village village = Village.get(id)
        if ( !village ) {
            return null
        }
        village.version = version
        village.featuredImageUrl = featuredImageUrl
        village.save()
    }

    @Transactional
    Village save(VillageCreateCommand cmd) {
        def village = new Village()
        village.properties = cmd.properties
        village.save()
    }

    @Transactional
    Village update(VillageUpdateCommand cmd) {
        Village village = Village.get(cmd.id)
        village.properties = cmd.properties
        village.save()
    }

    @Transactional
    void deleteById(Long villageId) {
        def village = Village.get(villageId)
        village?.delete()
    }

    @Transactional
    Village deleteFeaturedImageUrl(DeleteFeaturedImageUrlCommand cmd) {
        Village village = Village.get(cmd.id)
        if ( !village ) {
            return null
        }
        village.version = cmd.version
        village.featuredImageUrl = null
        if ( village.imageUrls ) {
            def imageUrl = village.imageUrls.first()
            village.featuredImageUrl = imageUrl
            village.removeFromImageUrls(imageUrl)

        }
        village.save()
    }

    @Transactional
    Village deleteImageUrl(DeleteImageUrlCommand cmd) {
        Village village = Village.get(cmd.id)
        if ( !village ) {
            return null
        }
        village.version = cmd.version
        village.removeFromImageUrls(cmd.imageUrl)
        village.save()
    }

}
