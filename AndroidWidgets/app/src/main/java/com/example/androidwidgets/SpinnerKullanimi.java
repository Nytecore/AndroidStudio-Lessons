package com.example.androidwidgets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.androidwidgets.databinding.FragmentSpinnerKullanimiBinding;

import java.util.ArrayList;

public class SpinnerKullanimi extends Fragment {
    private FragmentSpinnerKullanimiBinding tasarim;
    private ArrayList<String> ulkeler = new ArrayList<>();
    private ArrayAdapter<String> veriAdaptoru;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasarim = FragmentSpinnerKullanimiBinding.inflate(inflater, container, false);

        tasarim.sekizinciOncekiButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.sekizinciBack);
        });

        tasarim.sekizinciSonrakiButton.setOnClickListener(view -> {
            //Navigation.findNavController(view).navigate(R.id.sekizinciNext);
        });

        ulkeler.add("Türkiye");
        ulkeler.add("İtalya");
        ulkeler.add("Almanya");
        ulkeler.add("Japonya");
        ulkeler.add("Çin");
        ulkeler.add("Portekiz");
        ulkeler.add("İspanya");

        veriAdaptoru = new ArrayAdapter<String>(getContext()
                                                , android.R.layout.simple_list_item_1
                                                , android.R.id.text1
                                                , ulkeler);

        tasarim.spinner.setAdapter(veriAdaptoru);

        tasarim.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Herhangi bir item seçilirse burası çalışır. Bize int 'i' değerini verir.
                Toast.makeText(getContext()
                        , "Seçilen Ülke: " + ulkeler.get(i)
                        , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Hiç bir şey seçilmezse burası çalışır.
            }
        });

        tasarim.buttonGoster.setOnClickListener(view -> {
            Toast.makeText(getContext()
                    , "Ülke: " + ulkeler.get(tasarim.spinner.getSelectedItemPosition())
                    , Toast.LENGTH_SHORT).show();
        });




        return tasarim.getRoot();
    }
}