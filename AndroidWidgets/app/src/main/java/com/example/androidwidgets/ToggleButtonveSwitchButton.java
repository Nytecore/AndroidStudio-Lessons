package com.example.androidwidgets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.example.androidwidgets.databinding.FragmentToggleButtonveSwitchButtonBinding;

public class ToggleButtonveSwitchButton extends Fragment {
    private FragmentToggleButtonveSwitchButtonBinding tasarim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasarim = FragmentToggleButtonveSwitchButtonBinding.inflate(inflater, container, false);

        tasarim.switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Log.e("Switch" , "ON");
                } else {
                    Log.e("Switch" , "OFF");
                }

            }
        });


        tasarim.kontrolButtonu.setOnClickListener(view -> {
            Boolean switchDurum = tasarim.switchButton.isChecked();
            Boolean toggleDurum = tasarim.toggleButton.isChecked();

            Log.e("Switch Durum" , String.valueOf(switchDurum));
            Log.e("Toggle Button Durum" , String.valueOf(toggleDurum));
        });




        tasarim.toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Log.e("Toggle Button" , "ON");
                } else {
                    Log.e("Toggle Button" , "OFF");
                }

            }
        });

        tasarim.ikinciOnceki.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.ikinciBack);
        });


        tasarim.ikinciSonraki.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.ikinciNext);
        });








        return tasarim.getRoot();
    }
}