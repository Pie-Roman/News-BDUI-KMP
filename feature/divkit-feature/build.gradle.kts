plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

android {
    namespace = "ru.pyroman.news.feature.divkit"
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
                implementation(libs.divkit.div)
                implementation(libs.divkit.core)
                implementation(libs.divkit.json)
            }
        }
        commonMain {
            dependencies {
                implementation(projects.base.uikit)
                implementation(projects.common.core)

                implementation(projects.domain.divkitDomain)
                implementation(projects.data.divkitData)
            }
        }
    }
}