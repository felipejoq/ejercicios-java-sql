package com.uncodigo.webfiltros.services.impl;

import com.uncodigo.webfiltros.repositories.StockRepository;
import com.uncodigo.webfiltros.services.IStockService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements IStockService {

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public List<Object[]> obtenerStockPorCategoriaYSucursal(int idCategoriaProducto, int idSucursal) {
        return stockRepository.findStockByCategoriaAndSucursal(idCategoriaProducto, idSucursal);
    }
}
