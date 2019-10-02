package com.example.mykotlinfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var vasya = CommonMotorist("Vasya", 150000, garage = ArrayList(10))
        var lada = Car("Lada Priora", 2012, 56000, vasya, 190000,
            'B', 7, 8,7, false)
        var petya = Reseller("Petr", 200000, garage = ArrayList(3))
        vasya.sellCar(lada, petya)
    }
}

inline fun printMessage(message: String){
    Log.e("lala", message)
}
