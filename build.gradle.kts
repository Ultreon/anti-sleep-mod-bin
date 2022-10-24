plugins {
    kotlin("multiplatform") version "1.7.20"
}

group = "com.ultreon.mods"
version = "1.0.0"

repositories {
    mavenCentral()
}
dependencies {
}

kotlin {
    mingwX64().apply {
        binaries {
            sharedLib {
                baseName = "libanti-sleep"
            }
        }
    }

    linuxX64().apply {
        binaries {
            sharedLib {
                baseName = "anti-sleep"
            }
        }
        compilations["main"].cinterops {
            create("x11") {
                defFile("src/linuxX64Main/cinterop/x11.def")
                includeDirs("/usr/include")
            }
        }
    }

    sourceSets {
        val mingwX64Main by getting
        val mingwX64Test by getting
        val linuxX64Main by getting {
            dependencies {
                implementation("org.gtk-kt:glib:0.1.0-alpha1")
            }
        }
    }
}
