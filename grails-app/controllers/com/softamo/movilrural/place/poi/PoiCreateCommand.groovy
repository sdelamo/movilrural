package com.softamo.movilrural.place.poi

import com.softamo.movilrural.ConstraintsUtils
import com.softamo.movilrural.place.PlaceCreateCommand

class PoiCreateCommand extends PlaceCreateCommand {

    static constraints = {
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
