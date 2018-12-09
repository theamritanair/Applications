package com.example.android.githubapp;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubInterface {


    @GET("/users/{name}/repos")
    Call<ArrayList<Repository>> getRepositories(@Path("name") String name);


    @GET("/repos/{name}/{repo}/commits")
    Call<ArrayList<Commit>> getCommits(@Path("name") String name,
                                       @Path("repo") String repository);
}
