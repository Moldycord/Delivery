package com.example.delivery

import android.app.Activity
import android.os.Bundle
import com.example.delivery.databinding.MainActivityBinding
import com.example.delivery.domain.SuitabilityScoreCalculatorController

class MainActivity : Activity() {

    lateinit var binding: MainActivityBinding
    lateinit var deliveryController: SuitabilityScoreCalculatorController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
    }

    private fun initData() {
        deliveryController = SuitabilityScoreCalculatorController()
        val suitabilityScore =
            deliveryController.calculateSuitabilityScore("Osinski", "Orval")
        println(suitabilityScore.toString())
    }


}

