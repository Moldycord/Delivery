package com.example.delivery.ui


import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.delivery.databinding.MainActivityBinding
import com.example.delivery.entities.Driver
import com.example.delivery.entities.Shipment
import com.example.delivery.ui.adapter.DriversAdapter
import com.example.delivery.ui.listeners.OnDriverClickListener
import com.example.delivery.ui.viewmodel.MainActivityViewModel

class MainActivity : ComponentActivity() {

    private lateinit var binding: MainActivityBinding

    private val viewModel by lazy { ViewModelProvider(this)[MainActivityViewModel::class.java] }


    private lateinit var customDriverAdapter: DriversAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        setupObservers()
        initData()
    }

    private fun initData() {
        viewModel.loadDrivers()
    }

    private fun setupObservers() {
        viewModel.drivers.observe(this) {
            customDriverAdapter =
                DriversAdapter(it, OnDriverClickListener { d -> onDriverSelected(d) })
            binding.recyclerViewDrivers.adapter = customDriverAdapter
        }

    }

    private fun setupView() {
        binding.apply {
            with(recyclerViewDrivers) {
                layoutManager = LinearLayoutManager(context)
            }
        }
    }

    private fun onDriverSelected(driver: Driver) {
        val shipment = viewModel.onDriverSelected(driver)
        buildDialog(shipment)
    }

    private fun buildDialog(shipment: Shipment?) {
        shipment?.let {
            val alertDialogBuilder = AlertDialog.Builder(this@MainActivity)
            alertDialogBuilder.setTitle("Assigned shipment")
            val dialog = alertDialogBuilder.create()
            dialog.show()
        }
    }


}

