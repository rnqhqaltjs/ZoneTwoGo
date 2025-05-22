package com.prography.zonetwobe.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.prography.zonetwobe.navigation.MainTabRoute
import androidx.navigation.compose.composable
import com.prography.zonetwobe.profile.ProfileRoute

fun NavController.navigateProfile(navOptions: NavOptions? = null) {
    navigate(MainTabRoute.Profile, navOptions = navOptions)
}

fun NavGraphBuilder.profileNavGraph() {
    composable<MainTabRoute.Profile> { _ ->
        ProfileRoute()
    }
}