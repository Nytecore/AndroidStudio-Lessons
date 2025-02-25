package com.example.navigationslemleri;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationslemleri.databinding.FragmentOyunEkraniBinding;

public class OyunEkraniFragment extends Fragment {
    private FragmentOyunEkraniBinding tasarim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasarim = FragmentOyunEkraniBinding.inflate(inflater, container, false);

        OyunEkraniFragmentArgs bundle = OyunEkraniFragmentArgs.fromBundle(getArguments());
        String gelenIsim = bundle.getIsim();
        int gelenNumara = bundle.getNumara();
        float gelenBoy = bundle.getBoy();
        Kisiler gelenKisi = bundle.getNesne();

        Log.e("Gelen İsim" , gelenIsim);
        Log.e("Gelen Numara" , String.valueOf(gelenNumara));
        Log.e("Gelen Boy" , String.valueOf(gelenBoy));

        Log.e("Gelen Kişi İsim" , gelenKisi.getKisi_isim());
        Log.e("Gelen Kişi Numara" , String.valueOf(gelenKisi.getKisi_numara()));
        Log.e("Gelen Kişi Boy" , String.valueOf(gelenKisi.getKisi_boy()));

        tasarim.oyunEkraniButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.oyunEkranindanGecis);
        });

        return tasarim.getRoot();
    }
}