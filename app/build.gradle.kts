plugins {
    alias(libs.plugins.app.common)
    alias(libs.plugins.app.compose)
    alias(libs.plugins.app.hilt)
}

android {
    namespace = "com.prography.zonetwobe"

    defaultConfig {
        applicationId = "com.prography.zonetwobe"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    kotlinOptions {
        jvmTarget = "21"
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(project(":core:designsystem-mobile"))
    implementation(project(":feature-mobile:main"))


    implementation(libs.androidx.hilt.common)
    implementation(libs.v2.user)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(libs.hilt.android.testing)
    debugImplementation(libs.androidx.ui.test.manifest)
}