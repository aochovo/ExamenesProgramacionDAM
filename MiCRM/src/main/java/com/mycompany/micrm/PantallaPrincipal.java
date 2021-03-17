/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.micrm;

import static com.mycompany.micrm.PantallaLogin.btn_comprobar;
import static com.mycompany.micrm.PantallaLogin.lbl_error;
import static com.mycompany.micrm.PantallaLogin.password;
import static com.mycompany.micrm.PantallaLogin.txt_pwd;
import static com.mycompany.micrm.PantallaLogin.txt_usuario;
import static com.mycompany.micrm.PantallaLogin.usuario;
import java.io.File;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author FP Mañana A
 */
class PantallaPrincipal {
    /*Declaramos las variables que pertenecen a la pantalla de forma universal, para que las pueda ver toda la Clase*/
    static Button btn_articulos, btn_cliente, btn_cerrar_sesion, btn_proveedores;
    static void cargarPantallaPrincipal(Stage ventana, ComunicacionPrincipal llamante) {
        /*En este metodo, inicializamos todas las variables de la pantalla y le realizo las diferentes acciones necesarias*/
        File f=new File("recursos/pantalla_principal.fxml");
        try {
            URL url_pantalla_principal=f.toURI().toURL();
            Parent root=FXMLLoader.load(url_pantalla_principal);
            Scene escena=new Scene(root);
            /*Primero cogemos el archivo donde tienes la pantalla creada y se lo seteamos a la escena para que se vea*/
            /*Componentes de la pantalla*/
            btn_articulos=(Button)escena.lookup("#btn_articulos");
            btn_cliente=(Button)escena.lookup("#btn_clientes");
            btn_cerrar_sesion=(Button)escena.lookup("#btn_cerrar_sesion");
            btn_proveedores=(Button)escena.lookup("#btn_proveedores");
            btn_articulos.setOnAction(new EventHandler<ActionEvent>() {
                /*Accion sobre el boton de comprobar, y se activa cuando clicamos encima del boton*/
                @Override
                public void handle(ActionEvent t) {
                    llamante.mostrarPantallaArticulos();
                    /*llamamos a la interfaz para que muestre la pantalla articulos*/
                    
                }
            });
            btn_cliente.setOnAction(new EventHandler<ActionEvent>() {
                /*Accion sobre el boton de comprobar, y se activa cuando clicamos encima del boton*/
                @Override
                public void handle(ActionEvent t) {
                    llamante.mostrarPantallaClientes();
                     /*llamamos a la interfaz para que muestre la pantalla clientes*/
                }
            });
            btn_cerrar_sesion.setOnAction(new EventHandler<ActionEvent>() {
                /*Accion sobre el boton de comprobar, y se activa cuando clicamos encima del boton*/
                @Override
                public void handle(ActionEvent t) {
                    llamante.cerrarSesion();
                     /*llamamos a la interfaz para que muestre la pantalla de login*/
                }
            });
            btn_proveedores.setOnAction(new EventHandler<ActionEvent>() {
                /*Accion sobre el boton de comprobar, y se activa cuando clicamos encima del boton*/
                @Override
                public void handle(ActionEvent t) {
                    llamante.mostrarPantallaProveedores();
                     /*llamamos a la interfaz para que muestre la pantalla de login*/
                }
            });
            
          ventana.setScene(escena);
          ventana.show();
           /*A la ventana le seteamos la escena y la mostramos*/
        } catch (Exception ex) {
            Logger.getLogger(PantallaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public interface ComunicacionPrincipal
            /*Interfaz creada para poder comunicarse con la clase principal*/
  {
      public void mostrarPantallaProveedores();
      public void mostrarPantallaArticulos();
      public void cerrarSesion();
      public void mostrarPantallaClientes();
  }
    
}
