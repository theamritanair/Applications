package com.example.android.githubapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommitActivity extends AppCompatActivity {

    RecyclerView commitRecycler;
    CommitAdapter adapter;
    Context context;
    String repo;
    Bundle bun;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commit);
        context = this;

        commitRecycler= (RecyclerView) findViewById(R.id.gitRecycler);
        bun = new Bundle();
        bun = getIntent().getExtras();

        try {
            repo = bun.getString("value");
        }catch (Exception e){
            e.printStackTrace();
        }

        GitHubInterface gitInterface = GithubClient.getClient().create(GitHubInterface.class);
        Call<ArrayList<Commit>> callback = gitInterface.getCommits("theamritanair",repo);
        callback.enqueue(new Callback<ArrayList<Commit>>() {
            @Override
            public void onResponse(Call<ArrayList<Commit>> call, Response<ArrayList<Commit>> response) {
                ArrayList<Commit> commit = response.body();
                adapter = new CommitAdapter(commit, context);
                commitRecycler.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ArrayList<Commit>> call, Throwable t) {
                Toast.makeText(getBaseContext(),"Error :",Toast.LENGTH_SHORT);
            }
        });
    }
}
