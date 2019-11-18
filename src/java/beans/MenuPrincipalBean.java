/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author Juan de Dios
 */
public class MenuPrincipalBean implements Serializable {

    /**
     * Creates a new instance of MenuPrincipalBean
     */
    public MenuPrincipalBean() {
    }
    
   public String irCompras(){
       String resultado="compras";
               return resultado;
   }
    public String irventas(){
        String resultado = "ventas";
        return resultado;
    }
    public String nuevoUsuario(){
        String resultado="nuevoUsuario";
        return resultado;
    }
     public String cerrarSesion(){
        String resultado="Cerrar";
        return resultado;
    }
}
