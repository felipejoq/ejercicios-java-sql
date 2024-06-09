package com.uncodigo.webfiltros.services.impl;

import com.uncodigo.webfiltros.models.Producto;
import com.uncodigo.webfiltros.repositories.ProductoRepository;
import com.uncodigo.webfiltros.services.IProductoService;

public class ProductoServiceImpl implements IProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto findById(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }
}
