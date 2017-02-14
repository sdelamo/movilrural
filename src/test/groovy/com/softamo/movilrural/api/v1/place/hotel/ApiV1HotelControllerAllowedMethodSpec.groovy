package com.softamo.movilrural.api.v1.place.hotel

import static javax.servlet.http.HttpServletResponse.SC_METHOD_NOT_ALLOWED
import static javax.servlet.http.HttpServletResponse.SC_OK

import grails.test.hibernate.HibernateSpec
import grails.test.mixin.TestFor
import spock.lang.Ignore
import spock.lang.Unroll

@Ignore
@TestFor(HotelController)
class ApiV1HotelControllerAllowedMethodSpec extends HibernateSpec {

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
