package com.example.mykotlinfirst

import kotlin.math.abs

class Reseller(
    val name: String,
    countOfMoney: Int,
    garage: ArrayList<Car>,
    bargainingAbility: Int = 20000
) : Motorist(name, countOfMoney, garage, bargainingAbility), Sellable, Buyable, Repairable {

    override fun buyCar(car: Car, owner: Motorist) {
        if (countOfMoney >= car.cost) {
            val finalCostOfCar = car.cost - abs(bargainingAbility - owner.bargainingAbility)
            countOfMoney -= finalCostOfCar
            owner.countOfMoney += finalCostOfCar
            car.owner = this
            garage.add(car)
            owner.garage.remove(car)
            printMessage("I bought this car!!")
        }
    }

    override fun sellCar(car: Car, buyer: Motorist) {
        repairCar(car, countOfMoney / 10)
        if (buyer.countOfMoney >= car.cost) {
            val finalCostOfCar = car.cost - abs(bargainingAbility - buyer.bargainingAbility)
            countOfMoney += finalCostOfCar
            buyer.countOfMoney -= finalCostOfCar
            car.owner = buyer
            garage.remove(car)
            buyer.garage.add(car)
            printMessage("I sold this car!!")
        }
    }

    override fun repairCar(car: Car, moneyForRepair: Int) {
        car.isBeaten = false
        car.shortenMileage(50000)
        when (car.classOfCar) {
            'B' -> {
                val custom = moneyForRepair / 30000 + 1
                car.engineCondition += custom
                car.suspensionCondition += custom
                car.bodyCondition += custom
                car.cost += custom * 20000
            }
            'C' -> {
                val custom = moneyForRepair / 45000 + 1
                car.engineCondition += custom
                car.suspensionCondition += custom
                car.bodyCondition += custom
                car.cost += custom * 35000
            }
            'D' -> {
                val custom = moneyForRepair / 50000 + 1
                car.engineCondition += custom
                car.suspensionCondition += custom
                car.bodyCondition += custom
                car.cost += custom * 50000
            }
            'E' -> {
                val custom = moneyForRepair / 60000 + 1
                car.engineCondition += custom
                car.suspensionCondition += custom
                car.bodyCondition += custom
                car.cost += custom * 70000
            }
            'S' -> {
                val custom = moneyForRepair / 70000 + 1
                car.engineCondition += custom
                car.suspensionCondition += custom
                car.bodyCondition += custom
                car.cost += custom * 90000
            }
        }
        printMessage("The new cost of car = " + car.cost)
    }

}

