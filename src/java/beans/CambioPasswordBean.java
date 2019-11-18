/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import dbActions.CambioPasswordDbAction;
import java.io.Serializable;
import pojos.Usuario;
import utils.Messages;
/**
 *
 * @author Juan de Dios
 */
public class CambioPasswordBean implements Serializable{
    private String login_name;
    private String Password;
    private String Comprobacion;
    /**
     * Creates a new instance of CambioPasswordBean
     */
    public CambioPasswordBean() {
    }
     public String cambiarContraseña(){
        String result = "";
        if(this.getPassword().equals("") || this.getComprobacion().equals("")){
            Messages.warningMessage("Advertencia", "Debe llenar los campos requeridos");
        } else if(this.getPassword().equals(this.getComprobacion())){
            CambioPasswordDbAction usuario = new CambioPasswordDbAction ();
            int resultado = usuario.cambiarContraseña(this.getPassword(), indexBean.UserName);
            if(resultado == 1){
                Messages.infoMessage("EXITO", "Cambio de contraseña exitoso, vuelva a iniciar sesión");
                result = "index";
            } else{
                Messages.errorMessage("ERROR", "Error al guardar el usuario");
            }
        }else{
            Messages.warningMessage("Advertencia", "Verifica que la contraseña sea identica");
        }
        return result;
    }
//metodos get y set
    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getComprobacion() {
        return Comprobacion;
    }

    public void setComprobacion(String Comprobacion) {
        this.Comprobacion = Comprobacion;
    }
     
}
