plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version(ConfigData.gradle).apply(false)
    id("com.android.library").version(ConfigData.gradle).apply(false)
    kotlin("android").version(ConfigData.kotlin).apply(false)
    kotlin("multiplatform").version(ConfigData.kotlin).apply(false)
    kotlin("plugin.serialization") version ConfigData.kotlin
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

