/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.micrm;

import static com.mycompany.micrm.PantallaArticulo.lbl_error;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author alex
 */
public class PantallaCliente {
    /*Declaramos las variables que pertenecen a la pantalla de forma universal, para que las pueda ver toda la Clase*/
    static Label lbl_error;
    static Button btn_guardar, btn_borrar, btn_salir;
    static TextField txt_nif, txt_nombre, txt_domicilio;
    

    static void cargarPantallaCliente(Stage ventana, ComunicacionPantallaClientes llamante) {
        /*En este metodo, inicializamos todas las variables de la pantalla y le realizo las diferentes acciones necesarias*/
        try {
            File f=new File("recursos/pantalla_cliente.fxml");
            URL url_pantala_clientes=f.toURI().toURL();
            Parent root=FXMLLoader.load(url_pantala_clientes);
            Scene escena=new Scene(root);
            /*Primero cogemos el archivo donde tiene s la pantalla creada y se lo seteamos a la escena para que se vea*/
            /*Componentes de la pantalla*/
            txt_nif=(TextField)escena.lookup("#txt_nif");
            txt_nombre=(TextField)escena.lookup("#txt_nombre");
            txt_domicilio=(TextField)escena.lookup("#txt_domicilio");
            btn_guardar=(Button)escena.lookup("#btn_guardar");
            btn_borrar=(Button)escena.lookup("#btn_borrar");
            btn_salir=(Button)escena.lookup("#btn_salir");
            lbl_error=(Label)escena.lookup("#lbl_error");
            
            /*Acciones de los componentes*/
            
            txt_nif.setOnKeyPressed(new EventHandler<KeyEvent>() {
                /*Accion sobre el textfield del codigo, que se activa cuando le damos a la tecla enter*/
                @Override
                public void handle(KeyEvent t) {
                     if(t.getCode() == KeyCode.ENTER){
                        llamante.comprobarCliente(txt_nif.getText().toString());
                        /*mediante una interfaz le pasamos el codigo cogido del textfied*/
                     }
                    
                }
            });
            
            btn_borrar.setOnAction(new EventHandler<ActionEvent>() {
                /*Accion sobre el boton de borrar, y se activa cuando clicamos encima del boton*/
                @Override
                public void handle(ActionEvent t) {
                    String nif=txt_nif.getText().toString();
                    llamante.borrarCliente(nif);
                    /*Mediante una interfaz le pasamos el codigo para que pueda borrarlo*/
                    txt_nombre.setText("");
                    txt_domicilio.setText("");
                    /*El resto de campos los dejo vacios*/
                }
            });
            
            btn_salir.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    llamante.mostrarPantallaPrincipal();
                    /*Mediante una interfaz, le hagp que muestre la pantalla del menu*/
                }
            });
            
            btn_guardar.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                   String nif=txt_nif.getText();
                   String nombre=txt_nombre.getText();
                   String domicilio=txt_domicilio.getText();
                   Cliente c=new Cliente(nif, nombre, domicilio);
                   llamante.ingresarCliente(c);
                   lbl_error.setText("");
                   /*Cojo todos los valores de los campos y me creo un nuevo Cliente, el cual paso a la interfaz para
                   poder ingresarlo en la base de datos*/
                 }
            });
           
            ventana.setScene(escena);
            ventana.show();
            /*A la ventana le seteamos la escena y la mostramos*/
        } catch (Exception ex) {
            Logger.getLogger(PantallaArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    public static void indicarError1()
            /*Muestra un error*/
    {
        lbl_error.setText("No hay ninguno, Introduzca los valores nuevos");
        
    }
    
    public static void indicarError2()
            /*Muestra un error*/
    {
        lbl_error.setText("Ha habido algun error en la consulta");
        
    }

    static void mostrarCliente(Cliente a) {
         /*Pasandole un cliente*/
        if(a==null)
             /*Si es null*/
        {
            indicarError1();
            /*Indica el error*/
            txt_nombre.setText("");
            txt_domicilio.setText("");
            /*vacia los campos*/
        }
        else
            /*si no*/
        {
        lbl_error.setText("");
        txt_nombre.setText(a.getNombre().toString());
        txt_domicilio.setText(String.valueOf(a.getDomicilio()));
        /*muestra el resto de valores en su campos*/
        }
    }
    public interface ComunicacionPantallaClientes{
        /*Interfaz creada para poder comunicarse con la clase principal*/
        
        public void comprobarCliente(String nif);

        public void mostrarPantallaPrincipal();

        public void ingresarCliente(Cliente c);
        
        public void borrarCliente(String nif);
        
    }
}
