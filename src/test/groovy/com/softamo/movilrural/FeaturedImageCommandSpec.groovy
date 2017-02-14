package com.softamo.movilrural

import spock.lang.Specification

class FeaturedImageCommandSpec extends Specification {

    def "id is required"() {
        expect:
        new FeaturedImageCommand(id: 1l).validate(['id'])

        and:
        !new FeaturedImageCommand(id: null).validate(['id'])
    }

    def "version is required"() {
        expect:
        new FeaturedImageCommand(version: 1).validate(['version'])

        and:
        !new FeaturedImageCommand(version: null).validate(['version'])
    }

    def "imageUrl is required"() {
        expect:
        !new FeaturedImageCommand(featuredImageFile: null).validate(['featuredImageFile'])
    }
}
