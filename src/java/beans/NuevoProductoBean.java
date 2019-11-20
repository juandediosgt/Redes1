/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dbActions.NuevoProductoDbAction;
import javax.faces.model.SelectItem;
import utils.Catalogos;
import utils.Messages;

/**
 *
 * @author Juan de Dios
 */
public class NuevoProductoBean {
    private String nombre;
    private String descripcion;
    private float precio_compra;
    private float precio_venta;
    private int categoria;
    private int id_estado;
    private String proveedor;
    private SelectItem[] listaProveedor;
    private SelectItem[] listaCategorias;
    
    /**
     * Creates a new instance of NuevoProductoBean
     */
    public NuevoProductoBean() {
    cargarProveedor();
    cargarCategorias();
    }
    /**
     * Metodo que limpia los campos
     */
    public void limpiarCampos(){
        this.nombre=null;
        this.descripcion=null;
        this.precio_compra=0;
        this.precio_venta=0;
        this.proveedor=null;
        this.categoria=0;
    }
    /**
     * Metodo que regresa a el menu de producto
     * @return 
     */
     public String irmenuProducto(){
       String resultado="regresar";
               return resultado;
   }
     /**
     * Metodo que carga los proveedores del producto
     */
    public void cargarProveedor(){
        Catalogos lista = new Catalogos();
        listaProveedor = lista.cargarProveedor();
    }
    /**
     * Metodo que carga las categorias del producto
     */
    public void cargarCategorias(){
        Catalogos lista = new Catalogos();
        listaCategorias = lista.cargarCategorias();
    }
    
    public void agregarProducto(){
            
            
       if(this.getNombre().trim().equals("") || this.getDescripcion().trim().equals("") || this.getPrecio_compra() ==0 || this.getPrecio_venta() ==0 || this.getCategoria() ==0 || this.getProveedor().trim().equals("") ){
            Messages.warningMessage("Advertencia", "Debe llenar los campos requeridos");
        } else{
            NuevoProductoDbAction user = new NuevoProductoDbAction();
            int resultado =user.ingresarProducto(this.getNombre(), this.getDescripcion(), this.getPrecio_venta(), this.getPrecio_compra(), 0, this.getProveedor(), this.getCategoria());
            if(resultado == 1){
                Messages.infoMessage("EXITO", "Producto ingresado exitosamente");
                limpiarCampos();
            } else{
                Messages.errorMessage("ERROR", "Error al ingresar producto");
            }
        }
    }
    
    //get y set

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public SelectItem[] getListaProveedor() {
        return listaProveedor;
    }

    public void setListaProveedor(SelectItem[] listaProveedor) {
        this.listaProveedor = listaProveedor;
    }

    public SelectItem[] getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(SelectItem[] listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }
    
    
}
