package com.prography.zonetwobe.data.wear.repository

import androidx.health.services.client.ExerciseClient
import androidx.health.services.client.ExerciseUpdateCallback
import androidx.health.services.client.HealthServicesClient
import androidx.health.services.client.data.Availability
import androidx.health.services.client.data.DataType
import androidx.health.services.client.data.ExerciseConfig
import androidx.health.services.client.data.ExerciseLapSummary
import androidx.health.services.client.data.ExerciseType
import androidx.health.services.client.data.ExerciseTypeCapabilities
import androidx.health.services.client.data.ExerciseUpdate
import androidx.health.services.client.data.LocationAvailability
import androidx.health.services.client.data.WarmUpConfig
import androidx.health.services.client.endExercise
import androidx.health.services.client.getCapabilities
import androidx.health.services.client.pauseExercise
import androidx.health.services.client.prepareExercise
import androidx.health.services.client.resumeExercise
import androidx.health.services.client.startExercise
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
    class ExerciseClientManager @Inject constructor(
    healthServicesClient: HealthServicesClient
) {
    val exerciseClient: ExerciseClient = healthServicesClient.exerciseClient

    suspend fun getExerciseCapabilities(): ExerciseTypeCapabilities? {
        val capabilities = exerciseClient.getCapabilities()

        return if (ExerciseType.RUNNING in capabilities.supportedExerciseTypes) {
            capabilities.getExerciseTypeCapabilities(ExerciseType.RUNNING)
        } else {
            null
        }
    }

    suspend fun startExercise() {
        val capabilities = getExerciseCapabilities()

        if (capabilities == null) {
            return
        }

        val dataTypes = setOf(
            DataType.HEART_RATE_BPM,
            DataType.CALORIES_TOTAL,
            DataType.DISTANCE_TOTAL,
            DataType.STEPS_TOTAL
        ).intersect(capabilities.supportedDataTypes)

        val supportsAutoPauseAndResume = capabilities.supportsAutoPauseAndResume

        val config = ExerciseConfig(
            exerciseType = ExerciseType.RUNNING,
            dataTypes = dataTypes,
            isAutoPauseAndResumeEnabled = supportsAutoPauseAndResume,
            isGpsEnabled = true
        )

        exerciseClient.startExercise(config)
    }

    suspend fun prepareExercise() {
        val warmUpConfig = WarmUpConfig(
            exerciseType = ExerciseType.RUNNING,
            dataTypes = setOf(DataType.HEART_RATE_BPM, DataType.LOCATION)
        )

        exerciseClient.prepareExercise(warmUpConfig)
    }

    suspend fun endExercise() {
        exerciseClient.endExercise()
    }

    suspend fun pauseExercise() {
        exerciseClient.pauseExercise()
    }

    suspend fun resumeExercise() {
        exerciseClient.resumeExercise()
    }

    val exerciseUpdateFlow = callbackFlow {
        val callback = object : ExerciseUpdateCallback {
            override fun onExerciseUpdateReceived(update: ExerciseUpdate) {
                trySendBlocking(ExerciseMessage.ExerciseUpdateMessage(update))
            }

            override fun onLapSummaryReceived(lapSummary: ExerciseLapSummary) {
                trySendBlocking(ExerciseMessage.LapSummaryMessage(lapSummary))
            }

            override fun onRegistered() {
            }

            override fun onRegistrationFailed(throwable: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onAvailabilityChanged(
                dataType: DataType<*, *>, availability: Availability
            ) {
                if (availability is LocationAvailability) {
                    trySendBlocking(ExerciseMessage.LocationAvailabilityMessage(availability))
                }
            }
        }

        exerciseClient.setUpdateCallback(callback)
        awaitClose {
            exerciseClient.clearUpdateCallbackAsync(callback)
        }
    }
}

sealed class ExerciseMessage {
    class ExerciseUpdateMessage(val exerciseUpdate: ExerciseUpdate) : ExerciseMessage()
    class LapSummaryMessage(val lapSummary: ExerciseLapSummary) : ExerciseMessage()
    class LocationAvailabilityMessage(val locationAvailability: LocationAvailability) :
        ExerciseMessage()
}