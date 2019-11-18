/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dbActions.ActualizarProductoDbAction;
import javax.faces.model.SelectItem;
import utils.Catalogos;
import utils.Messages;
import pojos.Producto;

/**
 *
 * @author Juan de Dios
 */
public class ActualizarProductoBean {
    private String nombre;
    private String descripcion;
    private float precio_compra;
    private float precio_venta;
    private int cantidad_existencia;
    private String proveedor;
    private int categoria;
    private int id_estado;
    private Producto producto;
    private SelectItem[] listaProveedor;
    private SelectItem[] listaCategorias;
    private SelectItem[] listaEstado;
    private boolean actNombre;
    private boolean actDescripcion;
    private boolean actPrecio_compra;
    private boolean actPrecio_venta;
    private boolean actCantidad;
    private boolean actProveedor;
    private boolean actCategoria;
    private boolean actEstado;
    /**
     * Creates a new instance of ActualizarProductoBean
     */
    public ActualizarProductoBean() {
        cargarProveedor();
        cargarEstado();
        cargarCategorias();
        bloquearCampos();
    }
     /**
     * Metodo que regresa a el menu de producto
     * @return 
     */
     public String irmenuProducto(){
       String resultado="atras";
               return resultado;
   }
    /**
     * Metodo que limpia los campos
     */
    public void limpiarCampos(){
        this.nombre=null;
        this.descripcion=null;
        this.precio_compra=0;
        this.precio_venta=0;
        this.cantidad_existencia=0;
        this.proveedor=null;
        this.categoria=0;
        this.id_estado=0;
    }
     /**
     * Metodo que bloquea los campos
     */
    public void bloquearCampos(){
        this.setActNombre(false);
        this.setActDescripcion(true);
        this.setActPrecio_compra(true);
        this.setActPrecio_venta(true);
        this.setActCantidad(true);
        this.setActProveedor(true);
        this.setActCategoria(true);
        this.setActEstado(true);
    }
    /**
     * Metodo que activa los campos
     */
    public void activarCampos(){
        this.setActNombre(true);
        this.setActDescripcion(false);
        this.setActPrecio_compra(false);
        this.setActPrecio_venta(false);
        this.setActCantidad(false);
        this.setActProveedor(false);
        this.setActCategoria(false);
        this.setActEstado(false);
    }
    /**
     * Metodo que limpia los campos
     */
    public void nuevaBusqueda(){
        bloquearCampos();
        this.nombre=null;
        this.descripcion=null;
        this.precio_compra=0;
        this.precio_venta=0;
        this.cantidad_existencia=0;
        this.proveedor=null;
        this.categoria=0;
        this.id_estado=0;
    }
    /**
     * Metodo que carga los proveedores del producto
     */
    public void cargarEstado(){
        Catalogos lista = new Catalogos();
        listaEstado = lista.cargarEstado();
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
    
    /**
     * Metodo que consulta el alumno en funcion del carnet ingresado
     */
    public void consultarProducto(){
        ActualizarProductoDbAction actualizar = new ActualizarProductoDbAction();
        this.producto = actualizar.consultaProducto(this.getNombre());
        if(producto != null){
            activarCampos();
            this.setActNombre(true);
            this.setNombre(producto.getNombre());
            this.setDescripcion(producto.getDescripcion());
            this.setPrecio_venta(producto.getPrecio_venta());
            this.setPrecio_compra(producto.getPrecio_compra());
            this.setCantidad_existencia(producto.getCantidad_existencia());
            this.setProveedor(producto.getProveedor());
            this.setCategoria(producto.getIdcategoria());
            this.setId_estado(producto.getIdestado());
        }else {    
            limpiarCampos();
            Messages.errorMessage("Error", "Alumno no encontrado");
            
        }
    }
    
    /**
     * Metodo que actualiza el producto
     */
     public void ActProducto(){
       if(this.getDescripcion().trim().equals("") || this.getPrecio_compra() ==0 || this.getPrecio_venta() ==0 || this.getCantidad_existencia() ==0 || this.getCategoria() ==0 || this.getProveedor().trim().equals("") || this.getId_estado()==0){
            Messages.warningMessage("Advertencia", "Debe llenar los campos requeridos");
        } else{
            ActualizarProductoDbAction user = new ActualizarProductoDbAction();
            int resultado = user.actProducto(this.getNombre(), this.getDescripcion(), this.getPrecio_compra(), this.getPrecio_venta(), this.getCantidad_existencia(), this.getProveedor(), this.getCategoria(), this.getId_estado());
            if(resultado == 1){
                bloquearCampos();
                limpiarCampos();
                Messages.infoMessage("EXITO", "Producto actualizado exitosamente"); 
            } else{
               
                Messages.errorMessage("ERROR", "Error al actualizar el producto");    
            }
        }
    }
    //get y set

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

    public int getCantidad_existencia() {
        return cantidad_existencia;
    }

    public void setCantidad_existencia(int cantidad_existencia) {
        this.cantidad_existencia = cantidad_existencia;
    }

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

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public boolean isActNombre() {
        return actNombre;
    }

    public void setActNombre(boolean actNombre) {
        this.actNombre = actNombre;
    }

    public SelectItem[] getListaEstado() {
        return listaEstado;
    }

    public void setListaEstado(SelectItem[] listaEstado) {
        this.listaEstado = listaEstado;
    }

    public boolean isActDescripcion() {
        return actDescripcion;
    }

    public void setActDescripcion(boolean actDescripcion) {
        this.actDescripcion = actDescripcion;
    }

    public boolean isActPrecio_compra() {
        return actPrecio_compra;
    }

    public void setActPrecio_compra(boolean actPrecio_compra) {
        this.actPrecio_compra = actPrecio_compra;
    }

    public boolean isActPrecio_venta() {
        return actPrecio_venta;
    }

    public void setActPrecio_venta(boolean actPrecio_venta) {
        this.actPrecio_venta = actPrecio_venta;
    }

    public boolean isActCantidad() {
        return actCantidad;
    }

    public void setActCantidad(boolean actCantidad) {
        this.actCantidad = actCantidad;
    }

    public boolean isActProveedor() {
        return actProveedor;
    }

    public void setActProveedor(boolean actProveedor) {
        this.actProveedor = actProveedor;
    }

    public boolean isActCategoria() {
        return actCategoria;
    }

    public void setActCategoria(boolean actCategoria) {
        this.actCategoria = actCategoria;
    }

    public boolean isActEstado() {
        return actEstado;
    }

    public void setActEstado(boolean actEstado) {
        this.actEstado = actEstado;
    }
    
}
