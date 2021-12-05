package com.example.tugasp7_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Salamat, Semail;
    private EditText Enama, Ealamat, Eemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Salamat = i.getStringExtra("Ialamat");
        Semail = i.getStringExtra("Iemail");
        Enama = (EditText) findViewById(R.id.updel_museum);
        Ealamat = (EditText) findViewById(R.id.updel_alamat);
        Eemail = (EditText) findViewById(R.id.updel_email);
        Enama.setText(Snama);
        Ealamat.setText(Salamat);
        Eemail.setText(Semail);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Salamat = String.valueOf(Ealamat.getText());
                Semail = String.valueOf(Eemail.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama", Toast.LENGTH_SHORT).show();
                } else if (Salamat.equals("")){
                    Ealamat.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi warna", Toast.LENGTH_SHORT).show();
                } else if (Semail.equals("")){
                    Eemail.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi warna",
                            Toast.LENGTH_SHORT).show();
                } else {db.UpdateMuseum(new Museum(Sid, Snama, Salamat, Semail));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteMuseum (new Museum(Sid, Snama, Salamat, Semail));
                Toast.makeText(MainUpdel.this, "Data telah dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

