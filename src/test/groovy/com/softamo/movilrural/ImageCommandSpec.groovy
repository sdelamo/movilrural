package com.softamo.movilrural

import spock.lang.Specification

class ImageCommandSpec extends Specification {

    def "id is required"() {
        expect:
        new ImageCommand(id: 1l).validate(['id'])

        and:
        !new ImageCommand(id: null).validate(['id'])
    }

    def "version is required"() {
        expect:
        new ImageCommand(version: 1).validate(['version'])

        and:
        !new ImageCommand(version: null).validate(['version'])
    }

    def "imageUrl is required"() {
        expect:
        !new ImageCommand(imageFile: null).validate(['imageFile'])
    }
}
