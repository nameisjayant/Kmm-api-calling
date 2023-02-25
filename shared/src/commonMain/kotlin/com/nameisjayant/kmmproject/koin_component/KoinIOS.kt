package com.nameisjayant.kmmproject.koin_component

import com.nameisjayant.kmmproject.data.network.ApiService
import com.nameisjayant.kmmproject.data.repository.CatRepository
import com.nameisjayant.kmmproject.data.repository.PostRepository
import com.nameisjayant.kmmproject.di.initKoin
import org.koin.core.Koin
import org.koin.core.KoinApplication


fun KoinApplication.Companion.start():KoinApplication = initKoin()

// get api service instance
val Koin.apiService:ApiService get() = get()

// get post repository instance
val Koin.postRepository:PostRepository get() = get()

// get cat repository instance
val Koin.catRepository:CatRepository get() = get()