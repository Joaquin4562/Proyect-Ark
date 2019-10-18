package com.example.arkk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class pantallaInformacionVaca extends AppCompatActivity {
    TextView Raza,TempMax,TempMin,Longevidad,PesoPromedio,LitrosLeche,Crias,Enfermedades,Especialidad,Gestacion,CalidadLeche
    ,PropiedadesLeche,Temperamento,TipodeCuero;
    int posicion;
    String raza;
    ImageView imagenvaca;
    private Button comparar;

    public int getPosicion() {
        return posicion;
    }
    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pantalla_informacion_vaca);
        Raza=findViewById(R.id.raza);
        comparar=findViewById(R.id.comparar);
        TempMax=findViewById(R.id.tempmax);
        TempMin=findViewById(R.id.tempmin);
        Longevidad=findViewById(R.id.longevidad);
        PesoPromedio=findViewById(R.id.pesoP);
        LitrosLeche=findViewById(R.id.litrosLeche);
        Crias=findViewById(R.id.crias);
        Enfermedades=findViewById(R.id.enfermedades);
        Especialidad=findViewById(R.id.especialidad);
        Gestacion=findViewById(R.id.periodoGestacion);
        CalidadLeche=findViewById(R.id.calidadLeche);
        PropiedadesLeche=findViewById(R.id.propiedadesLeche);
        Temperamento=findViewById(R.id.temperamento);
        TipodeCuero=findViewById(R.id.tipoCuerpo);
        imagenvaca=findViewById(R.id.imagenVaca);
      ObtenerVaca(this.getRaza());
        comparar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(pantallaInformacionVaca.this,pantallaComparar.class);
                startActivity(intent);

            }
        });

    }
public void ObtenerVaca(String raza){
            try {
                Conexcion ob=new Conexcion();
                ResultSet rs=null;
                if(getPosicion()==0){
                   rs = ob.ConsultaBD("Select Raza,Peso_Promedio,Longevidad,Temperatura_minima,Temperatura_maxima," +
                            "Litros_de_leche_al_año,Crias_en_vida_productiva,Enfermedades_propensas,Especialidad,Periodo_de_gestacion," +
                            "Calidad_de_leche,Propiedades_de_la_leche,Temperamento,Tipo_de_cuero from Vacas where Raza='Pardo suiza'");
                   imagenvaca.setImageResource(R.drawable.pardasuiza);

                }else if (getPosicion()==1){
                    rs = ob.ConsultaBD("Select Raza,Peso_Promedio,Longevidad,Temperatura_minima,Temperatura_maxima," +
                            "Litros_de_leche_al_año,Crias_en_vida_productiva,Enfermedades_propensas,Especialidad,Periodo_de_gestacion," +
                            "Calidad_de_leche,Propiedades_de_la_leche,Temperamento,Tipo_de_cuero from Vacas where Raza='Brahman'");
                    imagenvaca.setImageResource(R.drawable.brahma);
                }else if(getPosicion()==2){
                    rs = ob.ConsultaBD("Select Raza,Peso_Promedio,Longevidad,Temperatura_minima,Temperatura_maxima," +
                            "Litros_de_leche_al_año,Crias_en_vida_productiva,Enfermedades_propensas,Especialidad,Periodo_de_gestacion," +
                            "Calidad_de_leche,Propiedades_de_la_leche,Temperamento,Tipo_de_cuero from Vacas where Raza='Simbrah'");
                    imagenvaca.setImageResource(R.drawable.simbrah);
                }
                while (rs.next()) {
                    Raza.setText(rs.getString("Raza"));
                    PesoPromedio.setText(PesoPromedio.getText().toString()+"    "+rs.getString("Peso_Promedio"));
                    Longevidad.setText(Longevidad.getText().toString()+"    "+rs.getString("Longevidad"));
                    TempMin.setText(TempMin.getText().toString()+"    "+rs.getString("Temperatura_minima"));
                    TempMax.setText(TempMax.getText().toString()+"    "+rs.getString("Temperatura_maxima"));
                    LitrosLeche.setText(LitrosLeche.getText().toString()+"    "+rs.getString("Litros_de_leche_al_año"));
                    Crias.setText(Crias.getText().toString()+"    "+rs.getString("Crias_en_vida_productiva"));
                    Enfermedades.setText(Enfermedades.getText().toString()+"    "+rs.getString("Enfermedades_propensas"));
                    Especialidad.setText(Especialidad.getText().toString()+"    "+rs.getString("Especialidad"));
                    Gestacion.setText(Gestacion.getText().toString()+"    "+rs.getString("Periodo_de_gestacion"));
                    CalidadLeche.setText(CalidadLeche.getText().toString()+"    "+rs.getString("Calidad_de_leche"));
                    PropiedadesLeche.setText(PropiedadesLeche.getText().toString()+"    "+rs.getString("Propiedades_de_la_leche"));
                    Temperamento.setText(Temperamento.getText().toString()+"    "+rs.getString("Temperamento"));
                    TipodeCuero.setText(TipodeCuero.getText().toString()+"    "+rs.getString("Tipo_de_cuero"));

                }
            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();

            }

}

}
