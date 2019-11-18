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
    private String proveedor;
    private int categoria;
    private int id_estado;
    /**
     * Creates a new instance of Producto
     */
    public Producto(  ) {
        
    }
    public Producto(String nombre, String descripcion, float precio_compra, float precio_venta, int cantidad_existencia, String proveedor, int categoria, int id_estado){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.cantidad_existencia = cantidad_existencia;
        this.proveedor = proveedor;
        this.categoria = categoria;
        this.id_estado = id_estado;
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
    
}
