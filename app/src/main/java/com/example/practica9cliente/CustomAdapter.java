package com.example.practica9cliente;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private ArrayList<RegistroAdapter> registros;

    public CustomAdapter() {
        this.registros = new ArrayList<RegistroAdapter>();
    }

    @Override
    public int getCount() {
        return registros.size();
    }

    @Override
    public Object getItem(int i) {
        return registros.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.renglon_registro, null);
        TextView nombreRenglon = row.findViewById(R.id.nombreRenglon);
        TextView cedulaRenglon = row.findViewById(R.id.cedulaRenglon);

        nombreRenglon.setText(registros.get(i).getNombre());
        cedulaRenglon.setText(registros.get(i).getCedula());
        return row;
    }

    public void agregarRegistro(RegistroAdapter registro) {
        registros.add(registro);
        this.notifyDataSetChanged();
    }
}
