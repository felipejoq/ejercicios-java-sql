import database.ConnectionDb;
import stock.IStockService;
import stock.dao.StockDao;
import stock.impl.StockServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        IStockService stockService = new StockServiceImpl(new StockDao(ConnectionDb.getInstance()));

        int option;
        do {
            Scanner scanner = new Scanner(System.in);
            // Menú de opciones de la app
            System.out.println("1. Verificar stock");
            System.out.println("2. Salir");
            System.out.print("Opción: ");
            option = scanner.nextInt();

            try {
                switch (option) {
                    case 1:
                        System.out.println("Verificar stock");
                        System.out.print("Ingrese el número de sucursal: ");
                        int sucursalNumber = scanner.nextInt();
                        System.out.print("Ingrese el ID del producto: ");
                        int productoId = scanner.nextInt();
                        stockService.checkStock(sucursalNumber, productoId);
                        break;
                    case 2:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (option != 10);
    }
}