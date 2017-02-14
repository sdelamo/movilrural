package com.softamo.movilrural.village

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable

@GrailsCompileStatic
class VillageUpdateCommand extends VillageCreateCommand implements Validateable {
    Long id
    Long version

    static constraints = {
        id nullable: false
        version nullable: false
    }
}
