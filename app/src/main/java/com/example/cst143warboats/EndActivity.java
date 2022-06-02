package com.example.cst143warboats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EndActivity extends AppCompatActivity {

    String name;
    Button btnPlayAgain;

    TextView tvScore;
    TextView tvResults;
    ImageView ivPic;

    private DBhelper db;
    private player CurrentPlayer;
    ArrayList<player> playerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        tvResults = findViewById(R.id.tvResults);
        tvScore = findViewById(R.id.tvScore);

        name = b.getString("name");
        Boolean win = b.getBoolean("win");

        name = b.getString("name").trim();
        long id = b.getLong("id");
        db = new DBhelper(this);
        db.open();
        playerList = db.getPlayerlist();

        if (id >0)
        {
            CurrentPlayer = playerList.get((int) id - 1);
        }
        else
        {
            CurrentPlayer = playerList.get(playerList.size() -1);
        }

        int shotsLeft;
        if (win){
            shotsLeft = b.getInt("shots");
            tvResults.setText("Congratulations Capn' " + name + "!!!!!\nYou Sank all the enemy ships!!!!!");
            tvScore.setText("You finished with " + shotsLeft + " Shots Left!");
            if (shotsLeft > CurrentPlayer.score)
            {
                CurrentPlayer.score = shotsLeft;
                db.updatePlayer(CurrentPlayer);
            }

        }
        else
        {
            tvResults.setText("Sorry Capn' " + name + ".\nYou failed to sink all the enemy ships");
        }

        btnPlayAgain = findViewById(R.id.btnPlayAgain);



        btnPlayAgain.setOnClickListener(v -> PlayAgain());
    }

    public void PlayAgain() {
        db.close();
        Intent intent = new Intent(this, PlayGame.class);
        intent.putExtra("name", CurrentPlayer.name);
        intent.putExtra("id", CurrentPlayer.id);
        this.startActivity(intent);
    }
}