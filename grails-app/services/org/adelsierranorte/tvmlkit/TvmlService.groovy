package org.adelsierranorte.tvmlkit

import grails.gorm.transactions.ReadOnly
import org.grails.plugins.tvml.MediaItem

class TvmlService {

    @ReadOnly
    Set<String> mediaItemCategories() {
        def c = MediaItem.createCriteria()
        c.listDistinct {
            projections {
                property('subtitle')
            }
        } as Set<String>
    }

    @ReadOnly
    Iterable<MediaItem> findAllMediaItemInTheSameCategory(String category) {

        def c = MediaItem.createCriteria()
        c.list {
            eq('subtitle', category)
        } as Iterable<MediaItem>
    }
}
