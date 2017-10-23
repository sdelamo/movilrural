package com.softamo.movilrural.place.poi

import static javax.servlet.http.HttpServletResponse.SC_METHOD_NOT_ALLOWED
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND
import static javax.servlet.http.HttpServletResponse.SC_OK
import com.softamo.movilrural.PoiGormService
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification
import spock.lang.Unroll

class PoiControllerAllowedMethodsSpec extends Specification implements ControllerUnitTest<PoiController> {

    @Unroll
    def "test PoiController.show does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.show()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test PoiController.show accepts GET requests"() {
        when:
        controller.poiGormService = Mock(PoiGormService)
        request.method = 'GET'
        controller.show()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test PoiController.editFeaturedImage does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.editFeaturedImage()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test PoiController.editFeaturedImage accepts GET requests"() {
        when:
        controller.poiGormService = Mock(PoiGormService)
        request.method = 'GET'
        controller.editFeaturedImage()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test PoiController.editAddress does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.editAddress()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test PoiController.editAddress accepts GET requests"() {
        when:
        controller.poiGormService = Mock(PoiGormService)
        request.method = 'GET'
        controller.editAddress()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test PoiController.editSocialNetwork does not accept #method requests"(String method) {
        when:
        controller.poiGormService = Mock(PoiGormService)
        request.method = method
        controller.editSocialNetwork()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test PoiController.editSocialNetwork accepts GET requests"() {
        when:
        controller.poiGormService = Mock(PoiGormService)
        request.method = 'GET'
        controller.editSocialNetwork()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test PoiController.edit does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.edit()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test PoiController.edit accepts GET requests"() {
        when:
        controller.poiGormService = Mock(PoiGormService)
        request.method = 'GET'
        controller.edit()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test PoiController.create does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.create()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test PoiController.create accepts GET requests"() {
        when:
        controller.poiGormService = Mock(PoiGormService)
        request.method = 'GET'
        controller.create()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test PoiController.update does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.update()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'GET']
    }

    def "test PoiController.update accepts GET requests"() {
        when:
        controller.poiGormService = Mock(PoiGormService)
        request.method = 'PUT'
        controller.update()

        then:
        response.status == SC_OK
    }

    @Unroll
    def "test PoiController.uploadFeaturedImage does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.uploadFeaturedImage()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'PUT', 'GET']
    }

    def "test PoiController.uploadFeaturedImage accepts GET requests"() {
        when:
        controller.poiGormService = Mock(PoiGormService)
        request.method = 'POST'
        controller.uploadFeaturedImage()

        then:
        response.status == SC_OK
    }

    @Unroll
    def "test PoiController.index does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.index()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test PoiController.index accepts GET requests"() {
        when:
        controller.poiGormService = Stub(PoiGormService) {
            list(_) >> [[], 0]
        }
        request.method = 'GET'
        controller.index()

        then:
        response.status == SC_OK
    }

    @Unroll
    def "test PoiController.save does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.save()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'GET', 'DELETE', 'PUT']
    }

    def "test PoiController.save accepts POST requests"() {
        when:
        controller.poiGormService = Mock(PoiGormService)
        request.method = 'POST'
        controller.save()

        then:
        response.status == SC_OK
    }

    @Unroll
    def "test PoiController.delete does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.delete()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'GET', 'POST', 'PUT']
    }

    def "test PoiController.delete accepts GET requests"() {
        when:
        controller.poiGormService = Mock(PoiGormService)
        request.method = 'DELETE'
        controller.delete()

        then:
        response.status == SC_NOT_FOUND
    }
}
