package com.uncodigo.appconsola.models;

import java.io.Serializable;
import java.util.Objects;

public class StockId implements Serializable {

    private Integer producto;
    private Integer sucursal;

    public StockId() {
    }

    public StockId(Integer producto, Integer sucursal) {
        this.producto = producto;
        this.sucursal = sucursal;
    }

    // Getters, setters, equals, and hashCode
    public Integer getProducto() {
        return producto;
    }

    public void setProducto(Integer producto) {
        this.producto = producto;
    }

    public Integer getSucursal() {
        return sucursal;
    }

    public void setSucursal(Integer sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockId stockId = (StockId) o;
        return Objects.equals(producto, stockId.producto) && Objects.equals(sucursal, stockId.sucursal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producto, sucursal);
    }
}
