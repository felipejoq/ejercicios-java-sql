package com.uncodigo.webfiltros.models;

import jakarta.persistence.*;

@Entity
@Table(name = "COLABORADOR")
public class Colaborador {

    @Id
    @Column(name = "rutcolaborador")
    private String rutColaborador;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "primerapellido")
    private String primerApellido;

    @Column(name = "segundoapellido")
    private String segundoApellido;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "comuna")
    private String comuna;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "rol")
    private int rol;

    @ManyToOne
    @JoinColumn(name = "idsucursal")
    private Sucursal sucursal;

    // Getters and setters
    public String getRutColaborador() {
        return rutColaborador;
    }

    public void setRutColaborador(String rutColaborador) {
        this.rutColaborador = rutColaborador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
