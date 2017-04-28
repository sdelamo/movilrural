package com.softamo.movilrural.api.v1.place.poi

import com.softamo.movilrural.Poi
import grails.rest.RestfulController
import groovy.transform.CompileStatic

@CompileStatic
class PoiController extends RestfulController<Poi> {
    static responseFormats = ['json']
    static namespace = 'v1'

    PoiController() {
        super(Poi)
    }

    @Override
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 1000)
        respond listAllResources(params), model: [("${resourceName}Count".toString()): countResources()]
    }
}
