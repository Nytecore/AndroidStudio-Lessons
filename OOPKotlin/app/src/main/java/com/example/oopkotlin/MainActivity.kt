package com.example.oopkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.oopkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //constructor
        var myUser = User("James" , 50)
        myUser.name = "Lars"
        myUser.age = 60

        println(myUser.age.toString())
        println(myUser.name)
        println(myUser.information())



        //encapsulation
        var  james = Musician("James" , "Guitar" , 55)
        println(james.age.toString())
        println(james.returnBandName("Kotlin"))
        println(james.returnBandName("Java"))


        //inheritance
        var lars = SuperMusician("Lars" , "Drums" , 65)
        println(lars.name)
        println(lars.returnBandName("Kotlin"))
        lars.sing()


        // polymorphism
        //static polymorphism
        var mathematics = Mathematics()
        println(mathematics.sum())
        println(mathematics.sum(5,6))
        println(mathematics.sum(5,6,7))

        //dynamic polymorphism
        val animal = Animal()
        animal.sing()

        val barley = Dog()
        barley.test()
        barley.sing()


        // abstract & interface

        //var myPeople = People()       --> cant create

        var myPiano = Piano()
        myPiano.brand = "Yamaha"
        myPiano.digital = false
        println(myPiano.roomName)     // ----> HouseDecor içerisinden alındı, override edildi.
        myPiano.info()                // ----> Instrument içerisinden alındı, override edildi.



        //Lambda Expressions

        fun printString(myString : String) {
            println(myString)
        }

        printString("My Test String")


        // String yazdırma lambda expressions
        val testString = {myString : String -> println(myString)}
        testString("My Lambda testString")
        // Çıktı: My Lambda testString

        // Lamda expressions çarpma işlemi
        val multiplyLambda = {a: Int, b: Int -> println(a * b)}
        multiplyLambda(3 , 5)
        // Çıktı: 15

        // lambda expressions çarpma işlemi version 2
        val multiplyLambdav2 : (Int, Int) -> Int = {a,b -> a*b}
        println(multiplyLambdav2(5,5))
        // Çıktı: 25



        //asynchrnous
        // callback function , listener function , completion function

        fun downloadMusicians(url: String, completion : (Musician) -> Unit) {
            //url -> download
            //data -> here
            val kirkHammet = Musician("Kirk" , "Guitar" , 60)
            completion(kirkHammet)
        }

        downloadMusicians("example.com" , { musician ->
            println(musician.name)
            //Burada yazılan işlemler yukarıdaki download işlemi bittiğinde yapılacak.
        })

    }
}