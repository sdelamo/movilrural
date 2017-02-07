package com.softamo.movilrural

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
    }

    def destroy = {
    }

    void saveRoles() {
        def authorities = []
        authorities += VISITOR_AUTHORITIES
        authorities += EDITOR_AUTHORITIES
        authorities += MANAGER_AUTHORITIES
        authorities.each { String authority ->
            if ( !Role.findByAuthority(authority) ) {
                new Role(authority).save()
            }
        }
    }
}
