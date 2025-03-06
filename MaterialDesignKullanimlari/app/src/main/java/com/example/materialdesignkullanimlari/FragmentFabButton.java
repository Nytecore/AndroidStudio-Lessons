package com.example.materialdesignkullanimlari;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.materialdesignkullanimlari.databinding.FragmentFabButtonBinding;
import com.google.android.material.snackbar.Snackbar;

public class FragmentFabButton extends Fragment {
    private FragmentFabButtonBinding tasarim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasarim = FragmentFabButtonBinding.inflate(inflater, container, false);

        tasarim.fabButton.setOnClickListener(view -> {
            Snackbar.make(view, "Floating Action Button", Snackbar.LENGTH_SHORT).show();
        });

        tasarim.fabSonrakiButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.sifirdanBire);
        });

        return tasarim.getRoot();
    }
}