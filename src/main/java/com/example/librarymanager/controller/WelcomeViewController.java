package com.example.librarymanager.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WelcomeViewController 
{
    @FXML private Button btnVoirLivres;
    @FXML private Button btnGererEmprunts;
    @FXML private Button closebtn;

    @FXML
    public void quitter() {
        Stage stage = (Stage) closebtn.getScene().getWindow();
        stage.close();
    }    
}
