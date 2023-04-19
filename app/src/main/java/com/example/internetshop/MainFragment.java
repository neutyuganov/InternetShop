package com.example.internetshop;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {

    Button cpu;
    Button motherboard;
    Button gpu;
    Button rom;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, container, false);

        cpu = v.findViewById(R.id.cpu);
        motherboard = v.findViewById(R.id.motherboard);
        gpu = v.findViewById(R.id.gpu);
        rom = v.findViewById(R.id.rom);

        Drawable drawableT = getResources().getDrawable(R.drawable.button_change_t);
        Drawable drawableF = getResources().getDrawable(R.drawable.button_change_f);
        Color colorW = Color.valueOf(getResources().getColor(R.color.secondary_text));



        cpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 cpu.setBackground(drawableT);
                 cpu.setTextColor(getResources().getColor(R.color.white));

                 motherboard.setBackground(drawableF);
                 motherboard.setTextColor(getResources().getColor(R.color.secondary_text));
                 gpu.setBackground(drawableF);
                 gpu.setTextColor(getResources().getColor(R.color.secondary_text));
                 rom.setBackground(drawableF);
                 rom.setTextColor(getResources().getColor(R.color.secondary_text));
            }
        });

        motherboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                motherboard.setBackground(drawableT);
                motherboard.setTextColor(getResources().getColor(R.color.white));

                cpu.setBackground(drawableF);
                cpu.setTextColor(getResources().getColor(R.color.secondary_text));
                gpu.setBackground(drawableF);
                gpu.setTextColor(getResources().getColor(R.color.secondary_text));
                rom.setBackground(drawableF);
                rom.setTextColor(getResources().getColor(R.color.secondary_text));
            }
        });

        gpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gpu.setBackground(drawableT);
                gpu.setTextColor(getResources().getColor(R.color.white));

                cpu.setBackground(drawableF);
                cpu.setTextColor(getResources().getColor(R.color.secondary_text));
                motherboard.setBackground(drawableF);
                motherboard.setTextColor(getResources().getColor(R.color.secondary_text));
                rom.setBackground(drawableF);
                rom.setTextColor(getResources().getColor(R.color.secondary_text));
            }
        });

        rom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rom.setBackground(drawableT);
                rom.setTextColor(getResources().getColor(R.color.white));

                cpu.setBackground(drawableF);
                cpu.setTextColor(getResources().getColor(R.color.secondary_text));
                motherboard.setBackground(drawableF);
                motherboard.setTextColor(getResources().getColor(R.color.secondary_text));
                gpu.setBackground(drawableF);
                gpu.setTextColor(getResources().getColor(R.color.secondary_text));
            }
        });

        return v;

    }
}