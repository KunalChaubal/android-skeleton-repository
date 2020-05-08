package com.repository.skeleton.extensions

import com.repository.skeleton.data.remote.model.Resource
import com.repository.skeleton.data.remote.exception.AppException

suspend fun <T> handleException(apiCall: suspend () -> T): Resource<T> {
    return try {
        Resource.success(apiCall.invoke())
    } catch (throwable: Throwable) {
        Resource.error(AppException(throwable))
    }
}