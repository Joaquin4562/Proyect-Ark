package com.example.arkk;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button abrirPrincipal, abrirRegistro, abrirRecuperarContra;
    private List<Usuarios> Usuarios = new ArrayList<>();
    private EditText Usuario, Contra;
    private boolean bol = false;
    private Connection conexion = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        abrirPrincipal = (Button) findViewById(R.id.BotonIniciar);
        abrirRegistro = (Button) findViewById(R.id.BotonRegistrar);
        abrirRecuperarContra = (Button) findViewById(R.id.BotonRecuperar);

        Usuario = (EditText) findViewById(R.id.Usuario);
        Contra = (EditText) findViewById(R.id.Contraseña);
        Usuarios objE = new Usuarios ("Admin", "12345");
        Usuarios.add(objE);
    }

    public void Iniciar (View v) {
        new Conexcion().conexionBd();
        ejecutarConsulta(conexion);
        bol = false;
            for(int i = 0; i < Usuarios.size(); i++) {
                if(Usuario.getText().toString().equals(Usuarios.get(i).getUsuario()) &&
                        Contra.getText().toString().equals(Usuarios.get(i).getContraseña()) && bol == false) {
                    Acceder_P(v);
                    bol = true;
                    //Toast.makeText(this,"Estas dentro!!!",Toast.LENGTH_LONG).show();
                }
            }
            if(bol == false){
                Toast.makeText(this,"Usuario o Contraseña incorrectos",Toast.LENGTH_LONG).show();
            }
    }


    public void ejecutarConsulta(Connection con) {
        try {
            String arreglo[];
            String linea;
            String SQL = "SELECT Nombre, Contraseña FROM Usuarios";

            ResultSet rs = new Conexcion().ConsultaBD(SQL);
            while (rs.next()) {
                linea = rs.getString("Nombre") + "," + rs.getString("Contraseña");
                arreglo = linea.split(",");
                Usuarios.add(new Usuarios(arreglo[0], arreglo[1]));
            }
            rs.close();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void Acceder_P(View v) {
        Intent abrirPrincipal = new Intent(MainActivity.this,MenuPrincipal.class);
        startActivity(abrirPrincipal);
    }

    public void Acceder_R(View v) {
        Intent abrirRegistro = new Intent(MainActivity.this,pantallaRegistro.class);
        startActivity(abrirRegistro);
    }

    public void Acceder_C(View v) {
        Intent abrirRecuperarContra = new Intent(MainActivity.this,pantallaRecuperarContra.class);
        startActivity(abrirRecuperarContra);
    }
}
