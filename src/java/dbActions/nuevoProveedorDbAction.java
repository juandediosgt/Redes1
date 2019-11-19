/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbActions;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import utils.Conexion;


/**
 *
 * @author Juan de Dios
 */
public class nuevoProveedorDbAction { 
    

    /**
     * Creates a new instance of nuevoProveedorDbAction
     */
    public nuevoProveedorDbAction() {
    }
    
    public int ingresarProveedor(String nit, String nombre, String direccion , int telefono) {
        int result = 0;
        try {
            Connection conn;
            Conexion newConexion = new Conexion();
            conn = newConexion.connect();
            String sql = "INSERT INTO proveedores(nit, nombre, direccion, telefono, id_estado) VALUES ('"+nit+"','"+nombre+"', '"+direccion+"',"+telefono+", 1 )";
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
