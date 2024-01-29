package com.example.rightsville_rental;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
/*
Rightsville Rental service for CSC 331
Authors - Shane Menzigian, Danny LeCasse, Lauren Wilson, Dowell
Controls the site for selecting what vehicles to rent. Gathers data on which checkboxes are selected, then sends data
to final contract page. Also updates labels based on if checkboxes are selected.
 */

public class Vehicle_Selection_Controller {
    static boolean[] in_stock = {true, true, true, true, true};
    static boolean[] checkbox_checks = {false,false,false,false,false};//The best way I found to move the data of checkboxes.
    @FXML
    private Label Available_Label_1;
    @FXML
    private Label Available_Label_2;
    @FXML
    private Label Available_Label_3;
    @FXML
    private Label Available_Label_4;
    @FXML
    private Label Available_Label_5;
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
    private void openPersonInfo(){
        //Method to open next site in checkout process.
        Stage stage1 = (Stage) ButtonConfirm.getScene().getWindow(); //Gets the current stage
        stage1.close(); //Closes itself
        set_stock(checkbox_checks);
        PersonInfo_Controller controller2 = new PersonInfo_Controller(this);
        controller2.showStage(); //Opens the new stage
    }
    public void set_stock(boolean[] checkbox_checks){
        for(int i = 0 ; i < checkbox_checks.length;i++){
            if(checkbox_checks[i]){
                in_stock[i] = false;
            }else{
                in_stock[i]= true;
            }
        }
    }
    public boolean[] getcheckbox_checks(){
        //Returns the list of what checkboxes are checked.True for checked
        return checkbox_checks;
    }

    public void initialize(){
        //Contains the various controls for the page.
        ButtonConfirm.setOnAction(event -> openPersonInfo()); //Sets the action of the button
        intitialize_checkbox(Rent_Check1, Available_Label_1, 0);
        intitialize_checkbox(Rent_Check2, Available_Label_2,1);
        intitialize_checkbox(Rent_Check3,Available_Label_3,2);
        intitialize_checkbox(Rent_Check4,Available_Label_4,3);
        intitialize_checkbox(Rent_Check5,Available_Label_5,4);
    }
    public void intitialize_checkbox(CheckBox box,Label availability,int coord){
        if(!in_stock[coord]) {
            box.setDisable(true);
            availability.setText("Unavailable");
        }else {
        box.selectedProperty().addListener(new ChangeListener<Boolean>() {
            //^ Checks what happens if checkbox is selected
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (box.isSelected()){
                    checkbox_checks[coord] = true;
                }else{
                    availability.setText("Available");
                    checkbox_checks[coord] = false;
                }
            }
        });}
    }
}

