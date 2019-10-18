package com.example.arkk;

public class Usuarios {
    private String usuario;
    private String contraseña;

    public Usuarios() {
    }

    public Usuarios(String nombre, String contraseña) {
        this.usuario = nombre;
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
