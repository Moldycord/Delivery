package com.example.delivery.ui

import android.app.Activity
import android.os.Bundle
import com.example.delivery.data.DriversRepository
import com.example.delivery.data.ShipmentsRepository
import com.example.delivery.databinding.MainActivityBinding
import com.example.delivery.domain.AssignmentDeliveryController
import com.example.delivery.entities.Driver
import com.example.delivery.ui.adapter.DriversAdapter
import com.example.delivery.ui.listeners.OnDriverClickListener

class MainActivity : Activity() {

    private lateinit var binding: MainActivityBinding

    private val deliveryController = AssignmentDeliveryController()
    private val driversRepository = DriversRepository()
    private val shipmentsRepository = ShipmentsRepository()
    private val customDriverAdapter = DriversAdapter(emptyList(), OnDriverClickListener { })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun initData() {
        val driversList = driversRepository.getDrivers()
        val shipmentsList = shipmentsRepository.getShipments()
        val optimalAssignments = deliveryController.getOptimalAssignments(
            driversList, shipmentsList
        )
        println(optimalAssignments)
    }

    private fun setupView() {
        binding.apply {
            with(recyclerViewDrivers) {
                adapter = customDriverAdapter
            }
        }
    }

    private fun onDriverSelected(driver: Driver) {

    }


}

