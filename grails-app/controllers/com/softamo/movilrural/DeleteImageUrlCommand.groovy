package com.softamo.movilrural

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable

@GrailsCompileStatic
class DeleteImageUrlCommand implements Validateable {
    Long id
    Long version
    String imageUrl

    static constraints = {
        id nullable: false
        version nullable: false
        imageUrl nullable: false
    }
}
