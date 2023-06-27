package com.example.delivery.data

import com.example.delivery.entities.Driver
import com.example.delivery.utils.DRIVERS_JSON
import com.example.delivery.utils.getJsonDataFromAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DriversRepository {

    fun getDrivers(): List<Driver> {
        val jsonString = getJsonDataFromAsset(DRIVERS_JSON)
        val listDriversType = object : TypeToken<List<Driver>>() {}.type
        return Gson().fromJson(jsonString, listDriversType)
    }
}