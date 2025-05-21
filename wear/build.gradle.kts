plugins {
    alias(libs.plugins.wear.common)
    alias(libs.plugins.wear.compose)
    alias(libs.plugins.app.hilt)
}

android {
    namespace = "com.prography.zonetwobe"

    defaultConfig {
        applicationId = "com.prography.zonetwobe"
        versionCode = 1
        versionName = "1.0"

    }
    kotlinOptions {
        jvmTarget = "21"
    }
}

dependencies {
    implementation(project(":core:data-wear"))
    implementation(project(":core:domain"))
    implementation(project(":core:common"))
    implementation(project(":core:model"))
    implementation(project(":feature-wear:exercise"))

    implementation(libs.play.services.wearable)
    implementation(libs.androidx.core.splashscreen)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(libs.hilt.android.testing)
    debugImplementation(libs.androidx.ui.test.manifest)
}