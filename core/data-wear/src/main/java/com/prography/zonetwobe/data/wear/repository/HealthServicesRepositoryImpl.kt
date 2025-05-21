package com.prography.zonetwobe.data.wear.repository

import androidx.health.services.client.data.DataType
import com.prography.zonetwobe.data.wear.mapper.HealthServicesMapper.toDomain
import com.prography.zonetwobe.data.wear.model.ExerciseMetricsEntity
import com.prography.zonetwobe.domain.repository.HealthServicesRepository
import com.prography.zonetwobe.model.ExerciseMetrics
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import javax.inject.Inject

class HealthServicesRepositoryImpl @Inject constructor(
    private val exerciseClientManager: ExerciseClientManager
) : HealthServicesRepository {

    override suspend fun hasExerciseCapability(): Boolean =  exerciseClientManager.getExerciseCapabilities() != null

    override suspend fun startExercise() {
        exerciseClientManager.startExercise()
    }

    override suspend fun prepareExercise() {
        exerciseClientManager.prepareExercise()
    }

    override suspend fun endExercise() {
        exerciseClientManager.endExercise()
    }

    override suspend fun pauseExercise() {
        exerciseClientManager.pauseExercise()
    }

    override suspend fun resumeExercise() {
        exerciseClientManager.resumeExercise()
    }

    override fun getExerciseMetricsFlow(): Flow<ExerciseMetrics> {
        return exerciseClientManager.exerciseUpdateFlow
            .mapNotNull { (it as? ExerciseMessage.ExerciseUpdateMessage)?.exerciseUpdate?.latestMetrics }
            .map { metrics ->
                ExerciseMetricsEntity(
                    heartRate = metrics.getData(DataType.HEART_RATE_BPM).lastOrNull()?.value?.toInt(),
                    calories = metrics.getData(DataType.CALORIES_TOTAL)?.total?.toInt(),
                    distance = metrics.getData(DataType.DISTANCE_TOTAL)?.total?.toInt(),
                    steps = metrics.getData(DataType.STEPS_TOTAL)?.total?.toInt()
                ).toDomain()
            }
            .distinctUntilChanged()
    }
}