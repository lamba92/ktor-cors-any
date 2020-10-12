pluginManagement {

    repositories {
        gradlePluginPortal()
        jcenter()
    }

    plugins {

        val kotlinVersion: String by settings
        val bintrayPluginVersion: String by settings

        kotlin("jvm") version kotlinVersion
        id("com.jfrog.bintray") version bintrayPluginVersion

    }

}

rootProject.name = "ktor-cors-any"
