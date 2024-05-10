plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

android {
    namespace = "ru.pyroman.news.base.uikit"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
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
        androidMain {
            dependencies {
                api(libs.androidx.fragmentKtx)
            }
        }

        commonMain {
            dependencies {
                api(libs.pyroman.mvpkmp)
                implementation(projects.common.core)
            }
        }
    }
}