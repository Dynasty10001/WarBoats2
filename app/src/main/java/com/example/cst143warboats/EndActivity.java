package com.example.cst143warboats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class EndActivity extends AppCompatActivity {

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        name = b.getString("name");
        Boolean win = b.getBoolean("win");
        int shotsLeft;
        if (win){ shotsLeft = b.getInt("shots"); }

    }

    public void PlayAgain() {
        Intent intent = new Intent(this, PlayGame.class);
        intent.putExtra("name", name);
//            intent.putExtra("img", ivPic.getDrawable().toString());
        this.startActivity(intent);
    }
}