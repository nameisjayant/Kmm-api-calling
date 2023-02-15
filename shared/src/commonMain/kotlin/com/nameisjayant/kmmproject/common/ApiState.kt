package com.nameisjayant.kmmproject.common


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

sealed class ApiState<out T> {

    data class Success<out T>(val data: T) : ApiState<T>()
    data class Failure(val msg: Throwable?) : ApiState<Nothing>()
    object Loading : ApiState<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success $data"
            is Failure -> "Failure $msg"
            Loading -> "Loading"
        }
    }
}

fun <T, R> ApiState<T>.map(transform: (T) -> R): ApiState<R> {
    return when (this) {
        is ApiState.Success -> ApiState.Success(transform(data))
        is ApiState.Failure -> ApiState.Failure(msg)
        ApiState.Loading -> ApiState.Loading
    }
}

fun <T> Flow<ApiState<T>>.doOnSuccess(action: suspend (T) -> Unit): Flow<ApiState<T>> =
    transform { result ->
        if (result is ApiState.Success) {
            action(result.data)
        }
        return@transform emit(result)
    }

fun <T> Flow<ApiState<T>>.doOnFailure(action: suspend (Throwable?) -> Unit): Flow<ApiState<T>> =
    transform { result ->
        if (result is ApiState.Failure) {
            action(result.msg)
        }
        return@transform emit(result)
    }

fun <T> Flow<ApiState<T>>.doOnLoading(action: suspend () -> Unit): Flow<ApiState<T>> =
    transform { result ->
        if (result is ApiState.Loading) {
            action()
        }
        return@transform emit(result)
    }