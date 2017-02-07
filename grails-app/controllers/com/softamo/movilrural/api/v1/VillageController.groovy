package com.softamo.movilrural.api.v1

import com.softamo.movilrural.Village
import grails.rest.RestfulController

class VillageController extends RestfulController {
    static responseFormats = ['json']
    static namespace = 'v1'

    VillageController() {
        super(Village)
    }
}
