package com.example.one;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {
      private Stage stage;
      private Scene scene;
    // JDBC URL, username, and password of MySQL server
//    String url = "jdbc:oracle:thin:@//localhost:1521/your_database_name";
//    String username = "your_username";
//    String password = "your_password";
//
//    // JDBC variables for opening, closing and managing connection
//    Connection connection = null;
//    Statement statement = null;
//    ResultSet resultSet = null;

      @FXML
      private Label mylabel;

      @FXML
      private TextField textFieldUserName;
      @FXML
      private PasswordField passwordFieldPassword;
       @FXML
       private Button loginButton;
        String username;
        String password;

//    try{
//        // Establish the connection
//        connection = DriverManager.getConnection(url, username, password);
//
//        // Create a statement
//        statement = connection.createStatement();
//
//        // Execute a query
//        resultSet = statement.executeQuery("SELECT * FROM LOGIN");
//
//        while (resultSet.next()) {
//            String username = resultSet.getString("USERNAME");
//            String pwd = resultSet.getString("PWD");
//
//            System.out.println("Username: " + username + ", Password: " + pwd);
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    } finally {
//        // Close the resources
//        try {
//            if (resultSet != null) resultSet.close();
//            if (statement != null) statement.close();
//            if (connection != null) connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public void getUserNamePassword(ActionEvent event) throws IOException{
           username= textFieldUserName.getText();
            password= passwordFieldPassword.getText();

            if(username.equals ("customer") && password.equals("customer")){
//        System.out.println("sadfasdfasdf");
            Parent root =FXMLLoader.load(getClass().getResource("dashboard.fxml"));
            stage= (Stage)((Node)event.getSource()).getScene().getWindow();
                  scene= new Scene(root);
                  stage.setScene(scene);
                  stage.show();
            }else {
                mylabel.setText("Invalid username or Password, hence try again!");

            }
        }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
