/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dbActions.indexDbAction;
import java.io.Serializable;
import pojos.Usuario;
import utils.Messages;

/**
 *
 * @author Juan de Dios
 */
public class indexBean  implements Serializable{
    //Atributos de la clase
    private String login_name;
    private String password;
    public static String UserName;
 

    /**
     * Creates a new instance of indexBean
     */
    public indexBean() {
    }
    
    /**
     * Metodo que valida el usuario y el password
     *
     * @return
     */
    public String validarUsuario() {
        String resultado = "";
        Usuario usuarioValidado = new Usuario();
        try {
            if (this.getLogin_name().equals("") || this.getPassword().equals("")) {
                Messages.infoMessage("Mensaje de usuario", "Debe llenar los dos campos obligatoriamente");
            } else {
                indexDbAction dbAction = new indexDbAction();
                usuarioValidado = dbAction.validarUsuario(this.getLogin_name(), this.getPassword());
                if (usuarioValidado != null) {
                    if (usuarioValidado.getIdEstado() != 1) {
                        resultado = "error";
                        Messages.errorMessage("Error", "Usuario inactivo!!!");
                    } else if (usuarioValidado.getLogin_name().equals(usuarioValidado.getPassword())) {
                        resultado = "cambiocontrasena";
                    } else if (usuarioValidado.getIdEstado() == 1 && usuarioValidado.getIdRol() == 1) {
                        resultado = "usuario";
                    } 
                    
                    
                    if(usuarioValidado.getLogin_name().equals(usuarioValidado.getPassword())){
                       UserName = usuarioValidado.getLogin_name();
                       resultado = "cambiocontrasena";
                     }    
                } else {
                        Messages.errorMessage("Error", "Usuario y/o Contraseña incorrectos");
                        resultado = "error"; 
                    }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultado;
    }
 
    
    //metodos get y set
    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
