package com.softamo.movilrural.place

import com.softamo.movilrural.ConstraintsUtils
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class PlaceUpdateCommand extends PlaceCreateCommand  {
    Long id
    Long version

    static constraints = {
        id nullable: false
        version nullable: false
        name nullable: false, blank: false
        url nullable: true
        email nullable: true
        telephone nullable: true
        about nullable: true
        category nullable: true
        officialRanking nullable: true
        latitude nullable: true, validator:
                    ConstraintsUtils.latitudeCustomValidator('latitude', 'range.toosmall', 'range.toobig')
        longitude nullable: true, validator:
                    ConstraintsUtils.longitudeCustomValidator('longitude', 'range.toosmall', 'range.toobig')
    }
}
