/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.model.SelectItem;

/**
 *
 * @author Ismael Ruiz
 */
public class Catalogos {

    /**
     * Creates a new instance of Catalogos
     */
    public Catalogos() {
    }
        
    /**
     * Metodo que carga la lista de status
     * @return 
     */
    public SelectItem[] cargarEstado(){
        SelectItem[] options = new SelectItem[]{new SelectItem("-1", "-")};
        try {
            Connection conect;
            Conexion conexion = new Conexion();
            conect = conexion.connect();
            Statement stmt = conect.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM estado";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.last()) {
                int size = rs.getRow();
                rs.beforeFirst();
                options = new SelectItem[size];
            }
            int i = 0;
            while (rs.next()) {
                String id = rs.getString("id_estado");
                String descr = rs.getString("descripcion");
                SelectItem d = new SelectItem();
                d.setValue(id);
                d.setLabel(descr);
                options[i] = d;
                i++;
            }
            conect.close();
        } catch (ConnectException | SQLException ex) {
            System.out.println("ERROR AL CARGAR LA LISTA");
        }
        return options;
    }
    
    /**
     * Metodo que carga la lista de roles
     * @return 
     */
    public SelectItem[] cargarRoles(){
        SelectItem[] options = new SelectItem[]{new SelectItem("-1", "-")};
        try {
            Connection conect;
            Conexion conexion = new Conexion();
            conect = conexion.connect();
            Statement stmt = conect.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select id_rol, descripcion from rol where id_estado = 1";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.last()) {
                int size = rs.getRow();
                rs.beforeFirst();
                options = new SelectItem[size];
            }
            int i = 0;
            while (rs.next()) {
                String id = rs.getString("id_rol");
                String descr = rs.getString("descripcion");
                SelectItem d = new SelectItem();
                d.setValue(id);
                d.setLabel(descr);
                options[i] = d;
                i++;
            }
            conect.close();
        } catch (ConnectException | SQLException ex) {
            System.out.println("ERROR AL CARGAR LA LISTA");
        }
        return options;
    }
  
     public SelectItem[] cargarProductos() {
        SelectItem[] options = new SelectItem[]{new SelectItem("-1", "-")};
        try {
            Connection conect;
            Conexion conexion = new Conexion();
            conect = conexion.connect();
            Statement stmt = conect.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select id_producto, nombre from producto where id_estado = 1";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.last()) {
                int size = rs.getRow();
                rs.beforeFirst();
                options = new SelectItem[size];
            }
            int i = 0;
            while (rs.next()) {
                String id = rs.getString("id_producto");
                String descr = rs.getString("nombre");
                SelectItem d = new SelectItem();
                d.setValue(id);
                d.setLabel(descr);
                options[i] = d;
                i++;
            }
            conect.close();
        } catch (ConnectException | SQLException ex) {
            System.out.println("ERROR AL CARGAR LA LISTA");
        }
        return options;
    }
    
    public SelectItem[] cargarProductos(String proveedor) {
        SelectItem[] options = new SelectItem[]{new SelectItem("-1", "-")};
        try {
            Connection conect;
            Conexion conexion = new Conexion();
            conect = conexion.connect();
            Statement stmt = conect.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select id_producto, nombre from producto where id_estado = 1 and id_proveedor='"+proveedor+"'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.last()) {
                int size = rs.getRow();
                rs.beforeFirst();
                options = new SelectItem[size];
            }
            int i = 0;
            while (rs.next()) {
                String id = rs.getString("id_producto");
                String descr = rs.getString("nombre");
                SelectItem d = new SelectItem();
                d.setValue(id);
                d.setLabel(descr);
                options[i] = d;
                i++;
            }
            conect.close();
        } catch (ConnectException | SQLException ex) {
            System.out.println("ERROR AL CARGAR LA LISTA");
        }
        return options;
    }
    
    public SelectItem[] cargarAreas() {
        SelectItem[] options = new SelectItem[]{new SelectItem("-1", "-")};
        try {
            Connection conect;
            Conexion conexion = new Conexion();
            conect = conexion.connect();
            Statement stmt = conect.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select id_area, descripcion from area where id_estado = 1 ";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.last()) {
                int size = rs.getRow();
                rs.beforeFirst();
                options = new SelectItem[size];
            }
            int i = 0;
            while (rs.next()) {
                String id = rs.getString("id_area");
                String descr = rs.getString("descripcion");
                SelectItem d = new SelectItem();
                d.setValue(id);
                d.setLabel(descr);
                options[i] = d;
                i++;
            }
            conect.close();
        } catch (ConnectException | SQLException ex) {
            System.out.println("ERROR AL CARGAR LA LISTA");
        }
        return options;
    }
    
    /**
     * Metodo que carga la lista de proveedores
     * @return 
     */
    public SelectItem[] cargarProveedor(){
        SelectItem[] options = new SelectItem[]{new SelectItem("-1", "-")};
        try {
            Connection conect;
            Conexion conexion = new Conexion();
            conect = conexion.connect();
            Statement stmt = conect.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select nit, nombre from proveedores where id_estado = 1";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.last()) {
                int size = rs.getRow();
                rs.beforeFirst();
                options = new SelectItem[size];
            }
            int i = 0;
            while (rs.next()) {
                String id = rs.getString("nit");
                String descr = rs.getString("nombre");
                SelectItem d = new SelectItem();
                d.setValue(id);
                d.setLabel(descr);
                options[i] = d;
                i++;
            }
            conect.close();
        } catch (ConnectException | SQLException ex) {
            System.out.println("ERROR AL CARGAR LA LISTA");
        }
        return options;
    }
    /**
     * Metodo que carga la lista de categorias
     * @return 
     */
    public SelectItem[] cargarCategorias(){
        SelectItem[] options = new SelectItem[]{new SelectItem("-1", "-")};
        try {
            Connection conect;
            Conexion conexion = new Conexion();
            conect = conexion.connect();
            Statement stmt = conect.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select id_categoria, nombre from categoria where id_estado = 1";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.last()) {
                int size = rs.getRow();
                rs.beforeFirst();
                options = new SelectItem[size];
            }
            int i = 0;
            while (rs.next()) {
                String id = rs.getString("id_categoria");
                String descr = rs.getString("nombre");
                SelectItem d = new SelectItem();
                d.setValue(id);
                d.setLabel(descr);
                options[i] = d;
                i++;
            }
            conect.close();
        } catch (ConnectException | SQLException ex) {
            System.out.println("ERROR AL CARGAR LA LISTA");
        }
        return options;
    }
}
