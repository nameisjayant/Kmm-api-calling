object Versions {

    const val composeVersion = "1.3.3"
    const val composeMaterial = "1.3.1"
    const val activityCompose = "1.6.1"
    const val composeFoundation = "1.3.1"
    const val ktorVersion = "2.2.3"
    const val koin = "3.2.0"
    const val kotlinxSerialization = "1.5.0-RC"
    const val coroutine = "1.6.4"
}

object ConfigData {

    const val compileSdkVersion = 33
    const val minSdkVersion = 24
    const val targetSdkVersion = 33
    const val versionCode = 1
    const val versionName = "1.0"
    const val kotlinCompilerExtVersion = "1.4.0"
    const val kotlin = "1.8.0"
    const val gradle = "7.4.0"

}

object Ktor {
    const val ktorCoreClient = "io.ktor:ktor-client-core:${Versions.ktorVersion}"
    const val ktorClientOkhttp = "io.ktor:ktor-client-okhttp:${Versions.ktorVersion}"
    const val ktorClientDarwin = "io.ktor:ktor-client-darwin:${Versions.ktorVersion}"
    const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerialization}"
    const val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktorVersion}"
    const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktorVersion}"
    const val json = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktorVersion}"

}

object Coroutines{
    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
}

object Koin {
    const val core = "io.insert-koin:koin-core:${Versions.koin}"
    const val test = "io.insert-koin:koin-test:${Versions.koin}"
    const val android = "io.insert-koin:koin-android:${Versions.koin}"
}

object Compose {
    const val composeUi = "androidx.compose.ui:ui:${Versions.composeVersion}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.composeMaterial}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeFoundation =
        "androidx.compose.foundation:foundation:${Versions.composeFoundation}"
    const val composeUiToolingPreview =
        "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
}