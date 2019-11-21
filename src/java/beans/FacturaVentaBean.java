/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dbActions.FacturaCompraDbAction;
import dbActions.FacturaVentaDbAction;
import java.net.ConnectException;
import java.sql.SQLException;
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
 * @author Juan de Dios
 */
public class FacturaVentaBean {
    private int no_factura;
    private String nit;
    private String nombre;
    private String direccion;
    private int producto;
    private int estado;
    private int cantidad;
    
    private SelectItem[] listaProveedor;
    private SelectItem[] listaProductos;
    
    private Date date10;
    private Date dateTimeDe;
    private List<Date> multi;
    private List<Date> range;
    private List<Date> invalidDates;
    private List<Integer> invalidDays;
    private Date minDate;
    private Date maxDate;
    
    private boolean actNoFactura;
    private boolean actNit;
    private boolean actNombre;
    private boolean actDireccion;
    private boolean Estadopro;
    private boolean Estadocant;
    private boolean actFecha;
    

    @PostConstruct
    public void init() {
        this.setEstadocant(true);
        this.setEstadopro(true);
        
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
     * Creates a new instance of FacturaVentaBean
     */
    public FacturaVentaBean() {
         cargarProductos();
    }
    
    public void activarCampos(){
        this.setActNombre(true);
        this.setActNit(true);
        this.setActNoFactura(true);
        this.setActDireccion(true);
        this.setActFecha(true);
        this.setEstadocant(false);
        this.setEstadopro(false);
    }
  
    public void cargarProductos(){
        Catalogos lista = new Catalogos();
        this.listaProductos = lista.cargarProductos();
    }
    
    public String irMenuPrincipal(){
        String resultado="regresar";
        return resultado;
    }

     public void agregarFactura(){
        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formatofecha.format(date10.getTime());
       if(this.getNo_factura()==0 || this.getNit().trim().equals("") || this.getNombre().trim().equals("") || this.getDireccion().trim().equals("") ){
            Messages.warningMessage("Advertencia", "Debe llenar los campos requeridos");
        } else{
            FacturaVentaDbAction user = new FacturaVentaDbAction();
            int resultado =user.ingresarFactura(this.getNo_factura(), fecha,  this.getNit(), this.getNombre(),  this.getDireccion());
            if(resultado == 1){
                Messages.infoMessage("EXITO", "Se ha registrado la factura");
                activarCampos();
            } else{
                Messages.errorMessage("ERROR", "Error al registrar la factura");
            }
        }
    }
     
     public void agregarProducto(){
         try{
       if(this.getProducto()==0 || this.getCantidad()==0 ){
            Messages.warningMessage("Advertencia", "Debe llenar los campos requeridos"+this.getProducto()+this.getCantidad());
        } else{
            FacturaVentaDbAction user = new FacturaVentaDbAction();
            int resultado =user.ingresarProducto(this.getNo_factura(), this.getProducto(), this.getCantidad());
            if(resultado == 1){
                Messages.infoMessage("EXITO", "Producto añadido a su venta");
                this.producto = 0;
                this.cantidad = 0;
            } else{
                Messages.errorMessage("ERROR", "Producto no añadido, no hay suficientes productos");
            }
        }
       } catch(Exception ex){
            ex.printStackTrace();                    
        }    
        }
   
    public void nuevaFactura(){
        this.setActNombre(false);
        this.setActNit(false);
        this.setActNoFactura(false);
        this.setActDireccion(false);
        this.setActFecha(false);
        this.setEstadocant(true);
        this.setEstadopro(true);
        this.nit=null;
        this.nombre=null;
        this.producto=0;
        this.cantidad=0;
        this.direccion=null;
        this.no_factura=0;
    
    }
    
    //Metodos Get Y set
    
    public int getNo_factura() {
        return no_factura;
    }

    public void setNo_factura(int no_factura) {
        this.no_factura = no_factura;
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
        this.minDate = minDate;
    }

    public Date getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
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

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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

    public boolean isActNoFactura() {
        return actNoFactura;
    }

    public void setActNoFactura(boolean actNoFactura) {
        this.actNoFactura = actNoFactura;
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

    public boolean isActFecha() {
        return actFecha;
    }

    public void setActFecha(boolean actFecha) {
        this.actFecha = actFecha;
    }
    
}
