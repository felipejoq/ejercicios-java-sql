package com.uncodigo.webfiltros.services;

import com.uncodigo.webfiltros.models.Producto;

public interface IProductoService {
    Producto findById(Integer id);
}
