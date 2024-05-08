plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
}

android {
    namespace = "ru.pyroman.news.common.umbrella"
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

    cocoapods {
        summary = "Common Umbrella Module"
        homepage = "Link to the Common Umbrella Module homepage"
        version = "1.0"
        name = "CommonUmbrella"
        ios.deploymentTarget = "12.0"
        podfile = project.file("../../iosApp/News/Podfile")
        framework {
            baseName = "CommonUmbrella"
            isStatic = true
            transitiveExport = true
            export(projects.base.uikit)
        }
    }

    sourceSets {
        commonMain.dependencies {
            api(projects.common.core)
            api(projects.common.core.platform)
            api(projects.common.core.network)

            api(projects.base.uikit)
        }
    }
}