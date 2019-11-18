/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dbActions.NuevoUsuarioDbAction;
import java.io.Serializable;
import utils.Messages;

    

/**
 *
 * @author Juan de Dios
 */
public class NuevoUsuarioBean implements Serializable {
    private String login_name;
    private String nombre;
    private String apellido;
   
    /**
     * Creates a new instance of NuevoUsuarioBean
     */
    public NuevoUsuarioBean() {
    }
    public String irMenuPrincipal(){
        String resultado="regresar";
        return resultado;
    }
    
    
    public void validarUsuario(){
        if(this.getLogin_name().equals("") || this.getNombre().equals("") || this.getApellido().equals("")){
            Messages.warningMessage("Advertencia", "Debe llenar todos los campos requeridos");
        } else{
            
            NuevoUsuarioDbAction user = new NuevoUsuarioDbAction();
            int resultado = user.ingresaUsuario(this.getLogin_name(), this.getNombre(), this.getApellido());
            if(resultado == 1){
                Messages.infoMessage("EXITO", "Usuario registrado exitosamente");
            } else{
                Messages.errorMessage("ERROR", "Error al guardar el usuario");
            }
            
        }
    }
    
    //METODOS GET Y SET
    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
    
}
