package com.softamo.movilrural.api.v1.place.hotel

import static javax.servlet.http.HttpServletResponse.SC_METHOD_NOT_ALLOWED
import static javax.servlet.http.HttpServletResponse.SC_OK
import grails.test.hibernate.HibernateSpec
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Ignore
import spock.lang.Unroll

@Ignore
class ApiV1HotelControllerAllowedMethodSpec extends HibernateSpec implements ControllerUnitTest<HotelController> {

    def setup() {
        controller.transactionManager = transactionManager
    }

    @Unroll
    def "test HotelController.index does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.index()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test HotelController.index accepts POST requests"() {
        when:
        request.method = 'GET'
        controller.index()

        then:
        response.status == SC_OK
    }
}
