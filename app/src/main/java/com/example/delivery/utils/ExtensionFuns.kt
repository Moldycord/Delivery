package com.example.delivery.utils

import android.app.Application
import android.content.Context
import com.example.delivery.application.DeliveryApplication
import java.io.IOException

fun getJsonDataFromAsset(fileName: String): String? {
    val context = DeliveryApplication.applicationContext()
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}