package com.softamo.movilrural.api.v1.village

import com.softamo.movilrural.Village
import grails.rest.RestfulController
import groovy.transform.CompileStatic

@CompileStatic
class VillageController extends RestfulController<Village> {
    static responseFormats = ['json']
    static namespace = 'v1'

    VillageController() {
        super(Village)
    }

    @Override
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 1000)
        respond listAllResources(params), model: [("${resourceName}Count".toString()): countResources()]
    }
}
