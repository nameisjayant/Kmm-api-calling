package com.nameisjayant.kmmproject.common.base

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesIgnore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.coroutines.CoroutineContext

@NativeCoroutinesIgnore
fun <T>execute(
    context: CoroutineContext = Dispatchers.Default,
    block: suspend () -> T
): Flow<T> {
    return flow {
        try {
            val out = block.invoke()
            emit(out)
        } catch (e: ApiException) {
            throw ApiError(e.errorTitle, e.errorMessage)
        }
        catch (e: Throwable) {
            throw e
        }
    }.flowOn(context)
}

@Serializable
data class ApiException(
    @SerialName("error")
    val errorTitle: String,
    @SerialName("error_description")
    val errorMessage: String
): Exception() {
    fun map(): ApiError {
        return ApiError(errorTitle, errorMessage)
    }
}

data class ApiError(
    val errorTitle: String,
    val errorMessage: String
): Exception()