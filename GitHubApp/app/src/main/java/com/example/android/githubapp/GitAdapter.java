package com.example.android.githubapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class GitAdapter extends RecyclerView.Adapter<GitAdapter.GitViewHolder> {

    private static ArrayList<Repository> gitArray;

    public ArrayList<Repository> getGitArray() {
        return gitArray;
    }

    Context context;

    public GitAdapter(ArrayList<Repository> gitArray, Context context) {
        this.gitArray = gitArray;
        this.context = context;
    }


    @NonNull
    @Override
    public GitViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new GitViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.layout,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull GitViewHolder gitViewHolder, int i) {

        gitViewHolder.gitText.setText(gitArray.get(i).getRepository());
    }

    @Override
    public int getItemCount() {
        return gitArray.size();
    }

    static class GitViewHolder extends RecyclerView.ViewHolder{
        public TextView gitText ;

        public GitViewHolder(@NonNull View itemView) {
            super(itemView);

            gitText = itemView.findViewById(R.id.gitText);

            gitText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();

                    Bundle bundle = new Bundle();
                    bundle.putString("value",gitArray.get(getAdapterPosition()).getRepository());
                    Intent intent = new Intent(context.getApplicationContext(),CommitActivity.class);
                    context.startActivity(intent);
                }
            });

        }



    }
}


