package com.uncodigo.webfiltros.controllers;

import com.uncodigo.webfiltros.models.Producto;
import com.uncodigo.webfiltros.services.ICategoriaService;
import com.uncodigo.webfiltros.services.IStockService;
import com.uncodigo.webfiltros.services.ISucursalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class FilterController {

    private final ICategoriaService categoriaService;
    private final ISucursalService sucursalService;
    private final IStockService stockService;

    public FilterController(ICategoriaService categoriaService, ISucursalService sucursalService, IStockService stockService) {
        this.categoriaService = categoriaService;
        this.sucursalService = sucursalService;
        this.stockService = stockService;
    }

    /*
     * Recibir por params sucursal y categoría para filtrar
     * y obtener los productos y su stock de dicha categoría y sucursal
     */
    @GetMapping("/")
    public String productos(
            @RequestParam(name = "sucursal", required = false, defaultValue = "0") int idSucursal,
            @RequestParam(name = "categoria", required = false, defaultValue = "0") int idCategoria,
            Model model
    ) {
        model.addAttribute("categorias", categoriaService.obtenerCategorias());
        model.addAttribute("sucursales", sucursalService.obtenerSucursales());
        model.addAttribute("idSucursalSeleccionada", idSucursal);
        model.addAttribute("idCategoriaSeleccionada", idCategoria);
        model.addAttribute("productos", stockService.obtenerStockPorCategoriaYSucursal(idCategoria, idSucursal));

        return "index";
    }

}
