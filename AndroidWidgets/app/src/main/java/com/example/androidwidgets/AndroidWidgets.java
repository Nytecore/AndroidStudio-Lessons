package com.example.androidwidgets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidwidgets.databinding.FragmentAndroidWidgetsBinding;

public class AndroidWidgets extends Fragment {
    private FragmentAndroidWidgetsBinding tasarim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasarim = FragmentAndroidWidgetsBinding.inflate(inflater, container, false);

        tasarim.sonrakiSayfaButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.anasayfadanNext);
        });


        return tasarim.getRoot();
    }
}