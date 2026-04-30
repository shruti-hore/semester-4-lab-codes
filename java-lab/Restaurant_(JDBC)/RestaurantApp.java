import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;

public class RestaurantApp extends Application {

    private TextArea outputArea;

    @Override
    public void start(Stage stage) {

        // UI Components
        Button insertBtn = new Button("Insert Data");
        Button selectBtn = new Button("Select (Price <=100)");
        Button joinBtn = new Button("Select (Cafe Java)");
        Button updateBtn = new Button("Update Prices");
        Button deleteBtn = new Button("Delete P Items");
        Button showAllBtn = new Button("Show All");

        outputArea = new TextArea();
        outputArea.setPrefHeight(300);

        VBox root = new VBox(10, insertBtn, selectBtn, joinBtn, updateBtn, deleteBtn, showAllBtn, outputArea);
        root.setPadding(new Insets(15));

        // DAO objects
        MenuItemDAO mdao = new MenuItemDAO();
        RestaurantDAO rdao = new RestaurantDAO();

        // Button Actions
        insertBtn.setOnAction(e -> runDB(() -> {
            rdao.insertRestaurants(DBConnection.getConnection());
            mdao.insertMenuItems(DBConnection.getConnection());
            outputArea.setText("Data Inserted Successfully!");
        }));

        selectBtn.setOnAction(e -> runDB(() -> {
            outputArea.setText(getResult(mdao, "PRICE"));
        }));

        joinBtn.setOnAction(e -> runDB(() -> {
            outputArea.setText(getResult(mdao, "JOIN"));
        }));

        updateBtn.setOnAction(e -> runDB(() -> {
            mdao.updatePrice(DBConnection.getConnection());
            outputArea.setText("Prices Updated!");
        }));

        deleteBtn.setOnAction(e -> runDB(() -> {
            mdao.deletePItems(DBConnection.getConnection());
            outputArea.setText("Deleted items starting with P!");
        }));

        showAllBtn.setOnAction(e -> runDB(() -> {
            outputArea.setText(getResult(mdao, "ALL"));
        }));

        stage.setTitle("Restaurant Management System");
        stage.setScene(new Scene(root, 400, 500));
        stage.show();
    }

    // Helper to handle DB execution safely
    private void runDB(DBTask task) {
        try {
            task.execute();
        } catch (Exception ex) {
            outputArea.setText("Error: " + ex.getMessage());
        }
    }

    // Convert DAO results to String (IMPORTANT FIX)
    private String getResult(MenuItemDAO dao, String type) throws Exception {
        Connection conn = DBConnection.getConnection();

        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        java.io.PrintStream ps = new java.io.PrintStream(baos);
        java.io.PrintStream old = System.out;

        System.setOut(ps);

        if (type.equals("PRICE")) dao.selectPriceLessThan100(conn);
        else if (type.equals("JOIN")) dao.selectFromCafeJava(conn);
        else dao.printAll(conn);

        System.out.flush();
        System.setOut(old);

        return baos.toString();
    }

    public static void main(String[] args) {
        launch();
    }

    // Functional interface
    interface DBTask {
        void execute() throws Exception;
    }
}