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
public class CambioPasswordDbAction implements Serializable {

    /**
     * Creates a new instance of CambioPasswordDbAction
     */
    public CambioPasswordDbAction() {
    }
     public int cambiarContraseña(String password, String login_name) {
        int result = 0;
        try {
            Connection conn;
            Conexion newConexion = new Conexion();
            conn = newConexion.connect();
            String sql = "UPDATE `proyectoredes`.`usuario` SET `password`='"+password+"' WHERE  `login_name`='"+login_name+"';";
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
