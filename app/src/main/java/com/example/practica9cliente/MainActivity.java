package com.example.practica9cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

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
                (v) -> {
                    if (!nombreText.getText().toString().equals("") && !cedulaText.getText().toString().equals("")) {

                        String nombre = nombreText.getText().toString();
                        String cedula = cedulaText.getText().toString();
                        RegistroAdapter registro = new RegistroAdapter(nombre, cedula);

                        Gson gson = new Gson();
                        String json = gson.toJson(registro);

                        comunicacionTcp.mandarMensaje(json);

                        Intent i = new Intent(MainActivity.this, SummaryActivity.class);
                        startActivity(i);

                    } else {
                        runOnUiThread(
                                () -> {
                                    Toast.makeText(this, "Completa los campos", Toast.LENGTH_SHORT).show();
                                }
                        );
                    }
                }
        );
    }
}
