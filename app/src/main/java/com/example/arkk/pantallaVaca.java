package com.example.arkk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class pantallaVaca extends AppCompatActivity {

    private RecyclerView recyclerViewRazas;
    private RecyclerViewAdaptador adaptadorRazas;
    private EditText BuscarFiltro;
    RecyclerViewAdaptador adapter;
    Button Send,Reset;
    Spinner Temp,Esp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_vaca);

        recyclerViewRazas =findViewById(R.id.recyclerRazas);
        recyclerViewRazas.setLayoutManager(new LinearLayoutManager(this));
        Send=findViewById(R.id.send);
        Temp=findViewById(R.id.spinnerTemp);
        Esp=findViewById(R.id.spinnerEsp);
        Reset=findViewById(R.id.reset);
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewRazas.setAdapter(new RecyclerViewAdaptador(obtenerVacasDB(), new RecyclerViewOnItemClickListener() {
                    @Override
                    public void onClick(View v, int position) {
                        Intent intent= new Intent(pantallaVaca.this,pantallaInformacionVaca.class  );
                        startActivity(intent);
                    }
                }));
            }
        });
        //FIltro
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!BuscarFiltro.getText().toString().equals("")){
                    recyclerViewRazas.setAdapter(new RecyclerViewAdaptador(obtenerFiltro(BuscarFiltro.getText().toString()), new RecyclerViewOnItemClickListener() {
                        @Override
                        public void onClick(View v, int position) {
                            Intent intent= new Intent(pantallaVaca.this,pantallaInformacionVaca.class  );
                            startActivity(intent);
                        }
                    }));
                }else{
                    Toast.makeText(pantallaVaca.this, "Asegurese de haber escrito algo", Toast.LENGTH_SHORT).show();
                    if (!Temp.getSelectedItem().toString().equals("Temperatura") && !Esp.getSelectedItem().toString().equals("Especialidad")){
                        recyclerViewRazas.setAdapter(new RecyclerViewAdaptador(FiltroSpinner(), new RecyclerViewOnItemClickListener() {
                            @Override
                            public void onClick(View v, int position) {
                                Intent intent= new Intent(pantallaVaca.this,pantallaInformacionVaca.class  );
                                startActivity(intent);
                            }
                        }));
                    }else{
                        Toast.makeText(pantallaVaca.this, "Asegurese de tener campos seleccionados", Toast.LENGTH_SHORT).show();
                    }
                }
                
            }
        });
        BuscarFiltro=findViewById(R.id.Buscar);
        //INICIO
        recyclerViewRazas.setAdapter(new RecyclerViewAdaptador(obtenerVacasDB(), new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent= new Intent(pantallaVaca.this,pantallaInformacionVaca.class  );
                startActivity(intent);


            }
        }));

    }
    public List<razaVacas> obtenerFiltro (String filtro){
        List<razaVacas> vaca= new ArrayList<>();
        try {
            ResultSet rs= new Conexcion().ConsultaBD("Select Raza from Vacas");

            while(rs.next()){
                if(rs.getString("Raza").equals("Pardo suiza")){
                    if(rs.getString("Raza").toLowerCase().contains(filtro)) {
                        vaca.add(new razaVacas(rs.getString("Raza"), "", R.drawable.pardasuiza));
                    }
                }else if(rs.getString("Raza").equals("Simbrah")){
                    if(rs.getString("Raza").toLowerCase().contains(filtro)) {
                        vaca.add(new razaVacas(rs.getString("Raza"), "", R.drawable.simbrah));
                    }
                }else if (rs.getString("Raza").equals("Brahman")){
                    if(rs.getString("Raza").toLowerCase().contains(filtro)) {
                        vaca.add(new razaVacas(rs.getString("Raza"), "", R.drawable.brahma));
                    }
                }


            }
        }catch(Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();

        }
        return vaca;
    }
    public List<razaVacas> obtenerVacasDB(){
        List<razaVacas> vaca= new ArrayList<>();
        try {
            ResultSet rs= new Conexcion().ConsultaBD("Select Raza from Vacas");

            while(rs.next()){
                if(rs.getString("Raza").equals("Pardo suiza")){
                    vaca.add(new razaVacas(rs.getString("Raza"),"",R.drawable.pardasuiza));
                }else if(rs.getString("Raza").equals("Simbrah")){
                    vaca.add(new razaVacas(rs.getString("Raza"),"",R.drawable.simbrah));
                }else if (rs.getString("Raza").equals("Brahman")){
                    vaca.add(new razaVacas(rs.getString("Raza"),"",R.drawable.brahma));
                }


            }
        }catch(Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();

        }
        return vaca;
    }
    public List<razaVacas> FiltroSpinner(){
        List<razaVacas> vaca= new ArrayList<>();
        try {
            String consulta="";

            if(!Temp.getSelectedItem().toString().equals("Temperatura")){
                consulta="Select Raza FROM Vacas WHERE Temperatura_minima = '"+Temp.getSelectedItem().toString()+"'";
                if(!Esp.getSelectedItem().toString().equals("Especialidad")){
                    consulta="Select Raza FROM Vacas WHERE Temperatura_minima = '"+Temp.getSelectedItem().toString()+"' AND " +
                            "Especialidad= '"+Esp.getSelectedItem().toString()+"'";
                }

            }else if(!Esp.getSelectedItem().toString().equals("Especialidad")){
                consulta="Select Raza FROM Vacas WHERE Especialidad = '"+Esp.getSelectedItem().toString()+"'";
                if(!Temp.getSelectedItem().toString().equals("Temperatura")){
                    consulta="Select Raza FROM Vacas WHERE Especialiad = '"+Esp.getSelectedItem().toString()+"' AND " +
                            "Temperatura_minima= '"+Temp.getSelectedItem().toString()+"'";
                }
            }

            ResultSet rs= new Conexcion().ConsultaBD(""+consulta+"");

            while(rs.next()){
                if(rs.getString("Raza").equals("Pardo suiza")){
                    vaca.add(new razaVacas(rs.getString("Raza"),"",R.drawable.pardasuiza));
                }else if(rs.getString("Raza").equals("Simbrah")){
                    vaca.add(new razaVacas(rs.getString("Raza"),"",R.drawable.simbrah));
                }else if (rs.getString("Raza").equals("Brahman")){
                    vaca.add(new razaVacas(rs.getString("Raza"),"",R.drawable.brahma));
                }
            }
        }catch(Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();

        }
        return vaca;
    }

    public List<razaVacas> obtenerRazas(){
        List<razaVacas> raza = new ArrayList<>();
        raza.add(new razaVacas("Brahma","La raza de ganado brahman tiene su origen en el ganado cebú llevado originariamente a los Estados Unidos de América proveniente de la India.",R.drawable.brahma));
        raza.add(new razaVacas("Parda Suiza","La expresión pardo suizo es alusiva a una raza de ganado lechero de Estados Unidos derivada de la parda alpina, originaria de los Alpes suizos.",R.drawable.pardasuiza));
        raza.add(new razaVacas("Simbrah","Para el cruce con las razas Cebuínas, el cruce con Simmental es mejor que con otras razas, por que se mejora el rendimiento lácteo paralelamente con el rendimiento cárnico",R.drawable.simbrah));
        raza.add(new razaVacas("Simbrah","Para el cruce con las razas Cebuínas, el cruce con Simmental es mejor que con otras razas, por que se mejora el rendimiento lácteo paralelamente con el rendimiento cárnico",R.drawable.simbrah));
        raza.add(new razaVacas("Simbrah","Para el cruce con las razas Cebuínas, el cruce con Simmental es mejor que con otras razas, por que se mejora el rendimiento lácteo paralelamente con el rendimiento cárnico",R.drawable.simbrah));
        raza.add(new razaVacas("Simbrah","Para el cruce con las razas Cebuínas, el cruce con Simmental es mejor que con otras razas, por que se mejora el rendimiento lácteo paralelamente con el rendimiento cárnico",R.drawable.simbrah));

        return raza;
    }

    }

