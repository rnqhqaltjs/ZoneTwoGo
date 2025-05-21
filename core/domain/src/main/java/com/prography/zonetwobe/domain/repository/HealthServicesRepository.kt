package com.prography.zonetwobe.domain.repository

import com.prography.zonetwobe.model.ExerciseMetrics
import kotlinx.coroutines.flow.Flow

interface HealthServicesRepository {
    suspend fun hasExerciseCapability(): Boolean
    suspend fun prepareExercise()
    suspend fun startExercise()
    suspend fun pauseExercise()
    suspend fun resumeExercise()
    suspend fun endExercise()

    fun getExerciseMetricsFlow(): Flow<ExerciseMetrics>
}