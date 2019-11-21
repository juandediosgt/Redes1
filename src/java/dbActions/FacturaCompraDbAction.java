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
import pojos.Producto;
import utils.Conexion;
import utils.Messages;

/**
 *
 * @author ardan
 */
public class FacturaCompraDbAction {

    /**
     * Creates a new instance of FacturaCompraDbAction
     */
    public FacturaCompraDbAction() {
    }
    
    public int ingresarFactura(int nofactura, String proveedor, String fecha) {
        int result = 0;
        try {
            Connection conn;
            Conexion newConexion = new Conexion();
            conn = newConexion.connect();
            String sql = "INSERT INTO factura_compra (`no_factura`, `id_proveedor`, `fecha`, `id_estado`) VALUES ("+nofactura+", '"+proveedor+"', '"+fecha+"', '1')";
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
            String sql = "insert into detalleventa(`idFacturaVenta`, `idProducto`, `cantidad`) VALUES ("+nofactura+", '"+producto+"', '"+cantidad+"')";
            Statement pst = conn.createStatement();
            int resultado = pst.executeUpdate(sql);
            if (resultado == 1) {
                result = resultado;
                //vamos a obtener la cantidad del producto y sumarla la nueva cantiddad que se compro
                String sql2 = "select cantidad_existencia from producto where id_producto ="+producto;
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql2);
                if(rs.next()){
                rs.beforeFirst();
                    int cantActualizada = 0;
                   while (rs.next()) {
                   cantActualizada = rs.getInt("cantidad_existencia");
                   
                   cantActualizada = cantActualizada + cantidad;
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
