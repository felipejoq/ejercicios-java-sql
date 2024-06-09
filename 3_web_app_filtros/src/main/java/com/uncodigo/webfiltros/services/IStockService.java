package com.uncodigo.webfiltros.services;

import java.util.List;

public interface IStockService {
    List<Object[]> obtenerStockPorCategoriaYSucursal(int idCategoriaProducto, int idSucursal);
}
