package com.softamo.movilrural

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile

@GrailsCompileStatic
class ImageCommand implements Validateable {
    MultipartFile imageFile
    Long id
    Long version

    static constraints = {
        id nullable: false
        version nullable: false
        imageFile validator: ConstraintsUtils.imageFile()
    }
}
