package com.softamo.movilrural

import groovy.transform.CompileStatic
import org.springframework.web.multipart.MultipartFile

@CompileStatic
class UploadHotelFeaturedImageService implements ImageUploadable {

    HotelGormService hotelGormService

    Hotel uploadFeatureImage(FeaturedImageCommand cmd) {
        uploadImageToS3(cmd.id, cmd.version, cmd.featuredImageFile) { Long id, Long version, String s3FileUrl ->
            hotelGormService.updateFeaturedImageUrl(id, version, s3FileUrl)
        } as Hotel
    }

    Hotel uploadImage(ImageCommand cmd) {
        uploadImageToS3(cmd.id, cmd.version, cmd.imageFile) { Long id, Long version, String s3FileUrl ->
            hotelGormService.addImageUrl(cmd.id, cmd.version, s3FileUrl)
        } as Hotel
    }

    Hotel deleteImageUrl(DeleteImageUrlCommand cmd) {
        Hotel hotel = hotelGormService.deleteImageUrl(cmd)
        if ( hotel && !hotel.hasErrors() ) {
            deleteFileFromServer(cmd.imageUrl)
        }
        hotel
    }

    Hotel deleteFeaturedImageUrl(DeleteFeaturedImageUrlCommand cmd) {
        Hotel hotel = Hotel.get(cmd.id)
        String imageUrl = hotel.featuredImageUrl
        hotel = hotelGormService.deleteFeaturedImageUrl(cmd)
        if ( hotel && !hotel.hasErrors() ) {
            deleteFileFromServer(imageUrl)
        }
        hotel
    }

    @Override
    String pathWithMultipartFile(Long id, MultipartFile imageFile) {
        "hotel/${id}/${imageFile.originalFilename}" as String
    }
}
