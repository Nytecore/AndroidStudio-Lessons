package com.example.androidwidgets;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidwidgets.databinding.FragmentCheckboxRadioButtonBinding;
import com.example.androidwidgets.databinding.FragmentToggleButtonveSwitchButtonBinding;

import java.util.ArrayList;

public class CheckboxRadioButton extends Fragment {
    private FragmentCheckboxRadioButtonBinding tasarim;


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasarim = FragmentCheckboxRadioButtonBinding.inflate(inflater, container, false);

        tasarim.ucuncuOnceki.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.ucuncuBack);
        });

        tasarim.ucuncuSonraki.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.ucuncuNext);
        });

        tasarim.kontrolButton.setOnClickListener(view -> {

            ArrayList<String> diller = new ArrayList<>();
            if (tasarim.javaCheckBox.isChecked()) diller.add("Java");
            if (tasarim.kotlinCheckBox.isChecked()) diller.add("Kotlin");

            if (diller.isEmpty()) {
                tasarim.dilKontrolText.setText("Herhangi bir dil seçilmedi!");
            } else {
                tasarim.dilKontrolText.setText("Bilinen diller: " + String.join(", ", diller));
            }

            if (tasarim.barcelonaRadioButton.isChecked()) {
                tasarim.takimKontrolText.setText("Desteklenen Takım: Bercelona");
            } else if (tasarim.madridRadioButton.isChecked()) {
                tasarim.takimKontrolText.setText("Desteklenen Takım: Real Madrid");
            } else {
                tasarim.takimKontrolText.setText("Herhangi bir takım seçilmedi!");
            }
        });



        return tasarim.getRoot();
    }
}