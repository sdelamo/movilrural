package com.softamo.movilrural

import com.softamo.movilrural.place.AddressCommand
import com.softamo.movilrural.place.SocialNetworkCommand
import groovy.transform.CompileStatic

@CompileStatic
class PlaceService {

    @SuppressWarnings('FactoryMethodName')
    static Address createAddress(AddressCommand cmd) {
        def address = new Address()
        address.with {
            streetAddress = cmd.streetAddress
            countryName = cmd.countryName
            locality = cmd.locality
            postalCode = cmd.postalCode
            province = cmd.province
            region = cmd.region
        }
        address
    }

    @SuppressWarnings('FactoryMethodName')
    static SocialNetwork createSocialNetwork(SocialNetworkCommand cmd) {
        def sn = new SocialNetwork()
        sn.with {
            toprural = cmd.toprural
            facebook = cmd.facebook
            twitter = cmd.twitter
            googlePlus = cmd.googlePlus
            minube = cmd.minube
            tuenti = cmd.tuenti
        }
        sn
    }
}
