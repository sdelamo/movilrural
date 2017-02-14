package com.softamo.movilrural

import groovy.transform.CompileStatic
import org.springframework.web.multipart.MultipartFile

@CompileStatic
class UploadPoiFeaturedImageService implements ImageUploadable {

    PoiGormService poiGormService

    Poi uploadFeatureImage(FeaturedImageCommand cmd) {
        uploadImageToS3(cmd.id, cmd.version, cmd.featuredImageFile) { Long id, Long version, String s3FileUrl ->
            poiGormService.updateFeaturedImageUrl(id, version, s3FileUrl)
        } as Poi
    }

    Poi uploadImage(ImageCommand cmd) {
        uploadImageToS3(cmd.id, cmd.version, cmd.imageFile) { Long id, Long version, String s3FileUrl ->
            poiGormService.addImageUrl(cmd.id, cmd.version, s3FileUrl)
        } as Poi
    }

    Poi deleteImageUrl(DeleteImageUrlCommand cmd) {
        Poi poi = poiGormService.deleteImageUrl(cmd)
        if ( poi && !poi.hasErrors() ) {
            deleteFileFromServer(cmd.imageUrl)
        }
        poi
    }

    Poi deleteFeaturedImageUrl(DeleteFeaturedImageUrlCommand cmd) {
        Poi poi = Poi.get(cmd.id)
        String imageUrl = poi.featuredImageUrl
        poi = poiGormService.deleteFeaturedImageUrl(cmd)
        if ( poi && !poi.hasErrors() ) {
            deleteFileFromServer(imageUrl)
        }
        poi
    }

    @Override
    String pathWithMultipartFile(Long id, MultipartFile imageFile) {
        "poi/${id}/${imageFile.originalFilename}" as String
    }
}
