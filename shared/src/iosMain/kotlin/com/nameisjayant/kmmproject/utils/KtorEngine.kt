package com.nameisjayant.kmmproject.utils

import io.ktor.client.engine.darwin.*
import org.koin.dsl.module


actual fun ktorEngineModule() = module{
    single { Darwin.create() }
}