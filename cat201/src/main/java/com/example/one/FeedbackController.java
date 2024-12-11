package com.example.one;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FeedbackController {

    private static final Logger LOGGER = Logger.getLogger(FeedbackController.class.getName());

    @FXML
    private StackPane SP;

    @FXML
    private TextField nameField;

    @FXML
    private Label thankYouLabel;

    @FXML
    private Label title;

    @FXML
    private Label name;




    @FXML
    private Label rating;

    @FXML
    private Label review;

    @FXML
    private Label feedbackLabel;

    @FXML
    private ChoiceBox<String> feedbackTypeChoiceBox;

    @FXML
    private Slider ratingSlider;

    @FXML
    private TextArea reviewTextArea;

    @FXML
    private Button submitButton;

    @FXML
    private Label makeAnotherResponseLabel;

    @FXML
    public void initialize() {

        makeAnotherResponseLabel.setVisible(false);
        // Set the items for the feedbackTypeChoiceBox
        ObservableList<String> feedbackOptions = FXCollections.observableArrayList(
                "Service is good",
                "Environment is good",
                "Staff is friendly",
                "Cleanliness is excellent",
                "Value for money",
                "Other"
                // Add more options as needed
        );
        feedbackTypeChoiceBox.setItems(feedbackOptions);
    }



    @FXML
    private void handleSubmitButton(){
        // Handle the submission logic here
        String name = nameField.getText();
        String feedbackType = feedbackTypeChoiceBox.getValue();
        double rating = ratingSlider.getValue();
        String review = reviewTextArea.getText();

        // Process and save the feedback as needed
        System.out.println("Name: " + name);
        System.out.println("Feedback: " + feedbackType);
        System.out.println("Rating: " + rating);
        System.out.println("Review: " + review);

        // Reset the input fields
        nameField.clear();
        feedbackTypeChoiceBox.setValue(null);
        ratingSlider.setValue(0);  // Reset the slider to its initial value
        reviewTextArea.clear();

        submitButton.setDisable(false);
        showThankYouMessage();
        makeAnotherResponseLabel.setVisible(true);

    }

    @FXML
    private void showThankYouMessage() {
        // Set the visibility of the "Thank you" label to true
        thankYouLabel.setVisible(true);
        makeAnotherResponseLabel.setVisible(true);

        // Optionally, you can hide other elements if needed
        nameField.setVisible(false);
        feedbackLabel.setVisible(false);
        feedbackTypeChoiceBox.setVisible(false);
        ratingSlider.setVisible(false);
        reviewTextArea.setVisible(false);
        submitButton.setVisible(false);
        title.setVisible(false);
        name.setVisible(false);
        rating.setVisible(false);
        review.setVisible(false);

    }

    @FXML
    private void handleMakeAnotherResponse() {
        // Reset visibility and clear input fields
        makeAnotherResponseLabel.setVisible(false);
        thankYouLabel.setVisible(false);
        nameField.setVisible(true);
        feedbackLabel.setVisible(true);
        feedbackTypeChoiceBox.setVisible(true);
        ratingSlider.setVisible(true);
        reviewTextArea.setVisible(true);
        submitButton.setVisible(true);
        title.setVisible(true);
        name.setVisible(true);
        rating.setVisible(true);
        review.setVisible(true);
    }

    @FXML
    private void handleNavigationOne() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            Parent root = loader.load();
            SP.getChildren().setAll(root);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error loading FXML file", e);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Unexpected error", e);
        }
    }

}

