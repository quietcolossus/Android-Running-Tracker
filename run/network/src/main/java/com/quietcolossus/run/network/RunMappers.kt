package com.quietcolossus.run.network

import com.quietcolossus.core.domain.location.Location
import com.quietcolossus.core.domain.run.Run
import java.time.Instant
import java.time.ZoneId
import kotlin.time.Duration.Companion.milliseconds

fun RunDto.toRun(): Run {
    return Run(
        id = id,
        duration = durationMillis.milliseconds,
        dateTimeUtc = Instant.parse(dateTimeUtc)
            .atZone(ZoneId.of("UTC")),
        distanceMeters = distanceMeters,
        location = Location(lat, long),
        maxSpeedKmh = maxSpeedKmh,
        totalElevationMeters = totalElevationMeters,
        mapPictureUrl = mapPictureUrl
    )
}

fun Run.toCreateRunRequest(): CreateRunRequest {
    return CreateRunRequest(
        id = id!!,
        durationMillis = duration.inWholeMilliseconds,
        distanceMeters = distanceMeters,
        lat = location.latitude,
        long = location.longitude,
        avgSpeedKmh = avgSpeedKmh,
        maxSpeedKmh = maxSpeedKmh,
        totalElevationMeters = totalElevationMeters,
        epochMillis = dateTimeUtc.toEpochSecond() * 1000L
    )
}