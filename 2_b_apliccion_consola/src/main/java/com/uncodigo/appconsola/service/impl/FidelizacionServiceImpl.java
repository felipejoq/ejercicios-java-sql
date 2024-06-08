package com.uncodigo.appconsola.service.impl;

import com.uncodigo.appconsola.models.Cliente;
import com.uncodigo.appconsola.repository.ClienteRepository;
import com.uncodigo.appconsola.service.IFidelizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FidelizacionServiceImpl implements IFidelizacionService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public String determinarNivelFidelizacion(int puntos) {
        if (puntos >= 6001) {
            return "Gold";
        } else if (puntos >= 3001) {
            return "Silver";
        } else if (puntos >= 500) {
            return "Inicial";
        } else {
            return "No Aplica";
        }
    }

    @Override
    public String obtenerBeneficios(int puntos) {
        String nivel = determinarNivelFidelizacion(puntos);
        return switch (nivel) {
            case "Gold" -> "· 1 regalo cada 2 compras.\n· Por cada $1000 de compra habrá un 15% de descuento.\n· Regalo especial 1 vez al mes.";
            case "Silver" -> "· 1 regalo cada 4 compras.\n· Por cada $1000 de compra habrá un 15% de descuento.";
            case "Inicial" -> "· 1 regalo cada 4 compras.\n· Por cada $1000 de compra habrá un 10% de descuento.";
            default -> "No tiene beneficios.";
        };
    }

    @Override
    public void mostrarFidelizacionCliente(String rutCliente) {
        Cliente cliente = this.clienteRepository.findById(rutCliente).orElse(null);
        if (cliente != null) {
            String nivel = determinarNivelFidelizacion(cliente.getPuntos());
            String beneficios = obtenerBeneficios(cliente.getPuntos());

            System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getPrimerApellido() + " " + cliente.getSegundoApellido());
            System.out.println("Nivel de Fidelización: " + nivel);
            System.out.println("Beneficios:");
            System.out.println(beneficios);
            System.out.println("--------------------");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
}
