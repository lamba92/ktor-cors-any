pluginManagement {

    repositories {
        gradlePluginPortal()
        jcenter()
        mavenCentral()
    }

    plugins {

        val kotlinVersion: String by settings
        val bintrayPluginVersion: String by settings

        kotlin("multiplatform") version kotlinVersion
        id("com.jfrog.bintray") version bintrayPluginVersion

    }

}

rootProject.name = "ktor-cors-any"
