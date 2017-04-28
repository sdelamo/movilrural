package com.softamo.movilrural.api.hotel

import grails.plugins.rest.client.RestBuilder
import grails.test.mixin.integration.Integration
import spock.lang.Specification

@Integration
class ApiHotelControllerIntegrationSpec extends Specification {

    def "api/guest/hotels is an anonymous accessible endpoint"() {
        given:
        RestBuilder rest = new RestBuilder()

        when:
        def resp = rest.get("http://localhost:${serverPort}/api/guest/hotels") {
            accept('application/json')
            header("Accept-Version", "1.0")
        }

        then:
        resp.statusCode.value() == 200
    }
}
