package com.example.backstackfonksiyonu;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.backstackfonksiyonu.databinding.ActivityCBinding;
import com.example.backstackfonksiyonu.databinding.ActivityMainBinding;

public class ActivityC extends AppCompatActivity {
    private ActivityCBinding tasarim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        tasarim = ActivityCBinding.inflate(getLayoutInflater());
        setContentView(tasarim.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tasarim.cButton.setOnClickListener(view -> {

            startActivity(new Intent(ActivityC.this , ActivityD.class));

        });
    }
}