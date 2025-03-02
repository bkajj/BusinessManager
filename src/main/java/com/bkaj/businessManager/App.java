package com.bkaj.businessManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class App extends Application {
    private static Stage mainStage;
    private static Connection dbConnection;
    public static void main(String[] args) {
        launch(args);
    }

    public static Connection getDbConnection() {
        return dbConnection;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        connectToDatabase();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Business Manager");
        primaryStage.show();
    }

    private void connectToDatabase() throws ClassNotFoundException, SQLException {
        String databaseUrl = "jdbc:mysql://localhost:3306/business_manager";
        String user = "root";
        String password = "admin";

        dbConnection = DriverManager.getConnection(databaseUrl, user, password);
    }

    public static void changeScene(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        mainStage.setScene(scene);
    }
}