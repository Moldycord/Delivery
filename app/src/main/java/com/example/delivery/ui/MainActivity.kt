package com.example.delivery.ui

import android.app.Activity
import android.os.Bundle
import com.example.delivery.data.DriversRepository
import com.example.delivery.data.ShipmentsRepository
import com.example.delivery.databinding.MainActivityBinding
import com.example.delivery.domain.AssignmentDeliveryController

class MainActivity : Activity() {

    lateinit var binding: MainActivityBinding

    private val deliveryController = AssignmentDeliveryController()
    private val driversRepository = DriversRepository()
    private val shipmentsRepository = ShipmentsRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
    }

    private fun initData() {
        val driversList = driversRepository.getDrivers()
        val shipmentsList = shipmentsRepository.getShipments()
        val optimalAssignments = deliveryController.getOptimalAssignments(
            driversList, shipmentsList
        )
        println(optimalAssignments)
    }


}

