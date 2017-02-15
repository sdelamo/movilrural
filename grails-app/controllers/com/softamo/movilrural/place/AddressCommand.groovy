package com.softamo.movilrural.place

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable

@GrailsCompileStatic
class AddressCommand implements Validateable {
    Long id
    Long version
    String streetAddress
    String locality
    String postalCode
    String province
    String region
    String countryName

    static constraints = {
        id nullable: false
        version nullable: false
        streetAddress nullable: true
        locality nullable: true
        postalCode nullable: true
        province nullable: true
        region nullable: true
        countryName nullable: true
    }
}
