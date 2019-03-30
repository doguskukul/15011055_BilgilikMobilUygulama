package com.example.deneme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class sayfa3 extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayfa3);
        Intent i3 = getIntent();
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<Ders> input = new ArrayList<>();
        Ders[] dersler = new Ders[30];
        dersler[0] = new Ders("Bilgisayar Bilimlerine Giris","CC");
        dersler[1] = new Ders("Matematik 1 ","AA");
        dersler[2] = new Ders("Fizik 1","CB");
        dersler[3] = new Ders("Lineer Cebir","BB");
        dersler[4] = new Ders("Ileri Ingilizce 1","AA");
        dersler[5] = new Ders("Yapisal Programlamaya Giris","BB");
        dersler[6] = new Ders("Toplumsal Yapilar","AA");
        dersler[7] = new Ders("Sayisal Analiz","BB");
        dersler[8] = new Ders("Devre Teorisi","BB");
        dersler[9] = new Ders("Yariiletken Fizigi","CB");
        dersler[10] = new Ders("Matematik 2","CB");
        dersler[11] = new Ders("Ileri Ingilizce 2","BA");
        dersler[12] = new Ders("Istatistik ve Olasılık","BB");
        dersler[13] = new Ders("Alt Seviye Programlama","DC");
        dersler[14] = new Ders("Yapisal Programlama","BB");
        dersler[15] = new Ders("Ayrik Matematik","AA");
        dersler[16] = new Ders("Sinyaller ve Sistemler","BB");
        dersler[17] = new Ders("Ingilizce Okuma ve Konusma","AA");
        dersler[18] = new Ders("Lojik Devreler","CC");
        dersler[19] = new Ders("Nesneye Yonelik Programlama","BA");
        dersler[20] = new Ders("Bilgisayar Donanimi","CC");
        dersler[21] = new Ders("Elektronik Devreler","CB");
        dersler[22] = new Ders("Sistem Analizi ve Tasarimi","AA");
        dersler[23] = new Ders("Hesaplama Kurami","CB");
        dersler[24] = new Ders("Veri Yapilari ve Algoritmalar","CC");
        dersler[25] = new Ders("Felsefeye Giris","BB");
        dersler[26] = new Ders("Mesleki Hukuk ve Etik","BA");
        dersler[27] = new Ders("Algoritma Analizi","BB");
        dersler[28] = new Ders("Mikroislemci Sistemleri","CC");
        dersler[29] = new Ders("Veritabani Yonetimi","BA");
        for(Ders ders:dersler){
            input.add(ders);
        }
        MyAdapter mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }
}
