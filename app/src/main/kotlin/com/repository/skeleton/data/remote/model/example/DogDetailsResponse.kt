package com.repository.skeleton.data.remote.model.example


import com.google.gson.annotations.SerializedName

data class DogDetailsResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)