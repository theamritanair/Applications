package com.example.android.githubapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CommitAdapter extends RecyclerView.Adapter<CommitAdapter.commitViewHolder> {

    ArrayList<Commit> commitArrayList;
    Context context;

    public CommitAdapter(ArrayList<Commit> commitArrayList, Context context) {
        this.commitArrayList = commitArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CommitAdapter.commitViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new commitViewHolder(LayoutInflater.from(context).inflate(R.layout.commitlayout
                ,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CommitAdapter.commitViewHolder commitViewHolder, int i) {
            commitViewHolder.commitMessage.setText(commitArrayList.get(i).getMessage());
            commitViewHolder.commitName.setText(commitArrayList.get(i).toString());
    }

    @Override
    public int getItemCount() {
        return commitArrayList.size();
    }


    static class commitViewHolder extends RecyclerView.ViewHolder{

        TextView commitName;
        TextView commitMessage;

        public commitViewHolder(@NonNull View itemView) {
            super(itemView);
            commitName = itemView.findViewById(R.id.commitName);
            commitMessage = itemView.findViewById(R.id.commitMessage);
        }
    }
}
