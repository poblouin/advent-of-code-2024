plugins {
    application

    kotlin("jvm") version "2.1.0"

    alias(libs.plugins.ktlint)
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.kotest)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation(libs.guava)
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

tasks.register<JavaExec>("generateDay") {
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("aoc2024.utils.DayGeneratorKt")
    workingDir = project.projectDir
    args = (project.findProperty("args")?.toString() ?: "").split(",").filter { it.isNotEmpty() }
}
