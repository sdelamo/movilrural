package com.softamo.movilrural

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable

@GrailsCompileStatic
class DeleteFeaturedImageUrlCommand implements Validateable {
    Long id
    Long version

    static constraints = {
        id nullable: false
        version nullable: false
    }
}
