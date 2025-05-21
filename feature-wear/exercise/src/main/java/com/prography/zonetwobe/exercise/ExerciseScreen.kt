package com.prography.zonetwobe.exercise

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text
import com.prography.zonetwobe.model.ExerciseMetrics


@Composable
fun ExerciseRoute(
    viewModel: ExerciseViewModel = hiltViewModel()
) {
    val exerciseMetrics by viewModel.exerciseMetrics.collectAsStateWithLifecycle()

    ExerciseScreen(
        exerciseMetrics = exerciseMetrics,
        startExercise = viewModel::startExercise,
        endExercise = viewModel::endExercise
    )
}
@Composable
fun ExerciseScreen(
    exerciseMetrics: ExerciseMetrics?,
    startExercise: () -> Unit,
    endExercise: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "심박수: ${exerciseMetrics?.heartRate} bpm")
        Text(text = "칼로리: ${exerciseMetrics?.calories} kcal")
        Text(text = "거리: ${exerciseMetrics?.distance} m")
        Text(text = "걸음 수: ${exerciseMetrics?.steps} 걸음")

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Button(
                onClick = startExercise,
            ) {
                Text("PLAY")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = endExercise
            ) {
                Text("STOP")
            }
        }
    }
}

//@Preview(device = WearDevices.SMALL_ROUND, showSystemUi = true)
//@Composable
//fun HeartRateScreenPreview() {
//    HeartRateScreen()
//}