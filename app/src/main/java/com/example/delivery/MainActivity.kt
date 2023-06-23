package com.example.delivery

import android.app.Activity
import android.os.Bundle
import com.example.delivery.databinding.MainActivityBinding

class MainActivity : Activity() {

    lateinit var binding : MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

