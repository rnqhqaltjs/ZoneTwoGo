pluginManagement {
    includeBuild("build-logic")

    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = java.net.URI("https://devrepo.kakao.com/nexus/content/groups/public/") }
    }
}

rootProject.name = "ZoneTwoGo"
include(":app")
include(":feature-mobile:login")
include(":core:domain")
include(":core:data-mobile")
include(":wear")
include(":feature-wear:exercise")
include(":core:data-wear")
include(":core:common")
include(":core:model")
include(":infra-mobile")
include(":infra-wear")
include(":core:navigation")
include(":feature-mobile:main")
include(":feature-mobile:exercise")
include(":feature-mobile:report")
include(":feature-mobile:profile")
include(":core:designsystem-mobile")
