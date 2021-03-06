package com.softamo.movilrural.place

import com.softamo.movilrural.ConstraintsUtils
import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable

@GrailsCompileStatic
class PlaceCreateCommand implements Validateable {
    String name
    String url
    String email
    String telephone
    String about
    String category
    String officialRanking
    BigDecimal latitude
    BigDecimal longitude

    static constraints = {
        name nullable: false, blank: false
        url nullable: true
        email nullable: true
        telephone nullable: true
        about nullable: true
        category nullable: true
        officialRanking nullable: true

        latitude nullable: false, validator:
            ConstraintsUtils.latitudeCustomValidator('latitude', 'range.toosmall', 'range.toobig')
        longitude nullable: false, validator:
            ConstraintsUtils.longitudeCustomValidator('longitude', 'range.toosmall', 'range.toobig')
    }
}
