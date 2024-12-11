package com.example.one;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class DisplayInfoController implements Initializable {
    List<String> StringList= new ArrayList<String>();
    @FXML

    private StackPane SP;
    @FXML
    private Button searchButton;
    @FXML
    private TextField searchBar;
    @FXML
    private ListView<String> list;

    @FXML
    public void search(ActionEvent event)throws IOException {

        list.getItems().clear();
        populateStringList();
        list.getItems().addAll(searchList(searchBar.getText(),StringList));
    }
  private List<String> searchList(String searchWords, List<String> listOfStrings){
     List<String> searchWordsArray= Arrays.asList(searchWords.trim().split(" "));
     return listOfStrings.stream().filter(input -> {
         return searchWordsArray.stream().allMatch(word ->
                 input.toLowerCase().contains(word.toLowerCase()));}).collect(Collectors.toList());

  }
  public void populateStringList(){
        StringList.clear();
        for(int id=0;id<BookingController.bookingSet.bookings.size();id++){
            StringList.add(BookingController.bookingSet.bookings.get(id).toString());

        }
  }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       populateStringList();
        list.getItems().addAll(StringList);
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


