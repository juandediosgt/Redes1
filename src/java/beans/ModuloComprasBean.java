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
public class ModuloComprasBean implements Serializable {

    /**
     * Creates a new instance of ModuloComprasBean
     */
    public ModuloComprasBean() {
    }
    public String irMenuPrincipal(){
        String resultado="regresar";
        return resultado;
    }
    public String irProductos(){
        String resultado="producto";
        return resultado;
    }
}
