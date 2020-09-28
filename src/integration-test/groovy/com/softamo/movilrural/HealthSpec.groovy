package com.softamo.movilrural

import com.softamo.movilrural.fixtures.MySQL
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
class HealthSpec  extends Specification {

    def setupSpec() {
        MySQL.init()
    }

    @Shared
    @AutoCleanup
    HttpClient client

    @OnceBefore
    void init() {
        client  = HttpClient.create(new URL("http://localhost:$serverPort"))
    }

    def "/health is an anonymous accessible endpoint and returns up"() {
        when:
        HttpRequest request = HttpRequest.GET("/health")
                .accept(MediaType.APPLICATION_JSON_TYPE)
        HttpResponse<Map> response = client.toBlocking().exchange(request, Map)

        then:
        response.status() == HttpStatus.OK
        response.getBody().isPresent()

        when:
        Map m = response.body.get()

        then:
        m.status == 'UP'
    }
}
