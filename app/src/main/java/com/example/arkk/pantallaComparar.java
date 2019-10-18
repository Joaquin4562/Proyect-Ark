package com.example.arkk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class pantallaComparar extends AppCompatActivity {
    TextView raza,longevidad, temax, temin, pesprom, lechee, crias, periodo, calidad;
    TextView raza2,longevidad2, temax2, temin2, pesprom2, leche2, crias2, periodo2, calidad2;
    int posicion;
    private RadioButton rr1, rr2, rr3,rr4,rr5,rr6;
    String nombre1, nombre2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_comparar);
        raza=findViewById(R.id.raza);
        this.longevidad=findViewById(R.id.longevidad);
        temax=findViewById(R.id.tempmax);
        temin=findViewById(R.id.tempmin);
        pesprom=findViewById(R.id.pesoP);
        lechee= findViewById (R.id.litrosLeche);
        this.crias=findViewById(R.id.crias);
        periodo=findViewById(R.id.periodoGestacion);
        calidad=findViewById(R.id.calidadLeche);

        raza2=findViewById(R.id.raza2);
        this.longevidad2=findViewById(R.id.longevidad2);
        temax2=findViewById(R.id.tempmax2);
        temin2=findViewById(R.id.tempmin2);
        pesprom2=findViewById(R.id.pesoP2);
        leche2= findViewById (R.id.litrosLeche2);
        this.crias2=findViewById(R.id.crias2);
        periodo2=findViewById(R.id.periodoGestacion2);
        calidad2=findViewById(R.id.calidadLeche2);
        rr1=findViewById(R.id.r1);
        rr2=findViewById(R.id.r2);
        rr3=findViewById(R.id.r3);
        rr4=findViewById(R.id.radioButton4);
        rr5=findViewById(R.id.radioButton5);
        rr6=findViewById(R.id.radioButton6);






    }





    public int getPosicion() {
        return posicion;
    }
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }


   public void ObtenerVaca(View v){

            try {
                Statement st = conexionBd().createStatement();
                ResultSet rs = st.executeQuery("Select Raza,Peso_Promedio,Longevidad,Temperatura_maxima,Temperatura_minima," +
                        "Litros_de_leche_al_año, Crias_en_vida_productiva, Periodo_de_gestacion, Calidad_de_leche from Vacas where Raza='Brahman'");
                while (rs.next()) {
                    raza.setText(raza.getText().toString()+"    "+rs.getString("Raza"));
                    pesprom.setText(pesprom.getText().toString()+"    "+rs.getString("Peso_Promedio"));
                    longevidad.setText(longevidad.getText().toString()+"    "+rs.getString("Longevidad"));
                    temax.setText(temax.getText().toString()+"    "+rs.getString("Temperatura_maxima"));
                    temin.setText(temin.getText().toString()+"    "+rs.getString("Temperatura_minima"));
                    lechee.setText(lechee.getText().toString()+"    "+rs.getString("Litros_de_leche_al_año"));
                    crias.setText(crias.getText().toString()+"    "+rs.getString("Crias_en_vida_productiva"));
                    periodo.setText(periodo.getText().toString()+"    "+rs.getString("Periodo_de_gestacion"));
                    calidad.setText(calidad.getText().toString()+"    "+rs.getString("Calidad_de_leche"));

                }
            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();

            }



    }

    public void ObtenerVacaPardo(View v){

        try {
            Statement st = conexionBd().createStatement();
            ResultSet rs = st.executeQuery("Select Raza,Peso_Promedio,Longevidad,Temperatura_maxima,Temperatura_minima," +
                    "Litros_de_leche_al_año, Crias_en_vida_productiva, Periodo_de_gestacion, Calidad_de_leche from Vacas where Raza='Pardo suiza'");
            while (rs.next()) {
                raza.setText(raza.getText().toString()+"    "+rs.getString("Raza"));
                pesprom.setText(pesprom.getText().toString()+"    "+rs.getString("Peso_Promedio"));
                longevidad.setText(longevidad.getText().toString()+"    "+rs.getString("Longevidad"));
                temax.setText(temax.getText().toString()+"    "+rs.getString("Temperatura_maxima"));
                temin.setText(temin.getText().toString()+"    "+rs.getString("Temperatura_minima"));
                lechee.setText(lechee.getText().toString()+"    "+rs.getString("Litros_de_leche_al_año"));
                crias.setText(crias.getText().toString()+"    "+rs.getString("Crias_en_vida_productiva"));
                periodo.setText(periodo.getText().toString()+"    "+rs.getString("Periodo_de_gestacion"));
                calidad.setText(calidad.getText().toString()+"    "+rs.getString("Calidad_de_leche"));

            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();

        }



    }

    public void ObtenerVacaSimbrah(View v){

        try {
            Statement st = conexionBd().createStatement();
            ResultSet rs = st.executeQuery("Select Raza,Peso_Promedio,Longevidad,Temperatura_maxima,Temperatura_minima," +
                    "Litros_de_leche_al_año, Crias_en_vida_productiva, Periodo_de_gestacion, Calidad_de_leche from Vacas where Raza='Simbrah'");
            while (rs.next()) {
                raza.setText(raza.getText().toString()+"    "+rs.getString("Raza"));
                pesprom.setText(pesprom.getText().toString()+"    "+rs.getString("Peso_Promedio"));
                longevidad.setText(longevidad.getText().toString()+"    "+rs.getString("Longevidad"));
                temax.setText(temax.getText().toString()+"    "+rs.getString("Temperatura_maxima"));
                temin.setText(temin.getText().toString()+"    "+rs.getString("Temperatura_minima"));
                lechee.setText(lechee.getText().toString()+"    "+rs.getString("Litros_de_leche_al_año"));
                crias.setText(crias.getText().toString()+"    "+rs.getString("Crias_en_vida_productiva"));
                periodo.setText(periodo.getText().toString()+"    "+rs.getString("Periodo_de_gestacion"));
                calidad.setText(calidad.getText().toString()+"    "+rs.getString("Calidad_de_leche"));

            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();

        }



    }




    public void ObtenerVaca2Simbrah(View v){

            try {
                Statement st2 = conexionBd().createStatement();
                ResultSet rs2 = st2.executeQuery("Select Raza,Peso_Promedio,Longevidad,Temperatura_maxima,Temperatura_minima," +
                        "Litros_de_leche_al_año, Crias_en_vida_productiva, Periodo_de_gestacion, Calidad_de_leche from Vacas where Raza= 'Simbrah'");
                while (rs2.next()) {
                    raza2.setText(raza2.getText().toString()+"    "+rs2.getString("Raza"));
                    pesprom2.setText(pesprom2.getText().toString()+"    "+rs2.getString("Peso_Promedio"));
                    longevidad2.setText(longevidad2.getText().toString()+"    "+rs2.getString("Longevidad"));
                    temax2.setText(temax2.getText().toString()+"    "+rs2.getString("Temperatura_maxima"));
                    temin2.setText(temin2.getText().toString()+"    "+rs2.getString("Temperatura_minima"));
                    leche2.setText(leche2.getText().toString()+"    "+rs2.getString("Litros_de_leche_al_año"));
                    crias2.setText(crias2.getText().toString()+"    "+rs2.getString("Crias_en_vida_productiva"));
                    periodo2.setText(periodo2.getText().toString()+"    "+rs2.getString("Periodo_de_gestacion"));
                    calidad2.setText(calidad2.getText().toString()+"    "+rs2.getString("Calidad_de_leche"));

                }
            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();

            }
        }

    public void ObtenerVaca2Pardo(View v){

        try {
            Statement st2 = conexionBd().createStatement();
            ResultSet rs2 = st2.executeQuery("Select Raza,Peso_Promedio,Longevidad,Temperatura_maxima,Temperatura_minima," +
                    "Litros_de_leche_al_año, Crias_en_vida_productiva, Periodo_de_gestacion, Calidad_de_leche from Vacas where Raza= 'Pardo suiza'");
            while (rs2.next()) {
                raza2.setText(raza2.getText().toString()+"    "+rs2.getString("Raza"));
                pesprom2.setText(pesprom2.getText().toString()+"    "+rs2.getString("Peso_Promedio"));
                longevidad2.setText(longevidad2.getText().toString()+"    "+rs2.getString("Longevidad"));
                temax2.setText(temax2.getText().toString()+"    "+rs2.getString("Temperatura_maxima"));
                temin2.setText(temin2.getText().toString()+"    "+rs2.getString("Temperatura_minima"));
                leche2.setText(leche2.getText().toString()+"    "+rs2.getString("Litros_de_leche_al_año"));
                crias2.setText(crias2.getText().toString()+"    "+rs2.getString("Crias_en_vida_productiva"));
                periodo2.setText(periodo2.getText().toString()+"    "+rs2.getString("Periodo_de_gestacion"));
                calidad2.setText(calidad2.getText().toString()+"    "+rs2.getString("Calidad_de_leche"));

            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();

        }
    }

    public void ObtenerVaca2Brahman(View v){

        try {
            Statement st2 = conexionBd().createStatement();
            ResultSet rs2 = st2.executeQuery("Select Raza,Peso_Promedio,Longevidad,Temperatura_maxima,Temperatura_minima," +
                    "Litros_de_leche_al_año, Crias_en_vida_productiva, Periodo_de_gestacion, Calidad_de_leche from Vacas where Raza= 'Brahman'");
            while (rs2.next()) {
                raza2.setText(raza2.getText().toString()+"    "+rs2.getString("Raza"));
                pesprom2.setText(pesprom2.getText().toString()+"    "+rs2.getString("Peso_Promedio"));
                longevidad2.setText(longevidad2.getText().toString()+"    "+rs2.getString("Longevidad"));
                temax2.setText(temax2.getText().toString()+"    "+rs2.getString("Temperatura_maxima"));
                temin2.setText(temin2.getText().toString()+"    "+rs2.getString("Temperatura_minima"));
                leche2.setText(leche2.getText().toString()+"    "+rs2.getString("Litros_de_leche_al_año"));
                crias2.setText(crias2.getText().toString()+"    "+rs2.getString("Crias_en_vida_productiva"));
                periodo2.setText(periodo2.getText().toString()+"    "+rs2.getString("Periodo_de_gestacion"));
                calidad2.setText(calidad2.getText().toString()+"    "+rs2.getString("Calidad_de_leche"));

            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();

        }
    }





    public Connection conexionBd(){
        Connection conexion=null;
        try {
            StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion= DriverManager.getConnection("jdbc:jtds:sqlserver://sql5045.site4now.net:1433;databaseName=DB_A4E6C9_ProyectArk;user=DB_A4E6C9_ProyectArk_admin;" +
                    "password=Joaquin4562#;integratedSecurity=true;");
            Toast.makeText(this,"Conectado!!", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return conexion;
    }
}
