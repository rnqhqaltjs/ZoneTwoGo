package com.prography.zonetwobe.exercise

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prography.zonetwobe.domain.repository.HealthServicesRepository
import com.prography.zonetwobe.model.ExerciseMetrics
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExerciseViewModel @Inject constructor(
    private val healthServicesRepository: HealthServicesRepository
) : ViewModel() {

    val exerciseMetrics: StateFlow<ExerciseMetrics?> = healthServicesRepository.getExerciseMetricsFlow()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null
        )

    private val _hasCapability = MutableStateFlow(false)
    val hasCapability: StateFlow<Boolean> = _hasCapability

    init {
        viewModelScope.launch {
            _hasCapability.value = healthServicesRepository.hasExerciseCapability()
        }
    }

    fun prepareExercise() {
        viewModelScope.launch {
            healthServicesRepository.prepareExercise()
        }
    }

    fun startExercise() {
        viewModelScope.launch {
            healthServicesRepository.startExercise()
        }
    }

    fun pauseExercise() {
        viewModelScope.launch {
            healthServicesRepository.pauseExercise()
        }
    }

    fun resumeExercise() {
        viewModelScope.launch {
            healthServicesRepository.resumeExercise()
        }
    }

    fun endExercise() {
        viewModelScope.launch {
            healthServicesRepository.endExercise()
        }
    }
}