package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int scoreTeamA=0,scoreTeamB=0;
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void add3forTeamA(View view){
        scoreTeamA+=3;
        displayForTeamA(scoreTeamA);
    }

    public void twoPointsforA(View view){
        scoreTeamA+=2;
        displayForTeamA(scoreTeamA);
    }

    public void freeThrowforA(View view){
        scoreTeamA+=1;
        displayForTeamA(scoreTeamA);
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    public void freeThrowforB(View view) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
    }

        public void twoPointsforB(View view) {
            scoreTeamB += 2;
            displayForTeamB(scoreTeamB);
        }

    public void add3forTeamB(View view){
        scoreTeamB+=3;
        displayForTeamB(scoreTeamB);
    }
    public void resetScore(View view){
        scoreTeamA=0;
        scoreTeamB=0;
        displayForTeamB(scoreTeamB);
        displayForTeamA(scoreTeamA);
    }
}
