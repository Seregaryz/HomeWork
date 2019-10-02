package com.example.mykotlinfirst

import kotlin.math.abs

class CommonMotorist (var name: String, countOfMoney: Int, garage: ArrayList<Car>, bargainingAbility: Int = 10000)
    : Motorist(name, countOfMoney, garage, bargainingAbility), Buyable, Sellable {


    override fun buyCar(car: Car, owner: Motorist){
        if(countOfMoney >= car.cost && !car.isBeaten){
            val finalCostOfCar = car.cost - abs(bargainingAbility - owner.bargainingAbility)
            countOfMoney -= finalCostOfCar
            owner.countOfMoney += finalCostOfCar
            car.owner = this
            garage.add(car)
            owner.garage.remove(car)
        } else printMessage("I don't want buy beaten car!")
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