package stock;

public interface IStockService {
    void checkStock(int sucursalNumber, int productoId);
    void checkFidelizacion(String rutCliente);
}
