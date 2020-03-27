package com.example.practica9cliente;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SummaryActivity extends AppCompatActivity implements ComunicacionTCP.OnMessageListener {

    private ComunicacionTCP comunicacionTcp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        comunicacionTcp = ComunicacionTCP.getInstance();
        comunicacionTcp.setObserver(this);
        comunicacionTcp.mandarMensaje("list");
    }

    @Override
    public void onMessage(String mensaje) {

    }
}
