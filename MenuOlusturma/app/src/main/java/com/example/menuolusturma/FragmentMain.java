package com.example.menuolusturma;

import android.os.Bundle;

import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.menuolusturma.databinding.FragmentMainBinding;

public class FragmentMain extends Fragment {
    private FragmentMainBinding tasarim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasarim = FragmentMainBinding.inflate(inflater, container, false);


        tasarim.buttonMenuAc.setOnClickListener(view -> {
            PopupMenu popUp = new PopupMenu(getContext(), tasarim.buttonMenuAc);

            popUp.getMenuInflater().inflate(R.menu.popup_menu, popUp.getMenu());

            popUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {

                    int id = item.getItemId();
                    if (id == R.id.action_sil){
                        Toast.makeText(requireContext(), "Sil butonuna tıklandı.", Toast.LENGTH_SHORT).show();
                        return true;

                    } else if (id == R.id.action_duzenle) {
                        Toast.makeText(requireContext(), "Düzenle butonu tıklandı", Toast.LENGTH_SHORT).show();
                        return true;

                    } else {
                        return false;
                    }
                }
            });
            popUp.show();


        });
        return tasarim.getRoot();
    }
}