package com.iman.inc.sqlitetes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputData extends AppCompatActivity {
    EditText edtUmur ;
    EditText edtGolonganDarah;
    EditText edtNama;
    DatabaseHelper databaseHelper ;
    ModelIdentitas modelIdentitas ;
    Button btnSimpanData ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        edtUmur = findViewById(R.id.input_edt_umur);
        edtNama = findViewById(R.id.input_edt_Nama);
        edtGolonganDarah = findViewById(R.id.input_golongan_darah);
        btnSimpanData = findViewById(R.id.btn_simpan_data);

        databaseHelper = new DatabaseHelper(this);



        btnSimpanData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modelIdentitas = new ModelIdentitas(edtNama.getText().toString(),Integer.parseInt(edtUmur.getText().toString()), edtGolonganDarah.getText().toString());
                boolean insert = databaseHelper.addData(modelIdentitas);
                if(insert){
                    Toast.makeText(InputData.this, "BERHASIL INPUT DATA", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(InputData.this, MainActivity.class));
                }else{

                }
            }
        });


    }
}
