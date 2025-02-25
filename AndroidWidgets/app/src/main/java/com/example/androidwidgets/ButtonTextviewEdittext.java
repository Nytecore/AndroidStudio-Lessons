package com.example.androidwidgets;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidwidgets.databinding.FragmentButtonTextviewEdittextBinding;

public class ButtonTextviewEdittext extends Fragment {
    private FragmentButtonTextviewEdittextBinding tasarim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        tasarim = FragmentButtonTextviewEdittextBinding.inflate(inflater, container, false);

        tasarim.degistirButton.setOnClickListener(view -> {
            String alinanVeri = tasarim.editTextAlani.getText().toString();
            tasarim.textViewAlani.setText(alinanVeri);
        });

        tasarim.birinciSonraki.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.birinciNext);
        });



        tasarim.birinciOnceki.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.birinciBack);
                    // NavController navController = Navigation.findNavController(view);
                    // navController.popBackStack();
        });

        return tasarim.getRoot();
    }
}