package com.uncodigo.appconsola.repository;

import com.uncodigo.appconsola.models.Stock;
import com.uncodigo.appconsola.models.StockId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, StockId> {
}
