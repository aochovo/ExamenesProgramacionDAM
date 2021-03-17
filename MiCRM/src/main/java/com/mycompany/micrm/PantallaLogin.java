/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.micrm;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author alex
 */
public class PantallaLogin {
    /*Declaramos las variables que pertenecen a la pantalla de forma universal, para que las pueda ver toda la Clase*/
    static String usuario, password;
    static Label lbl_error;
    static Button btn_comprobar;
    static TextField txt_usuario;
    static PasswordField txt_pwd;
    static void cargarPantallaLogin(Stage window, ComunicacionLogin llamante) {
        /*En este metodo, inicializamos todas las variables de la pantalla y le realizo las diferentes acciones necesarias*/
       File f=new File("recursos/pantalla_login.fxml");
        try {
            URL url_pantalla_login=f.toURI().toURL();
            Parent root=FXMLLoader.load(url_pantalla_login);
            Scene escena=new Scene(root);
            /*Primero cogemos el archivo donde tienes la pantalla creada y se lo seteamos a la escena para que se vea*/
            /*Componentes de la pantalla*/
            txt_usuario=(TextField)escena.lookup("#txt_usuario");
            txt_pwd=(PasswordField)escena.lookup("#txt_pwd");
            btn_comprobar=(Button)escena.lookup("#btn_comprobar");
            lbl_error=(Label)escena.lookup("#lbl_error");
            
            EventHandler<ActionEvent> oyente_btn=new EventHandler<ActionEvent>() {
                /*Accion sobre el boton de comprobar, y se activa cuando clicamos encima del boton*/
                @Override
                public void handle(ActionEvent t) {
                   usuario=txt_usuario.getText();
                   password=txt_pwd.getText();
                   //JavaFX_1.comprobarUsuario2(nombre, password);
                   llamante.comprobarUsuario(usuario, password);
                   /*Recojo el usuario y contraseña introducidos y se los paso a la interfaz para
                   que pueda comprobarlo con la base de datos*/
                }
            };
            btn_comprobar.setOnAction(oyente_btn);
            window.setScene(escena);
            window.show();
            /*A la ventana le seteamos la escena y la mostramos*/
        } catch (Exception ex) {
            Logger.getLogger(PantallaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void indicarError()
             /*Muestra un error*/
    {
        lbl_error.setText("Ha habido un error. Inténtelo de nuevo");
        txt_usuario .setText("");
        txt_pwd.setText("");
        
    }
  public interface ComunicacionLogin
          /*Interfaz creada para poder comunicarse con la clase principal*/
  {
      public void comprobarUsuario(String nombre, String password);
  }
}
