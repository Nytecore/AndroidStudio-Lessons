package com.example.storingdata

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.storingdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var age: Int? = null
    lateinit var sharedPref : SharedPreferences

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = this.getSharedPreferences("com.example.storingdata" , MODE_PRIVATE)

        val userAgePref = sharedPref.getInt("age" , -1)

        if (userAgePref == -1) {
            binding.ageTextView.text = "Age: "

        } else {
            binding.ageTextView.text = "Age: ${userAgePref}"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Toast.makeText(this, "Kaydedildi", Toast.LENGTH_SHORT).show()


        binding.submitButton.setOnClickListener {
            age = binding.ageEditText.text.toString().toIntOrNull()
            if (age != null){
                binding.ageTextView.text = "Age: $age"
                sharedPref.edit().putInt("age" , age!!).apply()
            } else {
                binding.ageTextView.text = "Enter a valid age!"
            }

        }

        binding.deleteButton.setOnClickListener {
            binding.ageTextView.text = "Age: "
            binding.ageEditText.setText("")
            sharedPref.edit().remove("age").apply()
        }

    }
}