package com.iman.inc.sqlitetes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by z on 23/03/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME= "identitas.db" ;
    public static final String TABLE_NAME= "pribadi" ;
    public static final String COL_ID = "id" ;
    public static final String COL_NAMA = "nama" ;
    public static final String COL_UMUR = "umur" ;
    public static final String COL_GOLONGAN_DARAH = "golongandarah" ;



SQLiteDatabase sqLiteDatabase ;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABLE_NAME+"("
                +COL_ID+" INTEGER AUTO INCREMENT,"
                +COL_NAMA+" TEXT,"
                +COL_UMUR+" INTEGER,"
                +COL_GOLONGAN_DARAH+" TEXT)";


        db.execSQL(sql);
        Log.d("TABLE DIBUAT", "onCreate: "+sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }


    boolean addData(ModelIdentitas modelIdentitas){
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAMA,modelIdentitas.getNama());
        contentValues.put(COL_UMUR,modelIdentitas.getUmur());
        contentValues.put(COL_GOLONGAN_DARAH,modelIdentitas.getGolonganDarah());
        long hasilInsert = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        if(hasilInsert < 0 ){
            return false ;
        }
        sqLiteDatabase.close();
        return true ;
    }


    ArrayList<ModelIdentitas> getAllData( ){
        sqLiteDatabase = this.getReadableDatabase();
        ArrayList<ModelIdentitas> temporary = new ArrayList<>();


        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                int id = cursor.getInt(cursor.getColumnIndex(COL_ID));
                String nama = cursor.getString(cursor.getColumnIndex(COL_NAMA));
                int umur = cursor.getColumnIndex(COL_UMUR);
                String golonganDarah = cursor.getString(cursor.getColumnIndex(COL_GOLONGAN_DARAH));
                ModelIdentitas temp = new ModelIdentitas(nama,umur,golonganDarah);
                temp.setId(id);

                temporary.add(temp);
                cursor.moveToNext();


            }
        }
        cursor.close();
        sqLiteDatabase.close();

        return temporary ;

    }
}
