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
import java.text.SimpleDateFormat;
import utils.Conexion;

/**
 *
 * @author Juan de Dios
 */
public class NuevoProductoDbAction {

    /**
     * Creates a new instance of NuevoProductoDbAction
     */
    public NuevoProductoDbAction() {
    }
    
    /**
     * 
     * @param nombre
     * @param descripcion
     * @param precio_compra
     * @param precio_venta
     * @param cantidad_existencia
     * @param id_proveedor
     * @param id_categoria
     * @return 
     */
    public int ingresarProducto(String nombre, String descripcion, float precio_compra, float precio_venta, int cantidad_existencia, String id_proveedor, int id_categoria) {
        int result = 0;
        try {
            
            Connection conn;
            Conexion newConexion = new Conexion();
            conn = newConexion.connect();
            String sql = "insert into producto(nombre, descripcion, precio_venta, precio_compra,  cantidad_existencia, id_proveedor, id_categoria, id_estado) values('"+nombre+"', '"+descripcion+"',"+precio_compra+","+precio_venta+","+cantidad_existencia+",'"+id_proveedor+"', "+id_categoria+", 1)";
            Statement pst = conn.createStatement();
            int resultado = pst.executeUpdate(sql);
            if (resultado == 1) {
                result = resultado;                
            } else {
                result = resultado;                
            }
            conn.close();
        } catch (ConnectException | SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
