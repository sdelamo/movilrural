package com.softamo.movilrural.village

import static javax.servlet.http.HttpServletResponse.SC_METHOD_NOT_ALLOWED
import static javax.servlet.http.HttpServletResponse.SC_OK
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND
import com.softamo.movilrural.VillageGormService
import spock.lang.Specification
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Unroll

class VillageControllerAllowedMethodsSpec extends Specification implements ControllerUnitTest<VillageController> {

    @Unroll
    def "test VillageController.show does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.show()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test VillageController.show accepts GET requests"() {
        when:
        controller.villageGormService = Mock(VillageGormService)
        request.method = 'GET'
        controller.show()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test VillageController.editFeaturedImage does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.editFeaturedImage()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test VillageController.editFeaturedImage accepts GET requests"() {
        when:
        controller.villageGormService = Mock(VillageGormService)
        request.method = 'GET'
        controller.editFeaturedImage()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test VillageController.edit does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.edit()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test VillageController.edit accepts GET requests"() {
        when:
        controller.villageGormService = Mock(VillageGormService)
        request.method = 'GET'
        controller.edit()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test VillageController.create does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.create()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'PUT']
    }

    def "test VillageController.create accepts GET requests"() {
        when:
        controller.villageGormService = Mock(VillageGormService)
        request.method = 'GET'
        controller.create()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test VillageController.update does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.update()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'POST', 'GET']
    }

    def "test VillageController.update accepts GET requests"() {
        when:
        controller.villageGormService = Mock(VillageGormService)
        request.method = 'PUT'
        controller.update()

        then:
        response.status == SC_OK
    }

    @Unroll
    def "test VillageController.uploadFeaturedImage does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.uploadFeaturedImage()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'DELETE', 'PUT', 'GET']
    }

    def "test VillageController.uploadFeaturedImage accepts GET requests"() {
        when:
        controller.villageGormService = Mock(VillageGormService)
        request.method = 'POST'
        controller.uploadFeaturedImage()

        then:
        response.status == SC_OK
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

    def "test VillageController.index accepts GET requests"() {
        when:
        controller.villageGormService = Stub(VillageGormService) {
            list(_) >> [[], 0]
        }
        request.method = 'GET'
        controller.index()

        then:
        response.status == SC_OK
    }

    @Unroll
    def "test VillageController.save does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.save()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'GET', 'DELETE', 'PUT']
    }

    def "test VillageController.save accepts POST requests"() {
        when:
        controller.villageGormService = Mock(VillageGormService)
        request.method = 'POST'
        controller.save()

        then:
        response.status == SC_OK
    }

    @Unroll
    def "test VillageController.delete does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.delete()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'GET', 'POST', 'PUT']
    }

    def "test VillageController.delete accepts GET requests"() {
        when:
        controller.villageGormService = Mock(VillageGormService)
        request.method = 'DELETE'
        controller.delete()

        then:
        response.status == SC_NOT_FOUND
    }
}
