package com.example.android.cricketcounterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int toss = 0;
    int team_a_overs = 0;
    int team_b_overs = 0;
    int team_a_balls = 0;
    int team_b_balls = 0;
    int total_overs = 5;
    int total_balls = total_overs * 6;
    int team_a_wickets = 0;
    int team_b_wickets = 0;
    int match_start = 0;
    int team_a_score = 0;
    int team_b_score = 0;
    String winnerName = "";
    int inningsOver = 0;
    int team_a_batting = 0;
    int team_b_batting = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rematch(View view){
        team_a_overs = 0;
        team_b_overs = 0;
        team_a_balls = 0;
        team_b_balls = 0;
        total_overs = 5;
        total_balls = total_overs * 6;
        team_a_wickets = 0;
        team_b_wickets = 0;
        match_start = 0;
        team_a_score =0;
        team_b_score = 0;
        team_a_wickets = 0;
        team_b_wickets = 0;
        inningsOver = 0;
        winnerName = "";
        display_team_a_wickets(team_a_wickets);
        display_team_b_wickets(team_b_wickets);
        display_team_a_score(team_a_score);
        display_team_b_score(team_a_score);
        display_team_a_overs(team_a_overs);
        display_team_b_overs(team_b_overs);
        display_team_a_balls();
        display_team_b_balls();
        TextView toss_winner = (TextView) findViewById(R.id.toss_winner);
        toss_winner.setText("Yet to be decided");
        displayWinnerName("Yet to be decided");
    }

    public void displayTossWinner(View view) {
        if (match_start == 0) {
            Random random = new Random();
            toss = random.nextInt(2);
            TextView toss_winner = (TextView) findViewById(R.id.toss_winner);
            if (toss == 0) {
                toss_winner.setText("Kolkata Knight Riders");
                team_a_batting = 1;
                winnerName = "Kolkata Knight Riders";
            } else if (toss == 1) {
                toss_winner.setText("Sunrisers Hyderabad");
                team_b_batting = 1;
                winnerName = "Sunrisers Hyderabad";
            }
            match_start = 1;
        }
    }

    public void add_no_ball(View view){
        if(match_start == 1 && toss == 0 && team_a_batting == 1){
            team_a_score += 1;
            display_team_a_score(team_a_score);
        } else if(match_start == 1 && toss == 1 && team_b_batting == 1){
            team_b_score += 1;
            display_team_b_score(team_b_score);
        }
    }

    public void add_wickets(View view){
        if(match_start == 1 && toss == 0 && team_a_batting == 1 && team_a_wickets <= 10){
            team_a_wickets += 1;
            team_a_balls += 1;
            display_team_a_balls();
            if(team_a_wickets < 11){
                display_team_a_wickets(team_a_wickets);
            }
            if(inningsOver == 2){
                checkWinner();
            }
        } else if(match_start == 1 && toss == 1 && team_b_batting == 1 && team_b_wickets <= 10){
            team_b_wickets += 1;
            team_b_balls += 1;
            display_team_b_balls();
            if(team_b_wickets < 11){
                display_team_b_wickets(team_b_wickets);
            }
            if(inningsOver == 1){
                checkWinner();
            }
        }
    }

    public void display_team_a_wickets(int team_a_wickets){
        TextView team_a_wickets_view = (TextView) findViewById(R.id.team_a_wickets);
        team_a_wickets_view.setText("" + team_a_wickets);
    }

    public void display_team_b_wickets(int team_b_wickets){
        TextView team_b_wickets_view = (TextView) findViewById(R.id.team_b_wickets);
        team_b_wickets_view.setText("" + team_b_wickets);
    }

    public void add_wide_ball(View view){
        if(match_start == 1 && toss == 0 && team_a_wickets <= 10){
            team_a_score += 1;
            display_team_a_score(team_a_score);

        } else if(match_start == 1 && toss == 1 && team_b_wickets <= 10){
            team_b_score += 1;
            display_team_b_score(team_b_score);

        }
    }

    public void add_one(View view){
        if(match_start == 1 && toss == 0){
            team_a_score += 1;
            team_a_balls += 1;
            display_team_a_score(team_a_score);
            display_team_a_balls();
        }
        else if(match_start == 1 && toss == 1){
            team_b_score += 1;
            team_b_balls += 1;
            display_team_b_score(team_b_score);
            display_team_b_balls();
        }
    }

    public void add_two(View view){
        if(match_start == 1 && toss == 0){
            team_a_score += 2;
            team_a_balls += 1;
            display_team_a_score(team_a_score);
            display_team_a_balls();
        }
        else if(match_start == 1 && toss == 1){
            team_b_score += 2;
            team_b_balls += 1;
            display_team_b_score(team_b_score);
            display_team_b_balls();
        }
    }

    public void add_four(View view){
        if(match_start == 1 && toss == 0){
            team_a_score += 4;
            team_a_balls += 1;
            display_team_a_score(team_a_score);
            display_team_a_balls();
        }
        else if(match_start == 1 && toss == 1){
            team_b_score += 4;
            team_b_balls += 1;
            display_team_b_score(team_b_score);
            display_team_b_balls();
        }
    }

    public void add_six(View view){
        if(match_start == 1 && toss == 0){
            team_a_score += 6;
            team_a_balls += 1;
            display_team_a_score(team_a_score);
            display_team_a_balls();
        }
        else if(match_start == 1 && toss == 1){
            team_b_score += 6;
            team_b_balls += 1;
            display_team_b_score(team_b_score);
            display_team_b_balls();
        }
    }


    public void display_team_a_score(int team_a_score){
        TextView team_a_score_view = (TextView) findViewById(R.id.team_a_score);
        team_a_score_view.setText("" + team_a_score);
    }

    public void display_team_b_score(int team_b_score){
        TextView team_a_score_view = (TextView) findViewById(R.id.team_b_score);
        team_a_score_view.setText("" + team_b_score);
    }

    public void display_team_a_balls(){
        TextView team_a_ball_view = (TextView) findViewById(R.id.team_a_balls);
        team_a_ball_view.setText("" + (team_a_balls % 6));
        if(team_a_balls < 30 && team_a_wickets < 10 && match_start == 1){
            if(team_a_balls%6 == 0){
                team_a_overs += 1;
                display_team_a_overs(team_a_overs);
            }
        } else if (team_a_balls == 30 && team_a_wickets < 10 && match_start == 1){
            team_a_overs += 1;
            toss = 1;
            inningsOver = 1;
            display_team_a_overs(team_a_overs);
            team_a_batting = 0;
            team_b_batting = 1;
        } else if(team_a_balls < 30 && team_a_wickets == 10 && match_start == 1){
            toss = 1;
            inningsOver = 1;
            team_a_batting = 0;
            team_b_batting = 1;
        }
        if(inningsOver == 2){
            checkWinner();
        }
    }

    public void display_team_b_balls(){
        TextView team_b_ball_view = (TextView) findViewById(R.id.team_b_balls);
        team_b_ball_view.setText("" + (team_b_balls % 6));
        if(team_b_balls < 30 && team_b_wickets < 10 && match_start == 1){
            if(team_b_balls%6 == 0){
                team_b_overs += 1;
                display_team_b_overs(team_b_overs);
            }
        } else if(team_b_balls == 30 && team_b_wickets < 10 && match_start == 1){
            team_b_overs += 1;
            toss = 0;
            inningsOver = 2;
            display_team_b_overs(team_b_overs);
            team_b_batting = 0;
            team_a_batting = 1;
        } else if(team_b_balls < 30 && team_b_wickets == 10 && match_start == 1){
            toss = 0;
            inningsOver = 2;
            team_b_batting = 0;
            team_a_batting = 1;
        }
        if(inningsOver == 1){
            checkWinner();
        }
    }

    public void checkWinner(){
        if(inningsOver == 1 && team_a_score > team_b_score && team_b_batting == 1 && (team_b_wickets == 10 || team_b_balls == 30)){
            winnerName = "Kolkata Knight Riders";
            displayWinnerName(winnerName);
        }
        else if(inningsOver == 1 && team_a_score < team_b_score && team_b_batting == 1){
            winnerName = "Sunrisers Hyderabad";
            displayWinnerName(winnerName);
        }
        if(inningsOver == 2 && team_b_score > team_a_score && team_a_batting == 1 && (team_a_wickets == 10 || team_a_balls == 30)){
            winnerName = "Sunrisers Hyderabad";
            displayWinnerName(winnerName);
        }
        else if(inningsOver == 2 && team_b_score < team_a_score && team_a_batting == 1){
            winnerName = "Kolkata Knight Riders";
            displayWinnerName(winnerName);
        }
    }

    public void displayWinnerName(String winner){
        TextView winner_view = (TextView) findViewById(R.id.winner);
        winner_view.setText(winner);
        toss = -1;
    }

    public void display_team_a_overs(int team_a_overs){
        TextView team_a_overs_view = (TextView) findViewById(R.id.team_a_overs);
        team_a_overs_view.setText("" + team_a_overs);
    }

    public void display_team_b_overs(int team_b_overs){
        TextView team_b_overs_view = (TextView) findViewById(R.id.team_b_overs);
        team_b_overs_view.setText("" + team_b_overs);
    }

}



