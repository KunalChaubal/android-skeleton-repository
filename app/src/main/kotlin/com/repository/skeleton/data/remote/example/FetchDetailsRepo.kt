package com.repository.skeleton.data.remote.example

import com.repository.skeleton.data.remote.model.Resource
import com.repository.skeleton.data.remote.model.example.DogDetailsResponse
import com.repository.skeleton.extensions.handleException

class FetchDetailsRepo(private val fetchDetailsAPI: FetchDetailsAPI) {
    suspend fun fetchDetails(): Resource<DogDetailsResponse> {
        return handleException { fetchDetailsAPI.fetchDetails() }
    }
}