package com.example.librarymanager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class Livre {

    private StringProperty title;
    private IntegerProperty isbn;
    private StringProperty author;

    public Livre() {
        this(null, 0, null);
    }

    public Livre(String title, Integer isbn, String author) {
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.isbn = new SimpleIntegerProperty(isbn);
    }

    public Livre(String title, Integer isbn) {
        this.title = new SimpleStringProperty(title);
        this.isbn = new SimpleIntegerProperty(isbn);
    }

    public String getTitle() { return title.get(); }
    public void setTitle(String title) { this.title.set(title); }
    public StringProperty titleProperty() { return this.title; }

    public int getIsbn() { return isbn.get(); }
    public void setIsbn(Integer isbn) { this.isbn.set(isbn); }
    public IntegerProperty isbnProperty() { return this.isbn; }


    public String getAuthor() { return author.get(); }
    public void setAuthor(String author) { this.author.set(author); }
    public StringProperty authorProperty() { return this.author; }


}
