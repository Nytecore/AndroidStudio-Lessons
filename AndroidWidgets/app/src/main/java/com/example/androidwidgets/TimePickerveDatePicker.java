package com.example.androidwidgets;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.androidwidgets.databinding.FragmentTimePickerveDatePickerBinding;

import java.util.Calendar;

public class TimePickerveDatePicker extends Fragment {
    private FragmentTimePickerveDatePickerBinding tasarim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasarim = FragmentTimePickerveDatePickerBinding.inflate(inflater, container, false);

        tasarim.altinciOncekiButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.altinciBack);
        });

        tasarim.altinciSonrakiButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.altinciNext);
        });

        tasarim.editTextSaat.setOnClickListener(view -> {
            Calendar calendar = Calendar.getInstance();
            int saat = calendar.get(Calendar.HOUR_OF_DAY);
            int dakika = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePicker;
            timePicker = new TimePickerDialog(this.getContext(), new TimePickerDialog.OnTimeSetListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    tasarim.editTextSaat.setText(i + " : " + i1);
                }
            }, saat, dakika, true);

            timePicker.setTitle("Saat Seçiniz");
            timePicker.setButton(DialogInterface.BUTTON_POSITIVE, "Ayarla" , timePicker);
            timePicker.setButton(DialogInterface.BUTTON_NEGATIVE, "İptal" , timePicker);

            timePicker.show();

        });

        tasarim.editTextTarih.setOnClickListener(view -> {

            Calendar calendar = Calendar.getInstance();
            int yil = calendar.get(Calendar.YEAR);
            int ay = calendar.get(Calendar.MONTH);
            int gun = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePicker;
            datePicker = new DatePickerDialog(this.getContext(), new DatePickerDialog.OnDateSetListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    tasarim.editTextTarih.setText(i2 + " / " + (i1+1) + " / " + i);
                }
            }, yil, ay, gun);

            datePicker.setTitle("Tarih Seçiniz");
            datePicker.setButton(DialogInterface.BUTTON_POSITIVE, "Ayarla", datePicker);
            datePicker.setButton(DialogInterface.BUTTON_NEGATIVE, "İptal", datePicker);

            datePicker.show();


        });
        return tasarim.getRoot();
    }
}