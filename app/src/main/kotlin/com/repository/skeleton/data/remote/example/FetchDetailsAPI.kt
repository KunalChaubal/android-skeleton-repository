package com.repository.skeleton.data.remote.example

import com.repository.skeleton.data.remote.model.example.DogDetailsResponse
import retrofit2.http.GET

interface FetchDetailsAPI {
        @GET("/api/breeds/image/random")
        suspend fun fetchDetails(): DogDetailsResponse
}