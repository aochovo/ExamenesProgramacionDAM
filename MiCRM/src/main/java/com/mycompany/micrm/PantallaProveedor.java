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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author FP Mañana A
 */
public class PantallaProveedor {
    static Label lbl_error,tv_nif_cif;
    static Button btn_guardar, btn_borrar,btn_salir;
    static TextField txt_codigo, txt_nombre, txt_cif_nif, txt_direccion, txt_localidad,txt_codigo_postal,txt_provincia,txt_telefono,txt_contacto,txt_email;
    static ComboBox cb_tipo;

    static void cargarPantallaArticulo(Stage ventana, ComunicacionPantallaProveedores llamante) {
        /*En este metodo, inicializamos todas las variables de la pantalla y le realizo las diferentes acciones necesarias*/
        try {
            File f=new File("recursos/pantalla_proveedores.fxml");
            URL url_pantala_productos=f.toURI().toURL();
            Parent root=FXMLLoader.load(url_pantala_productos);
            Scene escena=new Scene(root);
            /*Primero cogemos el archivo donde tiene s la pantalla creada y se lo seteamos a la escena para que se vea*/
            /*Componentes de la pantalla*/
            txt_codigo=(TextField)escena.lookup("#txt_codigo");
            txt_nombre=(TextField)escena.lookup("#txt_nombre");
            txt_cif_nif=(TextField)escena.lookup("#txt_cif_nif");
            txt_direccion=(TextField)escena.lookup("#txt_direccion");
            txt_localidad=(TextField)escena.lookup("#txt_localidad");
            txt_codigo_postal=(TextField)escena.lookup("#txt_codigo_postal");
            txt_provincia=(TextField)escena.lookup("#txt_provincia");
            txt_telefono=(TextField)escena.lookup("#txt_telefono");
            txt_contacto=(TextField)escena.lookup("#txt_contacto");
            txt_email=(TextField)escena.lookup("#txt_email");
            tv_nif_cif=(Label)escena.lookup("#tv_nif_cif");
            cb_tipo=(ComboBox)escena.lookup("#cb_tipo");
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
                        llamante.comprobarProveedor(txt_codigo.getText().toString());
                        /*mediante una interfaz le pasamos el codigo cogido del textfied*/
                     }
                    
                }
            });
            cb_tipo.getItems().addAll(
                "Empresa",
                "Persona Física"
            );
            
            
            
            cb_tipo.setOnAction(new EventHandler() {
                @Override
                public void handle(Event t) {
                    if(cb_tipo.getValue()=="Empresa")
                    {
                        tv_nif_cif.setText("CIF");
                        
                    }        
                    else
                    {
                        tv_nif_cif.setText("NIF");
                        
                    }
                }
            });
            
            txt_email.setOnKeyPressed(new EventHandler<KeyEvent>(){
                @Override
                public void handle(KeyEvent t) {
                    lbl_error.setText("");
                    if(t.getCode() == KeyCode.ENTER){
                       boolean aux=validarEmail(txt_email.getText().toString());
                               
                        if(aux==false)
                        {
                            indicarError5();
                            txt_email.setText("");
                        } 
                    }
                }
            });
            
            txt_cif_nif.setOnKeyPressed(new EventHandler<KeyEvent>() {
                /*Accion sobre el textfield del codigo, que se activa cuando le damos a la tecla enter*/
                @Override
                public void handle(KeyEvent t) {
                    lbl_error.setText("");
                     if(t.getCode() == KeyCode.ENTER){
                         if(cb_tipo.getValue()=="Empresa")
                    {
                        
                        boolean aux=validadorCIF(txt_cif_nif.getText().toString());
                        if(aux==false)
                        {
                            indicarError3();
                            txt_cif_nif.setText("");
                        }
                    }        
                    else
                    {
                        
                        boolean aux=validadorNIF(txt_cif_nif.getText().toString());
                        if(aux==false)
                        {
                            indicarError4();
                            txt_cif_nif.setText("");
                        }
                    }
                     }
                    
                }
            });
            
            btn_borrar.setOnAction(new EventHandler<ActionEvent>() {
                /*Accion sobre el boton de borrar, y se activa cuando clicamos encima del boton*/
                @Override
                public void handle(ActionEvent t) {
                    String codigo=txt_codigo.getText().toString();
                    llamante.borrarProveedor(codigo);
                    /*Mediante una interfaz le pasamos el codigo para que pueda borrarlo*/
                    txt_nombre.setText("");
                    txt_cif_nif.setText("");
                    txt_direccion.setText("");
                    txt_localidad.setText("");
                    txt_codigo_postal.setText("");
                    txt_provincia.setText("");
                    txt_telefono.setText("");
                    txt_contacto.setText("");
                    txt_email.setText("");
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
                   String nombre=txt_nombre.getText();
                   String tipo=cb_tipo.getValue().toString();
                   String cif_nif=txt_cif_nif.getText();
                   String direccion=txt_direccion.getText();
                   String localidad=txt_localidad.getText();
                   String codigo_postal=txt_codigo_postal.getText();
                   String provincia=txt_provincia.getText();
                   String telefono=txt_telefono.getText();
                   String contacto=txt_contacto.getText();
                   String email=txt_email.getText();;
                   Proveedor p=new Proveedor(codigo, nombre, tipo, cif_nif, direccion, localidad, codigo_postal, provincia, telefono, contacto, email);
                   llamante.ingresarProveedor(p);
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
    public static void indicarError3()
            /*Muestra un error*/
    {
        lbl_error.setText("Su CIF es incorrecto, compruebelo");
        
    }
    public static void indicarError4()
            /*Muestra un error*/
    {
        lbl_error.setText("Su NIF es incorrecto, compruebelo");
        
    }
    public static void indicarError5()
            /*Muestra un error*/
    {
        lbl_error.setText("Su EMAIL es incorrecto, compruebelo");
        
    }

    static void mostrarProveedor(Proveedor a) {
        /*Pasandole un articulo*/
        if(a==null)
            /*Si es null*/
        {
            indicarError1();
            /*Indica el error*/
            txt_nombre.setText("");
            txt_cif_nif.setText("");
            txt_direccion.setText("");
            txt_localidad.setText("");
            txt_codigo_postal.setText("");
            txt_provincia.setText("");
            txt_telefono.setText("");
            txt_contacto.setText("");
            txt_email.setText("");
            /*vacia los campos*/
        }
        else
            /*si no*/
        {
        lbl_error.setText("");
        txt_nombre.setText(a.getNombre().toString());
        cb_tipo.setValue(a.getTipo());
        txt_cif_nif.setText(a.getCif_nif());
        txt_direccion.setText(a.getDireccion());
        txt_localidad.setText(a.getLocalidad());
        txt_codigo_postal.setText(a.getCodigo_postal());
        txt_provincia.setText(a.getProvincia());
        txt_telefono.setText(a.getTelefono());
        txt_contacto.setText(a.getContacto());
        txt_email.setText(a.getEmail());
        /*muestra el resto de valores en su campos*/
        }
    }
    
    public static boolean validarEmail(String email){
        boolean resultado = false;
    Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
 
        Matcher mather = pattern.matcher(email);
 
        if (mather.find() == true) {
            resultado = true;
        }
        return resultado;
    }


    private static boolean validadorCIF(String cif) {
        boolean resultado = false;
		int digito_de_control;
                String letras_validas = "ABCDEFGHJPQRSUV";
                String caracteres_de_control = "JABCDEFGHI";
                String tipo_de_letra = "PQS";
                String tipo_de_nombre = "ABEH";
		try {
			/* Un CIF tiene que tener nueve dígitos */
			if (cif.length() == 9) {

				/* Toma la primera letra del CIF */
				char letra_CIF = cif.charAt(0);

				/* Comprueba si la primera letra del CIF es válida */
				if (letras_validas.indexOf(letra_CIF) >= 0) {

					if (Character.isDigit(cif.charAt(8))) {
						digito_de_control = Character.getNumericValue(cif
								.charAt(8));
						if (tipo_de_letra.indexOf(letra_CIF) >= 0)
							digito_de_control = 100;
					} else {
						digito_de_control = caracteres_de_control.indexOf(cif
								.charAt(8));
						if (tipo_de_nombre.indexOf(letra_CIF) >= 0)
							digito_de_control = 100;
					}

					int a = 0, b = 0, c = 0;
					byte[] impares = { 0, 2, 4, 6, 8, 1, 3, 5, 7, 9 };

					/* Calcula A y B. */
					for (int t = 1; t <= 6; t = t + 2) {

						/* Suma los pares */
						a = a + Character.getNumericValue(cif.charAt(t + 1));
						b = b
								+ impares[Character.getNumericValue(cif
										.charAt(t))];
					}

					b = b + impares[Character.getNumericValue(cif.charAt(7))];
					/* Calcula C */
					c = 10 - ((a + b) % 10);
					/* Compara C con los dígitos de control */
					resultado = (c == digito_de_control);
				}
			}
		} catch (Exception e) {
			resultado = false;
		}
		return resultado;
    }

    private static boolean validadorNIF(String nif) {
        char[] letras={'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
       if (nif.length()!=9)
       {
           return false;
       }
      String numero= nif.substring(0, 8);//12345678J
      String letra=nif.substring(8, 9);
      int num=0;
      try
      {
          num=Integer.parseInt(numero);
      }
      catch(Exception e)
      {
          return false;
      }
      int resto=num%23;
      char letra_correcta=letras[resto];
      char letra_dni=letra.charAt(0);
      if (letra_correcta!=letra_dni)
      {
          return false;
      }
        return true;
    }
    public interface ComunicacionPantallaProveedores{
        /*Interfaz creada para poder comunicarse con la clase principal*/
        
        public void comprobarProveedor(String cod_pro);

        public void mostrarPantallaPrincipal();

        public void ingresarProveedor(Proveedor a);
        
        public void borrarProveedor(String cod_pro);
        
    }
}
