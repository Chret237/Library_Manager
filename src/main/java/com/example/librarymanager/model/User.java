package com.example.librarymanager.model;

public class User 
{
    public User(String username, String email, String password, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    private String username;
    public String getUsername() { return this.username; }
    public void setUsername(String name) { this.username = name; }


    private String email;
    public String getEmail() { return this.email; }
    public void setEmail(String email) { this.email = email; }
    

    private String password;
    public String getPassword() { return this.password; }
    public void setPassword(String password) { this.password = password; }


    private Role role;
    public Role getRole() { return this.role; }

    public enum Role {
        LECTURER, ADMIN
    }
}
