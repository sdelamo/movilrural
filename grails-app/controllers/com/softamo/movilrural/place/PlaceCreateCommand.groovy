package com.softamo.movilrural.place

import com.softamo.movilrural.Address
import com.softamo.movilrural.ConstraintsUtils
import com.softamo.movilrural.SocialNetwork
import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable

@GrailsCompileStatic
class PlaceCreateCommand implements Validateable {
    String name
    String type
    String url
    String email
    String telephone
    String about
    String category
    String officialRanking
    BigDecimal latitude
    BigDecimal longitude
    String featuredImageUrl
    Address address
    SocialNetwork socialNetwork

    static constraints = {
        name nullable: false, blank: false
        type nullable: true
        url nullable: true
        email nullable: true
        telephone nullable: true
        about nullable: true
        category nullable: true
        address nullable: true
        socialNetwork nullable: true
        officialRanking nullable: true

        latitude nullable: false, validator:
            ConstraintsUtils.latitudeCustomValidator('latitude', 'range.toosmall', 'range.toobig')
        longitude nullable: false, validator:
            ConstraintsUtils.longitudeCustomValidator('longitude', 'range.toosmall', 'range.toobig')
    }
}
