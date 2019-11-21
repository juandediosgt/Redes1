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
    
}
