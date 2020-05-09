package com.softamo.movilrural

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
class InfoSpec extends Specification {

    @Shared
    @AutoCleanup
    HttpClient client

    @OnceBefore
    void init() {
        client  = HttpClient.create(new URL("http://localhost:$serverPort"))
    }

    def "test git commit info appears in JSON"() {
        given:
        HttpRequest request = HttpRequest.GET("/info")
                .accept(MediaType.APPLICATION_JSON_TYPE)
        when:
        HttpResponse<Map> resp = client.toBlocking().exchange(request, Map)

        then:
        resp.status() == HttpStatus.OK

        when:
        Map json = resp.body()

        then:
        json
        json.git
        json.git.commit
        json.git.commit.time
        json.git.commit.id
        json.git.branch
    }
}
