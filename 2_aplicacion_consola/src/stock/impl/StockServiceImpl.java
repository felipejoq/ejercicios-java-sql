package stock.impl;

import database.ConnectionDb;
import stock.IStockService;
import stock.dao.StockDao;

public class StockServiceImpl implements IStockService {

    private StockDao stockDao;

    public StockServiceImpl(StockDao stockDao) {
        this.stockDao = stockDao;
    }

    @Override
    public void checkStock(int sucursalNumber, int productoId) {
        stockDao.checkStock(sucursalNumber, productoId);
    }
}
