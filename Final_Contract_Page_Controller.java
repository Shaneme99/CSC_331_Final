package com.example.rightsville_rental;
import java.io.IOException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import  javafx.scene.Parent;
/*
Rightsville Rental service for CSC 331
Authors - Shane Menzigian, Danny LeCasse, Lauren Wilson, Dowell
Presents the final contract.
 */

public class Final_Contract_Page_Controller{
    private final Stage thisStage;
    private final PersonInfo_Controller person_controller;
    private final Vehicle_Selection_Controller vehicle_controller;
    @FXML
    private TextArea FinalOrder;
    @FXML
    private CheckBox Signature;
    @FXML
    private Button FinalConfirm;
    public Final_Contract_Page_Controller(PersonInfo_Controller person_controller, Vehicle_Selection_Controller vehicle_controller){
        // This method creates and runs the controller for the final site
        this.person_controller = person_controller; //To get user info
        this.vehicle_controller = vehicle_controller; //To get vehicle rentals
        thisStage = new Stage();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ConfirmationUpdated.fxml"));
            loader.setController(this);
            thisStage.setScene(new Scene(loader.load()));
            thisStage.setTitle("Final Contract");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void showStage(){
        thisStage.showAndWait();
    }
    @FXML
    private void initialize(){
        UserInfo person = person_controller.getEnteredText(); //Grabs user info
        String vehicles = "";
        LocalDate current = LocalDate.now();
        long days_rented = getdays(person); //Finds how long the user wants their items
        LocalDate return_by = find_return(days_rented, current); //Adds number of expected rental days to current date
        int i =0;
        float cost = 0;
        boolean[] rented = vehicle_controller.getcheckbox_checks(); //Grabs rented vehicles
        //This forloop is the most efficient way I found to add the selected vehicles to the contract.
        for (boolean t:rented){
            //For every item in the rented vehicles Array, if said item is true, that vehicle is added to the list.
            switch (i) {
                case (0) -> {
                    if (t) {
                        vehicles += ("1 Kayak\n");
                        i++;
                        cost += 50;
                    }
                }
                case (1) -> {
                    if (t) {
                        vehicles +=("1 Surfboard\n");
                        i++;
                        cost +=40;
                    }
                }
                case (2) -> {
                    if (t) {
                        vehicles +=("1 Paddleboard\n");
                        i++;
                        cost += 20;
                    }
                }
                case (3) -> {
                    if (t) {
                        vehicles +=("1 Jet Ski\n");
                        i++;
                        cost +=150;
                    }
                }
                case (4) -> {
                    if (t) {
                        vehicles +=("1 Snorkel");
                        i++;
                        cost +=15;
                    }
                }
            }
        }
        cost = cost * days_rented; //Calculates final cost
        createcontract(person,current,return_by,cost,vehicles);
        FinalConfirm.setOnAction(event -> {
            try {
                finishpurchase(thisStage, Signature);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
    private long getdays(UserInfo person){
        //Transforms a string to a long. Some error handling incase somehow the user left it blank.
        long days_rented;
        try{
            days_rented = Long.parseLong(person.days);}
        catch(NumberFormatException ex){
            days_rented = 1;
        }
        return days_rented;
    }
    private LocalDate find_return(long days_rented, LocalDate current){
        //Adds a set number of days to the current time to find the return window.
        return current.plus(days_rented, ChronoUnit.DAYS);
    }
    public void finishpurchase(Stage thisStage, CheckBox Signature) throws Exception{
        //The method to be called when the confirmation button is pushed, showing a final confirmation screen.
        //If the user has not selected the checkbox, it will be highlighted instead.
        if (Signature.isSelected()) {
            thisStage.close();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load((getClass().getResource("Popup.fxml")));
            Scene scene = new Scene(root);
            stage.setTitle("Thank you!");
            stage.setScene(scene);
            stage.show();
        } else {
            Signature.requestFocus();
        }
    }
    private void createcontract(UserInfo person, LocalDate current, LocalDate return_by, float cost, String vehicles){
        //Formats the final string that actually creates the contract
        FinalOrder.setText(String.format("I, %s %s %s, hereby promise to rent the following vehicle(s) for a period of %s days " +
                "beginning today, %s.\nI promise to return the rental(s) by %s in good condition.\nI recognize that if " +
                "I do not, I will pay a fine of $50 per damaged vehicle. \nI also recognize that any late returns will be " +
                "subject to a fine of $20 per day."
                + "\n Vehicles Rented: \n" + vehicles
                + "\nCredit Card Used: %s"
                + "\nTotal Cost: $%.2f", person.firstname, person.middlename, person.lastname, person.days, current, return_by, person.card_no, cost));

    }
}
