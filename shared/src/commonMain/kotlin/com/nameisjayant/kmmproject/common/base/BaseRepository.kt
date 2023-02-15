package com.nameisjayant.kmmproject.common.base

import com.nameisjayant.kmmproject.common.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseRepository {

    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): Flow<ApiState<T>> = flow {

        emit(ApiState.Loading)
        val response = apiCall()
        emit(ApiState.Success(response))

    }.catch { e ->
        emit(ApiState.Failure(e))
    }.flowOn(Dispatchers.Default)

}