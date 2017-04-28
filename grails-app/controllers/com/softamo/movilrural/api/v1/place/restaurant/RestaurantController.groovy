package com.softamo.movilrural.api.v1.place.restaurant

import com.softamo.movilrural.Restaurant
import grails.rest.RestfulController
import groovy.transform.CompileStatic

@CompileStatic
class RestaurantController extends RestfulController<Restaurant> {
    static responseFormats = ['json']
    static namespace = 'v1'

    RestaurantController() {
        super(Restaurant)
    }

    @Override
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 1000)
        respond listAllResources(params), model: [("${resourceName}Count".toString()): countResources()]
    }
}
