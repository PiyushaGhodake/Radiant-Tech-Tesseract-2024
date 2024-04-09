package com.example.pathsage;

public class User {
    private String phoneNumber;
    private String username;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String phoneNumber, String username) {
        this.phoneNumber = phoneNumber;
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUsername() {
        return username;
    }
}

