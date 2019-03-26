package com.example.deneme;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.content.Context;
import android.widget.Toast;
public class sayfa2 extends AppCompatActivity {
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayfa2);
        TextView textViewAd = (TextView) this.findViewById(R.id.ad2);
        TextView textView2 = (TextView) this.findViewById(R.id.soyad2);
        TextView textView3 = (TextView) this.findViewById(R.id.kimlikno2);
        TextView textView4 = (TextView) this.findViewById(R.id.tarih2);
        TextView textView5 = (TextView) this.findViewById(R.id.yer2);
        final TextView textView6 = (TextView) this.findViewById(R.id.telefonno2);
        Intent i = getIntent();
        String s = i.getStringExtra("mesaj");
        String s2 = i.getStringExtra("mesaj2");
        String s3 = i.getStringExtra("mesaj3");
        String s4 = i.getStringExtra("mesaj4");
        String s5 = i.getStringExtra("mesaj5");
        String s6 = i.getStringExtra("mesaj7"); // TODO - 6 ya geri cevir
        textViewAd.setText(s);
        textView2.setText(s2);
        textView3.setText(s3);
        textView4.setText(s4);
        textView5.setText(s5);
        textView6.setText(s6);
        Button button2 = (Button) this.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i2 = new Intent(Intent.ACTION_CALL);
                i2.setData(Uri.parse("tel:" + textView6.getText().toString()));
                if(ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getApplicationContext(), "Ayarlar/Uygulamalar/Kimlik/İzinler/Telefon : izni aç", Toast.LENGTH_LONG).show();
                    return;
                }
                startActivity(i2);
            }
        });
    }
}