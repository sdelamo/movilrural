package com.softamo.movilrural

import grails.validation.Validateable

class DeleteFeaturedImageUrlCommand implements Validateable {
    Long id
    Integer version

    static constraints = {
        id nullable: false
        version nullable: false
    }
}
