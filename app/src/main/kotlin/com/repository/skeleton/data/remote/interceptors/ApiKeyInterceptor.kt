package com.repository.skeleton.data.remote.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {

    companion object {
        private const val AUTH = "Authorization"
        private const val AUTH_KEY = "YOUR_AUTH_KEY"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
            .addHeader(AUTH, AUTH_KEY)
            .build()
        return chain.proceed(newRequest)
    }
}