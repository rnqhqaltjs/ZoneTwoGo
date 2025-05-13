plugins {
    alias(libs.plugins.lib.common)
    alias(libs.plugins.app.hilt)
}

android {
    namespace = "com.prography.zonetwogo.data.mobile"
    kotlinOptions {
        jvmTarget = "21"
    }
}

dependencies {
}