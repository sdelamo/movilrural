package com.softamo.movilrural.place.restaurant

import static javax.servlet.http.HttpServletResponse.SC_METHOD_NOT_ALLOWED
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND
import static javax.servlet.http.HttpServletResponse.SC_OK

import com.softamo.movilrural.RestaurantGormService
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(RestaurantController)
class RestaurantControllerAllowedMethodsSpec extends Specification {

    @Unroll
    def "test RestaurantController.editAddress does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.editAddress()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test RestaurantController.editAddress accepts GET requests"() {
        when:
        controller.restaurantGormService = Mock(RestaurantGormService)
        request.method = 'GET'
        controller.editAddress()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test RestaurantController.editSocialNetwork does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.editSocialNetwork()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test RestaurantController.editSocialNetwork accepts GET requests"() {
        when:
        controller.restaurantGormService = Mock(RestaurantGormService)
        request.method = 'GET'
        controller.editSocialNetwork()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test RestaurantController.show does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.show()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test RestaurantController.show accepts GET requests"() {
        when:
        controller.restaurantGormService = Mock(RestaurantGormService)
        request.method = 'GET'
        controller.show()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test RestaurantController.editFeaturedImage does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.editFeaturedImage()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test RestaurantController.editFeaturedImage accepts GET requests"() {
        when:
        controller.restaurantGormService = Mock(RestaurantGormService)
        request.method = 'GET'
        controller.editFeaturedImage()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test RestaurantController.edit does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.edit()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test RestaurantController.edit accepts GET requests"() {
        when:
        controller.restaurantGormService = Mock(RestaurantGormService)
        request.method = 'GET'
        controller.edit()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test RestaurantController.create does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.create()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test RestaurantController.create accepts GET requests"() {
        when:
        controller.restaurantGormService = Mock(RestaurantGormService)
        request.method = 'GET'
        controller.create()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test RestaurantController.update does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.update()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'GET']
    }

    def "test RestaurantController.update accepts GET requests"() {
        when:
        controller.restaurantGormService = Mock(RestaurantGormService)
        request.method = 'PUT'
        controller.update()

        then:
        response.status == SC_OK
    }

    @Unroll
    def "test RestaurantController.uploadFeaturedImage does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.uploadFeaturedImage()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'PUT', 'GET']
    }

    def "test RestaurantController.uploadFeaturedImage accepts GET requests"() {
        when:
        controller.restaurantGormService = Mock(RestaurantGormService)
        request.method = 'POST'
        controller.uploadFeaturedImage()

        then:
        response.status == SC_OK
    }

    @Unroll
    def "test RestaurantController.index does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.index()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test RestaurantController.index accepts GET requests"() {
        when:
        controller.restaurantGormService = Stub(RestaurantGormService) {
            list(_) >> [[], 0]
        }
        request.method = 'GET'
        controller.index()

        then:
        response.status == SC_OK
    }

    @Unroll
    def "test RestaurantController.save does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.save()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'GET', 'DELETE', 'PUT']
    }

    def "test RestaurantController.save accepts POST requests"() {
        when:
        controller.restaurantGormService = Mock(RestaurantGormService)
        request.method = 'POST'
        controller.save()

        then:
        response.status == SC_OK
    }

    @Unroll
    def "test RestaurantController.delete does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.delete()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'GET', 'POST', 'PUT']
    }

    def "test RestaurantController.delete accepts GET requests"() {
        when:
        controller.restaurantGormService = Mock(RestaurantGormService)
        request.method = 'DELETE'
        controller.delete()

        then:
        response.status == SC_NOT_FOUND
    }
}
