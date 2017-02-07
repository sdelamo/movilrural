package com.softamo.movilrural

class UploadVillageFeaturedImageService {

    def amazonS3Service

    VillageGormService villageGormService

    Village uploadFeatureImage(FeaturedImageCommand cmd) {

        def path = "village/${cmd.id}/" + cmd.featuredImageFile.originalFilename
        String s3FileUrl = amazonS3Service.storeMultipartFile(path, cmd.featuredImageFile)

        def village = villageGormService.updateFeaturedImageUrl(cmd.id, cmd.version, s3FileUrl)
        if ( !village || village.hasErrors() ) {
            amazonS3Service.deleteFile(path)
        }
        village
    }
}
