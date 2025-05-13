plugins {
    alias(libs.plugins.wear.lib.common)
    alias(libs.plugins.app.hilt)
}

android {
    namespace = "com.prography.zonetwogo.infra.wear"
    kotlinOptions {
        jvmTarget = "21"
    }
}

dependencies {
}