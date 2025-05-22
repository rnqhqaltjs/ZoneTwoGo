package com.prography.zonetwobe.report.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.prography.zonetwobe.navigation.MainTabRoute
import androidx.navigation.compose.composable
import com.prography.zonetwobe.report.ReportRoute

fun NavController.navigateReport(navOptions: NavOptions? = null) {
    navigate(MainTabRoute.Report, navOptions = navOptions)
}

fun NavGraphBuilder.reportNavGraph() {
    composable<MainTabRoute.Report> { _ ->
        ReportRoute()
    }
}