package com.softamo.movilrural

import org.springframework.web.multipart.MultipartFile
import spock.lang.Specification
import spock.lang.Unroll

class ImageUploadableSpec extends Specification {

    @Unroll
    def "lowercase and remove white spaces in imageUrl #imageUrl => #expected"(String imageUrl, String expected) {
        when:
        def result = ImageUploadableImpl.cleanupImageName(imageUrl)

        then:
        result == expected
        notThrown NullPointerException

        where:
        imageUrl        | expected
        null            | null
        'galiana 1.jpg' | 'galiana_1.jpg'
        'Galiana 1.jpg' | 'galiana_1.jpg'
        'galiana1.jpg'  | 'galiana1.jpg'

    }
}

class ImageUploadableImpl implements ImageUploadable {

    @Override
    String pathWithMultipartFile(Long id, MultipartFile imageFile) {
        null
    }
}
