plugins {
    alias(libs.plugins.wear.lib.common)
    alias(libs.plugins.app.hilt)
}

android {
    namespace = "com.prography.zonetwobe.data.wear"
    kotlinOptions {
        jvmTarget = "21"
    }
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:model"))
    implementation(libs.androidx.health.services.client)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.guava)
}