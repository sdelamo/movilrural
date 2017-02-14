package com.softamo.movilrural

import groovy.transform.CompileStatic
import org.springframework.web.multipart.MultipartFile

@CompileStatic
class UploadRestaurantFeaturedImageService implements ImageUploadable {

    RestaurantGormService restaurantGormService

    Restaurant uploadFeatureImage(FeaturedImageCommand cmd) {
        uploadImageToS3(cmd.id, cmd.version, cmd.featuredImageFile) { Long id, Long version, String s3FileUrl ->
            restaurantGormService.updateFeaturedImageUrl(id, version, s3FileUrl)
        } as Restaurant
    }

    Restaurant uploadImage(ImageCommand cmd) {
        uploadImageToS3(cmd.id, cmd.version, cmd.imageFile) { Long id, Long version, String s3FileUrl ->
            restaurantGormService.addImageUrl(cmd.id, cmd.version, s3FileUrl)
        } as Restaurant
    }

    Restaurant deleteImageUrl(DeleteImageUrlCommand cmd) {
        Restaurant restaurant = restaurantGormService.deleteImageUrl(cmd)
        if ( restaurant && !restaurant.hasErrors() ) {
            deleteFileFromServer(cmd.imageUrl)
        }
        restaurant
    }

    Restaurant deleteFeaturedImageUrl(DeleteFeaturedImageUrlCommand cmd) {
        Restaurant restaurant = Restaurant.get(cmd.id)
        String imageUrl = restaurant.featuredImageUrl
        restaurant = restaurantGormService.deleteFeaturedImageUrl(cmd)
        if ( restaurant && !restaurant.hasErrors() ) {
            deleteFileFromServer(imageUrl)
        }
        restaurant
    }

    @Override
    String pathWithMultipartFile(Long id, MultipartFile imageFile) {
        "restaurant/${id}/${imageFile.originalFilename}" as String
    }
}
