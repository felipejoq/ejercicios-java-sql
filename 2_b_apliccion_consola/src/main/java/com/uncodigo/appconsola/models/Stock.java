package com.uncodigo.appconsola.models;

import jakarta.persistence.*;

@Entity
@Table(name = "stock")
@IdClass(StockId.class)
public class Stock {

    @Id
    @ManyToOne
    @JoinColumn(name = "idproducto")
    private Producto producto;

    @Id
    @ManyToOne
    @JoinColumn(name = "idsucursal")
    private Sucursal sucursal;

    @Column(name = "stock")
    private int stock;

    @ManyToOne
    @JoinColumn(name = "idadministrador")
    private Administrador administrador;

    // Getters and setters
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
}
