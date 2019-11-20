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
public class ModuloVentasBean implements Serializable{

    /**
     * Creates a new instance of ModuloVentasBean
     */
    public ModuloVentasBean() {
    }
    public String irMenuPrincipal(){
        String resultado="regresar";
        return resultado;
    }
    public String menuProducto(){
        String resultado="producto";
        return resultado;
    }
    public String facturaVenta(){
        String resultado="venta";
        return resultado;
    }
    
}
