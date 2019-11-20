/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dbActions.FacturaCompraDbAction;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import utils.Catalogos;
import utils.Messages;

/**
 *
 * @author ardan
 */
public class FacturaCompraBean {
    
    private int nofactura;
    private String proveedor;
    private int producto;
    private int cantidad;
    
    private boolean Estadonofac;
    private boolean Estadonoprov;
    private boolean Estadodate;
    private boolean Estadopro;
    private boolean Estadocant;
    
    private Date date10;
    private Date dateTimeDe;
    private List<Date> multi;
    private List<Date> range;
    private List<Date> invalidDates;
    private List<Integer> invalidDays;
    private Date minDate;
    private Date maxDate;
 
    
    private SelectItem[] listaProveedor;
    private SelectItem[] listaProductos;
    
    @PostConstruct
    public void init() {
        this.setEstadocant(true);
        this.setEstadopro(true);
        cargarProveedor();
        
        invalidDates = new ArrayList<>();
        Date today = new Date();
        invalidDates.add(today);
        long oneDay = 24 * 60 * 60 * 1000;
        for (int i = 0; i < 5; i++) {
            invalidDates.add(new Date(invalidDates.get(i).getTime() + oneDay));
        }
 
        invalidDays = new ArrayList<>();
        invalidDays.add(0); /* the first day of week is disabled */
        invalidDays.add(3);
 
        minDate = new Date(today.getTime() - (365 * oneDay));
        maxDate = new Date(today.getTime() + (365 * oneDay));
 
        date10 = GregorianCalendar.getInstance().getTime();
        dateTimeDe = GregorianCalendar.getInstance().getTime();
        
    }
    /**
     * Creates a new instance of FacturaCompraBean
     */
    public FacturaCompraBean() {
    }
     /**
     * Metodo que carga los proveedores del producto
     */
    public void cargarProveedor(){
        Catalogos lista = new Catalogos();
        listaProveedor = lista.cargarProveedor();
    }
    
    public void cargarProductos(String proveedor){
        Catalogos lista = new Catalogos();
        this.listaProductos = lista.cargarProductos(proveedor);
    }
    
    public void agregarFactura(){
        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formatofecha.format(date10.getTime());
       if(this.getNofactura()==0 || this.getProveedor().trim().equals("") ){
            Messages.warningMessage("Advertencia", "Debe llenar los campos requeridos");
        } else{
            FacturaCompraDbAction user = new FacturaCompraDbAction();
            int resultado =user.ingresarFactura(this.getNofactura(), this.getProveedor(), fecha);
            if(resultado == 1){
                Messages.infoMessage("EXITO", "Se ha registrado la factura");
                cargarProductos(this.getProveedor());
                activarCampos();
            } else{
                Messages.errorMessage("ERROR", "Error al registrar la factura");
            }
        }
    }
    
    public void agregarProducto(){
       if(this.getProducto()==0 || this.getCantidad()==0 ){
            Messages.warningMessage("Advertencia", "Debe llenar los campos requeridos"+this.getProducto()+this.getCantidad());
        } else{
            FacturaCompraDbAction user = new FacturaCompraDbAction();
            int resultado =user.ingresarProducto(this.getNofactura(), this.getProducto(), this.getCantidad());
            if(resultado == 1){
                Messages.infoMessage("EXITO", "Producto añadido");
                this.producto = 0;
                this.cantidad = 0;
            } else{
                Messages.errorMessage("ERROR", "Producto no añadido");
            }
        }
    }
    public void activarCampos(){
        this.setEstadodate(true);
        this.setEstadonofac(true);
        this.setEstadonoprov(true);
        this.setEstadocant(false);
        this.setEstadopro(false);
    }
   
    public void limpiar(){
        this.nofactura = 0;
        this.proveedor=null;
        this.setEstadodate(false);
        this.setEstadonofac(false);
        this.setEstadonoprov(false);
        this.cantidad=0;
        this.producto=0;
        this.setEstadocant(true);
        this.setEstadopro(true);
    }
    
    public String irModuloCompras(){
        return "regresar";
    }

    public int getNofactura() {
        return nofactura;
    }

    public void setNofactura(int nofactura) {
        this.nofactura = nofactura;
    }

    public boolean isEstadonofac() {
        return Estadonofac;
    }

    public void setEstadonofac(boolean Estadonofac) {
        this.Estadonofac = Estadonofac;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public boolean isEstadonoprov() {
        return Estadonoprov;
    }

    public void setEstadonoprov(boolean Estadonoprov) {
        this.Estadonoprov = Estadonoprov;
    }

    public Date getDate10() {
        return date10;
    }

    public void setDate10(Date date10) {
        this.date10 = date10;
    }

    public Date getDateTimeDe() {
        return dateTimeDe;
    }

    public void setDateTimeDe(Date dateTimeDe) {
        this.dateTimeDe = dateTimeDe;
    }

    public List<Date> getMulti() {
        return multi;
    }

    public void setMulti(List<Date> multi) {
        this.multi = multi;
    }

    public List<Date> getRange() {
        return range;
    }

    public void setRange(List<Date> range) {
        this.range = range;
    }

    public List<Date> getInvalidDates() {
        return invalidDates;
    }

    public void setInvalidDates(List<Date> invalidDates) {
        this.invalidDates = invalidDates;
    }

    public List<Integer> getInvalidDays() {
        return invalidDays;
    }

    public void setInvalidDays(List<Integer> invalidDays) {
        this.invalidDays = invalidDays;
    }

    public Date getMinDate() {
        return minDate;
    }

    public void setMinDate(Date minDate) {
        this.minDate = minDate; //
    }

    public Date getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }

    public boolean isEstadodate() {
        return Estadodate;
    }

    public void setEstadodate(boolean Estadodate) {
        this.Estadodate = Estadodate;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public SelectItem[] getListaProveedor() {
        return listaProveedor;
    }

    public void setListaProveedor(SelectItem[] listaProveedor) {
        this.listaProveedor = listaProveedor;
    }

    public SelectItem[] getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(SelectItem[] listaProductos) {
        this.listaProductos = listaProductos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isEstadopro() {
        return Estadopro;
    }

    public void setEstadopro(boolean Estadopro) {
        this.Estadopro = Estadopro;
    }

    public boolean isEstadocant() {
        return Estadocant;
    }

    public void setEstadocant(boolean Estadocant) {
        this.Estadocant = Estadocant;
    }
    
    
    
    
    
    
    
}
