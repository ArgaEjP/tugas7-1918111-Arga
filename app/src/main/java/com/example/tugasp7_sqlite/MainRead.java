package com.example.tugasp7_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Museum> ListMuseum = new ArrayList<Museum>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListMuseum );
        mListView = (ListView) findViewById(R.id.list_museum);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListMuseum.clear();
        List<Museum> contacts = db.ReadMuseum();
        for (Museum cn : contacts) {
            Museum judulModel = new Museum();
            judulModel.set_id(cn.get_id());
            judulModel.set_namamuseum(cn.get_namamuseum());
            judulModel.set_alamat(cn.get_alamat());
            judulModel.set_email(cn.get_email());
            ListMuseum.add(judulModel);
            if ((ListMuseum.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Museum obj_itemDetails = (Museum) o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_namamuseum();
        String Salamat = obj_itemDetails.get_alamat();
        String Semail = obj_itemDetails.get_email();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Iasal", Salamat);
        goUpdel.putExtra("Itujuan", Semail);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListMuseum.clear();
        mListView.setAdapter(adapter_off);
        List<Museum> contacts = db.ReadMuseum();
        for (Museum cn : contacts) {
            Museum judulModel = new Museum();
            judulModel.set_id(cn.get_id());
            judulModel.set_namamuseum(cn.get_namamuseum());
            judulModel.set_alamat(cn.get_alamat());
            judulModel.set_email(cn.get_email());
            ListMuseum.add(judulModel);
            if ((ListMuseum.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}


