package com.example.exameninterfacesfinal3;

public class Contacto {
    private String nombre, telefono;
    private int img_contacto;

    public Contacto(String nombre, String telefono, int img_contacto) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.img_contacto = img_contacto;
    }

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getImg_contacto() {
        return img_contacto;
    }

    public void setImg_contacto(int img_contacto) {
        this.img_contacto = img_contacto;
    }
}
