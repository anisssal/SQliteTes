package com.iman.inc.sqlitetes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by z on 23/03/18.
 */

public class listAdapter extends BaseAdapter{
ArrayList<ModelIdentitas> modelIdentitas ;
Context context ;

    public listAdapter(ArrayList<ModelIdentitas> modelIdentitas, Context context) {
        this.modelIdentitas = modelIdentitas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return modelIdentitas.size() ;
    }

    @Override
    public Object getItem(int position) {
        return modelIdentitas.get(position) ;
    }

    @Override
    public long getItemId(int position) {
        return modelIdentitas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.tampilan_list,parent,false);
        convertView = view ;
        TextView txtNama = view.findViewById(R.id.txt_nama);
        TextView txtUmur = view.findViewById(R.id.txt_umur);
        TextView txtGolonganDarah = view.findViewById(R.id.txt_golongan_dara);

        txtNama.setText(modelIdentitas.get(position).getNama());
        txtUmur.setText(modelIdentitas.get(position).getUmur()+"");
        txtGolonganDarah.setText(modelIdentitas.get(position).getGolonganDarah());


        return convertView;
    }
}
