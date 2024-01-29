package com.example.rightsville_rental;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;
/*
Rightsville Rental service for CSC 331
Purpose - Mimic a website that provides services for renting various items. Includes payment screena and final confirmation.
Authors - Shane Menzigian, Danny LeCasse, Lauren Wilson, Dowell
This program loads up the front page.
 */

public class Rightsville_Rental extends Application {

    @Override
    public void start(Stage stage) throws Exception { //Takes over the initial loading process
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FrontPageDesign.fxml")));
        // ^ Grabs the fxml page to load
        Scene scene = new Scene(root); //Sets the fxml object to a scene
        stage.setTitle("Front_Page"); //Sets title
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}