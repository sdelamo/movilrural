package com.softamo.movilrural.place

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable

@GrailsCompileStatic
class SocialNetworkCommand implements Validateable {
    Long id
    Long version
    String toprural
    String facebook
    String twitter
    String googlePlus
    String minube
    String tuenti

    static constraints = {
        id nullable: false
        version nullable: false
        toprural nullable: true
        facebook nullable: true
        twitter nullable: true
        googlePlus nullable: true
        minube nullable: true
        tuenti nullable: true
    }
}
