package com.uncodigo.appconsola.controller;

import com.uncodigo.appconsola.service.IFidelizacionService;
import com.uncodigo.appconsola.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class MenuOpcionesController {

    @Autowired
    private IStockService stockService;
    @Autowired
    private IFidelizacionService fidelizacionService;

    private Scanner scanner;

    public MenuOpcionesController() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        boolean running = true;

        while (running) {

            System.out.println("Menu de opciones:");
            for (String menuOp : getOpciones()) {
                System.out.println(menuOp);
            }

            System.out.println("Ingrese una opción: ");
            int opt = scanner.nextInt();

            switch (opt) {
                case 1:
                    checkStock(scanner);
                    break;
                case 2:
                    checkFidelizacion(scanner);
                    break;
                case 3:
                    running = false;
                    System.out.println("Terminando la aplicación");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }

    private void checkStock(Scanner scanner) {
        System.out.print("Ingrese el número de sucursal: ");
        int sucursalNumber = scanner.nextInt();
        System.out.print("Ingrese el ID del producto: ");
        int productoId = scanner.nextInt();
        stockService.checkStock(sucursalNumber, productoId);
    }

    private void checkFidelizacion(Scanner scanner) {
        System.out.print("Ingrese el RUT del cliente: ");
        String rutCliente = scanner.next();

        fidelizacionService.mostrarFidelizacionCliente(rutCliente);
    }

    private List<String> getOpciones() {
        return List.of(
                "1. Verificar stock",
                "2. Verificar fidelización",
                "3. Salir"
        );
    }
}
