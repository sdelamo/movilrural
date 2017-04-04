package com.softamo.movilrural

class Place {
    String name
    String url
    String email
    String telephone
    String about
    String category
    String officialRanking
    BigDecimal latitude
    BigDecimal longitude
    String featuredImageUrl
    Address address
    SocialNetwork socialNetwork
    Date dateCreated
    Date lastUpdated

    static hasMany = [imageUrls: String]
    static embedded = ['address', 'socialNetwork']

    static constraints = {
        name nullable: false, blank: false
        url nullable: true
        email nullable: true
        telephone nullable: true
        about nullable: true
        category nullable: true
        address nullable: true
        socialNetwork nullable: true
        officialRanking nullable: true
        latitude nullable: true, validator: ConstraintsUtils.latitudeCustomValidator('latitude',
                'range.toosmall',
                'range.toobig')
        longitude nullable: true, validator: ConstraintsUtils.longitudeCustomValidator('longitude',
                'range.toosmall',
                'range.toobig')
        featuredImageUrl nullable: true
        imageUrls nullable: true
    }

    static mapping = {
        about type: 'text'
        sort name: 'asc'
    }
}

class Poi extends Place {

    static constraints = {
        latitude nullable: true
        longitude nullable: true
    }
}

class Restaurant extends Place { }

class Hotel extends Place {
    Integer places

    static constraints = {
        places nullable: true
    }
}

class Address {
    String streetAddress
    String locality
    String postalCode
    String province
    String region
    String countryName

    static constraints = {
        streetAddress nullable: true
        locality nullable: true
        postalCode nullable: true
        province nullable: true
        region nullable: true
        countryName nullable: true
    }
}

class SocialNetwork {
    String toprural
    String facebook
    String twitter
    String googlePlus
    String minube
    String tuenti

    static constraints = {
        toprural nullable: true
        facebook nullable: true
        twitter nullable: true
        googlePlus nullable: true
        minube nullable: true
        tuenti nullable: true
    }
}
