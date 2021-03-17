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
import javafx.scene.control.Alert;
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
public class PantallaArticulo {
    /*Declaramos las variables que pertenecen a la pantalla de forma universal, para que las pueda ver toda la Clase*/
    static Label lbl_error,txt_pvp;
    static Button btn_guardar, btn_borrar,btn_salir;
    static TextField txt_codigo, txt_descripcion, txt_precio, txt_impuesto, txt_margen;
    

    static void cargarPantallaArticulo(Stage ventana, ComunicacionPantallaProductos llamante) {
        /*En este metodo, inicializamos todas las variables de la pantalla y le realizo las diferentes acciones necesarias*/
        try {
            File f=new File("recursos/pantalla_articulo.fxml");
            URL url_pantala_productos=f.toURI().toURL();
            Parent root=FXMLLoader.load(url_pantala_productos);
            Scene escena=new Scene(root);
            /*Primero cogemos el archivo donde tiene s la pantalla creada y se lo seteamos a la escena para que se vea*/
            /*Componentes de la pantalla*/
            txt_codigo=(TextField)escena.lookup("#txt_codigo");
            txt_descripcion=(TextField)escena.lookup("#txt_descripcion");
            txt_precio=(TextField)escena.lookup("#txt_precio");
            txt_impuesto=(TextField)escena.lookup("#txt_impuesto");
            txt_margen=(TextField)escena.lookup("#txt_margen");
            txt_pvp=(Label)escena.lookup("#txt_pvp");
            btn_guardar=(Button)escena.lookup("#btn_guardar");
            btn_borrar=(Button)escena.lookup("#btn_borrar");
            btn_salir=(Button)escena.lookup("#btn_salir");
            lbl_error=(Label)escena.lookup("#lbl_error");
            
            /*Acciones de los componentes*/
            
            txt_codigo.setOnKeyPressed(new EventHandler<KeyEvent>() {
                /*Accion sobre el textfield del codigo, que se activa cuando le damos a la tecla enter*/
                @Override
                public void handle(KeyEvent t) {
                     if(t.getCode() == KeyCode.ENTER){
                        llamante.comprobarArticulo(txt_codigo.getText().toString());
                        /*mediante una interfaz le pasamos el codigo cogido del textfied*/
                     }
                    
                }
            });
            
            btn_borrar.setOnAction(new EventHandler<ActionEvent>() {
                /*Accion sobre el boton de borrar, y se activa cuando clicamos encima del boton*/
                @Override
                public void handle(ActionEvent t) {
                    String codigo=txt_codigo.getText().toString();
                    llamante.borrarArticulo(codigo);
                    /*Mediante una interfaz le pasamos el codigo para que pueda borrarlo*/
                    txt_descripcion.setText("");
                    txt_precio.setText("");
                    txt_impuesto.setText("");
                    txt_margen.setText("");
                    txt_pvp.setText("");
                    /*El resto de campos los dejo vacios*/
                }
            });
            
            btn_salir.setOnAction(new EventHandler<ActionEvent>() {
                /*Accion sobre el boton de salir, y se activa cuando clicamos encima del boton*/
                @Override
                public void handle(ActionEvent t) {
                    llamante.mostrarPantallaPrincipal();
                    /*Mediante una interfaz, le hagp que muestre la pantalla del menu*/
                }
            });
            
            btn_guardar.setOnAction(new EventHandler<ActionEvent>() {
                /*Accion sobre el boton de guardar, y se activa cuando clicamos encima del boton*/
                @Override
                public void handle(ActionEvent t) {
                   String codigo=txt_codigo.getText();
                   String descripcion=txt_descripcion.getText();
                   float precio=Float.parseFloat(txt_precio.getText());
                   float impuesto=Float.parseFloat(txt_impuesto.getText());
                   float margen=Float.parseFloat(txt_margen.getText());
                   float pvp=precio * ((impuesto / 100)+1) * ((margen/100)+1);
                   txt_pvp.setText(String.valueOf(pvp));
                   Articulo a=new Articulo(codigo, descripcion, precio, impuesto, margen, pvp);
                   llamante.ingresarArticulo(a);
                   /*Cojo todos los valores de los campos y me creo un nuevo Articulo, el cual paso a la interfaz para
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

    static void mostrarArticulo(Articulo a) {
        /*Pasandole un articulo*/
        if(a==null)
            /*Si es null*/
        {
            indicarError1();
            /*Indica el error*/
            txt_descripcion.setText("");
            txt_precio.setText("");
            txt_impuesto.setText("");
            txt_margen.setText("");
            txt_pvp.setText("");
            /*vacia los campos*/
        }
        else
            /*si no*/
        {
        lbl_error.setText("");
        txt_descripcion.setText(a.getDescripcion_articulo().toString());
        txt_precio.setText(String.valueOf(a.getPrecio_articulo()));
        txt_impuesto.setText(String.valueOf(a.getImpuesto_articulo()));
        txt_margen.setText(String.valueOf(a.getMargen_articulo()));
        txt_pvp.setText(String.valueOf(a.getPvp_articulo()));
        /*muestra el resto de valores en su campos*/
        }
    }
    public interface ComunicacionPantallaProductos{
        /*Interfaz creada para poder comunicarse con la clase principal*/
        
        public void comprobarArticulo(String cod_articulo);

        public void mostrarPantallaPrincipal();

        public void ingresarArticulo(Articulo a);
        
        public void borrarArticulo(String cod_art);
        
    }
}
