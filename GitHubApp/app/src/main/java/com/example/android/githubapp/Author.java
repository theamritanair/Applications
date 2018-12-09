package com.example.android.githubapp;

public class Author {
    String name;
    String email;
    String date;

    public Author(String name, String email, String date) {
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDate() {
        return date;
    }
}
