package com.uncodigo.webfiltros.repositories;


import com.uncodigo.webfiltros.models.Stock;
import com.uncodigo.webfiltros.models.StockId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, StockId> {
    @Query("SELECT s.nombre AS NombreSucursal, p.idProducto, p.nombreProducto AS NombreProducto, cp.nombre AS NombreCategoria, st.stock " +
            "FROM Stock st " +
            "JOIN st.producto p " +
            "JOIN p.categoriaProducto cp " +
            "JOIN st.sucursal s " +
            "WHERE cp.idCategoriaProducto = :idCategoriaProducto " +
            "AND s.idSucursal = :idSucursal ORDER BY st.stock DESC")
    List<Object[]> findStockByCategoriaAndSucursal(@Param("idCategoriaProducto") int idCategoriaProducto, @Param("idSucursal") int idSucursal);
}

