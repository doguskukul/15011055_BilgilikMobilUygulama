package com.example.deneme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class NoteActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes);
        Intent i3 = getIntent();
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<Ders> input = new ArrayList<>();
        Ders[] dersler = new Ders[30];
        dersler[0] = new Ders("Yariiletken Fizigi","BB","Erdal Bakkal","4");
        dersler[1] = new Ders("Algoritma Analizi","CB","Yavuz Hırsız","3");
        dersler[2] = new Ders("Fizik 1","CB","İskender Çınar","4");
        dersler[3] = new Ders("Bilgisayar Bilimlerine Giris","CB","Mecnun Çınar","3");
        dersler[4] = new Ders("Ileri Ingilizce 1","BA","Erdal Bakkal","3");
        dersler[5] = new Ders("Yapisal Programlamaya Giris","AA","Mecnun Çınar","4");
        dersler[6] = new Ders("Toplumsal Yapilar","BA","İskender Çınar","3");
        dersler[7] = new Ders("Sayisal Analiz","CB","Erdal Bakkal","2");
        dersler[8] = new Ders("Devre Teorisi","BB","İsmail Abi","3");
        dersler[9] = new Ders("Ayrik Matematik","AA","İskender Çınar","3");
        dersler[10] = new Ders("Matematik 2","CB","İskender Çınar","4");
        dersler[11] = new Ders("Ileri Ingilizce 2","AA","İskender Çınar","2");
        dersler[12] = new Ders("Istatistik ve Olasılık","BB","Yavuz Hırsız","3");
        dersler[13] = new Ders("Alt Seviye Programlama","CC","İsmail Abi","3");
        dersler[14] = new Ders("Yapisal Programlama","BB","Yavuz Hırsız","3");
        dersler[15] = new Ders("Bilgisayar Donanimi","CC","İskender Çınar","3");
        dersler[16] = new Ders("Sinyaller ve Sistemler","BB","Yavuz Hırsız","4");
        dersler[17] = new Ders("Ingilizce Okuma ve Konusma","BA","Mecnun Çınar","2");
        dersler[18] = new Ders("Lojik Devreler","CC","İsmail Abi","4");
        dersler[19] = new Ders("Nesneye Yonelik Programlama","AA","Erdal Bakkal","3");
        dersler[20] = new Ders("Matematik 1 ","CC","İsmail Abi","3");
        dersler[21] = new Ders("Elektronik Devreler","CB","İskender Çınar","4");
        dersler[22] = new Ders("Sistem Analizi ve Tasarimi","AA","Mecnun Çınar","4");
        dersler[23] = new Ders("Hesaplama Kurami","CB","Yavuz Hırsız","3");
        dersler[24] = new Ders("Veri Yapilari ve Algoritmalar","CC","Erdal Bakkal","4");
        dersler[25] = new Ders("Felsefeye Giris","BB","Yavuz Hırsız","3");
        dersler[26] = new Ders("Mesleki Hukuk ve Etik","BA","Yavuz Hırsız","4");
        dersler[27] = new Ders("Veritabani Yonetimi","BA","İskender Çınar","3");
        dersler[28] = new Ders("Mikroislemci Sistemleri","CC","Mecnun Çınar","4");
        dersler[29] = new Ders("Lineer Cebir","BB","İsmail Abi","3");

        for(Ders ders:dersler){
            input.add(ders);
        }
        MyAdapter mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }
}
