package com.example.delivery.entities

import com.google.gson.annotations.SerializedName

data class Driver(
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String
)