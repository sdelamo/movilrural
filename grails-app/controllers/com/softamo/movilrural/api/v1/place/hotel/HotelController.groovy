package com.softamo.movilrural.api.v1.place.hotel

import com.softamo.movilrural.Hotel
import grails.rest.RestfulController
import groovy.transform.CompileStatic

@CompileStatic
class HotelController extends RestfulController<Hotel> {
    static responseFormats = ['json']
    static namespace = 'v1'

    HotelController() {
        super(Hotel)
    }

    @Override
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 1000)
        respond listAllResources(params), model: [("${resourceName}Count".toString()): countResources()]
    }
}
