package com.example.rightsville_rental;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
/*
Rightsville Rental service for CSC 331
Authors - Shane Menzigian, Danny LeCasse, Lauren Wilson, Dowell
Controls the site for gathering user information for final checkout.
 */

public class PersonInfo_Controller {
    private final Stage thisStage;
    private final Vehicle_Selection_Controller vehicle_controller; //Grabs vehicle selection controller to pass to final page
    @FXML
    private TextField CardCRN;
    @FXML
    private TextField CardEXP;
    @FXML
    private TextField CardNumber;
    @FXML
    private TextField City;
    @FXML
    private Button ConfirmSelection;
    @FXML
    private TextField DaysRented;
    @FXML
    private TextField FirstName;
    @FXML
    private TextField LastName;
    @FXML
    private TextField MidName;
    @FXML
    private TextField State;
    @FXML
    private TextField Street;
    @FXML
    private TextField ZipCode;

    @FXML
    private void initialize() {
        ConfirmSelection.setOnAction(event -> openFinalContract());
    }//Sets the button
    public PersonInfo_Controller(Vehicle_Selection_Controller vehicle_controller){
        //Contstructor method for site
        this.vehicle_controller = vehicle_controller;
        thisStage = new Stage();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PersonInfoUpdated.fxml"));
            loader.setController(this);
            thisStage.setScene(new Scene(loader.load()));
            thisStage.setTitle("Enter Info");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void openFinalContract(){;
        if(DaysRented.getText().isEmpty()){
            DaysRented.selectAll();
            DaysRented.requestFocus();
        }else {
        Final_Contract_Page_Controller final_controller = new Final_Contract_Page_Controller(this, vehicle_controller);
        final_controller.showStage();
        close();}
    }
    public void showStage(){
        thisStage.showAndWait();
    }

    public UserInfo getEnteredText(){
        return new UserInfo(FirstName.getText(),MidName.getText(),LastName.getText(),Street.getText(),City.getText(),State.getText(),
        ZipCode.getText(),CardNumber.getText(),CardEXP.getText(),CardCRN.getText(), DaysRented.getText());}
    public void close(){
        Stage stage1 = (Stage) ConfirmSelection.getScene().getWindow();
        stage1.close();
    }
}

