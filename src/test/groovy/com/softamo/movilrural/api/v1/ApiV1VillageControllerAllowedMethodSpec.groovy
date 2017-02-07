package com.softamo.movilrural.api.v1

import static javax.servlet.http.HttpServletResponse.SC_METHOD_NOT_ALLOWED
import static javax.servlet.http.HttpServletResponse.SC_OK

import grails.test.hibernate.HibernateSpec

import grails.test.mixin.TestFor
import spock.lang.Unroll
import spock.lang.Ignore

@Ignore
@TestFor(VillageController)
class ApiV1VillageControllerAllowedMethodSpec extends HibernateSpec {

    def setup() {
        controller.transactionManager = transactionManager
    }

    @Unroll
    def "test VillageController.index does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.index()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test VillageController.index accepts POST requests"() {
        when:
        request.method = 'GET'
        controller.index()

        then:
        response.status == SC_OK
    }
}
