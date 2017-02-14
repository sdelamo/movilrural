package com.softamo.movilrural.api.v1.place.restaurant

import com.softamo.movilrural.Restaurant
import grails.rest.RestfulController

class RestaurantController extends RestfulController<Restaurant> {
    static responseFormats = ['json']
    static namespace = 'v1'

    RestaurantController() {
        super(Restaurant)
    }
}
