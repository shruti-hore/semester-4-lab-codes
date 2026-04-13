import java.sql.*;

public class RestaurantManager {
    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            // 1. CREATE TABLES
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Restaurant (" +
                    "id INT PRIMARY KEY, name VARCHAR(50), address VARCHAR(100))");
            
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Menu (" +
                    "id INT PRIMARY KEY, name VARCHAR(50), price DOUBLE, " +
                    "res_id INT, FOREIGN KEY (res_id) REFERENCES Restaurant(id))");
            System.out.println("Tables created.");

            // 2. INSERT 10 RECORDS (Simplified batch example)
            // Note: In a real lab, you'd loop or add 10 unique strings.
            for (int i = 1; i <= 10; i++) {
                stmt.executeUpdate("INSERT IGNORE INTO Restaurant VALUES (" + i + ", 'Res_" + i + "', 'Street " + i + "')");
                stmt.executeUpdate("INSERT IGNORE INTO Menu VALUES (" + i + ", 'Dish_" + i + "', " + (i * 20) + ", " + i + ")");
            }
            // Manually add one starting with 'P' for the delete test
            stmt.executeUpdate("INSERT IGNORE INTO Menu VALUES (11, 'Pizza', 90, 1)");
            System.out.println("Data inserted.");

            // 3. SELECT: Price <= 100
            System.out.println("\n--- Items with Price <= 100 ---");
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM Menu WHERE price <= 100");
            while (rs1.next()) {
                System.out.println(rs1.getString("name") + " - " + rs1.getDouble("price"));
            }

            // 4. SELECT: By Restaurant Name (Join)
            String targetRes = "Res_1";
            System.out.println("\n--- Menu at " + targetRes + " ---");
            ResultSet rs2 = stmt.executeQuery("SELECT M.name FROM Menu M JOIN Restaurant R " +
                                             "ON M.res_id = R.id WHERE R.name = '" + targetRes + "'");
            while (rs2.next()) {
                System.out.println(rs2.getString("name"));
            }

            // 5. UPDATE: Price <= 100 to 200
            int updatedRows = stmt.executeUpdate("UPDATE Menu SET price = 200 WHERE price <= 100");
            System.out.println("\n[UPDATE] Rows affected: " + updatedRows);

            // 6. DELETE: Name starting with 'P'
            int deletedRows = stmt.executeUpdate("DELETE FROM Menu WHERE name LIKE 'P%'");
            System.out.println("[DELETE] Rows affected: " + deletedRows);

        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }
}