plugins {
    kotlin("jvm") version "2.1.20"
}

group = "com.sobiroglu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}