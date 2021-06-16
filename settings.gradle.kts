dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
    }
}
rootProject.name = "Multimodule Activity Navigation Sample"
include(":app")
include(":common")
include(":feature1")
include(":feature2")
include(":navigation")
