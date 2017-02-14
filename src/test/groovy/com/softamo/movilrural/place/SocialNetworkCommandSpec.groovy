package com.softamo.movilrural.place

import spock.lang.Specification

class SocialNetworkCommandSpec extends Specification {
   def "toprural is not required"() {
        expect:
        new SocialNetworkCommand(toprural: null).validate(['toprural'])
    }

    def "facebook is not required"() {
        expect:
        new SocialNetworkCommand(facebook: null).validate(['facebook'])
    }

    def "twitter is not required"() {
        expect:
        new SocialNetworkCommand(twitter: null).validate(['twitter'])
    }

    def "googlePlus is not required"() {
        expect:
        new SocialNetworkCommand(googlePlus: null).validate(['googlePlus'])
    }

    def "minube is not required"() {
        expect:
        new SocialNetworkCommand(minube: null).validate(['minube'])
    }

    def "tuenti is not required"() {
        expect:
        new SocialNetworkCommand(tuenti: null).validate(['tuenti'])
    }
}
