package com.example.delivery.domain

import com.example.delivery.utils.A_VOWEL
import com.example.delivery.utils.E_VOWEL
import com.example.delivery.utils.I_VOWEL
import com.example.delivery.utils.O_VOWEL
import com.example.delivery.utils.U_VOWEL

class SuitabilityScoreCalculatorController {


    fun calculateSuitabilityScore(streetName: String, driverName: String): Double {
        var currentScore: Double

        val isStreetNameEven: Boolean = (streetName.length % 2 == 0)

        currentScore = if (isStreetNameEven) {
            countVowelsOrConsonants(driverName, true) * 1.5
        } else {
            countVowelsOrConsonants(driverName, false) * 1
        }

        val commonFactor = findCommonFactor(streetName.length,driverName.length)

        if(commonFactor>1){
            currentScore *= 1.5
        }
        return currentScore

    }

    private fun countVowelsOrConsonants(driver: String, shouldReturnVowels: Boolean): Double {
        var vowels = 0
        var consonants = 0

        for (i in driver.indices) {
            when (driver[i].uppercaseChar()) {
                A_VOWEL, E_VOWEL, I_VOWEL, O_VOWEL, U_VOWEL -> ++vowels
                else -> ++consonants
            }
        }

        return if (shouldReturnVowels) vowels.toDouble() else consonants.toDouble()
    }

    private fun findCommonFactor(streetNameSize: Int, driverNameSize: Int): Int {

        return if(driverNameSize!=0)
            findCommonFactor(driverNameSize,streetNameSize% driverNameSize)
        else
            streetNameSize

    }
}