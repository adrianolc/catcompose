package com.example.catcompose.core.network

import retrofit2.HttpException
import java.io.IOException
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public sealed interface NetworkResult<out T> {
    data class Success<out T>(val data: T) : NetworkResult<T>
    data class Error(val exception: Throwable) : NetworkResult<Nothing>
}

@ExperimentalContracts
public inline fun <T> asNetworkResult(action: () -> T): NetworkResult<T> {
    contract {
        callsInPlace(action, InvocationKind.EXACTLY_ONCE)
    }
    return try {
        NetworkResult.Success(data = action())
    } catch (e: Throwable) {
        e.asNetworkErrorOrThrow()
    }
}

public fun Throwable.asNetworkErrorOrThrow(): NetworkResult.Error {
    return when (this) {
        is HttpException -> NetworkResult.Error(this)
        is IOException -> NetworkResult.Error(this)
        else -> throw this
    }
}
