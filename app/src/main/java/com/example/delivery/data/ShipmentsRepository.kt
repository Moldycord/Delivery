package com.example.delivery.data

import com.example.delivery.entities.Shipment
import com.example.delivery.utils.SHIPMENTS_JSON
import com.example.delivery.utils.getJsonDataFromAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ShipmentsRepository {
    fun getShipments(): List<Shipment> {
        val jsonString = getJsonDataFromAsset(SHIPMENTS_JSON)
        val listShipmentsType = object : TypeToken<List<Shipment>>() {}.type
        return Gson().fromJson(jsonString, listShipmentsType)
    }
}