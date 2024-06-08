package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDb implements IDatabaseEnvs, IConnectionDb {
    // Singleton para conectarse a la DB
    private static ConnectionDb instance = null;
    private Connection conn = null;

    private ConnectionDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    IDatabaseEnvs.DB_URL,
                    IDatabaseEnvs.DB_USER,
                    IDatabaseEnvs.DB_PASS
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ConnectionDb getInstance() {
        if (instance == null) {
            instance = new ConnectionDb();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    IDatabaseEnvs.DB_URL,
                    IDatabaseEnvs.DB_USER,
                    IDatabaseEnvs.DB_PASS
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
