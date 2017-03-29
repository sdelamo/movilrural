package org.adelsierranorte.tvmlkit

import grails.transaction.Transactional
import org.grails.plugins.tvml.MediaItem

class TvmlService {

    @Transactional(readOnly = true)
    Set<String> mediaItemCategories() {
        def c = MediaItem.createCriteria()
        c.listDistinct {
            projections {
                property('subtitle')
            }
        } as Set<String>
    }

    @Transactional(readOnly = true)
    Iterable<MediaItem> findAllMediaItemInTheSameCategory(String category) {

        def c = MediaItem.createCriteria()
        c.list {
            eq('subtitle', category)
        } as Iterable<MediaItem>
    }
}