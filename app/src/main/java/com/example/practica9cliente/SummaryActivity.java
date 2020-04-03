package com.example.practica9cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

public class SummaryActivity extends AppCompatActivity implements ComunicacionTCP.OnMessageListener {

    private ComunicacionTCP comunicacionTcp;
    private ListView listaRegistro;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        listaRegistro = findViewById(R.id.listaRegistro);
        comunicacionTcp = ComunicacionTCP.getInstance();
        comunicacionTcp.setObserver(this);
        comunicacionTcp.mandarMensaje("list");
        adapter = new CustomAdapter();
        listaRegistro.setAdapter(adapter);
    }

    @Override
    public void onMessage(String json) {

        Gson gson = new Gson();
        RegistroAdapter[] registros = gson.fromJson(json, RegistroAdapter[].class);

        for (int i = 0; i < registros.length; i++) {
            adapter.agregarRegistro(registros[i]);
        }

    }

}
