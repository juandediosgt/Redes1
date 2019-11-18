/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Juan de Dios
 */
public class MenuProductoBean {

    /**
     * Creates a new instance of MenuProductoBean
     */
    public MenuProductoBean() {
    }
    
    public String irNuevoProducto(){
       String resultado="nuevo";
               return resultado;
   }
    public String irConsultarProducto(){
       String resultado="consulta";
               return resultado;
   }
    public String irActualizarProducto(){
       String resultado="actualizar";
               return resultado;
   }
    public String irmenuPrincipal(){
       String resultado="regresar";
               return resultado;
   }
}
