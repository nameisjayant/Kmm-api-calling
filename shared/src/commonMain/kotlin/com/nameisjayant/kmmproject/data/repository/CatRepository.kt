package com.nameisjayant.kmmproject.data.repository

import com.nameisjayant.kmmproject.data.model.Cat
import com.nameisjayant.kmmproject.data.network.ApiService
import kotlinx.coroutines.flow.flow


class CatRepository constructor(
    private val apiService: ApiService
) {

    suspend fun getCats() = flow<List<Cat>> {
        emit(apiService.getCats())
    }

}