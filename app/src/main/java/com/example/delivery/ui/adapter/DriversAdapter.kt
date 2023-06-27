package com.example.delivery.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.delivery.databinding.DriverItemViewBinding
import com.example.delivery.entities.Driver
import com.example.delivery.ui.listeners.OnDriverClickListener

class DriversAdapter(
    private val driversList: List<Driver>, private val listener: OnDriverClickListener
) : RecyclerView.Adapter<DriversAdapter.DriverViewHolder>() {
    private var drivers = driversList


    inner class DriverViewHolder(val binding: DriverItemViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverViewHolder {
        val binding =
            DriverItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DriverViewHolder(binding)
    }

    override fun getItemCount(): Int = driversList.size

    override fun onBindViewHolder(holder: DriverViewHolder, position: Int) {
        with(holder) {
            with(driversList[position]) {
                binding.textViewDriverName.text = "${this.firstName} ${this.lastName}"
                holder.itemView.setOnClickListener { listener.onClick(this) }
            }

        }
    }
}