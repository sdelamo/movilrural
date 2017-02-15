package com.softamo.movilrural.place.hotel

import static javax.servlet.http.HttpServletResponse.SC_METHOD_NOT_ALLOWED
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND
import static javax.servlet.http.HttpServletResponse.SC_OK

import com.softamo.movilrural.HotelGormService

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(HotelController)
class HotelControllerAllowedMethodsSpec extends Specification {

    @Unroll
    def "test HotelController.editAddress does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.editAddress()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test HotelController.editAddress accepts GET requests"() {
        when:
        controller.hotelGormService = Mock(HotelGormService)
        request.method = 'GET'
        controller.editAddress()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test HotelController.editSocialNetwork does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.editSocialNetwork()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test HotelController.editSocialNetwork accepts GET requests"() {
        when:
        controller.hotelGormService = Mock(HotelGormService)
        request.method = 'GET'
        controller.editSocialNetwork()

        then:
        response.status == SC_NOT_FOUND
    }
    @Unroll
    def "test HotelController.show does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.show()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test HotelController.show accepts GET requests"() {
        when:
        controller.hotelGormService = Mock(HotelGormService)
        request.method = 'GET'
        controller.show()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test HotelController.editFeaturedImage does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.editFeaturedImage()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test HotelController.editFeaturedImage accepts GET requests"() {
        when:
        controller.hotelGormService = Mock(HotelGormService)
        request.method = 'GET'
        controller.editFeaturedImage()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test HotelController.edit does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.edit()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test HotelController.edit accepts GET requests"() {
        when:
        controller.hotelGormService = Mock(HotelGormService)
        request.method = 'GET'
        controller.edit()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test HotelController.create does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.create()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test HotelController.create accepts GET requests"() {
        when:
        controller.hotelGormService = Mock(HotelGormService)
        request.method = 'GET'
        controller.create()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test HotelController.update does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.update()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'GET']
    }

    def "test HotelController.update accepts GET requests"() {
        when:
        controller.hotelGormService = Mock(HotelGormService)
        request.method = 'PUT'
        controller.update()

        then:
        response.status == SC_OK
    }

    @Unroll
    def "test HotelController.uploadFeaturedImage does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.uploadFeaturedImage()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'PUT', 'GET']
    }

    def "test HotelController.uploadFeaturedImage accepts GET requests"() {
        when:
        controller.hotelGormService = Mock(HotelGormService)
        request.method = 'POST'
        controller.uploadFeaturedImage()

        then:
        response.status == SC_OK
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

    def "test HotelController.index accepts GET requests"() {
        when:
        controller.hotelGormService = Stub(HotelGormService) {
            list(_) >> [[], 0]
        }
        request.method = 'GET'
        controller.index()

        then:
        response.status == SC_OK
    }

    @Unroll
    def "test HotelController.save does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.save()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'GET', 'DELETE', 'PUT']
    }

    def "test HotelController.save accepts POST requests"() {
        when:
        controller.hotelGormService = Mock(HotelGormService)
        request.method = 'POST'
        controller.save()

        then:
        response.status == SC_OK
    }

    @Unroll
    def "test HotelController.delete does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.delete()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'GET', 'POST', 'PUT']
    }

    def "test HotelController.delete accepts GET requests"() {
        when:
        controller.hotelGormService = Mock(HotelGormService)
        request.method = 'DELETE'
        controller.delete()

        then:
        response.status == SC_NOT_FOUND
    }
}
