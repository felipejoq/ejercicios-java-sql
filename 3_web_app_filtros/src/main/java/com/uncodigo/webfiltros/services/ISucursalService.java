package com.uncodigo.webfiltros.services;

import com.uncodigo.webfiltros.models.Sucursal;

import java.util.List;

public interface ISucursalService {
    Sucursal obtenerSucursal(Integer idSucursal);
    List<Sucursal> obtenerSucursales();
}
