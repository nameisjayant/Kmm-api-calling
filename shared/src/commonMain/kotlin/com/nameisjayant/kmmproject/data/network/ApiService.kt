package com.nameisjayant.kmmproject.data.network

import com.nameisjayant.kmmproject.data.model.Post
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class ApiService(
    private val client:HttpClient,
    private val baseUrl: String = "https://jsonplaceholder.typicode.com"
) {

    suspend fun getPosts():List<Post>{
        return client.get {
            url("$baseUrl/posts")
        }.body()
    }

}