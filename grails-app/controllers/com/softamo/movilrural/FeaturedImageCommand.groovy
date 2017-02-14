package com.softamo.movilrural

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile

@GrailsCompileStatic
class FeaturedImageCommand implements Validateable {
    MultipartFile featuredImageFile
    Long id
    Long version

    static constraints = {
        id nullable: false
        version nullable: false
        featuredImageFile validator: ConstraintsUtils.imageFile()
    }
}
