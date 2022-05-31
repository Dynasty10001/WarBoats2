package com.example.cst143warboats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    String name;
    Button btnPlayAgain;

    TextView tvScore;
    TextView tvResults;
    ImageView ivPic;

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
        int shotsLeft;
        if (win){
            shotsLeft = b.getInt("shots");
            tvResults.setText("Congratulations Capn' " + name + "!!!!!\nYou Sank all the enemy ships!!!!!");
            tvScore.setText("You finished with " + shotsLeft + " Shots Left!");
        }
        else
        {
            tvResults.setText("Sorry Capn' " + name + ".\nYou failed to sink all the enemy ships");
        }

        btnPlayAgain = findViewById(R.id.btnPlayAgain);


        btnPlayAgain.setOnClickListener(v -> PlayAgain());
    }

    public void PlayAgain() {
        Intent intent = new Intent(this, PlayGame.class);
        intent.putExtra("name", name);
//            intent.putExtra("img", ivPic.getDrawable().toString());
        this.startActivity(intent);
    }
}