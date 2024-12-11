package com.example.one;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookingController implements Initializable{

    public AnchorPane AP;
    @FXML
    private StackPane SP;
    private String name,email;
    public static BookingSet bookingSet= new BookingSet();
    private ArrayList<Integer> Machine= new ArrayList<Integer>();

     private Pane view;
    private int numMachine;
    private String [] bookingTypes={"Dry Clean","Wash and Fold","Commercial Service"};
    private String bookType;
    private String numMachineString;
    private String numberString;
    private static int bookingId = 1101;
     @FXML
     private Label confirmation;
    @FXML
    private ChoiceBox<String>  bookingChoiceBox;
    @FXML
    private TextField txtName;
    @FXML
    private Button bookingButton;
    @FXML
    private TextField txtNumMachine;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtPhone;
    @FXML
    private DatePicker bookingDatePicker;
    @FXML
    private DatePicker pickupDatePicker;
    @FXML
     public void  getData(ActionEvent event) {

        name = txtName.getText();
        numMachineString = txtNumMachine.getText();
        numberString = txtPhone.getText();
        email = txtEmail.getText();
        LocalDate bookingDate = bookingDatePicker.getValue();
        LocalDate pickupDate= pickupDatePicker.getValue();
        if (bookingDate == null) {
            confirmation.setText("Please select a drop-off date!");
            return;
        } else if (pickupDate == null) {
            confirmation.setText("Please select a pick-up date!");
            return;
        }

        if (!validateName(name)) {
            confirmation.setText("Please enter only alphabets for name.");
        } else if (!validateNumMachine(numMachineString)) {
            confirmation.setText("Please book 1 to 9 machines for a single booking.");
        } else if (!validatePhone(numberString)) {
            confirmation.setText("Please enter a valid phone number, not more than 10 digits.");
        } else if (bookType == null || bookType.isEmpty()) {
            confirmation.setText("Please select a service type.");
        } else if (!validateEmail(email)) {
            confirmation.setText("Please enter a valid email.");
        } else {
            numMachine = Integer.parseInt(numMachineString);
            for (int i = 0; i < numMachine; i++) {
                Machine.add(bookingSet.MachineFree.get(i));
                bookingSet.MachineInUse.add(bookingSet.MachineFree.get(i));
            }
              bookingSet.populateFreeMachine();

              User u = new User(name,bookingId,numberString,email);
              Booking a=new Booking(bookingId,Machine,u,bookType,bookingDate);
              bookingSet.add(a);
              confirmation.setText("Booking confirmed! Your booking ID is: " + bookingId);
              bookingId++;


          }




           System.out.println(name);
           System.out.println(numMachine);
           System.out.println(email);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bookingChoiceBox.getItems().addAll(bookingTypes);
        bookingChoiceBox.setOnAction(this::getType);

    }

    @FXML
    public void getType(ActionEvent event){
       bookType= bookingChoiceBox.getValue();
       System.out.println(bookType);

    }

    public boolean validateName(String name) {
        // Check if the name is not empty and contains only alphabetic characters
        return !name.isEmpty() && name.matches("^[a-zA-Z]+$");
    }

    public boolean validatePhone(String Phone) {
        // Check if the phone number is not null and has a valid length
        if (Phone == null || Phone.length() == 0 || Phone.length() > 10) {
            return false;
        }

        // Check if all characters in the phone number are digits
        for (char digit : Phone.toCharArray()) {
            if (!Character.isDigit(digit)) {
                return false;
            }
        }

        // Phone number is valid
        return true;
    }

    private boolean validateEmail(String email) {
        // Use a regular expression for a basic email format validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }

    public boolean validateNumMachine(String NumMachine){
          if(NumMachine.length()!=1){
              return false;
          }else{
              if(Character.isDigit(NumMachine.charAt(0))){
                  return true;
              }else{
                  return false;
              }
          }

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
