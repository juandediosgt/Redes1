/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dbActions.ActualizarProductoDbAction;
import dbActions.actProveedorDbAction;
import javax.faces.model.SelectItem;
import pojos.Proveedor;
import utils.Catalogos;
import utils.Messages;

/**
 *
 * @author Juan de Dios
 */
public class actProveedorBean {
    private String nit;
    private String nombre;
    private String direccion;
    private int telefono;
    private int id_estado;
    private SelectItem[] listaEstado;
    private boolean actNit;
    private boolean actNombre;
    private boolean actDireccion;
    private boolean actTelefono;
    private boolean actId_estado;
    private Proveedor proveedor; 
    /**
     * Creates a new instance of actProveedorBean
     */
    public actProveedorBean() {
        cargarEstado();
        bloquearCampos();
    }
    /**
     * Metodo que regresa a el menu de producto
     * @return 
     */
     public String irmenuProveedor(){
       String resultado="regresar";
               return resultado;
   }
     /**
     * Metodo que bloquea los campos
     */
    public void bloquearCampos(){
        this.setActNit(false);
        this.setActNombre(true);
        this.setActDireccion(true);
        this.setActTelefono(true);
        this.setActId_estado(true);
    }
     /**
     * Metodo que activa los campos
     */
    public void activarCampos(){
        this.setActNit(true);
        this.setActNombre(false);
        this.setActDireccion(false);
        this.setActTelefono(false);
        this.setActId_estado(false);
    }
    /**
     * Metodo que limpia los campos
     */
    public void nuevaBusqueda(){
        bloquearCampos();
        this.nit=null;
        this.nombre=null;
        this.direccion=null;
        this.telefono=0;
        this.id_estado=0;
    }
    /**
     * Metodo que carga los proveedores del producto
     */
    public void cargarEstado(){
        Catalogos lista = new Catalogos();
        listaEstado = lista.cargarEstado();
    }
    public void limpiarCampos(){
        this.nit=null;
        this.nombre=null;
        this.direccion=null;
        this.telefono=0;
        this.id_estado=0;
    }
    
     /**
     * Metodo que consulta el alumno en funcion del carnet ingresado
     */
    public void consultarProveedor(){
        actProveedorDbAction actualizar = new actProveedorDbAction();
        this.proveedor = actualizar.consultaProveedor(this.getNit());
        if(proveedor != null){
            activarCampos();
            this.setActNit(true);
            this.setNit(proveedor.getNit());
            this.setNombre(proveedor.getNombre());
            this.setDireccion(proveedor.getDireccion());
            this.setTelefono(proveedor.getTelefono());
            this.setId_estado(proveedor.getId_estado());
        }else {    
            limpiarCampos();
            Messages.errorMessage("Error", "Alumno no encontrado");
            
        }
    }
        
    /**
     * Metodo que actualiza el producto
     */
     public void actProveedor(){
         try{
       if(this.getNit().equals("") || this.getNombre().trim().equals("") || this.getTelefono() ==0 || this.getDireccion().trim().equals("")){
            Messages.warningMessage("Advertencia", "Debe llenar los campos requeridos");
        } else{
            actProveedorDbAction user = new actProveedorDbAction();
            int resultado = user.actProveedor(this.getNit(), this.getNombre(), this.getDireccion(), this.getTelefono(), this.getId_estado());
            if(resultado == 1){
                bloquearCampos();
                limpiarCampos();
                Messages.infoMessage("EXITO", "Producto actualizado exitosamente"); 
            } else{
               
                Messages.errorMessage("ERROR", "Error al actualizar el producto");    
            }
        }
        }catch
            (Exception ex){
            ex.printStackTrace();{
    }
    }
    }
    
    //METODOS GET Y SET
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

    public SelectItem[] getListaEstado() {
        return listaEstado;
    }

    public void setListaEstado(SelectItem[] listaEstado) {
        this.listaEstado = listaEstado;
    }

    public boolean isActNit() {
        return actNit;
    }

    public void setActNit(boolean actNit) {
        this.actNit = actNit;
    }

    public boolean isActNombre() {
        return actNombre;
    }

    public void setActNombre(boolean actNombre) {
        this.actNombre = actNombre;
    }

    public boolean isActDireccion() {
        return actDireccion;
    }

    public void setActDireccion(boolean actDireccion) {
        this.actDireccion = actDireccion;
    }

    public boolean isActTelefono() {
        return actTelefono;
    }

    public void setActTelefono(boolean actTelefono) {
        this.actTelefono = actTelefono;
    }

    public boolean isActId_estado() {
        return actId_estado;
    }

    public void setActId_estado(boolean actId_estado) {
        this.actId_estado = actId_estado;
    }
    
    
}
