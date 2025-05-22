plugins {
    alias(libs.plugins.lib.common)
    alias(libs.plugins.lib.compose)
    alias(libs.plugins.app.hilt)
    alias(libs.plugins.app.feature)
}

android {
    namespace = "com.prography.zonetwobe.main"
    kotlinOptions {
        jvmTarget = "21"
    }
}

dependencies {
    implementation(project(":core:designsystem-mobile"))
    implementation(project(":core:navigation"))
    implementation(project(":feature-mobile:exercise"))
    implementation(project(":feature-mobile:profile"))
    implementation(project(":feature-mobile:report"))
}