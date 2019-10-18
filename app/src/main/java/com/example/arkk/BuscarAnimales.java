package com.example.arkk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuscarAnimales extends AppCompatActivity {

    Button abrirRazaVacas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_animales);

        abrirRazaVacas = (Button) findViewById(R.id.animalVaca);
        abrirRazaVacas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirRazaVacas = new Intent(BuscarAnimales.this,pantallaVaca.class);
                startActivity(abrirRazaVacas);
            }
        });
    }



}
