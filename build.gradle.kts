import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath("com.github.erizo.gradle:jcstress-gradle-plugin:0.8.6")
    }
}

apply {
    plugin("jcstress")
}

dependencies {
}

plugins {
    kotlin("jvm") version "1.4.21"
}

group = "me.alexk"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}



tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}