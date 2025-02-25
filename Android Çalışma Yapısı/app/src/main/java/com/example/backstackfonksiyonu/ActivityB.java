package com.example.backstackfonksiyonu;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.backstackfonksiyonu.databinding.ActivityBBinding;
import com.example.backstackfonksiyonu.databinding.ActivityMainBinding;

public class ActivityB extends AppCompatActivity {
    private ActivityBBinding tasarim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        tasarim = ActivityBBinding.inflate(getLayoutInflater());
        setContentView(tasarim.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tasarim.bButton.setOnClickListener(view -> {

            startActivity(new Intent(ActivityB.this , ActivityC.class));

        });

    }
}