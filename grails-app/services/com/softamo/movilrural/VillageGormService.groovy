package com.softamo.movilrural

import grails.transaction.Transactional

@Transactional
class VillageGormService {

    @Transactional(readOnly = true)
    List list(Map params) {
        [Village.list(params), Village.count()]
    }

    @Transactional
    Village updateFeaturedImageUrl(Long id, Integer version, String featuredImageUrl) {
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
}
