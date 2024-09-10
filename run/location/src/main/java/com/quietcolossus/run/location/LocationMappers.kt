package com.quietcolossus.run.location

import android.location.Location
import com.quietcolossus.core.domain.location.LocationWithAltitude

fun Location.toLocationWithAltitude(): LocationWithAltitude {
    return LocationWithAltitude(
        location = com.quietcolossus.core.domain.location.Location(
            latitude = latitude,
            longitude = longitude
        ),
        altitude = altitude
    )
}