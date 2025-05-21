package com.prography.zonetwobe.model

data class Availability(
    val status: DataTypeAvailability
)

enum class DataTypeAvailability {
    ACQUIRING,
    AVAILABLE,
    UNAVAILABLE,
    UNAVAILABLE_DEVICE_OFF_BODY,
    UNKNOWN
}