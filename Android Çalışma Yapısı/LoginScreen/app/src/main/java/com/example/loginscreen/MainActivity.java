package com.example.loginscreen;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.loginscreen.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;


/** @noinspection ALL*/
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding tasarim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasarim = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(tasarim.getRoot());

        tasarim.loginButton.setOnClickListener(view -> {
            tasarim.usernameTextField.setText("Butona Tıklandı....");
        });

    }
}
