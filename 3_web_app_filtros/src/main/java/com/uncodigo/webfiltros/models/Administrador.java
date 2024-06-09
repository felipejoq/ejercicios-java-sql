package com.uncodigo.webfiltros.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ADMINISTRADOR")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idadministrador")
    private Integer idAdministrador;

    @Column(name = "nombre")
    private String nombre;

    // Getters and setters
    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
