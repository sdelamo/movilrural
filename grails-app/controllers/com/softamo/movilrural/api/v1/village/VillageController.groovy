package com.softamo.movilrural.api.v1.village

import com.softamo.movilrural.Village
import grails.rest.RestfulController

class VillageController extends RestfulController<Village> {
    static responseFormats = ['json']
    static namespace = 'v1'

    VillageController() {
        super(Village)
    }
}
