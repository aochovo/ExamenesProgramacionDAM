/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.micrm;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.naming.Context;

/**
 *
 * @author alex
 */
public class Main extends Application  implements PantallaLogin.ComunicacionLogin, PantallaArticulo.ComunicacionPantallaProductos, PantallaPrincipal.ComunicacionPrincipal, PantallaCliente.ComunicacionPantallaClientes, PantallaProveedor.ComunicacionPantallaProveedores{
    static Stage ventana;
    /*Declaramos el Stage de forma universal para poder jugar luego con las distintas 
    pantallas del ERP*/
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        ventana=stage;
        ventana.getIcons().add(new Image("https://images-na.ssl-images-amazon.com/images/I/51lpm9SpsJL.png"));
        /*Le ponemos una imagen de icono a nuestra aplicacion */
        AccesoBD.conectarBD();
        /*Nos conectamos a la BBDD de la tienda*/
        PantallaLogin.cargarPantallaLogin(ventana, this);
        /*Mostramos la pantalla de Login segun arranca la aplicacion*/
    }

    @Override
    public void comprobarUsuario(String nombre, String password) {
        /*En este metodo, pasándole el nombre y paswd, comprobamos si el usuario introducido es correcto.
        Si es correcto, muestra la pantalla del menu;
        si no, indica el error*/
        Usuario d=AccesoBD.comprobarUsuario(nombre, password);
       if(d==null)
       {
           PantallaLogin.indicarError();
       }
       else
       {//Si etá bien logueado
           PantallaPrincipal.cargarPantallaPrincipal(ventana, this);
           
       }
    }

    @Override
    public void ingresarArticulo(Articulo a) {
        /*En este metodo, pasándole un objeto Articulo:
        en el caso de que sea el articulo null, te lo creara, en cambio,
        si el Articulo no es null, te los sobrescribira.
        Si no se pueden hacer dichas consultas,  te lo indicara*/
        Articulo b=AccesoBD.comprobarArticulo(String.valueOf(a.getCodigo_articulo()));
        if(b==null)
        {
           boolean aux=AccesoBD.meterArticulo(a); 
           if(aux==false)
           {
               PantallaArticulo.indicarError2();
           }
        }
        else
        {
            boolean aux=AccesoBD.updateArticulo(a);
            if(aux==false)
           {
               PantallaArticulo.indicarError2();
           }
        }
        
    }

    @Override
    public void comprobarArticulo(String codigo) {
        /*En este metodo, pasándole el codigo del articulo, comprobamos si el codigo del articulo se encuentra en la base de datos y si es asi,
        te los muestra rellenando el resto de campos; si no, te indicara un error como que no existe y tendras que rellenar los campos.*/
        Articulo a=AccesoBD.comprobarArticulo(codigo);
        PantallaArticulo.mostrarArticulo(a);
    }

    

    @Override
    public void cerrarSesion() {
        /*En este metodo te devuelve a la pantalla de login*/
        PantallaLogin.cargarPantallaLogin(ventana, this);
    }

    @Override
    public void mostrarPantallaClientes() {
        /*En este metodo te lleva a la pantalla de clientes*/
        PantallaCliente.cargarPantallaCliente(ventana, this);
    }

    @Override
    public void mostrarPantallaPrincipal() {
        /*En este metodo te lleva a la pantalla del menu*/
        PantallaPrincipal.cargarPantallaPrincipal(ventana, this);
    }

    @Override
    public void mostrarPantallaArticulos() {
        /*En este metodo te lleva a la pantalla de articulos*/
        PantallaArticulo.cargarPantallaArticulo(ventana, this);
    }

    @Override
    public void borrarArticulo(String cod_art) {
        /*En este metodo, borramos un articulo de base de datos pasandole el codigo de dicho articulo.
        En el caso de que no se pueda realizar la consulta, te lo indicara*/
        boolean aux=AccesoBD.borrarArt(cod_art);
        if (aux==false) {
            PantallaArticulo.indicarError2();
        }
    }

    @Override
    public void comprobarCliente(String nif) {
        /*En este metodo, pasándole el nif del cliente, comprobamos si el nif del cliente se encuentra en la base de datos y si es asi,
        te los muestra rellenando el resto de campos; si no, te indicara un error como que no existe y tendras que rellenar los campos.*/
        Cliente c=AccesoBD.comprobarCliente(nif);
        PantallaCliente.mostrarCliente(c);
    }

    @Override
    public void ingresarCliente(Cliente c) {
        /*En este metodo, pasándole un objeto Cliente:
        en el caso de que sea el cliente null, te lo creara, en cambio,
        si el cliente no es null, te los sobrescribira.
        Si no se pueden hacer dichas consultas,  te lo indicara*/
        Cliente b=AccesoBD.comprobarCliente(String.valueOf(c.getNIF()));
        if(b==null)
        {
           boolean aux=AccesoBD.meterCliente(c); 
           if(aux==false)
           {
               PantallaCliente.indicarError2();
           }
        }
        else
        {
            boolean aux=AccesoBD.updateCliente(c);
            if(aux==false)
           {
               PantallaCliente.indicarError2();
           }
        }
    }

    @Override
    public void borrarCliente(String nif) {
        /*En este metodo, borramos un cliente de base de datos pasandole el nif de dicho cliente.
        En el caso de que no se pueda realizar la consulta, te lo indicara*/
        boolean aux=AccesoBD.borrarCliente(nif);
        if(aux==false)
           {
               PantallaCliente.indicarError2();
           }
    }

    @Override
    public void comprobarProveedor(String cod_pro) {
        Proveedor p=AccesoBD.comprobarProveedor(cod_pro);
        PantallaProveedor.mostrarProveedor(p);
    }

    @Override
    public void ingresarProveedor(Proveedor a) {
        Proveedor p=AccesoBD.comprobarProveedor(a.getCodigo());
        if(p==null)
        {
           boolean aux=AccesoBD.meterProveedor(a); 
           if(aux==false)
           {
               PantallaCliente.indicarError2();
           }
        }
        else
        {
            boolean aux=AccesoBD.updateProveedor(a);
            if(aux==false)
           {
               PantallaCliente.indicarError2();
           }
        }
    }

    @Override
    public void borrarProveedor(String cod_pro) {
        boolean aux=AccesoBD.borrarProveedor(cod_pro);
        if(aux==false)
           {
               PantallaCliente.indicarError2();
           }
    }

    @Override
    public void mostrarPantallaProveedores() {
        PantallaProveedor.cargarPantallaArticulo(ventana, this);
    }

    

    
}
