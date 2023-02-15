package com.nameisjayant.kmmproject.data.repository

import com.nameisjayant.kmmproject.common.base.BaseRepository
import com.nameisjayant.kmmproject.data.network.ApiService

class PostRepository constructor(
    private val apiService: ApiService
) : BaseRepository() {

    suspend fun getPosts() = safeApiCall {
        apiService.getPosts()
    }
}