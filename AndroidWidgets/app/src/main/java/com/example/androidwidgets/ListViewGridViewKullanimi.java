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

import com.example.androidwidgets.databinding.FragmentListViewGridViewKullanimiBinding;

import java.util.ArrayList;

public class ListViewGridViewKullanimi extends Fragment {
    private FragmentListViewGridViewKullanimiBinding tasarim;
    private ArrayList<String> ulkeler = new ArrayList<>();
    private ArrayAdapter<String> veriAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasarim = FragmentListViewGridViewKullanimiBinding.inflate(inflater, container, false);

        tasarim.yedinciOncekiButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.yedinciBack);
        });

        tasarim.yedinciSonrakiButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.yedinciNext);
        });

        ulkeler.add("Türkiye");
        ulkeler.add("Amerika Birleşik Devletleri");
        ulkeler.add("İngiltere");
        ulkeler.add("İtalya");
        ulkeler.add("Fransa");
        ulkeler.add("İspanya");
        ulkeler.add("Çek Cumhuriyeti");
        ulkeler.add("Japonya");


        veriAdapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, ulkeler);
        tasarim.gridView.setAdapter(veriAdapter);

        tasarim.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext()
                        , "Seçilen ülke: " + ulkeler.get(i)
                        , Toast.LENGTH_SHORT).show();
            }
        });



        return tasarim.getRoot();
    }
}