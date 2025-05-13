plugins {
    alias(libs.plugins.wear.lib.common)
    alias(libs.plugins.wear.lib.compose)
    alias(libs.plugins.app.hilt)
    alias(libs.plugins.wear.feature)
}

android {
    namespace = "com.prography.zonetwogo.heartrate"
    kotlinOptions {
        jvmTarget = "21"
    }
}

dependencies {
}