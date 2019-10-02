package com.example.mykotlinfirst

import kotlin.random.Random

class Car(val name: String, val yearOfIssue: Int, var milleage: Int, var owner: Motorist, var cost: Int, val classOfCar: Char,
          var engineCondition: Int, var bodyCondition: Int, var suspensionCondition: Int, var isBeaten: Boolean) {

    init {
        var cost: Int = 0
        val countOfEears: Int = 2019 - yearOfIssue
        when (classOfCar){
            'B' -> cost = 1000000 - 100000 * yearOfIssue - 10000 * (10 - engineCondition) - 10000 * (10 - bodyCondition) - 10000 * (10 - suspensionCondition)
            'C' -> cost = 1500000 - 120000 * yearOfIssue - 20000 * (10 - engineCondition) - 20000 * (10 - bodyCondition) - 20000 * (10 - suspensionCondition)
            'D' -> cost = 2000000 - 150000 * yearOfIssue - 40000 * (10 - engineCondition) - 30000 * (10 - bodyCondition) - 40000 * (10 - suspensionCondition)
            'E' -> cost = 2500000 - 180000 * yearOfIssue - 60000 * (10 - engineCondition) - 50000 * (10 - bodyCondition) - 60000 * (10 - suspensionCondition)
            'S' -> cost = 3500000 - 220000 * yearOfIssue - 100000 * (10 - engineCondition) - 80000 * (10 - bodyCondition) - 100000 * (10 - suspensionCondition)
        }
        printMessage("The cost of this car = " + cost)

    }

    fun shortenMileage(kilometres: Int){
        if(kilometres <= milleage) {
            milleage -= kilometres
        } else printMessage("kilometres can't be more than milleage!")
    }

    fun breakDown(){
        val failureRate = Random.nextInt(10)
        val component = Random.nextInt(3)
        when(component){
            1 -> {
                if(failureRate > engineCondition) engineCondition = 0
                else engineCondition -= failureRate
                }
            2 -> {
                if(failureRate > bodyCondition) bodyCondition = 0
                else bodyCondition -= failureRate
            }
            3 -> {
                if(failureRate > suspensionCondition) suspensionCondition = 0
                else suspensionCondition -= failureRate
            }
        }
    }

}
