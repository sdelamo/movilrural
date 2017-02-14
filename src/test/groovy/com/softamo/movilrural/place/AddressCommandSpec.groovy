package com.softamo.movilrural.place

import spock.lang.Specification

class AddressCommandSpec extends Specification {

    def "region is not required"() {
        expect:
        new AddressCommand(region: null).validate(['region'])
    }

    def "countryName is not required"() {
        expect:
        new AddressCommand(countryName: null).validate(['countryName'])
    }

    def "province is not required"() {
        expect:
        new AddressCommand(province: null).validate(['province'])
    }

    def "postalCode is not required"() {
        expect:
        new AddressCommand(postalCode: null).validate(['postalCode'])
    }

    def "streetAddress is not required"() {
        expect:
        new AddressCommand(streetAddress: null).validate(['streetAddress'])
    }

    def "locality is not required"() {
        expect:
        new AddressCommand(locality: null).validate(['locality'])
    }
}
