package extension

import com.android.build.api.dsl.CommonExtension
import libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
    includeWear: Boolean = false
) {
    commonExtension.run {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion("compose.compiler").get().toString()
        }

        dependencies {
            "implementation"(libs.findLibrary("androidx.activity.compose").get())
            "implementation"(platform(libs.findLibrary("androidx.compose.bom").get()))
            "implementation"(libs.findLibrary("androidx.ui").get())
            "implementation"(libs.findLibrary("androidx.ui.graphics").get())
            "implementation"(libs.findLibrary("androidx.ui.tooling.preview").get())
            "debugImplementation"(libs.findLibrary("androidx.ui.tooling").get())

            if (includeWear) {
                "implementation"(libs.findLibrary("androidx.compose.material").get())
                "implementation"(libs.findLibrary("androidx.compose.foundation").get())
                "implementation"(libs.findLibrary("androidx.wear.tooling.preview").get())
            } else {
                "implementation"(libs.findLibrary("androidx.material3").get())
            }
        }
    }
}