package com.example.librarymanager.controller;

import javafx.scene.control.*;

import com.example.librarymanager.App;
import com.example.librarymanager.model.Livre;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;

public class MainViewController 
{
    @FXML
    public TableView<Livre> livreTable;
    @FXML
    private TableColumn<Livre, String> titleColumn;
    @FXML
    private TableColumn<Livre, String> authorColumn;

    @FXML
    private Label titleLabel;
    @FXML
    private Label isbnLabel;
    @FXML
    private Label authorLabel;
    @FXML
    private Label yearLabel;
    @FXML
    private Label categoryLabel;
    @FXML
    private Label statusLabel;

    public Button newBtn;
    public Button editBtn;
    public Button deleteBtn;

    private App app;

    public MainViewController() {}

    public void initialize() {
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        authorColumn.setCellValueFactory(cellData -> cellData.getValue().authorProperty());

        showLivreDetails(null);

        livreTable.getSelectionModel().selectedItemProperty().addListener(
          (Observable, oldValue, newValue) -> showLivreDetails(newValue)
        );
    }

    public void showLivreDetails(Livre livre) {
        if (livre != null) {
            titleLabel.setText(livre.getTitle());
            isbnLabel.setText(Integer.toString(livre.getIsbn()));
            authorLabel.setText(livre.getAuthor());
            // yearTextField.setText(livre.getYear());
            // categoryTextField.setText(livre.getCategory());
            // statusTextField.setText(livre.getStatus());
        } else {
            titleLabel.setText("");
            isbnLabel.setText("");
            authorLabel.setText("");
            yearLabel.setText("");
            categoryLabel.setText("");
            statusLabel.setText("");
        }
    }

    @FXML
    public void newBtnHandler() {
        Livre tempLivre = new Livre();
        boolean okClicked = app.showAddPage(tempLivre);

        if (okClicked) {
            app.getLivres().add(tempLivre);
        }
    }

    @FXML
    public void editBtnHandler() {
        Livre selectedLivre = livreTable.getSelectionModel().getSelectedItem();

        if (selectedLivre != null) {
            boolean okClicked = app.showEditPage(selectedLivre);
            if (okClicked) {
                showLivreDetails(selectedLivre);
            }
        } else {
            Alert();
        }
    }

    @FXML
    public void deleteBtnHandler() {
        int selectedIndex = livreTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            // TODO : Ajouter une alerte de type confirmation
            livreTable.getItems().remove(selectedIndex);
            System.out.println("livre supprimé");
        } else {
            Alert();
        }

    }

    public void Alert() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.initOwner(app.getPrimaryStage());
        alert.setTitle("Aucun livre sélectionné");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez sélectionner un livre !");

        alert.showAndWait();
    }

    public void setApp(App app) {
        this.app = app;

        livreTable.setItems(app.getLivres());
    }

}