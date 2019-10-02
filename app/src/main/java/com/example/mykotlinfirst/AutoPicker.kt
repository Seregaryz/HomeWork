package com.example.mykotlinfirst

import kotlin.math.abs

class AutoPicker(val name: String, countOfMoney: Int, garage: ArrayList<Car>, var mercenary: Motorist,
                 bargainingAbility: Int = 15000): Motorist(name, countOfMoney, garage, bargainingAbility), Buyable, Sellable{

    override fun buyCar(car: Car, owner: Motorist) {
        if(countOfMoney >= car.cost && !car.isBeaten && car.suspensionCondition > 7 && car.bodyCondition > 7 && car.engineCondition > 7){
            val finalCostOfCar = car.cost - abs(bargainingAbility - owner.bargainingAbility)
            countOfMoney -= finalCostOfCar
            owner.countOfMoney += finalCostOfCar
            car.owner = this
            garage.add(car)
            owner.garage.remove(car)
        } else printMessage("I don't want buy this bad car!")
    }

    fun buyCarForMercenary(car: Car, owner: Motorist){
        if(mercenary.countOfMoney >= car.cost && car.engineCondition >= 8 && car.bodyCondition >= 8 && car.suspensionCondition >= 8 && !car.isBeaten) {
            val finalCostOfCar = car.cost - abs(bargainingAbility - owner.bargainingAbility)
            mercenary.countOfMoney -= car.cost
            owner.countOfMoney += car.cost
            mercenary.garage.add(car)
            owner.garage.remove(car)
        } else printMessage("I can't buy this car for my mercenary!")
    }

    override fun sellCar(car: Car, buyer: Motorist){
        if(buyer.countOfMoney > car.cost){
            val finalCostOfCar = car.cost - abs(bargainingAbility - buyer.bargainingAbility)
            countOfMoney += finalCostOfCar
            buyer.countOfMoney -= finalCostOfCar
            car.owner = buyer
            garage.remove(car)
            buyer.garage.add(car)
            printMessage("Sold))")
        }
    }
}