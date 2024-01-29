package com.example.rightsville_rental;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class Vehicle_Return_Controller {

    Vehicle_Return_Controller returnController;
    private final Stage thisStage;
    @FXML
    private Button ButtonConfirm;

    @FXML
    private CheckBox Rent_Check1;

    @FXML
    private CheckBox Rent_Check2;

    @FXML
    private CheckBox Rent_Check3;

    @FXML
    private CheckBox Rent_Check4;

    @FXML
    private CheckBox Rent_Check5;

    @FXML
    private RadioButton goodjet;

    @FXML
    private RadioButton goodkayak;

    @FXML
    private RadioButton goodpaddle;

    @FXML
    private RadioButton goodsnorkel;

    @FXML
    private RadioButton goodsurf;

    @FXML
    private RadioButton poorjet;

    @FXML
    private RadioButton poorkayak;

    @FXML
    private RadioButton poorsnorkel;

    @FXML
    private RadioButton poorpaddle;
    @FXML
    private RadioButton poorsurf;

    public Vehicle_Return_Controller(){
        thisStage = new Stage();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Vehicle_Return.fxml"));
            loader.setController(this);
            thisStage.setScene(new Scene(loader.load()));
            thisStage.setTitle("Return Vehicle");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void showStage(){thisStage.showAndWait();}
    public void initialize(){
        initial_check(Rent_Check1, goodkayak,poorkayak,0);
        initial_check(Rent_Check2,goodsurf,poorsurf,1);
        initial_check(Rent_Check3,goodpaddle,poorpaddle,2);
        initial_check(Rent_Check4, goodjet,poorjet,3);
        initial_check(Rent_Check5,goodsnorkel,poorsnorkel,4);
        ButtonConfirm.setOnAction(event -> return_vehicles());
    }
    public void initial_check(CheckBox box, RadioButton good, RadioButton poor,int coord){
        if(Vehicle_Selection_Controller.in_stock[coord]){
            box.setDisable(true);
            good.setDisable(true);
            poor.setDisable(true);
        }else{
        box.selectedProperty().addListener(new ChangeListener<Boolean>() {
            //^ Checks what happens if checkbox is selected
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                Vehicle_Selection_Controller.in_stock[coord] = !box.isSelected() || !poor.isSelected();

            }
        });
    }}
    public void return_vehicles(){
        thisStage.close();
    }
}
