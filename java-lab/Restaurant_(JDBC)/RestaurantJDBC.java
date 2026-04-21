import java.sql.Connection;

public class RestaurantJDBC {

    public static void main(String[] args) {

        try (Connection conn = DBConnection.getConnection()) {

            RestaurantDAO rdao = new RestaurantDAO();
            MenuItemDAO mdao = new MenuItemDAO();

            // INSERT DATA
            rdao.insertRestaurants(conn);
            mdao.insertMenuItems(conn);

            // SELECT OPERATIONS
            mdao.selectPriceLessThan100(conn);
            mdao.selectFromCafeJava(conn);

            // UPDATE OPERATION
            mdao.updatePrice(conn);

            // DELETE OPERATION
            mdao.deletePItems(conn);

            // FINAL TABLE
            mdao.printAll(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}