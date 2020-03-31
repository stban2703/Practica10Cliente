package com.example.practica9cliente;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

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
    public void onMessage(String mensaje) {
        /*runOnUiThread(
                () -> {
                    Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                }
        );*/
        String[] registrosServidor = mensaje.split(",");
        String nombre = registrosServidor[0];
        String cedula = registrosServidor[1];

        RegistroAdapter registro = new RegistroAdapter(nombre, cedula);
        adapter.agregarRegistro(registro);
    }
}
