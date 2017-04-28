package com.softamo.movilrural.api.hotel

import grails.plugins.rest.client.RestBuilder
import grails.test.mixin.integration.Integration
import spock.lang.Specification

@Integration
class ApiRestaurantControllerIntegrationSpec extends Specification {

    def "api/guest/restaurants is an anonymous accessible endpoint"() {
        given:
        RestBuilder rest = new RestBuilder()

        when:
        def resp = rest.get("http://localhost:${serverPort}/api/guest/restaurants") {
            accept('application/json')
            header("Accept-Version", "1.0")
        }

        then:
        resp.statusCode.value() == 200
    }
}
