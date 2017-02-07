package com.softamo.movilrural

class Village {
  String name
  String about
  Date dateCreated
  Date lastUpdated
  BigDecimal latitude
  BigDecimal longitude
  String featuredImageUrl
  static hasMany = [imageUrls: String]

  static constraints = {
    name nullable: false, unique: true
    about nullable: true
    latitude nullable: false, validator: ConstraintsUtils.latitudeCustomValidator('latitude',
                                                                                  'range.toosmall',
                                                                                  'range.toobig')
    longitude nullable: false, validator: ConstraintsUtils.longitudeCustomValidator('longitude',
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
