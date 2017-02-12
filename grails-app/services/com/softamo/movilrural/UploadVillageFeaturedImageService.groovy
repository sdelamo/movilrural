package com.softamo.movilrural

import groovy.transform.CompileStatic
import org.springframework.web.multipart.MultipartFile

@CompileStatic
class UploadVillageFeaturedImageService implements ImageUploadable {

    VillageGormService villageGormService

    Village uploadFeatureImage(FeaturedImageCommand cmd) {
        uploadImageToS3(cmd.id, cmd.version, cmd.featuredImageFile) { Long id, Integer version, String s3FileUrl ->
            villageGormService.updateFeaturedImageUrl(id, version, s3FileUrl)
        } as Village
    }

    Village uploadImage(ImageCommand cmd) {
        uploadImageToS3(cmd.id, cmd.version, cmd.imageFile) { Long id, Integer version, String s3FileUrl ->
            villageGormService.addImageUrl(cmd.id, cmd.version, s3FileUrl)
        } as Village
    }

    Village deleteImageUrl(DeleteImageUrlCommand cmd) {
        Village village = villageGormService.deleteImageUrl(cmd)
        if ( village && !village.hasErrors() ) {
            deleteFileFromServer(cmd.imageUrl)
        }
        village
    }

    Village deleteFeaturedImageUrl(DeleteFeaturedImageUrlCommand cmd) {
        Village village = Village.get(cmd.id)
        String imageUrl = village.featuredImageUrl
        village = villageGormService.deleteFeaturedImageUrl(cmd)
        if ( village && !village.hasErrors() ) {
            deleteFileFromServer(imageUrl)
        }
        village
    }

    @Override
    String pathWithMultipartFile(Long id, MultipartFile imageFile) {
        "village/${id}/${imageFile.originalFilename}" as String
    }
}
