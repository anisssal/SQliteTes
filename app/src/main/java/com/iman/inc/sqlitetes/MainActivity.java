package com.iman.inc.sqlitetes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Button btnTambahData ;
ListView listView ;
listAdapter listAdapter ;
DatabaseHelper databaseHelper ;
ArrayList<ModelIdentitas> lisbalik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTambahData = findViewById(R.id.btn_tambah_data);
        listView = findViewById(R.id.list_view);
        databaseHelper = new DatabaseHelper(this);
        lisbalik =databaseHelper.getAllData();

        listAdapter = new listAdapter(lisbalik,this);
        listView.setAdapter(listAdapter);


        btnTambahData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputData.class);
                startActivity(intent);
                finish();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }
}
