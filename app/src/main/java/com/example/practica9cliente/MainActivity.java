package com.example.practica9cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nombreText;
    private EditText cedulaText;
    private Button registrarBtn;

    private ComunicacionTCP comunicacionTcp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comunicacionTcp = ComunicacionTCP.getInstance();
        comunicacionTcp.solicitarConexion("10.0.2.2");

        nombreText = findViewById(R.id.nombreText);
        cedulaText = findViewById(R.id.cedulaText);
        registrarBtn = findViewById(R.id.registrarBtn);

        registrarBtn.setOnClickListener(
                (v)-> {
                    comunicacionTcp.mandarMensaje("reg," + nombreText.getText().toString() + "," + cedulaText.getText().toString());
                    Intent i = new Intent(MainActivity.this, SummaryActivity.class);
                    startActivity(i);
                }
        );
    }
}
