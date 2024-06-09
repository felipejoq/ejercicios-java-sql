package com.uncodigo.webfiltros.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "VENTA")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idventa")
    private Integer idVenta;

    @ManyToOne
    @JoinColumn(name = "idsucursal")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "rutcliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idadministrador")
    private Administrador administrador;

    @Column(name = "fecha")
    private Date fecha;

    // Getters and setters
    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
