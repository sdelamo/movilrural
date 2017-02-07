package com.softamo.movilrural

import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile

class ImageCommand implements Validateable {
    MultipartFile imageFile
    Long id
    Integer version

    static constraints = {
        id nullable: false
        version nullable: false
        imageFile validator: ConstraintsUtils.imageFile()
    }
}
