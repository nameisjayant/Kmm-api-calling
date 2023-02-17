package com.nameisjayant.kmmproject.data.repository

import com.nameisjayant.kmmproject.common.base.BaseRepository
import com.nameisjayant.kmmproject.common.base.execute
import com.nameisjayant.kmmproject.data.model.Post
import com.nameisjayant.kmmproject.data.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostRepository constructor(
    private val apiService: ApiService
) : BaseRepository() {

    suspend fun getPosts() = safeApiCall {
        apiService.getPosts()
    }

    suspend fun getPostForIos():Flow<List<Post>> {
      return execute {
          apiService.getPosts()
      }
    }

    suspend fun getPostTest():List<Post> = apiService.getPosts()
}
