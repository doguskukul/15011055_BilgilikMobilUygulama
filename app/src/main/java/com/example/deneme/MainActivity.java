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
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText txtInputName,txtInputSurname,txtInputID,txtInputDate,txtInputPlace,txtInputPhone,txtInputYear;
    int counter;
    String year2;
    @Override
    // Gorsel güzelleştirme yapılacak
    // Creation of the text fields and buttons.
    // Called on App Start
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtInputName = (EditText) this.findViewById(R.id.editName);
        txtInputSurname = (EditText) this.findViewById(R.id.editSurname);
        txtInputID = (EditText) this.findViewById(R.id.editID);
        txtInputDate = (EditText) this.findViewById(R.id.editDate);
        txtInputPlace = (EditText) this.findViewById(R.id.editPlace);
        txtInputPhone = (EditText) this.findViewById(R.id.editPhone);

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
                                // year, month ve dayOfMonth değerleri seçilen tarihin değerleridir.
                                // Edittextte bu değerleri gösteriyoruz.
                                txtInputDate.setText(dayOfMonth + "/" + month + "/" + year);
                                year2 = String.valueOf(year);
                            }
                        }, yil, ay, gun);
                // datepicker açıldığında set edilecek değerleri buraya yazıyoruz.
                // şimdiki zamanı göstermesi için yukarda tanmladığımz değşkenleri kullanyoruz.

                // dialog penceresinin button bilgilerini ayarlıyoruz ve ekranda gösteriyoruz.
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
                Intent i = new Intent(MainActivity.this,sayfa2.class);
                i.putExtra("mName",txtInputName.getText().toString());
                i.putExtra("mSurname",txtInputSurname.getText().toString());
                i.putExtra("mID",txtInputID.getText().toString());
                i.putExtra("mDate",txtInputDate.getText().toString());
                i.putExtra("mPlace",txtInputPlace.getText().toString());
                i.putExtra("mPhone",txtInputPhone.getText().toString());
                i.putExtra("mYear",year2);
                startActivity(i);
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
                    Bitmap bitmap= BitmapFactory.decodeStream(stream);
                    ImageView iv=findViewById(R.id.imagePhoto);
                    iv.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}