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
public class Articulo {
    /*Clase Objeto Articulo.
    propiedades:codigo, descripcion, precio, impuesto, margen y pvp.
    le creo el contructor lleno y otro vacio y ademas, los get y los set y ademas el toString aunque no lo vata a necesitar*/
    
    private String codigo_articulo,descripcion_articulo;
    private float precio_articulo, margen_articulo, pvp_articulo, impuesto_articulo;

    public Articulo(String codigo_articulo, String descripcion_articulo,float precio_articulo,float impuesto_articulo , float margen_articulo, float pvp_articulo) {
        this.impuesto_articulo = impuesto_articulo;
        this.codigo_articulo = codigo_articulo;
        this.descripcion_articulo = descripcion_articulo;
        this.precio_articulo = precio_articulo;
        this.margen_articulo = margen_articulo;
        this.pvp_articulo = pvp_articulo;
    }

    public Articulo() {
    }

    public float getImpuesto_articulo() {
        return impuesto_articulo;
    }

    public void setImpuesto_articulo(int impuesto_articulo) {
        this.impuesto_articulo = impuesto_articulo;
    }

    public String getCodigo_articulo() {
        return codigo_articulo;
    }

    public void setCodigo_articulo(String codigo_articulo) {
        this.codigo_articulo = codigo_articulo;
    }

    public String getDescripcion_articulo() {
        return descripcion_articulo;
    }

    public void setDescripcion_articulo(String descripcion_articulo) {
        this.descripcion_articulo = descripcion_articulo;
    }

    public float getPrecio_articulo() {
        return precio_articulo;
    }

    public void setPrecio_articulo(float precio_articulo) {
        this.precio_articulo = precio_articulo;
    }

    public float getMargen_articulo() {
        return margen_articulo;
    }

    public void setMargen_articulo(float margen_articulo) {
        this.margen_articulo = margen_articulo;
    }

    public float getPvp_articulo() {
        return pvp_articulo;
    }

    public void setPvp_articulo(float pvp_articulo) {
        this.pvp_articulo = pvp_articulo;
    }

    @Override
    public String toString() {
        return "Articulo{" + "impuesto_articulo=" + impuesto_articulo + ", codigo_articulo=" + codigo_articulo + ", descripcion_articulo=" + descripcion_articulo + ", precio_articulo=" + precio_articulo + ", margen_articulo=" + margen_articulo + ", pvp_articulo=" + pvp_articulo + '}';
    }

   
    
    
}
