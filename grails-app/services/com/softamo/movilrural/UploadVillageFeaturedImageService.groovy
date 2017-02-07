package com.softamo.movilrural

import org.springframework.web.multipart.MultipartFile

class UploadVillageFeaturedImageService {

    def amazonS3Service

    VillageGormService villageGormService

    private String pathWithMultipartFile(Long id, MultipartFile imageFile) {
        "village/${id}/${imageFile.originalFilename}"
    }

    Village uploadFeatureImage(FeaturedImageCommand cmd) {

        def path = pathWithMultipartFile(cmd.id, cmd.featuredImageFile)
        String s3FileUrl = amazonS3Service.storeMultipartFile(path, cmd.featuredImageFile)
        if ( !s3FileUrl ) {
            return null
        }

        def village = villageGormService.updateFeaturedImageUrl(cmd.id, cmd.version, s3FileUrl)
        if ( !village || village.hasErrors() ) {
            amazonS3Service.deleteFile(path)
        }
        village
    }

    Village uploadImage(ImageCommand cmd) {
        def path = pathWithMultipartFile(cmd.id, cmd.imageFile)
        String s3FileUrl = amazonS3Service.storeMultipartFile(path, cmd.imageFile)
        if ( !s3FileUrl ) {
            return null
        }
        def village = villageGormService.addImageUrl(cmd.id, cmd.version, s3FileUrl)
        if ( !village || village.hasErrors() ) {
            amazonS3Service.deleteFile(path)
        }
        village
    }
}
