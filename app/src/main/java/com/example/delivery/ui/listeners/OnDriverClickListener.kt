package com.example.delivery.ui.listeners

import com.example.delivery.entities.Driver

class OnDriverClickListener(val clickListener: (driver: Driver) -> Unit) {

    fun onClick(selectedDriver: Driver) = clickListener(selectedDriver)
}