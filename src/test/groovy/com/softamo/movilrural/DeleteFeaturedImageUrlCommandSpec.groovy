package com.softamo.movilrural

import spock.lang.Specification

class DeleteFeaturedImageUrlCommandSpec extends Specification {

    def "id is required"() {
        expect:
        new DeleteFeaturedImageUrlCommand(id: 1l).validate(['id'])

        and:
        !new DeleteFeaturedImageUrlCommand(id: null).validate(['id'])
    }

    def "version is required"() {
        expect:
        new DeleteFeaturedImageUrlCommand(version: 1).validate(['version'])

        and:
        !new DeleteFeaturedImageUrlCommand(version: null).validate(['version'])
    }
}
