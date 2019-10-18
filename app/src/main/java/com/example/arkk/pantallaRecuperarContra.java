package com.example.arkk;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


public class pantallaRecuperarContra extends AppCompatActivity {

    Button abrirInicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_recuperar_contra);


        abrirInicio = (Button) findViewById(R.id.recuperar);
        abrirInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirInicio = new Intent(pantallaRecuperarContra.this, MainActivity.class);
                startActivity(abrirInicio);
            }
        });
    }
}
