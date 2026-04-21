import java.sql.*;

public class MenuItemDAO {

    public void insertMenuItems(Connection conn) throws Exception {
        String sql = "INSERT INTO MenuItem (Name, Price, ResId) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        for (int i = 1; i <= 10; i++) {
            ps.setString(1, (i % 2 == 0 ? "Pizza" : "Pasta") + i);
            ps.setDouble(2, i * 50); // mix of <=100 and >100
            ps.setInt(3, 1);
            ps.executeUpdate();
        }
    }

    public void selectPriceLessThan100(Connection conn) throws Exception {
        String sql = "SELECT * FROM MenuItem WHERE Price <= 100";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\nMenu Items (Price <= 100):");
        print(rs);
    }

    public void selectFromCafeJava(Connection conn) throws Exception {
        String sql = "SELECT m.* FROM MenuItem m " +
                     "JOIN Restaurant r ON m.ResId = r.Id " +
                     "WHERE r.Name = 'Cafe Java'";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\nMenu Items in Cafe Java:");
        print(rs);
    }

    public void updatePrice(Connection conn) throws Exception {
        String sql = "UPDATE MenuItem SET Price = 200 WHERE Price <= 100";
        Statement stmt = conn.createStatement();

        int rows = stmt.executeUpdate(sql);
        System.out.println("\nUpdated rows (<=100 -> 200): " + rows);
    }

    public void deletePItems(Connection conn) throws Exception {
        String sql = "DELETE FROM MenuItem WHERE Name LIKE 'P%'";
        Statement stmt = conn.createStatement();

        int rows = stmt.executeUpdate(sql);
        System.out.println("Deleted rows (Name starts with P): " + rows);
    }

    public void printAll(Connection conn) throws Exception {
        String sql = "SELECT * FROM MenuItem";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\nFinal MenuItem Table:");
        print(rs);
    }

    // ---------------- PRINT RESULTSET ----------------
    private void print(ResultSet rs) throws Exception {
        ResultSetMetaData md = rs.getMetaData();
        int cols = md.getColumnCount();

        for (int i = 1; i <= cols; i++) {
            System.out.print(md.getColumnName(i) + "\t");
        }
        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= cols; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
    }
}