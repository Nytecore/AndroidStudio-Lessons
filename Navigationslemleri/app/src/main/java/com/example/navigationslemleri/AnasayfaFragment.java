package com.example.navigationslemleri;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationslemleri.databinding.FragmentAnasayfaBinding;

public class AnasayfaFragment extends Fragment {
    private FragmentAnasayfaBinding tasarim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false);

        tasarim.anasayfaButton.setOnClickListener(view -> {
            Kisiler kisi1 = new Kisiler("Hasan" , 302 , 1.80f );
            AnasayfaFragmentDirections.AnasayfadanGecis transfer = AnasayfaFragmentDirections.anasayfadanGecis(kisi1);
            transfer.setIsim("Bora");
            transfer.setNumara(274);
            transfer.setBoy(1.77f);

            Navigation.findNavController(view).navigate(transfer);
        });
        return tasarim.getRoot();
    }
}