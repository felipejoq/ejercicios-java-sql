package com.uncodigo.webfiltros.services.impl;

import com.uncodigo.webfiltros.models.CategoriaProducto;
import com.uncodigo.webfiltros.repositories.CategoriaProductoRepository;
import com.uncodigo.webfiltros.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    private final CategoriaProductoRepository categoriaProductoRepository;

    public CategoriaServiceImpl(CategoriaProductoRepository categoriaProductoRepository) {
        this.categoriaProductoRepository = categoriaProductoRepository;
    }

    @Override
    public CategoriaProducto obtenerCategoria(Integer idCategoria) {
        return categoriaProductoRepository.findById(idCategoria).orElse(null);
    }

    @Override
    public List<CategoriaProducto> obtenerCategorias() {
        return categoriaProductoRepository.findAll();
    }
}
