plugins {
    alias(libs.plugins.lib.common)
    alias(libs.plugins.lib.compose)
}

android {
    namespace = "com.prography.zonetwobe.designsystem.mobile"
    kotlinOptions {
        jvmTarget = "21"
    }
}

dependencies {
}