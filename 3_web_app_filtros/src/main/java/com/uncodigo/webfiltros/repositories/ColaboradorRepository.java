package com.uncodigo.webfiltros.repositories;


import com.uncodigo.webfiltros.models.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, String> {
}
