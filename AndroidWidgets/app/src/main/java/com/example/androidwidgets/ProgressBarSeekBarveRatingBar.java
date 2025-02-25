package com.example.androidwidgets;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import com.example.androidwidgets.databinding.FragmentProgressBarSeekBarveRatingBarBinding;

public class ProgressBarSeekBarveRatingBar extends Fragment {
    private FragmentProgressBarSeekBarveRatingBarBinding tasarim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasarim = FragmentProgressBarSeekBarveRatingBarBinding.inflate(inflater, container, false);

            // Önceki Sayfa buttonu kullanımı
        tasarim.dorduncuOncekiButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.dorduncuBack);
        });

        // Sonraki Sayfa buttonu kullanımı
        tasarim.dorduncuSonrakiButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.dorduncuNext);
        });

            // ProgressBar çalışma işlemi
        tasarim.durBaslaButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    tasarim.progressBar.setVisibility(View.VISIBLE);
                } else {
                    tasarim.progressBar.setVisibility(View.INVISIBLE);
                }
            }
        });

                // SeekBar'da fare ile kaydırarak alınan progressi alana yazdırma.
        tasarim.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tasarim.textViewSonuc.setText("Sonuç: " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        tasarim.puanlamaButton.setOnClickListener(view -> {
            float gelenOy = tasarim.ratingBar.getRating();
            int gelenSeekProgress = tasarim.seekBar.getProgress();

            tasarim.puanSonucText.setText("Puan: " + gelenOy + " SeekBar ilerlemesi: " + gelenSeekProgress);
        });


        return tasarim.getRoot();
    }
}