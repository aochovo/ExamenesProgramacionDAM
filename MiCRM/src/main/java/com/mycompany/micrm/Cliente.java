/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.micrm;

/**
 *
 * @author alex
 */
public class Cliente {
    /*Clase Objeto Cliente.
    propiedades:nif, nombre, domicilio.
    le creo el contructor lleno y otro vacio y ademas, le creo los get y los set y ademas el toString aunque no lo vata a necesitar*/
    
    private String NIF, nombre, domicilio;

    public Cliente(String NIF, String nombre, String domicilio) {
        this.NIF = NIF;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    public Cliente() {
    }
    

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Cliente{" + "NIF=" + NIF + ", nombre=" + nombre + ", domicilio=" + domicilio + '}';
    }
    
}
