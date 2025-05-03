module com.example.librarymanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    // requires org.xerial.sqlitejdbc;
    // requires de.jensd.fx.glyphs.Fontawesome;
    // requires javafx.graphics;

    opens com.example.librarymanager.controller to javafx.fxml;

    exports com.example.librarymanager;
    exports com.example.librarymanager.controller;
    exports com.example.librarymanager.model;
    exports com.example.librarymanager.Views;
}