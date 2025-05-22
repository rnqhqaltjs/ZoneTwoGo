package com.prography.zonetwobe.exercise.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.prography.zonetwobe.exercise.ExerciseRoute
import com.prography.zonetwobe.navigation.MainTabRoute

fun NavController.navigateExercise(navOptions: NavOptions? = null) {
    navigate(MainTabRoute.Exercise, navOptions = navOptions)
}

fun NavGraphBuilder.exerciseNavGraph() {
    composable<MainTabRoute.Exercise> { _ ->
        ExerciseRoute()
    }
}