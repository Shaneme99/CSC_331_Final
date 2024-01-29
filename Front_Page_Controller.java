package com.example.rightsville_rental;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/*
Rightsville Rental service for CSC 331
Authors - Shane Menzigian, Danny LeCasse, Lauren Wilson, Dowell
Contains the controls for the front page, which ATM only includes a single button.
 */
public class Front_Page_Controller {
    @FXML
    public void calculatebuttonpress()throws Exception {
        Vehicle_Selection_Controller controller = new Vehicle_Selection_Controller();
        //Opens a new scene
        Stage stage = new Stage();
        Parent root = FXMLLoader.load((getClass().getResource("Vehicle_Selction_Updated.fxml")));
        Scene scene = new Scene(root);
        stage.setTitle("Vehicle Selection");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void returnbutton() throws Exception{
    Vehicle_Return_Controller controller = new Vehicle_Return_Controller();
    controller.showStage();
    }
}



