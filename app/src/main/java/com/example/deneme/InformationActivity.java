package com.example.deneme;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.content.Context;
import android.widget.Toast;


import java.util.Calendar;
public class InformationActivity extends AppCompatActivity {
    Context context=this;
    ImageView imagePhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        TextView textViewName = (TextView) this.findViewById(R.id.textName_p2);
        TextView textViewSurname = (TextView) this.findViewById(R.id.textSurname_p2);
        TextView textViewID = (TextView) this.findViewById(R.id.textID_p2);
        TextView textViewDate = (TextView) this.findViewById(R.id.textDate_p2);
        TextView textViewPlace = (TextView) this.findViewById(R.id.textPlace_p2);
        TextView textViewYear = (TextView) this.findViewById(R.id.textYear_p2);
        imagePhoto = (ImageView) this.findViewById(R.id.imagePhoto_p2);
        final TextView textViewEmail = (TextView) this.findViewById(R.id.textEmail_p2);
        final TextView textViewPhone = (TextView) this.findViewById(R.id.textPhone_p2);
        Intent i = getIntent();
        if(getIntent().hasExtra("byteArray")){
            Bitmap bitmap = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("byteArray"),
                    0,getIntent().getByteArrayExtra("byteArray").length);
            imagePhoto.setImageBitmap(bitmap);
        }
        String sName = i.getStringExtra("mName");
        String sSurname = i.getStringExtra("mSurname");
        String sID = i.getStringExtra("mID");
        String sDate = i.getStringExtra("mDate");
        String sPlace = i.getStringExtra("mPlace");
        String sPhone = i.getStringExtra("mPhone");
        String sYear = i.getStringExtra("mYear");
        String sEmail = i.getStringExtra("mEmail");
        textViewName.setText(sName);
        textViewSurname.setText(sSurname);
        textViewID.setText(sID);
        textViewDate.setText(sDate);
        textViewPlace.setText(sPlace);
        textViewPhone.setText(sPhone);
        textViewEmail.setText(sEmail);
        int curYear = Calendar.getInstance().get(Calendar.YEAR);
        int bYear = Integer.parseInt(sYear);
        int age=curYear-bYear;
        String age2 = String.valueOf(age);
        textViewYear.setText(age2);
        ImageButton buttonCall = (ImageButton) this.findViewById(R.id.buttonCall_p2);
        ImageButton buttonSend = (ImageButton) this.findViewById(R.id.buttonSend_p2);
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
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recipientList = textViewEmail.getText().toString();
                String[] recipients = recipientList.split(",");
                Intent iSend = new Intent(Intent.ACTION_SEND);
                iSend.putExtra(Intent.EXTRA_EMAIL, recipients);
                iSend.setType("message/rfc822");
                startActivity(Intent.createChooser(iSend, "Email uygulaması seciniz"));
            }
        });
        Button buttonToCourses = (Button) this.findViewById(R.id.buttonCourses);
        buttonToCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(InformationActivity.this, NoteActivity.class);
                startActivity(i3);
            }
        });
    }
}