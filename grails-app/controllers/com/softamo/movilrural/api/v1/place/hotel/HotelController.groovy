package com.softamo.movilrural.api.v1.place.hotel

import com.softamo.movilrural.Hotel
import grails.rest.RestfulController

class HotelController extends RestfulController<Hotel> {
    static responseFormats = ['json']
    static namespace = 'v1'

    HotelController() {
        super(Hotel)
    }
}
