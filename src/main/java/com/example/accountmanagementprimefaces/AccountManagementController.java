package com.example.accountmanagementprimefaces;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AccountManagementController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}