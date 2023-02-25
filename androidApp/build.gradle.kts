plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.nameisjayant.kmmproject.android"
    compileSdk = ConfigData.compileSdkVersion
    defaultConfig {
        applicationId = "com.nameisjayant.kmmproject.android"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = ConfigData.kotlinCompilerExtVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

}

dependencies {
    implementation(project(":shared"))
    implementation(Compose.composeUi)
    implementation(Compose.composeUiTooling)
    implementation(Compose.composeUiToolingPreview)
    implementation(Compose.composeFoundation)
    implementation(Compose.composeMaterial)
    implementation(Compose.composeActivity)
    implementation(Coroutines.coroutineAndroid)
    implementation(Koin.core)
    implementation(Koin.android)
    implementation(Compose.coilCompose)

}