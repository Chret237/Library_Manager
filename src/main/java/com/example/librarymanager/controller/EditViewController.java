package com.example.librarymanager.controller;

import com.example.librarymanager.model.Livre;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class EditViewController {

    public Button okBtn;
    public Button cancelBtn;
    @FXML
    private TextField titleTextField;
    @FXML
    private TextField isbnTextField;
    @FXML
    private TextField authorTextField;
    @FXML
    private TextField yearTextField;
    @FXML
    private TextField categoryTextField;
    @FXML
    private TextField statusTextField;

    private Stage editDialogStage;
    private Livre livre;
    private boolean okClicked = false;

    public EditViewController() {
    }

    public void initialize() {
    }

    public void setEditDialogStage(Stage editDialogStage) {
        this.editDialogStage = editDialogStage;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;

        titleTextField.setText(livre.getTitle());
        isbnTextField.setText(Integer.toString(livre.getIsbn()));
        authorTextField.setText(livre.getAuthor());
        // yearTextField.setText(livre.getYear());
        // categoryTextField.setText(livre.getCategory());
        // statusTextField.setText(livre.getStatus());
    }

    @FXML
    private void okBtnHandler() {
        if (isValidInput()) {
            livre.setTitle(titleTextField.getText());
            livre.setIsbn(Integer.parseInt(isbnTextField.getText()));
            livre.setAuthor(authorTextField.getText());
            // livre.setYear(titleTextField.getText());
            // livre.setCategory(titleTextField.getText());
            // livre.setStatus(titleTextField.getText());

            okClicked = true;
            editDialogStage.close();
            System.out.println("livre modifié");
        }
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void cancelBtnHandler() {
        editDialogStage.close();
    }

    public boolean isValidInput() {
        String errorMessage = "";

        if (titleTextField.getText() == null || titleTextField.getText().length() == 0) {
            errorMessage += "Titre invalide\n";
        }
        if (isbnTextField.getText() == null || isbnTextField.getText().length() == 0) {
            errorMessage += "Isbn Invalide\n";
        } else {
            try {
                Integer.parseInt(isbnTextField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Isbn Invalid (must be an integer)\n";
            }
        }
        // if (authorTextField.getText() == null || authorTextField.getText().length() == 0) {
        //     errorMessage += "Autheur Invalide";
        // }
        // if (yearTextField.getText() == null || yearTextField.getText().length() == 0) {
        //     errorMessage += "Année Invalide";
        // }
        // if (categoryTextField.getText() == null || categoryTextField.getText().length() == 0) {
        //     errorMessage += "Category Invalide";
        // }
        // if (statusTextField.getText() == null || statusTextField.getText().length() == 0) {
        //     errorMessage += "Statut Invalide";
        // }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(editDialogStage);
            alert.setTitle("Champ(s) Invalide");
            alert.setHeaderText(null);
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
