package com.example.deneme;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText txtInput1,txtInput2,txtInput3,txtInput4,txtInput5,txtInput6;
    int counter;
    @Override
    // Creation of the text fields and buttons.
    // Called on App Start
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtInput1 = (EditText) this.findViewById(R.id.ad);
        txtInput2 = (EditText) this.findViewById(R.id.soyad);
        txtInput3 = (EditText) this.findViewById(R.id.kimlikno);
        txtInput4 = (EditText) this.findViewById(R.id.dogumtarihi);
        txtInput5 = (EditText) this.findViewById(R.id.dogumyeri);
        txtInput6 = (EditText) this.findViewById(R.id.telefonno);
        if(savedInstanceState != null){
            String message = savedInstanceState.getString("msj");
            Toast.makeText(this,message,Toast.LENGTH_LONG).show();
            counter=savedInstanceState.getInt("counter",0);
        }
        Button button1 = (Button) this.findViewById(R.id.button);
        Button button3 = (Button) this.findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,sayfa2.class);
                i.putExtra("mesaj",txtInput1.getText().toString());
                i.putExtra("mesaj2",txtInput2.getText().toString());
                i.putExtra("mesaj3",txtInput3.getText().toString());
                i.putExtra("mesaj4",txtInput4.getText().toString());
                i.putExtra("mesaj5",txtInput5.getText().toString());
                i.putExtra("mesaj6",txtInput6.getText().toString());
                startActivity(i);
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v2) {
                txtInput1.getText().clear();
                txtInput2.getText().clear();
                txtInput3.getText().clear();
                txtInput4.getText().clear();
                txtInput5.getText().clear();
                txtInput6.getText().clear();
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
}