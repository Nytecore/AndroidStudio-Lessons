package com.example.materialdesignkullanimlari;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.materialdesignkullanimlari.databinding.FragmentToolbarKullanimiBinding;

public class FragmentToolbarKullanimi extends Fragment implements SearchView.OnQueryTextListener {
    private FragmentToolbarKullanimiBinding tasarim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasarim = FragmentToolbarKullanimiBinding.inflate(inflater, container, false);

        tasarim.downPage2.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.ikidenBire);
        });

        tasarim.nextPage2.setOnClickListener(view -> {
            //Navigation.findNavController(view).navigate(R.id.ikidenUce);
        });

        tasarim.toolbar.setTitle("TOOLBAR");

        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                    // Oluşturulan menünün
                menuInflater.inflate(R.menu.toolbar_menu, menu);

                MenuItem item = menu.findItem(R.id.action_ara);
                SearchView searchView = (SearchView) item.getActionView();
                searchView.setOnQueryTextListener(FragmentToolbarKullanimi.this);


            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                    // Tıklanıldığında bir işlem yaptırmak için gereken kod bloğu.
                if (menuItem.getItemId() == R.id.action_bilgi) {
                    Toast.makeText(requireContext(), "Bilgi Tıklandı" , Toast.LENGTH_SHORT).show();
                    return true;

                } else if (menuItem.getItemId() == R.id.action_ekle) {
                    Toast.makeText(requireContext(), "Ekle Tıklandı" , Toast.LENGTH_SHORT).show();
                    return true;

                } else if (menuItem.getItemId() == R.id.action_ayarlar) {
                    Toast.makeText(requireContext(), "Ayarlar Tıklandı" , Toast.LENGTH_SHORT).show();
                    return true;

                } else if (menuItem.getItemId() == R.id.action_cikis) {
                    Toast.makeText(requireContext(), "Çıkış Tıklandı" , Toast.LENGTH_SHORT).show();
                    return true;

                } else {
                    return false;
                }

            }
        });

        // Toolbar'ı ActionBar olarak ayarla
        ((MainActivity) requireActivity()).setSupportActionBar(tasarim.toolbar);

        return tasarim.getRoot();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
            // Search item --> Arama butonuna tıklayınca aramayı yaptıran metod.
        Log.e("Gönderilen arama sonucu" , query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
            // Search item --> Her harf girilip / silindiğinde aramayı yaptıran metod.
        Log.e("Harf girdikçe sonucu" , newText);
        return true;
    }
}