package com.softamo.movilrural.api.poi

import grails.testing.mixin.integration.Integration
import grails.testing.spock.OnceBefore
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.client.HttpClient
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

@Integration
class ApiPoiControllerIntegrationSpec extends Specification {

    @Shared
    @AutoCleanup
    HttpClient client

    @OnceBefore
    void init() {
        client  = HttpClient.create(new URL("http://localhost:$serverPort"))
    }

    def "api/guest/pois is an anonymous accessible endpoint"() {
        when:
        HttpRequest request = HttpRequest.GET("/api/guest/pois")
                .header("Accept-Version", "1.0")
                .accept(MediaType.APPLICATION_JSON_TYPE)
        HttpResponse response = client.toBlocking().exchange(request)

        then:
        response.status() == HttpStatus.OK
    }
}
