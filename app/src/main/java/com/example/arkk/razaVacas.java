package com.example.arkk;

public class razaVacas {
    private String nombre;
    private String descripcion;
    private int fotoRaza;

    public razaVacas() {
    }

    public razaVacas(String nombre, String descripcion, int fotoRaza) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotoRaza = fotoRaza;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getFotoRaza() {
        return fotoRaza;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFotoRaza(int fotoRaza) {
        this.fotoRaza = fotoRaza;
    }
}

