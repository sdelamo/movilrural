package org.adelsierranorte.tvmlkit

import groovy.transform.CompileStatic
import groovy.transform.TypeCheckingMode
import org.grails.plugins.tvml.MediaItemGormService
import org.grails.plugins.tvml.RetrieveGormEntityCommand

@CompileStatic
class TvmlController {

    static responseFormats = ['xml']

    static allowedMethods = [index: 'GET', show: 'GET']

    MediaItemGormService mediaItemGormService

    TvmlService tvmlService

    @CompileStatic(TypeCheckingMode.SKIP)
    def index() {
        def (l, total) = mediaItemGormService.list(params)
        def categories = tvmlService.mediaItemCategories()
        [mediaItemList: l, mediaItemCount: total, categories: categories]
    }

    def show(RetrieveGormEntityCommand id) {
        def mediaItem = mediaItemGormService.findById(id)
        [
                mediaItem: mediaItem,
                relatedMediaItems: tvmlService.findAllMediaItemInTheSameCategory(mediaItem.subtitle)
        ]
    }
}
