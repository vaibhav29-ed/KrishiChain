pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    // Choose one mode. PREFER_SETTINGS or FAIL_ON_PROJECT_REPOS
    // I’m using FAIL_ON_PROJECT_REPOS here
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "KrishiChain"
include(":app")
