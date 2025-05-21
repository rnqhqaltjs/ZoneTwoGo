package com.prography.zonetwobe.data.wear.mapper

import com.prography.zonetwobe.data.wear.model.AvailabilityEntity
import com.prography.zonetwobe.data.wear.model.ExerciseMetricsEntity
import com.prography.zonetwobe.model.Availability
import com.prography.zonetwobe.model.DataTypeAvailability
import com.prography.zonetwobe.model.ExerciseMetrics
import androidx.health.services.client.data.DataTypeAvailability as HealthDataTypeAvailability

object HealthServicesMapper {

    fun ExerciseMetricsEntity.toDomain(): ExerciseMetrics =
        ExerciseMetrics(
            heartRate = this.heartRate ?: 0,
            calories = this.calories ?: 0,
            distance = this.distance ?: 0,
            steps = this.steps ?: 0
        )

    fun AvailabilityEntity.toDomain(): Availability =
        Availability(
            status = this.status.toDomain()
        )

    fun HealthDataTypeAvailability.toDomain(): DataTypeAvailability =
        when (this) {
            HealthDataTypeAvailability.AVAILABLE -> DataTypeAvailability.AVAILABLE
            HealthDataTypeAvailability.ACQUIRING -> DataTypeAvailability.ACQUIRING
            HealthDataTypeAvailability.UNAVAILABLE -> DataTypeAvailability.UNAVAILABLE
            HealthDataTypeAvailability.UNAVAILABLE_DEVICE_OFF_BODY -> DataTypeAvailability.UNAVAILABLE_DEVICE_OFF_BODY
            else -> DataTypeAvailability.UNKNOWN
        }
}