package com.example.deneme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

import java.util.ArrayList;

public class DersInfo extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ders_info);
        TextView textDersAdi = (TextView) this.findViewById(R.id.textDersAdı);
        TextView textNot = (TextView) this.findViewById(R.id.textNot);
        TextView textOgretmen = (TextView) this.findViewById(R.id.textOgretmen);
        TextView textKredi = (TextView) this.findViewById(R.id.textKredi);
        Intent myIntent = getIntent();
        int i = myIntent.getIntExtra("i",0);
        String dersinAdı = myIntent.getStringExtra("dersAd");
        String dersinNotu = myIntent.getStringExtra("dersNot");
        String dersinOgretmeni = myIntent.getStringExtra("dersOgretmen");
        String dersinKredisi = myIntent.getStringExtra("dersKredi");
        textDersAdi.setText(dersinAdı);
        textNot.setText(dersinNotu);
        textOgretmen.setText(dersinOgretmeni);
        textKredi.setText(dersinKredisi);

    }
}
