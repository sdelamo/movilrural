package com.softamo.movilrural.village

import com.softamo.movilrural.Village
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import spock.lang.Unroll

class VillageSpec extends Specification implements DomainUnitTest<Village> {

    def "test name cannot be null"() {
        when:
        def village = new Village(name: null)

        then:
        !village.validate(['name'])
        village.errors['name'].code == 'nullable'
    }

    def "test name cannot be blank"() {
        expect:
        !new Village(name: '').validate(['name'])
    }

    @SuppressWarnings('LineLength')
    @Unroll('Village.validate() with latitude: #value should have returned #expected with errorCode: #expectedErrorCode')
    void "test latitude validation"() {
        when:
        def village = new Village(latitude: value)

        then:
        expected == village.validate(['latitude'])
        village.errors['latitude']?.code == expectedErrorCode

        where:
        value                  | expected | expectedErrorCode
        null                   | false    | 'nullable'
        0                      | true     | null
        0.5                    | true     | null
        90                     | true     | null
        90.5                   | false    | 'range.toobig'
        -90                    | true     | null
        -180                   | false    | 'range.toosmall'
        180                    | false    | 'range.toobig'
    }

    @SuppressWarnings('LineLength')
    @Unroll('Village.longitude() with latitude: #value should have returned #expected with error code: #expectedErrorCode')
    void "test longitude validation"() {
        when:
        def village = new Village(longitude: value)

        then:
        expected == village.validate(['longitude'])
        village.errors['longitude']?.code == expectedErrorCode

        where:
        value                  | expected | expectedErrorCode
        null                   | false    | 'nullable'
        0                      | true     | null
        90                     | true     | null
        90.1                   | true     | null
        -90                    | true     | null
        -180                   | true     | null
        180                    | true     | null
        180.1                  | false    | 'range.toobig'
        -180.1                 | false    | 'range.toosmall'
    }

}
