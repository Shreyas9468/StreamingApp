pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        maven("https://storage.zego.im/maven")
        maven("https://www.jitpack.io")
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        maven("https://storage.zego.im/maven")
        maven("https://www.jitpack.io")
        mavenCentral()
    }
}

rootProject.name = "StreamingApp"
include(":app")
 