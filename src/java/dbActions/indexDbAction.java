/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbActions;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import pojos.Usuario;
import utils.Conexion;


/**
 *
 * @author Juan de Dios
 */
public class indexDbAction implements Serializable {

    /**
     * Creates a new instance of indexDbAction
     */
    public indexDbAction() {
    }
    
    public Usuario validarUsuario(String UserName, String password){
        Usuario resultado = new Usuario();
        try{
            Connection conn;
            Conexion conexion = new Conexion();
            conn = conexion.connect();
            Statement st = conn.createStatement();
            String sql = "select login_name, password, nombre, apellido, id_estado, id_rol, fecha_creacion from usuario where login_name = '" + UserName + "' and password = '" + password + "'";
            ResultSet rs = st.executeQuery(sql);            
            if(rs.next()){
                rs.beforeFirst();
                while(rs.next()){
                    resultado.setLogin_name(rs.getString("login_name"));
                    resultado.setPassword(rs.getString("password"));
                    resultado.setNombre(rs.getString("nombre"));
                    resultado.setApellido(rs.getString("apellido"));
                    resultado.setIdEstado(rs.getInt("id_estado"));
                    resultado.setIdRol(rs.getInt("id_rol"));
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("SESSION_USER", rs.getString("login_name"));
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("SESSION_ROL", rs.getInt("id_rol"));
                    
 
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
    
    
}
