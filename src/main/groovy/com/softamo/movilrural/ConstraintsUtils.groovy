package com.softamo.movilrural

class ConstraintsUtils {

    static Closure latitudeCustomValidator(String fieldName, String smallErrorCode, String bigErrorCode) {
        decimalRangeCustomValidator(-90.0, 90.0, fieldName, smallErrorCode, bigErrorCode)
    }

    static Closure longitudeCustomValidator(String fieldName, String smallErrorCode, String bigErrorCode) {
        decimalRangeCustomValidator(-180.0, 180.0, fieldName, smallErrorCode, bigErrorCode)
    }

    static Closure decimalRangeCustomValidator(BigDecimal small,
                                               BigDecimal big,
                                               String fieldName,
                                               String smallErrorCode,
                                               String bigErrorCode) {
        return { val, obj, errors ->
            if ( val == null ) {
                return true
            }
            if (val < small) {
                errors.rejectValue(fieldName, smallErrorCode)
                return false
            }
            if (val > big) {
                errors.rejectValue(fieldName, bigErrorCode)
                return false
            }
            true
        }
    }

    static Closure imageFile() {
        { val, obj ->
            if ( val == null ) {
                return false
            }
            if ( val.empty ) {
                return false
            }

            ['jpeg', 'jpg', 'png'].any { extension ->
                val.originalFilename?.toLowerCase()?.endsWith(extension)
            }
        }
    }

}
