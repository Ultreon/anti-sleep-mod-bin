plugins {
    kotlin("multiplatform") version "1.7.20"
}

group = "com.ultreon.mods"
version = "1.0.0"

repositories {
    mavenCentral()
}

kotlin {
    mingwX64().apply {
        binaries {
            sharedLib {
                baseName = "libultreon-commons"
            }
        }
    }

    sourceSets {
        val mingwX64Main by getting
        val mingwX64Test by getting
    }
}
