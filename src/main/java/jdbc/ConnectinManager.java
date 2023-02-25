package jdbc;

public class ConnectManager {
    private static final String USER = "postgres";
    private static final String PASSWORD = "$Skobel2804";
    private static final String URL = "jdbc:postgresql://localhost:5432/skypro";

    private ConnectinManager() {

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
