/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojos.Producto;
import pojos.Proveedor;
import utils.Conexion;

/**
 *
 * @author Juan de Dios
 */
public class consultarProveedorBean implements Serializable{

    /**
     * Creates a new instance of consultarProveedorBean
     */
    public consultarProveedorBean() {
    }
    
    public List<Proveedor> listar(){
        List<Proveedor> ListaProveedor = new ArrayList();
                
        try{
            Connection conn;
            Conexion conexion = new Conexion();
            conn = conexion.connect();
            Statement st = conn.createStatement();
            String sql = "SELECT proveedores.nit AS 'NIT', \n" +
                "		 proveedores.nombre AS 'Nombre', \n" +
                "		 proveedores.direccion AS 'Direccion', \n" +
                "		 proveedores.telefono AS 'Telefono' \n" +
                "FROM   	 proveedores, \n" +
                "		 estado\n" +
                "WHERE  proveedores.id_estado = estado.id_estado";
            ResultSet rs = st.executeQuery(sql);            
            if(rs.next()){
                rs.beforeFirst();
                while(rs.next()){ ListaProveedor.add(new Proveedor(rs.getString("Nit"),   
                    rs.getString("Nombre"),
                    rs.getString("Direccion"),
                    rs.getInt("Telefono")));
                    }
            }
            else{
            }
            conn.close();
        } catch(ConnectException | SQLException ex){
            ex.printStackTrace();                    
        }        
        return ListaProveedor;
    }
    
    public String home(){
        return "regresar";
    }
    
}
