package com.example.yasamdongusu;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // onCreate() metodu aşağıdadır.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Log.e("Yaşam Döngüsü" , "onCreate metodu çalışıyor");


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Yaşam Döngüsü" , "onStart metodu çalışıyor");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Yaşam Döngüsü" , "onResume metodu çalışıyor.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Yaşam Döngüsü" , "onPause metodu çalışıyor.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Yaşam Döngüsü" , "onStop metodu çalışıyor.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Yaşam Döngüsü" , "onDestroy metodu çalışıyor.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Yaşam Döngüsü" , "onRestart metodu çalışıyor.");
    }
}