package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {

    private static final String url =
            "jdbc:postgresql://ep-calm-breeze-a4iu95vb-pooler.us-east-1.aws.neon.tech/neondb?user=neondb_owner&password=npg_wZO64YtMShay&sslmode=require"; //base de datos prueba
    // si ya todo esta hecho, se puede cambiar por esta "jdbc:postgresql://ep-calm-breeze-a4iu95vb-pooler.us-east-1.aws.neon.tech/educacion?user=neondb_owner&password=npg_wZO64YtMShay&sslmode=require"
    private static final String username = "neondb_owner";
    private static final String password = "npg_wZO64YtMShay";

    private ConnectionDatabase() {}

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}



