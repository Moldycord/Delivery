package com.example.delivery.entities

import com.google.gson.annotations.SerializedName

data class Shipment(
    @SerializedName("streetNumber")
    val streetNumber: Int,
    @SerializedName("streetName")
    val streetName: String,
    @SerializedName("unitNumber")
    val unitNumber: String? = "",
    @SerializedName("city")
    val city: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("zipCode")
    val zipCode: Int
) {
    override fun toString(): String {
        return "$streetNumber $streetName ${unitNumber ?: ""} $city $state $zipCode"
    }
}