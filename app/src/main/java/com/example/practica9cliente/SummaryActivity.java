package com.example.practica9cliente;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class SummaryActivity extends AppCompatActivity implements ComunicacionTCP.OnMessageListener {

    private ComunicacionTCP comunicacionTcp;
    private ListView listaRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        listaRegistro = findViewById(R.id.listaRegistro);
        comunicacionTcp = ComunicacionTCP.getInstance();
        comunicacionTcp.setObserver(this);
        comunicacionTcp.mandarMensaje("list");
    }

    @Override
    public void onMessage(String mensaje) {
        runOnUiThread(
                () -> {
                    Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                }
        );
    }
}
