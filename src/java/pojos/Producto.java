/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author Juan de Dios
 */
public class Producto {
    private String nombre;
    private String descripcion;
    private float precio_compra;
    private float precio_venta;
    private int cantidad_existencia;
    private int idproveedor;
    private String proveedor;
    private int idcategoria;
    private String categoria;
    private int idestado;
    private String estado;
    /**
     * Creates a new instance of Producto
     */
    public Producto(  ) {
        
    }
    public Producto(String nombre, String descripcion, float precio_compra, float precio_venta, int cantidad_existencia, int idproveedor, String proveedor, int idcategoria,String categoria, int idestado, String estado){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.cantidad_existencia = cantidad_existencia;
        this.idproveedor = idproveedor;
        this.proveedor = proveedor;
        this.idcategoria = idcategoria;
        this.categoria = categoria;
        this.idestado = idestado;
        this.estado= estado;
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

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }
    
}
