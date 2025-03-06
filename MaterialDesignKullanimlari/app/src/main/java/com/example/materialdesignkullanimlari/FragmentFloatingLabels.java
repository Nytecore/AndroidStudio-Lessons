package com.example.materialdesignkullanimlari;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.materialdesignkullanimlari.databinding.FragmentFabButtonBinding;
import com.example.materialdesignkullanimlari.databinding.FragmentFloatingLabelsBinding;
import com.google.android.material.snackbar.Snackbar;

public class FragmentFloatingLabels extends Fragment {
    private FragmentFloatingLabelsBinding tasarim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasarim = FragmentFloatingLabelsBinding.inflate(inflater, container, false);

        tasarim.downPage1.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.birdenSifira);
        });

        tasarim.nextPage1.setOnClickListener(view -> {
            Snackbar.make(view, "Sonraki sayfaya gitmek için giriş yapınız..." , Snackbar.LENGTH_SHORT).show();
        });


        tasarim.girisButton.setOnClickListener(view -> {

            if (tasarim.editTextID.getText().toString().equals("1234") && tasarim.editTextPW.getText().toString().equals("1234")){
                Snackbar.make(view , "Sonraki sayfaya geçtiniz" , Snackbar.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.birdenIkiye);

            } else {
                Snackbar.make(view , "Giriş bilgileri yanlış" , Snackbar.LENGTH_SHORT).show();
            }

        });

        tasarim.ipucuButton.setOnClickListener(view -> {

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(requireContext());

            alertDialog.setIcon(R.drawable.resim_user);
            alertDialog.setTitle("İPUCU");
            alertDialog.setMessage("Kullanıcı adı ve parola: 1234");

            alertDialog.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(requireContext(), "Anlaşıldı...", Toast.LENGTH_SHORT).show();
                }
            });

            alertDialog.create().show();

        });


        return tasarim.getRoot();
    }
}