package com.prography.zonetwobe.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
//    @Serializable
//    data class Edit(val alarmId: Int) : Route
}

sealed interface MainTabRoute : Route {
    @Serializable
    data object Exercise : MainTabRoute

    @Serializable
    data object Report : MainTabRoute

    @Serializable
    data object Profile : MainTabRoute
}