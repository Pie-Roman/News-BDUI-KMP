plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

android {
    namespace = "ru.pyroman.laza.common.core.di"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain {
            dependencies {
//                api(Dependencies.Kotlin.Serialization.serialization)
//                api(Dependencies.Kotlin.Coroutines.core)
//
//                api(Dependencies.Ktor.core)
//                implementation(Dependencies.Ktor.contentNegotiation)
//                implementation(Dependencies.Ktor.json)
//                implementation(Dependencies.Ktor.logging)
//                implementation(Dependencies.Ktor.serialization)
//                implementation(Dependencies.Ktor.serializationKotlinX)
//
                implementation(libs.kodein)
            }
        }

        androidMain {
//            dependencies {
//                implementation(Dependencies.Ktor.android)
//            }
        }

        iosMain {
//            dependencies {
//                implementation(Dependencies.Ktor.ios)
//            }
        }
    }
}