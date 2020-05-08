package com.repository.skeleton.data.remote.model

import com.repository.skeleton.data.remote.exception.AppException


class Resource<out T> private constructor(val status: Status, val data: T?, private val exception: AppException?) {

    enum class Status {
        SUCCESS, ERROR, LOADING, CANCEL
    }

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(
                Status.SUCCESS,
                data,
                null
            )
        }

        fun <T> error(exception: AppException? = null): Resource<T> {
            return Resource(
                Status.ERROR,
                null,
                exception
            )
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(
                Status.LOADING,
                data,
                null
            )
        }

        fun <T> cancel(data: T? = null, exception: AppException? = null): Resource<T> {
            return Resource(
                Status.CANCEL,
                data,
                exception
            )
        }
    }

    fun getErrorMessage() = exception?.getErrorMessage()
}