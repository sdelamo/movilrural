package com.softamo.movilrural.api.v1.village

import static javax.servlet.http.HttpServletResponse.SC_METHOD_NOT_ALLOWED
import static javax.servlet.http.HttpServletResponse.SC_OK

import grails.test.hibernate.HibernateSpec
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Unroll
import spock.lang.Ignore

@Ignore
class ApiV1VillageControllerAllowedMethodSpec extends HibernateSpec implements ControllerUnitTest<VillageController> {

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
