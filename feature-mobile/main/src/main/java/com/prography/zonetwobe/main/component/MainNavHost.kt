package com.prography.zonetwobe.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.prography.zonetwobe.exercise.navigation.exerciseNavGraph
import com.prography.zonetwobe.main.MainNavigator
import com.prography.zonetwobe.profile.navigation.profileNavGraph
import com.prography.zonetwobe.report.navigation.reportNavGraph

@Composable
internal fun MainNavHost(
    modifier: Modifier = Modifier,
    navigator: MainNavigator,
    padding: PaddingValues,
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceDim)
    ) {
        NavHost(
            navController = navigator.navController,
            startDestination = navigator.startDestination,
        ) {
            exerciseNavGraph()
            reportNavGraph()
            profileNavGraph()
        }
    }
}