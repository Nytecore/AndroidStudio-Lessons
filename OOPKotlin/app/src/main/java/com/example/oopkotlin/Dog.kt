package com.example.oopkotlin

class Dog : Animal() {

    fun test() {
        super.sing()
    }

    override fun sing() {
        println("dog class")
    }

}