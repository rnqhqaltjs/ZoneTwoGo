plugins {
    alias(libs.plugins.lib.common)
    alias(libs.plugins.lib.compose)
    alias(libs.plugins.app.hilt)
    alias(libs.plugins.app.feature)
}

android {
    namespace = "com.prography.zonetwobe.report"
    kotlinOptions {
        jvmTarget = "21"
    }
}

dependencies {
    implementation(project(":core:navigation"))
}