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
public class Usuario {
    /*Clase Objeto Usuario.
    propiedades:id, usuario, passwd.
    le creo el contructor lleno y ademas, le creo los get y los set y ademas el toString aunque no lo vata a necesitar*/
    private int id;
    private String usuario,passwd;

    public Usuario(int id, String usuario, String passwd) {
        this.id = id;
        this.usuario = usuario;
        this.passwd = passwd;
    }

    public Usuario(int id, String usuario) {
        this.id = id;
        this.usuario = usuario;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", usuario=" + usuario + ", passwd=" + passwd + '}';
    }
    
}
