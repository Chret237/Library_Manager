package com.example.librarymanager;

import java.io.IOException;

import com.example.librarymanager.controller.AddViewController;
import com.example.librarymanager.controller.EditViewController;
import com.example.librarymanager.controller.MainViewController;

// import java.io.IOException;

import com.example.librarymanager.model.Livre;

import javafx.application.Application;
// import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
// import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
// import javafx.stage.StageStyle;

public class App extends Application {

    private Stage primaryStage;

    ObservableList<Livre> livres = FXCollections.observableArrayList();

    public App () {     
        livres.add(new Livre("livre01", 12341, "autheur#1"));
        livres.add(new Livre("livre02", 12342, "autheur#2"));
        livres.add(new Livre("livre03", 12343, "autheur#3"));
        livres.add(new Livre("livre04", 12344, "autheur#4"));
    }
    
    public ObservableList<Livre> getLivres() {
        return livres;
    }
    
    @Override
    public void start(Stage primaryStage) {

        try 
        {
            primaryStage.setTitle("Gestionnaire de Bibliothèque");

            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/MainView.fxml"));
            BorderPane rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().add(getClass().getResource("/css/main.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();

            MainViewController controller = loader.getController();
            controller.setApp(this);

            // Parent root = FXMLLoader.load(getClass().getResource("/Fxml/WelcomeView.fxml"));
            // Scene scene = new Scene(root, 800, 600);
            
            // scene.getStylesheets().add(getClass().getResource("/css/welcome.css").toExternalForm());
            // primaryStage.setTitle("Library Manager");
            // // primaryStage.initStyle(StageStyle.UNDECORATED);
            // primaryStage.setScene(scene);
            // primaryStage.show(); 
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            System.err.println("<<<ERROR>>> : " + e.getMessage());
        }

    }

    public boolean showAddPage(Livre livre) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/Fxml/AddView.fxml"));
            AnchorPane addPage = loader.load();

            Stage addDialogStage = new Stage();
            addDialogStage.setTitle("Ajouter un livre");
            addDialogStage.initOwner(primaryStage);
            addDialogStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(addPage);
            addDialogStage.setScene(scene);

            AddViewController controller = loader.getController();
            controller.setAddDialogStage(addDialogStage);
            controller.setLivre(livre);

            addDialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean showEditPage(Livre livre) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/Fxml/EditView.fxml"));
            AnchorPane editPage = loader.load();
            
            Stage editdialogStage = new Stage();
            editdialogStage.setTitle("Modifier un livre");
            editdialogStage.initOwner(primaryStage);
            editdialogStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(editPage);
            editdialogStage.setScene(scene);

            EditViewController controller = loader.getController();
            controller.setEditDialogStage(editdialogStage);
            controller.setLivre(livre);

            editdialogStage.show();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
