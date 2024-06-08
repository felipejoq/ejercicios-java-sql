package com.uncodigo.appconsola.service;

public interface IFidelizacionService {
    String determinarNivelFidelizacion(int puntos);
    String obtenerBeneficios(int puntos);
    void mostrarFidelizacionCliente(String rutCliente);
}
