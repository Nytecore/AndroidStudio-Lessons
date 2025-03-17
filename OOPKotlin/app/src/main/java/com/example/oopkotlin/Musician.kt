package com.example.oopkotlin

open class Musician (name: String, instrument: String, age: Int){

    var name : String? = name
        private set
        get

    private var instrument : String? = instrument


    var age : Int? = age
        get
        private set


    private val bandName : String = "Metallica"

    fun returnBandName (password: String) : String {
        return if (password == "Kotlin") {
            bandName
        } else {
            "Wrong password!"
        }
    }
}