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
                "WHERE ST.stock < 13 " +
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
                    }
                    System.out.println("----------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
