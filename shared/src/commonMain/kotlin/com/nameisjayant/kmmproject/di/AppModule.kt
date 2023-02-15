package com.nameisjayant.kmmproject.di

import com.nameisjayant.kmmproject.data.network.ApiService
import com.nameisjayant.kmmproject.data.repository.PostRepository
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun init(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(appModule())

}

fun initKoin() = init{}

fun appModule() = module {
    single { createJson() }
    single { createHttpClient(get()) }
    single { ApiService(get()) }
    factory { PostRepository(get()) }
}

fun createJson(): Json = Json { isLenient = true; ignoreUnknownKeys = true }

fun createHttpClient(json: Json): HttpClient = HttpClient {

    install(ContentNegotiation) {
        json(json)
    }

    install(DefaultRequest) {
        headers.append("Content-Type", "application/json")
    }


    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.INFO
    }
}