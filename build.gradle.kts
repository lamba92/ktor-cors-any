import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "1.3.40"
    `maven-publish`
}

group = "it.lamba"
version = "1.0.0"

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(ktor("server-core"))
}

kotlin.sourceSets["main"].kotlin.srcDirs("src")
kotlin.sourceSets["test"].kotlin.srcDirs("test")

sourceSets["main"].resources.srcDirs("resources")
sourceSets["test"].resources.srcDirs("testresources")

fun DependencyHandlerScope.ktor(name: String, version: String = ktor_version) = "io.ktor:ktor-$name:$version"

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

val sources by tasks.register<Jar>("sourcesJar") {
    from(kotlin.sourceSets["main"].kotlin)
    archiveClassifier.set("sources")
}

publishing {
    publications {
        create<MavenPublication>("ktorCorsAnyPublication") {
            from(components["java"])
            artifact(sources)
        }
    }
}