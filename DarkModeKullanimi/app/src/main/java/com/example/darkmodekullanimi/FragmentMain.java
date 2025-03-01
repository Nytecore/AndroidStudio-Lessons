package com.example.darkmodekullanimi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.darkmodekullanimi.databinding.FragmentMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class FragmentMain extends Fragment {
    private FragmentMainBinding tasarim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasarim = FragmentMainBinding.inflate(inflater, container, false);

        tasarim.buttonNormal.setOnClickListener(view -> {

            ((AppCompatActivity) getActivity()).getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            Snackbar.make(view , "Normal tema seçildi..." , Snackbar.LENGTH_SHORT).show();

        });

        tasarim.buttonDark.setOnClickListener(view -> {

            ((AppCompatActivity)getActivity()).getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            Snackbar.make(view , "Karanlık tema seçildi..." , Snackbar.LENGTH_SHORT).show();

        });


        return tasarim.getRoot();
    }
}