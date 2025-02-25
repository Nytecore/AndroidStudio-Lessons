package com.example.navigationslemleri;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationslemleri.databinding.FragmentSonucEkraniBinding;

public class SonucEkraniFragment extends Fragment {
    private FragmentSonucEkraniBinding tasarim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasarim = FragmentSonucEkraniBinding.inflate(inflater, container, false);
        tasarim.kapatButton.setOnClickListener(view -> {
            System.exit(0);
        });

        return tasarim.getRoot();
    }
}