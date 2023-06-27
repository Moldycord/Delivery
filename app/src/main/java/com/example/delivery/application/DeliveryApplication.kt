package com.example.delivery.application

import android.app.Application
import android.content.Context

class DeliveryApplication : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: DeliveryApplication? = null

        fun applicationContext(): Context {
            return requireNotNull(instance).applicationContext
        }
    }
}