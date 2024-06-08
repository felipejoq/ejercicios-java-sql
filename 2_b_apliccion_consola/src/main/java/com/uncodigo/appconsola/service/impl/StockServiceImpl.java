package com.uncodigo.appconsola.service.impl;

import com.uncodigo.appconsola.models.Stock;
import com.uncodigo.appconsola.models.StockId;
import com.uncodigo.appconsola.repository.StockRepository;
import com.uncodigo.appconsola.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockServiceImpl implements IStockService {

    @Autowired
    private StockRepository stockRepository;

    public void checkStock(int sucursalNumber, int productoId) {
        Optional<Stock> stockOptional = stockRepository.findById(new StockId(productoId, sucursalNumber));
        if (stockOptional.isPresent()) {
            Stock stock = stockOptional.get();
            if (stock.getStock() < 13) {
                System.out.println(
                        "ALERTA: El stock del producto "
                        + stock.getProducto().getNombreProducto()
                        + " en la sucursal " + stock.getSucursal().getNombre()
                        + " es inferior a 13 unidades."
                );
            } else {
                System.out.println(
                        "El stock del producto "
                                + stock.getProducto().getNombreProducto()
                                + " en la sucursal "
                                + stock.getSucursal().getNombre()
                                + " es suficiente."
                );
            }
        } else {
            System.out.println("No se encontró el producto " + productoId + " en la sucursal " + sucursalNumber + ".");
        }
        System.out.println("----------------------");
    }
}
