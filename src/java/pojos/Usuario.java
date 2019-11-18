/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.Date;

/**
 *
 * @author Juan de Dios
 */
public class Usuario {
     private String login_name;
    private String password;
    private String nombre;
    private String apellido;
    private int idEstado;
    private int idRol;
    private Date fechaCreacion;

    /**
     * Creates a new instance of Usuario
     */
    public Usuario() {
    }
    public Usuario(String login_name, String password, String nombre, String apellido, int idEstado, String estadoDescr, int idRol, String rolDescr, Date fechaCreacion) {
        this.login_name = login_name;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idEstado = idEstado;
        this.idRol = idRol;
        this.fechaCreacion = fechaCreacion;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
}
