package com.prography.zonetwobe.main

import androidx.compose.runtime.Composable
import com.prography.zonetwobe.navigation.MainTabRoute
import com.prography.zonetwobe.navigation.Route

internal enum class MainTab(
    val iconResId: Int,
    internal val contentDescription: String,
    val route: MainTabRoute,
) {
    EXERCISE(
        iconResId = R.drawable.ic_exercise,
        contentDescription = "운동하기",
        MainTabRoute.Exercise,
    ),
    REPORT(
        iconResId = R.drawable.ic_report,
        contentDescription = "리포트",
        MainTabRoute.Report
    ),
    PROFILE(
        iconResId = R.drawable.ic_profile,
        contentDescription = "마이페이지",
        MainTabRoute.Profile,
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}