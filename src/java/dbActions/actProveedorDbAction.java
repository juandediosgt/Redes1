/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbActions;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pojos.Proveedor;
import utils.Conexion;

/**
 *
 * @author Juan de Dios
 */
public class actProveedorDbAction {

    /**
     * Creates a new instance of actProveedorDbAction
     */
    public actProveedorDbAction() {
    }
    
    /**
     *Metodo de  Consulta a BD
     * @param nit
     * @return 
     */
     public Proveedor consultaProveedor(String nit){
        Proveedor resultado = new Proveedor();
        try{
            Connection conn;
            Conexion conexion = new Conexion();
            conn = conexion.connect();
            Statement st = conn.createStatement();
            String sql = "SELECT nit, nombre, direccion, telefono, id_estado from proveedores where nit = '"+nit+"'";
            //st.executeUpdate("insert into usuario values ('"+user+"', '"+pass+"', '"+passEncript+"')");
            ResultSet rs = st.executeQuery(sql);            
            if(rs.next()){
                rs.beforeFirst();
                while(rs.next()){           
                    resultado.setNit(rs.getString("nit"));
                    resultado.setNombre(rs.getString("nombre")); 
                    resultado.setDireccion(rs.getString("direccion"));
                    resultado.setTelefono(rs.getInt("telefono"));
                    resultado.setId_estado(rs.getInt("id_estado"));
                   
                }
            }
            else{
                resultado = null;
            }
        } catch(Exception ex){
            ex.printStackTrace();                    
        }        
        return resultado;
    }
     /**
      * Metodo que hace UPDATE a tabla de proveedores
      * @param nit
      * @param nombre
      * @param direccion
      * @param telefono
      * @param id_estado
      * @return 
      */
     public int actProveedor(String nit, String nombre, String direccion , int telefono, int id_estado) {
        int result = 0;
        try {
            Connection conn;
            Conexion newConexion = new Conexion();
            conn = newConexion.connect();  
            String sql = "UPDATE proveedores SET nombre='"+nombre+"', direccion='"+direccion+"', telefono="+telefono+", id_estado="+id_estado+" where nit='"+nit+"'";
            Statement pst = conn.createStatement();
            int resultado = pst.executeUpdate(sql);
            if (resultado == 1) {
                result = resultado;                
            } else {
                result = resultado;                
            }
        } catch (ConnectException | SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
