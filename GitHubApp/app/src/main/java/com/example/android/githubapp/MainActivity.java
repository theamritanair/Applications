package com.example.android.githubapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter gitAdapter;

    TextView gitText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gitText = (TextView) findViewById(R.id.gitText);

        recyclerView = (RecyclerView) findViewById(R.id.gitRecycler);

        GitHubInterface gitHubInterface =GithubClient.getClient().create(GitHubInterface.class);
        Call<ArrayList<Repository>> gitRepo = gitHubInterface.getRepositories("theamritanair");
        gitRepo.enqueue(new Callback<ArrayList<Repository>>() {
            @Override
            public void onResponse(Call<ArrayList<Repository>> call, Response<ArrayList<Repository>> response) {
                ArrayList<Repository> repo = response.body();
                gitAdapter = new GitAdapter(repo,getBaseContext());
                recyclerView.setAdapter(gitAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Repository>> call, Throwable t) {
                Toast.makeText(getBaseContext(),"Error :) ",Toast.LENGTH_SHORT);

            }
        });






    }
}
