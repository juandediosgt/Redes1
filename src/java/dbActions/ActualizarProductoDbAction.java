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

/**
 *
 * @author Juan de Dios
 */
public class ActualizarProductoDbAction {

    /**
     * Creates a new instance of ActualizarProductoDbAction
     */
    public ActualizarProductoDbAction() {
    }
    
    /**
     * metodo para consultar un producto
     * @param nombre
     * @return 
     */
     public Producto consultaProducto(String nombre){
        Producto resultado = new Producto();
        try{
            Connection conn;
            Conexion conexion = new Conexion();
            conn = conexion.connect();
            Statement st = conn.createStatement();
            String sql = "select nombre, descripcion, precio_compra, precio_venta, cantidad_existencia, id_proveedor, id_categoria, id_estado from producto where nombre = '"+nombre+"'";
            //st.executeUpdate("insert into usuario values ('"+user+"', '"+pass+"', '"+passEncript+"')");
            ResultSet rs = st.executeQuery(sql);            
            if(rs.next()){
                rs.beforeFirst();
                while(rs.next()){           
                    resultado.setNombre(rs.getString("nombre"));
                    resultado.setDescripcion(rs.getString("descripcion")); 
                    resultado.setPrecio_venta(rs.getInt("precio_venta"));
                    resultado.setPrecio_compra(rs.getInt("precio_compra"));
                    resultado.setCantidad_existencia(rs.getInt("cantidad_existencia"));
                    resultado.setProveedor(rs.getString("id_proveedor"));
                    resultado.setIdcategoria(rs.getInt("id_categoria"));
                    resultado.setIdestado(rs.getInt("id_estado"));
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
     
      public int actProducto(String nombre, String descripcion, float precio_compra, float precio_venta, int cantidad_existencia, String proveedor, int categoria, int estado) {
        int result = 0;
        try {
            Connection conn;
            Conexion newConexion = new Conexion();
            conn = newConexion.connect();  
            String sql = "UPDATE producto SET descripcion='"+descripcion+"', precio_compra="+precio_compra+", precio_venta="+precio_venta+", cantidad_existencia="+cantidad_existencia+", id_proveedor='"+proveedor+"', id_categoria="+categoria+", id_estado="+estado+" where nombre='"+nombre+"'";
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
