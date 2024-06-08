package stock.dao;

import database.IConnectionDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StockDao {

    private IConnectionDb conn;

    public StockDao(IConnectionDb conn) {
        this.conn = conn;
    }

    public void checkStock(int sucursalNumber, int productoId) {
        String query = "SELECT S.nombre AS NombreSucursal, " +
                "P.idProducto, P.nombreProducto AS NombreProducto, " +
                "ST.stock " +
                "FROM stock ST " +
                "JOIN SUCURSAL S ON ST.idSucursal = S.idSucursal " +
                "JOIN PRODUCTO P ON ST.idProducto = P.idProducto " +
                "AND ST.idSucursal = ? " +
                "AND ST.idProducto = ?";

        try (Connection connection = conn.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setInt(1, sucursalNumber);
            pstmt.setInt(2, productoId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String nombreSucursal = rs.getString("NombreSucursal");
                    int idProducto = rs.getInt("idProducto");
                    String nombreProducto = rs.getString("NombreProducto");
                    int stock = rs.getInt("stock");

                    System.out.println("Sucursal: " + nombreSucursal);
                    System.out.println("ID Producto: " + idProducto);
                    System.out.println("Nombre Producto: " + nombreProducto);
                    System.out.println("Stock: " + stock);
                    if (stock < 13) {
                        System.out.println("ALERTA: Este producto tiene menos de 13 unidades en stock");
                    } else {
                        System.out.println("INFO: Stock de producto dentro de lo normal (13 o más unidades)");
                    }
                    System.out.println("----------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Implementar un algoritmo que permite determinar en qué nivel de fidelización se
     * encuentra un cliente en base a la siguiente tabla:
     */

    public String getNivelFidelizacion(int puntos) {
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

    public String getBeneficios(int puntos) {
        String nivel = getNivelFidelizacion(puntos);
        switch (nivel) {
            case "Gold":
                return "· 1 regalo cada 2 compras.\n· Por cada $1000 de compra habrá un 15% de descuento.\n· Regalo especial 1 vez al mes.";
            case "Silver":
                return "· 1 regalo cada 4 compras.\n· Por cada $1000 de compra habrá un 15% de descuento.";
            case "Inicial":
                return "· 1 regalo cada 4 compras.\n· Por cada $1000 de compra habrá un 10% de descuento.";
            default:
                return "No tiene beneficios.";
        }
    }

    public void checkFidelizacion(String rutCliente) {
        String query = "SELECT nombre, primerApellido, segundoApellido, puntos FROM CLIENTE WHERE rutCliente = ?";

        try (Connection connection = conn.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, rutCliente);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    String primerApellido = rs.getString("primerApellido");
                    String segundoApellido = rs.getString("segundoApellido");
                    int puntos = rs.getInt("puntos");

                    String nivel = getNivelFidelizacion(puntos);
                    String beneficios = getBeneficios(puntos);

                    System.out.println("Cliente: " + nombre + " " + primerApellido + " " + segundoApellido);
                    System.out.println("Nivel de Fidelización: " + nivel);
                    System.out.println("Beneficios: ");
                    System.out.println(beneficios);
                } else {
                    System.out.println("Cliente no encontrado.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
