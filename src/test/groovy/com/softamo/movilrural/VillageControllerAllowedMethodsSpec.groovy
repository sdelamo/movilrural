package com.softamo.movilrural

import static javax.servlet.http.HttpServletResponse.SC_METHOD_NOT_ALLOWED
import static javax.servlet.http.HttpServletResponse.SC_OK
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND

import grails.test.hibernate.HibernateSpec
import spock.lang.Ignore
import grails.test.mixin.TestFor
import spock.lang.Unroll

@Ignore
@TestFor(VillageController)
class VillageControllerAllowedMethodsSpec extends HibernateSpec {

    def setup() {
        controller.transactionManager = transactionManager
    }

    /*

					[pattern: '/village/show',  access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/village/create',  access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/village/editFeaturedImage',  access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/village/edit',  access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/village/uploadFeaturedImage',  access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/village/save',  access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
					[pattern: '/village/update',  access: ['ROLE_VILLAGE_EDITOR', 'ROLE_VILLAGE_MANAGER']],
     */

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
    def "test VillageController.delete does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.delete()

        then:
        response.status == SC_METHOD_NOT_ALLOWED

        where:
        method << ['PATCH', 'GET', 'POST', 'PUT']
    }

    def "test VillageController.delete accepts DELETE requests"() {
        when:
        controller.villageGormService = Mock(VillageGormService)
        request.method = 'DELETE'
        controller.delete()

        then:
        response.status == SC_NOT_FOUND
    }

    @Unroll
    def "test VillageController.show does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.delete()

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
}
