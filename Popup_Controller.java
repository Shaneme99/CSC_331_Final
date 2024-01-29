package com.example.rightsville_rental;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Popup_Controller {
    @FXML
    private Button ExitProgram;

    @FXML
    public void closewindows(ActionEvent event) {
        Stage stage = (Stage) ExitProgram.getScene().getWindow();
        stage.close();
    }

}
