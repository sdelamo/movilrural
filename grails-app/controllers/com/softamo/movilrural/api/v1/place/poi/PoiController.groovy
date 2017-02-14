package com.softamo.movilrural.api.v1.place.poi

import com.softamo.movilrural.Poi
import grails.rest.RestfulController

class PoiController extends RestfulController<Poi> {
    static responseFormats = ['json']
    static namespace = 'v1'

    PoiController() {
        super(Poi)
    }
}
