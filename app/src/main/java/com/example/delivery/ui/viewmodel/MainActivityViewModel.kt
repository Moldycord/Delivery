package com.example.delivery.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.delivery.data.DriversRepository
import com.example.delivery.data.ShipmentsRepository
import com.example.delivery.domain.AssignmentDeliveryController
import com.example.delivery.entities.Driver
import com.example.delivery.entities.Shipment

class MainActivityViewModel : ViewModel() {

    private val driversRepository = DriversRepository()
    private val shipmentsRepository = ShipmentsRepository()
    private val assignmentDeliveryController = AssignmentDeliveryController()

    private lateinit var driversMap: Map<Driver, Shipment>

    private val _driversList = MutableLiveData<List<Driver>>()
    val drivers: LiveData<List<Driver>> get() = _driversList


    fun loadDrivers() {
        val driversList = driversRepository.getDrivers()
        _driversList.value = driversList
        driversMap = assignmentDeliveryController.getOptimalAssignments(
            driversList, shipmentsRepository.getShipments()
        )
    }

    fun onDriverSelected(driver: Driver): Shipment? {
        if (this::driversMap.isInitialized) {
            return driversMap[driver]
        }
        return null
    }

}