package com.example.delivery.domain


import com.example.delivery.utils.VOWELS_STR

class SuitabilityScoreCalculatorController {


    fun calculateSuitabilityScore(streetName: String, driverName: String): Double {
        var currentScore: Double

        val isStreetNameEven: Boolean = (streetName.length % 2 == 0)

        currentScore = if (isStreetNameEven) {
            countVowelsOrConsonants(driverName, true) * 1.5
        } else {
            countVowelsOrConsonants(driverName, false) * 1
        }

        val commonFactor = findCommonFactor(streetName.length, driverName.length)

        if (commonFactor) {
            currentScore *= 1.5
        }
        return currentScore

    }

    private fun countVowelsOrConsonants(driver: String, shouldReturnVowels: Boolean): Double {
        val vowels = driver.count { it in VOWELS_STR }
        val consonants = driver.count { it !in VOWELS_STR }

        return if (shouldReturnVowels) vowels.toDouble() else consonants.toDouble()
    }

    private fun findCommonFactor(streetNameSize: Int, driverNameSize: Int): Boolean {
        for (i in 2..minOf(
            streetNameSize, driverNameSize
        )) if (streetNameSize % i == 0 && driverNameSize % i == 0) {
            return true
        }
        return false
    }
}