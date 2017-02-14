package com.softamo.movilrural

import grails.plugin.awssdk.s3.AmazonS3Service
import groovy.transform.CompileStatic
import org.grails.datastore.gorm.GormEntity
import org.springframework.web.multipart.MultipartFile

@CompileStatic
trait ImageUploadable {
    AmazonS3Service amazonS3Service

    abstract String pathWithMultipartFile(Long id, MultipartFile imageFile)

    GormEntity uploadImageToS3(Long id, Long version, MultipartFile file, Closure cls) {

        def path = pathWithMultipartFile(id, file)

        String s3FileUrl = amazonS3Service.storeMultipartFile(path, file)
        if ( !s3FileUrl ) {
            return null
        }

        GormEntity entity = cls(id, version, s3FileUrl) as GormEntity
        if ( !entity || entity.hasErrors() ) {
            deleteFileFromServer(path)
        }
        entity
    }

    void deleteFileFromServer(String key) {
        amazonS3Service.deleteFile(key)
    }
}
