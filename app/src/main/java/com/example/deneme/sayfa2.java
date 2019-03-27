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
import java.util.Calendar;
public class sayfa2 extends AppCompatActivity {
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayfa2);
        TextView textViewName = (TextView) this.findViewById(R.id.textName_p2);
        TextView textViewSurname = (TextView) this.findViewById(R.id.textSurname_p2);
        TextView textViewID = (TextView) this.findViewById(R.id.textID_p2);
        TextView textViewDate = (TextView) this.findViewById(R.id.textDate_p2);
        TextView textViewPlace = (TextView) this.findViewById(R.id.textPlace_p2);
        TextView textViewYear = (TextView) this.findViewById(R.id.textYear_p2);
        final TextView textViewPhone = (TextView) this.findViewById(R.id.textPhone_p2);
        Intent i = getIntent();
        String sName = i.getStringExtra("mName");
        String sSurname = i.getStringExtra("mSurname");
        String sID = i.getStringExtra("mID");
        String sDate = i.getStringExtra("mDate");
        String sPlace = i.getStringExtra("mPlace");
        String sPhone = i.getStringExtra("mPhone");
        String sYear = i.getStringExtra("mYear");
        textViewName.setText(sName);
        textViewSurname.setText(sSurname);
        textViewID.setText(sID);
        textViewDate.setText(sDate);
        textViewPlace.setText(sPlace);
        textViewPhone.setText(sPhone);
        int curYear = Calendar.getInstance().get(Calendar.YEAR);
        int bYear = Integer.parseInt(sYear);
        int age=curYear-bYear;
        String age2 = String.valueOf(age);
        textViewYear.setText(age2);
        Button buttonCall = (Button) this.findViewById(R.id.buttonCall_p2);
        buttonCall.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i2 = new Intent(Intent.ACTION_CALL);
                i2.setData(Uri.parse("tel:" + textViewPhone.getText().toString()));
                if(ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getApplicationContext(), "Ayarlar/Uygulamalar/Kimlik/İzinler/Telefon : izni aç", Toast.LENGTH_LONG).show();
                    return;
                }
                startActivity(i2);
            }
        });
    }
}