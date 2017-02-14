package com.softamo.movilrural

import spock.lang.Specification

class RetrieveGormEntityCommandSpec extends Specification {

    def "id is required"() {
        expect:
        new RetrieveGormEntityCommand(id: 1l).validate(['id'])

        and:
        !new RetrieveGormEntityCommand(id: null).validate(['id'])
    }
}
