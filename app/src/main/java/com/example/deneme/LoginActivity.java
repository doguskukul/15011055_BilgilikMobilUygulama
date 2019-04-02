package com.example.deneme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import java.lang.String;
public class LoginActivity extends AppCompatActivity {
    EditText txtLoginID,txtLoginPW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final String ID = "admin";
        final String PW = "password";
        txtLoginID = (EditText) this.findViewById(R.id.txtLoginID);
        txtLoginPW = (EditText) this.findViewById(R.id.txtLoginPW);
        ImageButton buttonContinue = (ImageButton) this.findViewById(R.id.imageButtonDevam);
        ImageButton buttonClear = (ImageButton) this.findViewById(R.id.imageButtonTemizle);

        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtLoginID.getText().toString().compareTo(ID)==0 && txtLoginPW.getText().toString().compareTo(PW)==0){
                    Intent i = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Hatalı Giriş Yaptınız!", Toast.LENGTH_LONG).show();
                }
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtLoginID.getText().clear();
                txtLoginPW.getText().clear();
            }
        });
    }
}
