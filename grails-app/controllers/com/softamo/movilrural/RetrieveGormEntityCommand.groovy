package com.softamo.movilrural

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable

@GrailsCompileStatic
class RetrieveGormEntityCommand implements Validateable {
    Long id

    static constraints = {
        id nullable: false
    }
}
