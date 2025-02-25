package com.example.alertviewkullanimi;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alertviewkullanimi.databinding.FragmentMainBinding;

public class FragmentMain extends Fragment {
    private FragmentMainBinding tasarim;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasarim = FragmentMainBinding.inflate(inflater, container, false);

        tasarim.buttonNormal.setOnClickListener(view -> {   // Button tıklama fonksiyonu

            AlertDialog.Builder ad = new AlertDialog.Builder(requireContext()); // AlertView, AlertBuilder sınıfı ile oluşturulur.
            ad.setMessage("Mesaj");         // AlertView içerisindeki mesaj.
            ad.setTitle("Başlık");          // AlertView başlığı.
            ad.setIcon(R.drawable.resim);   // AlertView içerisindeki resim (icon)

            ad.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {   // Pozitif buttonu ve onun listenerı
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(requireContext(), "Tamama tıklandı....", Toast.LENGTH_SHORT).show();
                }
            });

            ad.setNegativeButton("İptal", new DialogInterface.OnClickListener() {   // Negatif buttonu ve onun listenerı
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(requireContext(), "İptale tıklandı....", Toast.LENGTH_SHORT).show();
                }
            });

            ad.create().show(); // AlertView'in görünmesini sağlayan metod.
        });

        tasarim.buttonKapat.setOnClickListener(view -> {
            System.exit(0);
        });


        tasarim.buttonOzel.setOnClickListener(view -> {

            View tasarim = getLayoutInflater().inflate(R.layout.alert_tasarim, null);
            EditText editTextAlert = tasarim.findViewById(R.id.editTextAlert);
            AlertDialog.Builder ad = new AlertDialog.Builder(requireContext());

            ad.setTitle("Başlık");
            ad.setMessage("Mesaj");
            ad.setView(tasarim);

            ad.setPositiveButton("Kaydet", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String message = editTextAlert.getText().toString();
                    Toast.makeText(requireContext(), "Gelen mesaj: " + message, Toast.LENGTH_SHORT).show();
                }
            });

            ad.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(requireContext(), "İptal tıklandı", Toast.LENGTH_SHORT).show();
                }
            });

            ad.create().show();
        });



        return tasarim.getRoot();

    }
}