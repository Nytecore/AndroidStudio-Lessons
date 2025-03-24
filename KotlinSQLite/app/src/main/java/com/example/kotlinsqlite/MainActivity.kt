package com.example.kotlinsqlite

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinsqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        try {       //Aşağıdaki kod bloğundaki kodu dene, hata varsa catch'e git.

            val myDatabase = this.openOrCreateDatabase("Musicians" , MODE_PRIVATE, null)

            // Database oluşturma
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians(id INTEGER PRIMARY KEY, name VARCHAR, age INT)")

            // Database değer ekleme
            // myDatabase.execSQL("INSERT INTO musicians (name , age) VALUES ('James', 50)")    // Name: James - Age: 50 - ID: 1
            // myDatabase.execSQL("INSERT INTO musicians (name , age) VALUES ('Lars', 60)")     // Name: Lars  - Age: 60 - ID: 2
            // myDatabase.execSQL("INSERT INTO musicians (name , age) VALUES ('Kirk', 55)")     // Name: Kirk  - Age: 55 - ID: 3

            // Database değer güncelleme
            // myDatabase.execSQL("UPDATE musicians SET age = 61 WHERE name = 'Lars'")
            // myDatabase.execSQL("UPDATE musicians SET name = 'Kirk Hammett' WHERE id = 3")


            //Database değer silme
            //myDatabase.execSQL("DELETE FROM musicians WHERE name = 'Lars'")


            val cursor = myDatabase.rawQuery("SELECT * FROM musicians", null)

            val nameIx = cursor.getColumnIndex("name")
            val ageIx = cursor.getColumnIndex("age")
            val idIx = cursor.getColumnIndex("id")

            while (cursor.moveToNext()) {
                println("Name: " + cursor.getString(nameIx))
                println("Age: " + cursor.getInt(ageIx))
                println("ID: " + cursor.getInt(idIx))
            }

            cursor.close()

        } catch (e: Exception) {
            // Hata varsa onu yakala

        }
    }
}
