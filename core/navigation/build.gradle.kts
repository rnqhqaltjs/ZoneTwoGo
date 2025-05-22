plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
    id("kotlinx-serialization")
}
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21
    }
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
}
