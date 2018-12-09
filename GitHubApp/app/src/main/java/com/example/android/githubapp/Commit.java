package com.example.android.githubapp;

class Commit {

    String url;
    Author auth;
    Author committer;
    String message;
    int commentCount;

    public Commit(String url, Author auth, Author committer, String message, int commentCount) {
        this.url = url;
        this.auth = auth;
        this.committer = committer;
        this.message = message;
        this.commentCount = commentCount;
    }

    public String getUrl() {
        return url;
    }

    public Author getAuth() {
        return auth;
    }

    public Author getCommitter() {
        return committer;
    }

    public String getMessage() {
        return message;
    }

    public int getCommentCount() {
        return commentCount;
    }
}
