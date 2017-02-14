package com.softamo.movilrural.place

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable

@GrailsCompileStatic
class PlaceUpdateCommand extends PlaceCreateCommand implements Validateable {
    Long id
    Long version

    static constraints = {
        id nullable: false
        version nullable: false
    }
}
