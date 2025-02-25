package com.example.sayfalararasigecis;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sayfalararasigecis.databinding.ActivityUcuncuSayfaBinding;

public class ucuncuSayfa extends AppCompatActivity {
    private ActivityUcuncuSayfaBinding activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        activity = ActivityUcuncuSayfaBinding.inflate(getLayoutInflater());
        setContentView(activity.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        activity.ucuncuButton.setOnClickListener(view -> {
            finishAffinity();
            System.exit(0);
        });
    }
}