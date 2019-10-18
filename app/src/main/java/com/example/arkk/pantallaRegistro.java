package com.example.arkk;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class pantallaRegistro extends AppCompatActivity {

    private Button regis;
    private EditText Usuario, Ciudad, Estado, Correo, Telefono, Contra, ConfContra;
    private String usuario, ciudad, estado, correo, telefono, contra, confcontra;
    private Connection conexion = null;
    private boolean bol = false;
    private List Usuarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_registro);

        regis = (Button) findViewById(R.id.botonRegistro);

        Usuario = (EditText) findViewById(R.id.campoNombre);
        Ciudad = (EditText) findViewById(R.id.campoCiudad);
        Estado = (EditText) findViewById(R.id.campoEstado);
        Correo = (EditText) findViewById(R.id.campoCorreo);
        Telefono = (EditText) findViewById(R.id.campoTelefono);
        Contra = (EditText) findViewById(R.id.campoContraseña);
        ConfContra = (EditText) findViewById(R.id.campoConfContraseña);
        Conexcion o= new Conexcion();
        conexion= o.conexionBd();
    }

    public void Reg (View v){
        ejecutarConsulta(conexion);
        bol = false;
        vars();
        for(int i = 0; i < Usuarios.size(); i++) {
            if(usuario.equals(Usuarios.get(i).toString())) {
                bol = true;
                Toast.makeText(this,"Nombre de usuario ocupado",Toast.LENGTH_LONG).show();
                break;
            }
            else if(!contra.equals(confcontra)){ 
                bol = true;
                Toast.makeText(this,"La contraseña no fue confirmada correctamente",Toast.LENGTH_LONG).show();
                break;
            }
        }
        if (bol == false){
            try {
                String SQL = "INSERT INTO Usuarios VALUES ('" + usuario + "', '" + ciudad + "', '" + estado + "', '" 
			+ correo + "', '" + telefono + "', '" + contra + "')";
                Statement stmt = conexion.createStatement();
                int count = stmt.executeUpdate(SQL);
                stmt.close();
                Toast.makeText(this,"Registro creado exitosamente!",Toast.LENGTH_LONG).show();
            }catch(Exception Ex){
                Toast.makeText(this, Ex.getMessage(), Toast.LENGTH_LONG).show();
            }
            CamPant(v);
        }else{
            //Toast.makeText(this,"Algo salio mal, intentalo denuevo",Toast.LENGTH_LONG).show();
        }
    }
    public void vars(){
        usuario = Usuario.getText().toString();
        ciudad = Ciudad.getText().toString();
        estado = Estado.getText().toString();
        correo = Correo.getText().toString();
        telefono = Telefono.getText().toString();
        contra = Contra.getText().toString();
        confcontra = ConfContra.getText().toString();
    }

    public void ejecutarConsulta(Connection con) {
        try {
            String linea="";
            String SQL = "SELECT Nombre FROM Usuarios";
            Conexcion ob=new Conexcion();
            ResultSet rs= ob.ConsultaBD(SQL);
            while (rs.next()) {
                linea = rs.getString("Nombre");
                Usuarios.add(linea);
            }
            //Toast.makeText(this,"Consulta ejecutada, "+linea+"",Toast.LENGTH_LONG).show();
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void CamPant(View v) {
        Intent regis = new Intent(pantallaRegistro.this,MainActivity.class);
        startActivity(regis);
    }

}
