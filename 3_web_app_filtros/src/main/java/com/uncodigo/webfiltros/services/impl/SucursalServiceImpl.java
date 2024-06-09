package com.uncodigo.webfiltros.services.impl;

import com.uncodigo.webfiltros.models.Sucursal;
import com.uncodigo.webfiltros.repositories.SucursalRepository;
import com.uncodigo.webfiltros.services.ISucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalServiceImpl implements ISucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public Sucursal obtenerSucursal(Integer idSucursal) {
        return sucursalRepository.findById(idSucursal).orElse(null);
    }

    @Override
    public List<Sucursal> obtenerSucursales() {
        return sucursalRepository.findAll();
    }
}
