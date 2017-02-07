package com.softamo.movilrural

import grails.validation.Validateable

class VillageCreateCommand implements Validateable {

    String name
    BigDecimal latitude
    BigDecimal longitude
    String about

    static constraints = {
        name nullable: false
        latitude nullable: false, validator:
                ConstraintsUtils.latitudeCustomValidator('latitude', 'range.toosmall', 'range.toobig')
        longitude nullable: false, validator:
                ConstraintsUtils.longitudeCustomValidator('longitude', 'range.toosmall', 'range.toobig')
    }
}
