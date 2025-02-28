package com.example.snackbarkullanimi;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.snackbarkullanimi.databinding.FragmentSnackBarBinding;
import com.google.android.material.snackbar.Snackbar;

public class SnackBarFragment extends Fragment {
    private FragmentSnackBarBinding tasarim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasarim = FragmentSnackBarBinding.inflate(inflater, container, false);

        tasarim.buttonCikis.setOnClickListener(view -> {
            System.exit(0);
        });


        tasarim.buttonNormal.setOnClickListener(view -> {

            Snackbar.make(view , "Merhaba" , Snackbar.LENGTH_SHORT).show();

        });

        tasarim.buttonGeriDonus.setOnClickListener(view -> {

            Snackbar.make(view , "Mesaj silinsin mi?" , Snackbar.LENGTH_LONG)
                    .setAction("EVET", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar.make(view , "Mesaj silindi...", Snackbar.LENGTH_SHORT).show();
                        }
                    }).show();

        });

        tasarim.buttonOzel.setOnClickListener(view -> {

            Snackbar sb = Snackbar.make(view , "İnternet bağlantısı yok!" , Snackbar.LENGTH_LONG)
                    .setAction("Tekrar Dene", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    });

            sb.setActionTextColor(Color.YELLOW);    // Action Button rengi
            sb.setBackgroundTint(Color.BLACK);      // Arkaplan rengi
            sb.setTextColor(Color.RED);             // Verilen mesajın rengi

            sb.show();
        });

        return tasarim.getRoot();
    }
}