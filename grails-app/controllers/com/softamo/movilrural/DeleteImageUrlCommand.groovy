package com.softamo.movilrural

import grails.validation.Validateable

class DeleteImageUrlCommand implements Validateable {
    Long id
    Integer version
    String imageUrl

    static constraints = {
        id nullable: false
        version nullable: false
        imageUrl nullable: false
    }
}
