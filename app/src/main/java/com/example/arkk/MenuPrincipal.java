package com.example.arkk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.Spinner;


public class MenuPrincipal extends AppCompatActivity {


    Button abrirBusquedaAnimal;
    Button abrirGaleria;
    Button abrirNoticias;
    Button abrirComparar;
    Button abrirMapa;
    Spinner opciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        abrirBusquedaAnimal = (Button) findViewById(R.id.BuscarAnimales);
        abrirBusquedaAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirBusquedaAnimal = new Intent(MenuPrincipal.this,BuscarAnimales.class);
                startActivity(abrirBusquedaAnimal);
            }
        });
        abrirComparar = (Button) findViewById(R.id.comparar);
        abrirComparar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirComparar = new Intent(MenuPrincipal.this,pantallaComparar.class);
                startActivity(abrirComparar);
            }
        });

        abrirGaleria = (Button) findViewById(R.id.galeria);
        abrirGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirGaleria = new Intent(MenuPrincipal.this,pantallaGaleria.class);
                startActivity(abrirGaleria);
            }
        });

        abrirNoticias = (Button) findViewById(R.id.noticias);
        abrirNoticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirNoticias = new Intent(MenuPrincipal.this,pantallaNoticias.class);
                startActivity(abrirNoticias);
            }
        });

        abrirMapa = (Button) findViewById(R.id.mapa);
        abrirMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirMapa = new Intent(MenuPrincipal.this,pantallaMapa.class);
                startActivity(abrirMapa);
            }
        });

    }
}
