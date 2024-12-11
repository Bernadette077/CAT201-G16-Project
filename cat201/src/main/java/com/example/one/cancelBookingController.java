package com.example.one;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class cancelBookingController {

    @FXML
    private StackPane SP;
    private String bookingString;
    private int bookingId;
    @FXML
    private Button cancelButton;
    @FXML
    private Label cancelLabel;
    @FXML
    private TextField cancelTextField;
    @FXML
    public void getCancel(ActionEvent event) throws IOException {
             bookingString= cancelTextField.getText();
             if(validate(bookingString)==false){
                  cancelLabel.setText("Invalid characters present!");
             }else{
                 bookingId=Integer.parseInt(bookingString);

                  if(confirm(bookingId)==false){
                      cancelLabel.setText("No Such booking exists!");
                  }else{
                      for (int i = 0; i < BookingController.bookingSet.bookings.size(); i++) {
                          if (bookingId == BookingController.bookingSet.getBookingId(i)) {
                              for(int loop=0;loop<BookingController.bookingSet.getBooking(i).getBookedMachine().size();loop++){
                                  BookingController.bookingSet.MachineFree.add(BookingController.bookingSet.getBooking(i).getBookedMachine().get(loop ));
                                  BookingController.bookingSet.MachineInUse.remove(BookingController.bookingSet.getBooking(i).getBookedMachine().get(loop));

                              }
                              BookingController.bookingSet.removeBooking(bookingId);

                              cancelLabel.setText("Cancel confirmed!");
                          }
                      }
                  }
             }
    }
    public boolean confirm(int num) {
        for (int i = 0; i < BookingController.bookingSet.bookings.size(); i++) {

            if (num==BookingController.bookingSet.getBookingId(i)) {
                return true;
            }
        }
        return false;
    }
    public boolean validate(String str) {
        for(int i=0;i<str.length();i++){
            if (!(Character.isDigit(str.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    @FXML
    private void handleNavigationOne() {
        // Load the dashboard.fxml file and set it as the content of the main StackPane
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            Parent root = loader.load();
            SP.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
