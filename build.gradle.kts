import com.github.lamba92.gradle.utils.ktor
import com.github.lamba92.gradle.utils.prepareForPublication

buildscript {
    repositories {
        maven("https://dl.bintray.com/lamba92/com.github.lamba92/")
        google()
        jcenter()
    }
    dependencies {
        classpath("com.github.lamba92", "lamba-gradle-utils", "1.0.6")
    }
}

plugins {
    kotlin("multiplatform")
    id("com.jfrog.bintray")
    `maven-publish`
}

group = "com.github.lamba92"
version = System.getenv("GITHUB_REF")?.split("/")?.last() ?: "2.0.0"

repositories {
    jcenter()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    sourceSets {
        named("jvmMain") {
            kotlin.srcDirs("src")
            dependencies {
                val ktorVersion: String by project
                implementation(ktor("server-core", ktorVersion))
            }
        }
        named("jvmTest") {
            kotlin.srcDirs("test")
        }
    }
}

prepareForPublication()
