plugins {
    alias(libs.plugins.wear.lib.common)
    alias(libs.plugins.wear.lib.compose)
    alias(libs.plugins.app.hilt)
    alias(libs.plugins.wear.feature)
}

android {
    namespace = "com.prography.zonetwobe.exercise"
    kotlinOptions {
        jvmTarget = "21"
    }
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:model"))
}