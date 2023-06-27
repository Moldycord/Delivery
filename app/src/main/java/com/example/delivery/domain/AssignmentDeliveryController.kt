package com.example.delivery.domain

import com.example.delivery.entities.Driver
import com.example.delivery.entities.Shipment

class AssignmentDeliveryController {

    private val scoreCalculator = SuitabilityScoreCalculatorController()

    fun getOptimalAssignments(drivers: List<Driver>, shipments: List<Shipment>): Map<Driver, Shipment> {
        val assignedShipments = mutableSetOf<Shipment>()
        val assignedDrivers = mutableSetOf<Driver>()
        val assignments = mutableMapOf<Driver, Shipment>()

        for (shipment in shipments) {
            var maxScore = Double.MIN_VALUE
            var currentBestDriver: Driver? = null

            for (driver in drivers) {
                if (!assignedDrivers.contains(driver)) {
                    val score = scoreCalculator.calculateSuitabilityScore(
                        shipment.streetName,
                        driver.firstName
                    )
                    println(score.toString())

                    if (score > maxScore) {
                        maxScore = score
                        currentBestDriver = driver
                    }
                }
            }

            if (currentBestDriver != null) {
                assignments[currentBestDriver] = shipment
                assignedShipments.add(shipment)
                assignedDrivers.add(currentBestDriver)
            }
        }
        return assignments
    }

}