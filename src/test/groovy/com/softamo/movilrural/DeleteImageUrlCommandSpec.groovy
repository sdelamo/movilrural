package com.softamo.movilrural

import spock.lang.Specification

class DeleteImageUrlCommandSpec extends Specification {

    def "id is required"() {
        expect:
        new DeleteImageUrlCommand(id: 1l).validate(['id'])

        and:
        !new DeleteImageUrlCommand(id: null).validate(['id'])
    }

    def "version is required"() {
        expect:
        new DeleteImageUrlCommand(version: 1).validate(['version'])

        and:
        !new DeleteImageUrlCommand(version: null).validate(['version'])
    }

    def "imageUrl is required"() {
        expect:
        new DeleteImageUrlCommand(imageUrl: 'http://example.com/landscape.jpg').validate(['imageUrl'])

        and:
        !new DeleteImageUrlCommand(imageUrl: null).validate(['version'])
    }
}
