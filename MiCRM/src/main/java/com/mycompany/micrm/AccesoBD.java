/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.micrm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class AccesoBD {
    /*Declaramos universalmente Connection y Statement*/
    private static Connection conexion=null;
        private static Statement stmt=null;
    public static void conectarBD()
            /*Este metodo, te permite conectarte a la base de datos*/
    {
       try {
        conexion=DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/dqFgfi37e7", "dqFgfi37e7", "8Bv3Hlg7KP");
        stmt=conexion.createStatement();
           System.out.println("Te has conectado");
    } catch (SQLException ex) {
        Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }
    
    public static Usuario comprobarUsuario(String nombre, String password)
            /*En este metodo, pasandole el nombre y la contraseña, busca en la base de datos si hay algun usuario que coincida;
            si existe te coge los datos de la bbdd lo convierte en un Objeto Usuario y lo devuelve, si no, te devolveria el objeto null*/
    {
        try {
            
            String sql="SELECT * FROM `login` WHERE `nombre`='"+nombre+"' AND `passwd`='"+password+"'";
            
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next())
            {
                String usuario=rs.getString("nombre");
                int id=rs.getInt("id_usuario");
                Usuario u=new Usuario(id, usuario);
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    static Articulo comprobarArticulo(String codigo) {
        /*En este metodo, pasandole el codigo del articulo, busca en la base de datos si hay algun Articulo que coincida;
         si existe te coge los datos de la bbdd lo convierte en un Objeto Articulo y lo devuelve, si no, te devolveria el objeto null*/
        Articulo a=new Articulo();
        try {
            
            String sql="SELECT * FROM `articulos` WHERE `CodigoArt`='"+codigo+"'";
            
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next())
            {
                
                String codigoArt=rs.getString("CodigoArt");
                String descrArt=rs.getString("DescrArt");
                String precioArt=rs.getString("CostoArt");
                String impuestoArt=rs.getString("ImpuestoArt");
                String margen=rs.getString("Margen");
                String pvp=rs.getString("PvP");
                a.setCodigo_articulo(codigoArt);
                a.setDescripcion_articulo(descrArt);
                a.setImpuesto_articulo(Integer.parseInt(impuestoArt));
                a.setMargen_articulo(Float.parseFloat(margen));
                a.setPrecio_articulo(Float.parseFloat(precioArt));
                a.setPvp_articulo(Float.parseFloat(pvp));
                return a;
            }
           
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    
    static boolean meterArticulo(Articulo a) {
        /*En este metodo se le pasa el articulo metido por el usuario.
        Se crea un boolean para saber si se ha realizado con exito la consulta*/
        boolean aux=true;
        try {
            String codigoArt=a.getCodigo_articulo();
            String descrArt=a.getDescripcion_articulo();
            float precioArt=a.getPrecio_articulo();
            float impuestoArt=a.getImpuesto_articulo();
            float margen_art=a.getMargen_articulo();
            float pvp=a.getPvp_articulo(); 
            String sql="INSERT INTO `articulos`(`CodigoArt`, `DescrArt`, `CostoArt`, `ImpuestoArt`, `Margen`, `PvP`) VALUES ('"+codigoArt+"', '"+descrArt+"','"+precioArt+"','"+impuestoArt+"','"+margen_art+"','"+pvp+"')";
            stmt.executeUpdate(sql);
            /*Te inserta en la bbdd el nuevo articulo introducido*/
        } catch (SQLException ex) {
            aux=false;
            
        } 
        return aux;
    }

    static boolean borrarArt(String cod_art) {
        /*En este metodo se le pasa el codigo del articulo metido por el usuario.
        Se crea un boolean para saber si se ha realizado con exito la consulta*/
        String sql="DELETE FROM `articulos` WHERE `CodigoArt`='"+cod_art+"'";
        /*Te elimina el articulo con el codigo que hayas introducido*/
        boolean aux=true;
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            aux=false;
        }
        return aux;
    }
    
    static boolean updateArticulo(Articulo a) {
        /*En este metodo se le pasa el articulo metido por el usuario.
        Se crea un boolean para saber si se ha realizado con exito la consulta*/
        String sql="UPDATE `articulos` SET `CodigoArt`='"+a.getCodigo_articulo()+"',`DescrArt`='"+a.getDescripcion_articulo()+"',`CostoArt`='"+a.getPrecio_articulo()+"',`ImpuestoArt`='"+a.getImpuesto_articulo()+"',`Margen`='"+a.getMargen_articulo()+"',`PvP`='"+a.getPvp_articulo()+"' WHERE `CodigoArt`='"+a.getCodigo_articulo()+"'";
        /*Te sobreescribe eñ articulo que has decidido modificar de la bbdd*/
        boolean aux=true;
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            aux=false;
        }
        return aux;
    }

    static Cliente comprobarCliente(String nif) {
        /*En este metodo, pasandole el nif del cliente, busca en la base de datos si hay algun Cliente que coincida;
         si existe te coge los datos de la bbdd lo convierte en un Objeto Cliente y lo devuelve, si no, te devolveria el objeto null*/
        Cliente a=new Cliente();
        try {
            
            String sql="SELECT * FROM `cliente` WHERE `NIFCliente`='"+nif+"'";
            
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next())
            {
                
                String nif_cliente=rs.getString("NIFCliente");
                String domicilio_cliente=rs.getString("DomicilioCliente");
                String nombre_cliente=rs.getString("NombreCliente");
                
                a.setNIF(nif_cliente);
                a.setDomicilio(domicilio_cliente);
                a.setNombre(nombre_cliente);
                
                return a;
            }
           
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    static boolean meterCliente(Cliente c) {
        /*En este metodo se le pasa el articulo metido por el usuario.
        Se crea un boolean para saber si se ha realizado con exito la consulta*/
        boolean aux=true;
        try {
            String nif=c.getNIF();
            String nombre=c.getNombre();
            String domicilio=c.getDomicilio();
            String sql="INSERT INTO `cliente`(`NIFCliente`, `DomicilioCliente`, `NombreCliente`) VALUES('"+nif+"', '"+domicilio+"','"+nombre+"')";
            /*Te inserta en la bbdd el nuevo cliente introducido*/
            stmt.executeUpdate(sql);
            
        } catch (SQLException ex) {
            aux=false;
            
        }
        return aux;
    }

    static boolean borrarCliente(String nif) {
        /*En este metodo se le pasa el nif del cliente metido por el usuario.
        Se crea un boolean para saber si se ha realizado con exito la consulta*/
        String sql="DELETE FROM `cliente` WHERE `NIFCliente`='"+nif+"'";
        /*Te elimina el cliente con el nif que hayas introducido*/
        boolean aux=true;
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            aux=false;
        }
        return aux;
    }

    
    static boolean updateCliente(Cliente a) {
        /*En este metodo se le pasa el cliente metido por el usuario.
        Se crea un boolean para saber si se ha realizado con exito la consulta*/
        String sql="UPDATE `cliente` SET `NIFCliente`='"+a.getNIF()+"',`DomicilioCliente`='"+a.getDomicilio()+"',`NombreCliente`='"+a.getNombre()+"' WHERE `NIFCliente`='"+a.getNIF()+"'";
        
        /*Te sobreescribe el codigo que has decidido modificar de la bbdd*/
        boolean aux=true;
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            aux=false;
        }
        return aux;
    }

    static Proveedor comprobarProveedor(String cod_pro) {
        Proveedor p=new Proveedor();
        try {
            
            String sql="SELECT * FROM `proveedores` WHERE `id_proveedor`='"+cod_pro+"'";
            
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next())
            {
                String tipo=rs.getString("tipo");
                String nombre=rs.getString("nombre");
                String cif_nif=rs.getString("CIF_NIF");
                String direccion=rs.getString("direccion");
                String localidad=rs.getString("localidad");
                String codigo_postal=rs.getString("codigo_postal");
                String provincia=rs.getString("provincia");
                String telefono=rs.getString("telefono");
                String contacto=rs.getString("contacto");
                String email=rs.getString("email");
                p.setNombre(nombre);
                p.setTipo(tipo);
                p.setCif_nif(cif_nif);
                p.setDireccion(direccion);
                p.setLocalidad(localidad);
                p.setCodigo_postal(codigo_postal);
                p.setProvincia(provincia);
                p.setTelefono(telefono);
                p.setContacto(contacto);
                p.setEmail(email);
                
                return p;
            }
           
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    static boolean meterProveedor(Proveedor p) {
        boolean aux=true;
        try {
            String sql="INSERT INTO `proveedores`(`id_proveedor`, `tipo`, `nombre`, `CIF_NIF`, `direccion`, `localidad`, `codigo_postal`, `provincia`, `telefono`, `contacto`, `email`) VALUES ('"+p.getCodigo()+"','"+p.getTipo()+"','"+p.getNombre()+"','"+p.getCif_nif()+"','"+p.getDireccion()+"','"+p.getLocalidad()+"','"+p.getCodigo_postal()+"','"+p.getProvincia()+"','"+p.getTelefono()+"','"+p.getContacto()+"','"+p.getEmail()+"')";
            /*Te inserta en la bbdd el nuevo cliente introducido*/
            stmt.executeUpdate(sql);
            
        } catch (SQLException ex) {
            aux=false;
            
        }
        return aux;
    }

    static boolean updateProveedor(Proveedor p) {
        String sql="UPDATE `proveedores` SET `id_proveedor`='"+p.getCodigo()+"',`tipo`='"+p.getTipo()+"',`nombre`='"+p.getNombre()+"',`CIF_NIF`='"+p.getCif_nif()+"',`direccion`='"+p.getDireccion()+"',`localidad`='"+p.getLocalidad()+"',`codigo_postal`='"+p.getCodigo_postal()+"',`provincia`='"+p.getProvincia()+"',`telefono`='"+p.getTelefono()+"',`contacto`='"+p.getContacto()+"',`email`='"+p.getEmail()+"' WHERE `id_proveedor`='"+p.getCodigo()+"'";
        
        /*Te sobreescribe el codigo que has decidido modificar de la bbdd*/
        boolean aux=true;
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            aux=false;
        }
        return aux;
    }

    static boolean borrarProveedor(String cod_pro) {
        String sql="DELETE FROM `proveedores` WHERE `id_proveedor`='"+cod_pro+"'";
        /*Te elimina el cliente con el nif que hayas introducido*/
        boolean aux=true;
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            aux=false;
        }
        return aux;
    }
    }

