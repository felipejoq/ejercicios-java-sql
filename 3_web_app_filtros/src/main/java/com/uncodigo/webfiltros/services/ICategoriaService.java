package com.uncodigo.webfiltros.services;

import com.uncodigo.webfiltros.models.CategoriaProducto;

import java.util.List;

public interface ICategoriaService {
    CategoriaProducto obtenerCategoria(Integer idCategoria);
    List<CategoriaProducto> obtenerCategorias();
}
