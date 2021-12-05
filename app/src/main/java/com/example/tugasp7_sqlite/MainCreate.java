package com.example.tugasp7_sqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Ealamat, Eemail;
    private String Snama, Salamat, Semail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_museum);
        Ealamat = (EditText) findViewById(R.id.create_alamat);
        Eemail = (EditText) findViewById(R.id.create_email);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Salamat = String.valueOf(Ealamat.getText());
                Semail = String.valueOf(Eemail.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama lengkap anda", Toast.LENGTH_SHORT).show();
                } else if (Ealamat.equals("")){
                    Ealamat.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi asal kota anda", Toast.LENGTH_SHORT).show();
                } else if (Semail.equals("")) {
                    Eemail.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi tujuan anda",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Enama.setText("");
                    Ealamat.setText("");
                    Eemail.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah", Toast.LENGTH_SHORT).show();
                    db.CreateMuseum (new Museum(null, Snama, Salamat ,Semail));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}

