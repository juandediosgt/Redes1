/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojos.Producto;
import utils.Conexion;

/**
 *
 * @author Juan de Dios
 */
public class ConsultarProductoBean {

    /**
     * Creates a new instance of ConsultarProductoBean
     */
    public ConsultarProductoBean() {
    }
    
    public List<Producto> listar(){
        List<Producto> ListaProducto = new ArrayList();
                
        try{
            Connection conn;
            Conexion conexion = new Conexion();
            conn = conexion.connect();
            Statement st = conn.createStatement();
            String sql = "SELECT producto.nombre AS 'Nombre',\n" +
            "producto.descripcion AS 'Descripcion',\n" +
            "producto.precio_compra AS 'Precio_Compra',\n" +
            "producto.precio_venta AS 'Precio_Venta',\n" +
            "producto.cantidad_existencia AS 'Existencia',\n" +
            "proveedores.nombre AS 'Proveedor',\n" +
            "categoria.nombre AS 'Categoria',\n" +
            "estado.descripcion AS 'Estado'\n" +
            "\n" +
            "FROM producto,\n" +
            " proveedores,\n" +
            " categoria,\n" +
            " estado\n" +
            " \n" +
            "WHERE producto.id_proveedor=proveedores.nit\n" +
            "AND producto.id_categoria=categoria.id_categoria\n" +
            "AND producto.id_estado=estado.id_estado\n" +
            "AND producto.id_estado =1";
            ResultSet rs = st.executeQuery(sql);            
            if(rs.next()){
                rs.beforeFirst();
                while(rs.next()){ ListaProducto.add(new Producto(rs.getString("producto.nombre"),   
                    rs.getString("producto.descripcion"),
                    rs.getFloat("producto.precio_compra"),
                    rs.getFloat("producto.precio_venta"),
                    rs.getInt("producto.cantidad_existencia"),
                    rs.getString("producto.id_proveedor"),
                    rs.getInt("producto.id_categoria"),
                    rs.getInt("producto.id_estado")));
                    }
            }
            else{
            }
        } catch(ConnectException | SQLException ex){
            ex.printStackTrace();                    
        }        
        return ListaProducto;
    }
}
