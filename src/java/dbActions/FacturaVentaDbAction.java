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
import utils.Conexion;

/**
 *
 * @author Juan de Dios
 */
public class FacturaVentaDbAction {

    /**
     * Creates a new instance of FacturaVentaDbAction
     */
    public FacturaVentaDbAction() {
    }
    
     public int ingresarFactura(int nofactura, String fecha, String nit, String nombre, String direccion) {
        int result = 0;
        try {
            Connection conn;
            Conexion newConexion = new Conexion();
            conn = newConexion.connect();
            String sql = "INSERT INTO factura_venta ( no_factura, fecha, nit_comprador, nombre, direccion, id_estado ) VALUES ( "+nofactura+", '"+fecha+"', '"+nit+"', '"+nombre+"', '"+direccion+"', 1  )";
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
     
     public int ingresarProducto(int nofactura, int producto, int cantidad) {
        int result = 0;
        try {
            Connection conn;
            Conexion newConexion = new Conexion();
            conn = newConexion.connect();
            String sql = "INSERT INTO detalleventa ( idFacturaVenta, idProducto, Cantidad) VALUES ("+nofactura+","+producto+", "+cantidad+");";
            Statement pst = conn.createStatement();
            int resultado = pst.executeUpdate(sql);
            if (resultado == 1) {
                result = resultado;
                //vamos a obtener la cantidad del producto y restarle la nueva cantidad que se vendio
                String sql2 = "select cantidad_existencia from producto where id_producto ="+producto;
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql2);
                if(rs.next()){
                rs.beforeFirst();
                    int cantActualizada = 0;
                   while (rs.next()) {
                   cantActualizada = rs.getInt("cantidad_existencia");
                   
                   cantActualizada = cantActualizada - cantidad;
                   }
                   
                   String sql3 = "UPDATE producto SET cantidad_existencia="+cantActualizada+" where id_producto="+producto;
                   Statement st2 = conn.createStatement();
                   int resultado2 = st2.executeUpdate(sql3);
                    if (resultado2 == 1) {         
                     } else {
                               
                     }
                    
            }
            else{
            }
                
                
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
