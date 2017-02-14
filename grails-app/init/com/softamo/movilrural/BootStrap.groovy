package com.softamo.movilrural

import grails.util.Environment

class BootStrap {

    final static List<String> VISITOR_AUTHORITIES = ['ROLE_VILLAGE_VISITOR',
                                             'ROLE_POI_VISITOR',
                                             'ROLE_HOTEL_VISITOR',
                                             'ROLE_RESTAURANT_VISITOR',
                                             'ROLE_VIDEO_VISITOR',
                                             'ROLE_ROUTE_VISITOR']

    final static List<String> EDITOR_AUTHORITIES = ['ROLE_VILLAGE_EDITOR',
                       'ROLE_POI_EDITOR',
                       'ROLE_HOTEL_EDITOR',
                       'ROLE_RESTAURANT_EDITOR',
                       'ROLE_VIDEO_EDITOR',
                       'ROLE_ROUTE_EDITOR']

    final static List<String> MANAGER_AUTHORITIES =
                       ['ROLE_VILLAGE_MANAGER',
                       'ROLE_POI_MANAGER',
                       'ROLE_HOTEL_MANAGER',
                       'ROLE_RESTAURANT_MANAGER',
                       'ROLE_VIDEO_MANAGER',
                       'ROLE_ROUTE_MANAGER']

    def init = { servletContext ->
        saveRoles()
        saveAdminUser()
    }

    def destroy = {
    }

    void saveAdminUser() {
        if ( Environment.DEVELOPMENT == Environment.current) {
            if ( !User.findByUsername('admin') ) {
                def user = new User('admin', 'admin')
                user.save failOnError: true
                allAuthorities().each { String authority ->
                    def role = Role.findByAuthority(authority)
                    def userRole = new UserRole(user, role)
                    userRole.save failOnError: true
                }
            }
        }
    }

    static List<String> allAuthorities() {
        def authorities = []
        authorities += VISITOR_AUTHORITIES
        authorities += EDITOR_AUTHORITIES
        authorities += MANAGER_AUTHORITIES
        authorities
    }

    void saveRoles() {
        allAuthorities().each { String authority ->
            if ( !Role.findByAuthority(authority) ) {
                new Role(authority).save()
            }
        }
    }
}
