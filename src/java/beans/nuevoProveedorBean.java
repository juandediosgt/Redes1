/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dbActions.nuevoProveedorDbAction;
import utils.Messages;

/**
 *
 * @author Juan de Dios
 */
public class nuevoProveedorBean {
     private String nit;
     private String nombre;
     private String direccion;
     private int telefono;
     private int id_estado;
    /**
     * Creates a new instance of nuevoProveedorBean
     */
    public nuevoProveedorBean() {
    }
     /**
     * Metodo que regresa a el menu de producto
     * @return 
     */
     public String irmenuProveedor(){
       String resultado="regresar";
               return resultado;
   }
     
    public void limpiarCampos(){
        this.nit=null;
        this.nombre=null;
        this.direccion=null;
        this.telefono=0;
    }

    public void agregarProveeedor(){
       if(this.getNit().equals("") || this.getNombre().trim().equals("") || this.getTelefono() ==0 || this.getDireccion().trim().equals("") ){
            Messages.warningMessage("Advertencia", "Debe llenar los campos requeridos");
        } else{
            nuevoProveedorDbAction user = new nuevoProveedorDbAction();
            int resultado =user.ingresarProveedor(this.getNit(), this.getNombre(), this.getDireccion(), this.getTelefono());
            if(resultado == 1){
                Messages.infoMessage("EXITO", "Producto ingresado exitosamente");
                limpiarCampos();
            } else{
                Messages.errorMessage("ERROR", "Error al ingresar producto");
            }
        }
    }
     
     //metodos get y set

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }
  
    
     
    
}
