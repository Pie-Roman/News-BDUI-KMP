plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

android {
    namespace = "ru.pyroman.news.common.core.network"
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
                api(libs.ktor.core)
                implementation(libs.ktor.contentNegotiation)
                implementation(libs.ktor.json)
                implementation(libs.ktor.logging)
                implementation(libs.ktor.serialization)
                implementation(libs.ktor.serializationKotlinX)

                implementation(libs.kodein)

                implementation(projects.common.core.di)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.ktor.android)
            }
        }

        iosMain {
            dependencies {
                implementation(libs.ktor.ios)
            }
        }
    }
}