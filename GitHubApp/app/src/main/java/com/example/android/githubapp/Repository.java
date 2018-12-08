package com.example.android.githubapp;

import com.google.gson.annotations.SerializedName;

class Repository {

    @SerializedName("name")
    private String repository;

    public String getRepository() {
        return repository;
    }

    public Repository(String repository) {
        this.repository = repository;
    }

    @Override
    public String toString() {
        return repository;
    }
}
