package com.example.one;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.io.File;


public class HelloApplication extends Application {



    public static void main(String[] args) {

     launch();

    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CustomerLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Convert file path to URL
        URL imageUrl = new File("D:\\one\\src\\main\\java\\com\\example\\one\\icon.png").toURI().toURL();

        Image icon = new Image(imageUrl.toString());

        stage.setTitle("Login Washi Washi System");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();

    }


}