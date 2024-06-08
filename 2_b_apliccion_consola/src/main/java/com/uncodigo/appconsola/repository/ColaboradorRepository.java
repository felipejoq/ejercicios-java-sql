package com.uncodigo.appconsola.repository;

import com.uncodigo.appconsola.models.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, String> {
}
