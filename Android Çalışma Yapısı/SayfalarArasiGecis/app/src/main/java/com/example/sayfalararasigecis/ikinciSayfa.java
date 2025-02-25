package com.example.sayfalararasigecis;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sayfalararasigecis.databinding.ActivityIkinciSayfaBinding;
import com.example.sayfalararasigecis.databinding.ActivityMainBinding;

public class ikinciSayfa extends AppCompatActivity {
    private ActivityIkinciSayfaBinding activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        activity = ActivityIkinciSayfaBinding.inflate(getLayoutInflater());
        setContentView(activity.getRoot());
        Intent intent = new Intent(ikinciSayfa.this, ucuncuSayfa.class);

        activity.ikinciButton.setOnClickListener(view -> {
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}