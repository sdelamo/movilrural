package com.softamo.movilrural.place.poi

import com.softamo.movilrural.place.PlaceUpdateCommand

class PoiUpdateCommand extends PlaceUpdateCommand {
    static constraints = {
        id nullable: false
        version nullable: false
    }
}
