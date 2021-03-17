/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.micrm;

/**
 *
 * @author FP Mañana A
 */
public class Proveedor {
    private String codigo, tipo, nombre, cif_nif, direccion, localidad, codigo_postal,provincia, telefono, contacto, email;

    public Proveedor(String codigo, String tipo, String nombre, String cif_nif, String direccion, String localidad, String codigo_postal, String provincia, String telefono, String contacto, String email) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.cif_nif = cif_nif;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigo_postal = codigo_postal;
        this.provincia = provincia;
        this.telefono = telefono;
        this.contacto = contacto;
        this.email = email;
    }

    public Proveedor() {
    }
    
    
        
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif_nif() {
        return cif_nif;
    }

    public void setCif_nif(String cif_nif) {
        this.cif_nif = cif_nif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "codigo=" + codigo + ", tipo=" + tipo + ", nombre=" + nombre + ", cif_nif=" + cif_nif + ", direccion=" + direccion + ", localidad=" + localidad + ", codigo_postal=" + codigo_postal + ", provincia=" + provincia + ", telefono=" + telefono + ", contacto=" + contacto + ", email=" + email + '}';
    }
    
}
