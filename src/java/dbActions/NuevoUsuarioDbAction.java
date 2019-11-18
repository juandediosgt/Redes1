/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbActions;

import java.io.Serializable;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import utils.Conexion;

/**
 *
 * @author Juan de Dios
 */
public class NuevoUsuarioDbAction implements Serializable {

    /**
     * Creates a new instance of NuevoUsuarioDbAction
     */
    public NuevoUsuarioDbAction() {
    }
    
     public int ingresaUsuario(String login_name, String nombre, String apellido) {
        int result = 0;
        try {
            Connection conn;
            Conexion newConexion = new Conexion();
            conn = newConexion.connect();
            String sql = "insert into usuario (login_name, password, nombre, apellido, id_rol, id_estado) values('" + login_name + "', '" + login_name + "', '" + nombre + "', '" + apellido + "', 1 , 1)";
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
