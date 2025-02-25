package com.example.androidwidgets;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidwidgets.databinding.FragmentWebViewBinding;

public class WebView extends Fragment {
    private FragmentWebViewBinding tasarim;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasarim = FragmentWebViewBinding.inflate(inflater, container, false);

        tasarim.besinciOncekiButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.besinciBack);
        });

        tasarim.besinciSonrakiButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.besinciNext);
        });

        tasarim.webView.getSettings().setJavaScriptEnabled(true);
        tasarim.webView.loadUrl("https://gelecegiyazanlar.turkcell.com.tr");


        return tasarim.getRoot();
    }
}


