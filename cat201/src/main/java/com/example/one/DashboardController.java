package com.example.one;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML
    private StackPane SP;

    /*public void handleNavigationOne(ActionEvent event) throws  IOException{
          // BP.setCenter(AP)
        SP.getChildren().clear();  // Remove existing children
        SP.getChildren().add(AP);  // Add AP to SP
    }*/

    @FXML
    public void handleNavigationOne(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        SP.getChildren().setAll(root);
    }

    @FXML
    public void handleNavigationTwo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Booking.fxml"));
        SP.getChildren().setAll(root);
    }

    @FXML
    public void handleNavigationThree(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("cancelBooking.fxml"));
        SP.getChildren().setAll(root);
    }

    @FXML
    public void handleNavigationFour(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DisplayInfo.fxml"));
        SP.getChildren().setAll(root);
    }

    @FXML
    public void handleNavigationFive(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("feedback.fxml"));
        SP.getChildren().setAll(root);
    }

    @FXML
    public void handleNavigationSix(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CustomerLogin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    /*
    @FXML
    public void getDate(ActionEvent event){
        LocalDate bookingDate= bookingDatePicker.getValue();
        System.out.println(bookingDate.toString());
    }
    @FXML
    public void getDate2(ActionEvent event){
        LocalDate bookingDate2= bookingDatePicker2.getValue();
        System.out.println(bookingDate2.toString());
    }
    */
}

