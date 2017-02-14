package com.softamo.movilrural.place

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable

@GrailsCompileStatic
class SocialNetworkCommand implements Validateable {
    String toprural
    String facebook
    String twitter
    String googlePlus
    String minube
    String tuenti

    static constraints = {
        toprural nullable: true
        facebook nullable: true
        twitter nullable: true
        googlePlus nullable: true
        minube nullable: true
        tuenti nullable: true
    }
}
