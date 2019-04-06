package com.example.deneme;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.ImageView;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.BitmapDrawable;

public class FormActivity extends AppCompatActivity {
    EditText txtInputName,txtInputSurname,txtInputID,txtInputDate,txtInputPlace,txtInputPhone,txtInputEmail;
    ImageView imagePhoto;
    int counter;
    String year2;
    Bitmap bitmap;
    ByteArrayOutputStream stream;
    int isChange=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        txtInputName = (EditText) this.findViewById(R.id.editName);
        txtInputSurname = (EditText) this.findViewById(R.id.editSurname);
        txtInputID = (EditText) this.findViewById(R.id.editID);
        txtInputDate = (EditText) this.findViewById(R.id.editDate);
        txtInputPlace = (EditText) this.findViewById(R.id.editPlace);
        txtInputPhone = (EditText) this.findViewById(R.id.editPhone);
        txtInputEmail = (EditText) this.findViewById(R.id.editEmail);
        imagePhoto = (ImageView) this.findViewById(R.id.imagePhoto);
        txtInputDate.setKeyListener(null);
        stream = new ByteArrayOutputStream();


        if(savedInstanceState != null){
            String message = savedInstanceState.getString("msj");
            Toast.makeText(this,message,Toast.LENGTH_LONG).show();
            counter=savedInstanceState.getInt("counter",0);
        }
        final Context context = this;
        ImageButton buttonCalendar = (ImageButton) findViewById(R.id.buttonCalendar);
        buttonCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar takvim = Calendar.getInstance();
                int yil = takvim.get(Calendar.YEAR);
                int ay = takvim.get(Calendar.MONTH);
                int gun = takvim.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpd = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                // ay değeri 0 dan başladığı için (Ocak=0, Şubat=1,..,Aralık=11)
                                // değeri 1 artırarak gösteriyoruz.
                                month += 1;
                                txtInputDate.setText(dayOfMonth + "/" + month + "/" + year);
                                year2 = String.valueOf(year);
                            }
                        }, yil, ay, gun);
                dpd.setButton(DatePickerDialog.BUTTON_POSITIVE, "Seç", dpd);
                dpd.setButton(DatePickerDialog.BUTTON_NEGATIVE, "İptal", dpd);
                dpd.show();
            }
        });

        Button buttonSave = (Button) this.findViewById(R.id.buttonSave);
        Button buttonClear = (Button) this.findViewById(R.id.buttonClear);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isChange==1){
                bitmap.compress(Bitmap.CompressFormat.JPEG,20,stream);}
                Intent i = new Intent(FormActivity.this, InformationActivity.class);
                i.putExtra("mName",txtInputName.getText().toString());
                i.putExtra("mSurname",txtInputSurname.getText().toString());
                i.putExtra("mID",txtInputID.getText().toString());
                i.putExtra("mDate",txtInputDate.getText().toString());
                i.putExtra("mPlace",txtInputPlace.getText().toString());
                i.putExtra("mPhone",txtInputPhone.getText().toString());
                i.putExtra("mEmail",txtInputEmail.getText().toString());
                i.putExtra("mYear",year2);
                i.putExtra("byteArray",stream.toByteArray());
                if(isChange==0){
                    Toast.makeText(getApplicationContext(), "Eksik Bilgi, Lütfen Fotoğraf Seçiniz", Toast.LENGTH_LONG).show();
                }
                else if(isChange==1 && txtInputName.getText().toString().length()>0 && txtInputSurname.getText().toString().length()>0
                        && txtInputID.getText().toString().length()>0 && txtInputDate.getText().toString().length()>0
                        && txtInputPlace.getText().toString().length()>0 && txtInputPhone.getText().toString().length()>0
                        && txtInputEmail.getText().toString().length()>0){
                startActivity(i);}
                else{
                    Toast.makeText(getApplicationContext(), "Eksik Bilgi, Lütfen Kontrol Ediniz", Toast.LENGTH_LONG).show();
                }
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v2) {
                txtInputName.getText().clear();
                txtInputSurname.getText().clear();
                txtInputID.getText().clear();
                txtInputDate.getText().clear();
                txtInputPlace.getText().clear();
                txtInputPhone.getText().clear();
                txtInputEmail.getText().clear();
                imagePhoto.setImageResource(R.drawable.man);
                isChange = 0;

            }
        });
    }
    public void onResume(){
        super.onResume();
        counter++;
    }
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("message","This is a saved message");
        savedInstanceState.putInt("counter",counter);
    }
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(),"onRestoreInstanceState",Toast.LENGTH_SHORT).show();
        counter= savedInstanceState.getInt("counter",0);
    }
    public  void chooseImage(View v){

        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK){
            if (requestCode==1){

                Uri uri=data.getData();
                try {
                    InputStream stream=getContentResolver().openInputStream(uri);
                    bitmap= BitmapFactory.decodeStream(stream);
                    imagePhoto.setImageBitmap(bitmap);
                    isChange=1;
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}