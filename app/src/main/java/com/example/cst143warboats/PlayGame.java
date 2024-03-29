package com.example.cst143warboats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class PlayGame extends AppCompatActivity implements View.OnClickListener {
    //declaring variables
    TextView tvName;
    TextView tvBest;
    TextView tvRemain;
    ImageView ivPlayerPic;

    String name;

    private DBhelper db;
    private player CurrentPlayer;
    ArrayList<player> playerList;

    ImageView ivShipS;
    ImageView ivShipM;
    ImageView ivShipL;

    ImageButton[] ShipS = new ImageButton[2];
    ImageButton[] ShipM = new ImageButton[3];
    ImageButton[] ShipL = new ImageButton[4];

    int shotsLeft = 30;

    boolean ShipSSunk = false;
    boolean ShipMSunk = false;
    boolean ShipLSunk = false;

    Drawable hit;
    Drawable miss;

    ImageButton ib1,ib2,ib3,ib4,ib5,ib6,ib7,ib8,ib9,ib10,ib11,ib12,ib13,ib14,ib15,ib16,ib17,ib18,ib19,ib20,ib21,ib22,ib23,ib24,ib25,ib26,ib27,ib28,ib29,ib30,ib31,ib32,ib33,ib34,ib35,ib36,ib37,ib38,ib39,ib40,
            ib41,ib42,ib43,ib44,ib45,ib46,ib47,ib48,ib49,ib50,ib51,ib52,ib53,ib54,ib55,ib56,ib57,ib58,ib59,ib60,ib61,ib62,ib63,ib64;


    private ImageButton[] Buttons = {ib1,ib2,ib3,ib4,ib5,ib6,ib7,ib8,ib9,ib10,ib11,ib12,ib13,ib14,ib15,ib16,ib17,ib18,ib19,ib20,ib21,ib22,ib23,ib24,ib25,ib26,ib27,ib28,ib29,ib30,ib31,ib32,ib33,ib34,ib35,ib36,ib37,ib38,ib39,ib40,
            ib41,ib42,ib43,ib44,ib45,ib46,ib47,ib48,ib49,ib50,ib51,ib52,ib53,ib54,ib55,ib56,ib57,ib58,ib59,ib60,ib61,ib62,ib63,ib64};

    /**
     * Main onCreate for the activity, links variables to the actual buttons/images and sets click listeners for the
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        Intent i = getIntent();
        Bundle b = i.getExtras();

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

        tvBest = findViewById(R.id.tvBest);
        tvName = findViewById(R.id.tvName);
        ivPlayerPic = findViewById(R.id.ivPlayerPic);
        tvRemain = findViewById(R.id.tvRemain);

        tvName.setText("Capn' " + name);
        tvBest.setText("Best Score: " + CurrentPlayer.score);

        File imgFile = new File(CurrentPlayer.pic);

        if(imgFile.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            ivPlayerPic.setImageBitmap(myBitmap);
        }

        tvRemain.setText("Number of Shots Left: " + shotsLeft);

        ivShipS = findViewById(R.id.ivShipS);
        ivShipM = findViewById(R.id.ivShipM);
        ivShipL = findViewById(R.id.ivShipL);

        miss = getResources().getDrawable(R.drawable.ic_sploosh);
        hit = getResources().getDrawable(R.drawable.ic_explosion);

        //SO MANY BUTTONS
        Buttons[0] = findViewById(R.id.ib1);
        Buttons[1] = findViewById(R.id.ib2);
        Buttons[2] = findViewById(R.id.ib3);
        Buttons[3] = findViewById(R.id.ib4);
        Buttons[4] = findViewById(R.id.ib5);
        Buttons[5] = findViewById(R.id.ib6);
        Buttons[6] = findViewById(R.id.ib7);
        Buttons[7] = findViewById(R.id.ib8);
        Buttons[8] = findViewById(R.id.ib9);
        Buttons[9] = findViewById(R.id.ib10);
        Buttons[10] = findViewById(R.id.ib11);
        Buttons[11] = findViewById(R.id.ib12);
        Buttons[12] = findViewById(R.id.ib13);
        Buttons[13] = findViewById(R.id.ib14);
        Buttons[14] = findViewById(R.id.ib15);
        Buttons[15] = findViewById(R.id.ib16);
        Buttons[16] = findViewById(R.id.ib17);
        Buttons[17] = findViewById(R.id.ib18);
        Buttons[18] = findViewById(R.id.ib19);
        Buttons[19] = findViewById(R.id.ib20);
        Buttons[20] = findViewById(R.id.ib21);
        Buttons[21] = findViewById(R.id.ib22);
        Buttons[22] = findViewById(R.id.ib23);
        Buttons[23] = findViewById(R.id.ib24);
        Buttons[24] = findViewById(R.id.ib25);
        Buttons[25] = findViewById(R.id.ib26);
        Buttons[26] = findViewById(R.id.ib27);
        Buttons[27] = findViewById(R.id.ib28);
        Buttons[28] = findViewById(R.id.ib29);
        Buttons[29] = findViewById(R.id.ib30);
        Buttons[30] = findViewById(R.id.ib31);
        Buttons[31] = findViewById(R.id.ib32);
        Buttons[32] = findViewById(R.id.ib33);
        Buttons[33] = findViewById(R.id.ib34);
        Buttons[34] = findViewById(R.id.ib35);
        Buttons[35] = findViewById(R.id.ib36);
        Buttons[36] = findViewById(R.id.ib37);
        Buttons[37] = findViewById(R.id.ib38);
        Buttons[38] = findViewById(R.id.ib39);
        Buttons[39] = findViewById(R.id.ib40);
        Buttons[40] = findViewById(R.id.ib41);
        Buttons[41] = findViewById(R.id.ib42);
        Buttons[42] = findViewById(R.id.ib43);
        Buttons[43] = findViewById(R.id.ib44);
        Buttons[44] = findViewById(R.id.ib45);
        Buttons[45] = findViewById(R.id.ib46);
        Buttons[46] = findViewById(R.id.ib47);
        Buttons[47] = findViewById(R.id.ib48);
        Buttons[48] = findViewById(R.id.ib49);
        Buttons[49] = findViewById(R.id.ib50);
        Buttons[50] = findViewById(R.id.ib51);
        Buttons[51] = findViewById(R.id.ib52);
        Buttons[52] = findViewById(R.id.ib53);
        Buttons[53] = findViewById(R.id.ib54);
        Buttons[54] = findViewById(R.id.ib55);
        Buttons[55] = findViewById(R.id.ib56);
        Buttons[56] = findViewById(R.id.ib57);
        Buttons[57] = findViewById(R.id.ib58);
        Buttons[58] = findViewById(R.id.ib59);
        Buttons[59] = findViewById(R.id.ib60);
        Buttons[60] = findViewById(R.id.ib61);
        Buttons[61] = findViewById(R.id.ib62);
        Buttons[62] = findViewById(R.id.ib63);
        Buttons[63] = findViewById(R.id.ib64);

        for (ImageButton Button : Buttons)
        {
            Button.setOnClickListener(this);
        }

        RandomiseLocation();

    }

    /**
     * This method randomises both ship orientation and ship location. It also makes sure that no ships are overlapping.
     */
    private void RandomiseLocation() {


        int[] locations = new int[64];
        for (int i = 0; i<locations.length; i++) {
            locations[i] = i;
        }

        int[] tempS = new int[2];
        int[] tempM = new int[3];
        int[] tempL = new int[4];

        //Checking horizontal or vertical orientation of ship
        boolean b1 = (Math.random() > 0.5);
        boolean b2 = (Math.random() > 0.5);
        boolean b3 = (Math.random() > 0.5);


        if (b1){
            int l = 8 - tempL.length;
            boolean b;
            //Horizontal
            do {
                b=false;
                int x = (int) Math.floor(Math.random() * l) + 1;
                int y = (int) Math.floor(Math.random() * 8) + 1;
                for (int i = 0; i<tempL.length; i++) {
                    int temp = ((y - 1) * 8) + x + i;
                    tempL[i] = temp;
                }
                for (int i = 0; i<tempL.length; i++) {
                    if (locations[tempL[i] - 1] == -1) {
                        b = true;
                        break;
                    }
                }
            } while (b);
        }
        else {
            int l = 8 - tempL.length;
            boolean b;
            do {
                b=false;
                //Vertical
                int y = (int) Math.floor(Math.random() * l) + 1;
                int x = (int) Math.floor(Math.random() * 8) + 1;
                for (int i = 0; i < tempL.length; i++) {
                    int temp = ((y -1) * 8) + x + (i * 8);
                    tempL[i] = temp;
                }
                for (int i = 0; i<tempL.length; i++) {
                    if (locations[tempL[i] - 1] == -1) {
                        b = true;
                        break;
                    }
                }
            } while (b);
        }

        for (int i = 0; i<tempL.length; i++) { locations[tempL[i] - 1] = -1; }

        if (b2){
            int l = 8 - tempM.length;
            boolean b;
            //Horizontal
            do {
                b=false;
                int x = (int) Math.floor(Math.random() * l) + 1;
                int y = (int) Math.floor(Math.random() * 8) + 1;
                for (int i = 0; i<tempM.length; i++) {
                    int temp = ((y - 1) * 8) + x + i;
                    tempM[i] = temp;
                }
                for (int i = 0; i<tempM.length; i++) {
                    if (locations[tempM[i] - 1] == -1) {
                        b = true;
                        break;
                    }
                }
            } while (b);
        }
        else {
            int l = 8 - tempM.length;
            boolean b;
            do {
                b=false;
                //Vertical
                int y = (int) Math.floor(Math.random() * l) + 1;
                int x = (int) Math.floor(Math.random() * 8) + 1;
                for (int i = 0; i < tempM.length; i++) {
                    int temp = ((y - 1) * 8) + x + (i * 8);
                    tempM[i] = temp;
                }
                for (int i = 0; i<tempM.length; i++) {
                    if (locations[tempM[i] - 1] == -1) {
                        b = true;
                        break;
                    }
                }
            } while (b);
        }

        for (int i = 0; i<tempM.length; i++) { locations[tempM[i] - 1] = -1; }

        if (b3){
            int l = 8 - tempS.length;
            boolean b;
            //Horizontal
            do {
                b=false;
                int x = (int) Math.floor(Math.random() * l) + 1;
                int y = (int) Math.floor(Math.random() * 8) + 1;
                for (int i = 0; i<tempS.length; i++) {
                    int temp = ((y - 1) * 8) + x + i;
                    tempS[i] = temp;
                }
                for (int i = 0; i<tempS.length; i++) {
                    if (locations[tempS[i] - 1] == -1) {
                        b = true;
                        break;
                    }
                }
            } while (b);
        }
        else {
            int l = 8 - tempS.length;
            boolean b;
            do {
                b=false;
                //Vertical
                int y = (int) Math.floor(Math.random() * l) + 1;
                int x = (int) Math.floor(Math.random() * 8) + 1;
                for (int i = 0; i < tempS.length; i++) {
                    int temp = ((y -1) * 8) + x + (i * 8);
                    tempS[i] = temp;
                }
                for (int i = 0; i<tempS.length; i++) {
                    if (locations[tempS[i] - 1] == -1) {
                        b = true;
                        break;
                    }
                }
            } while (b);
        }

        for (int i = 0; i<tempS.length; i++) { locations[tempS[i] - 1] = -1; }

        for (int i =0; i< ShipL.length; i++) { ShipL[i] = Buttons[tempL[i]]; ShipL[i].setTag(1); }
        for (int i =0; i< ShipM.length; i++) { ShipM[i] = Buttons[tempM[i]]; ShipM[i].setTag(1); }
        for (int i =0; i< ShipS.length; i++) { ShipS[i] = Buttons[tempS[i]]; ShipS[i].setTag(1); }
    }

    /**
     * This method is called when an image button is clicked. It finds which image button was clicked and then
     * calls the check hit method. it then checks if all ships are sunk or shotsLeft has dropped to 0 and
     * calls the appropriate end activity if either of these are true.
     * @param v
     */
    @Override
    public void onClick(View v) {

        shotsLeft--;
        tvRemain.setText("Number of Shots Left: " + shotsLeft);

        for (int i = 0; i<Buttons.length; i++)
        {
                 if(v.getId() == Buttons[i].getId())
                 {
                     Buttons[i].setOnClickListener(null);
                     checkHit(Buttons[i]);
                     break;
                 }
        }


        if(!ShipSSunk){ checkShipS(); }
        if(!ShipMSunk){ checkShipM(); }
        if(!ShipLSunk){ checkShipL(); }
        if(ShipSSunk && ShipMSunk && ShipLSunk){
            EndActivity(true);
            return;
        } else if (shotsLeft == 0)
        {
            EndActivity(false);
        }
    }

    /**
     * this method checks to see if a ship was hit and sets the appropriate image for a hit,
     * if no ship was hit it sets the appropriate image for a miss.
     * @param ib
     */
    public void checkHit(ImageButton ib)
    {

        for (ImageButton i: ShipS) {
            if (i == ib) {
                ib.setImageDrawable(hit);
                ib.setBackgroundColor(Color.RED);
                ib.setTag(0);
                return;
            }
        }
        for (ImageButton i: ShipM) {
            if (i == ib) {
                ib.setImageDrawable(hit);
                ib.setBackgroundColor(Color.RED);
                ib.setTag(0);
                return;
            }
        }
        for (ImageButton i: ShipL) {
            if (i == ib) {
                ib.setImageDrawable(hit);
                ib.setBackgroundColor(Color.RED);
                ib.setTag(0);
                return;
            }
        }

        ib.setImageDrawable(miss);
        ib.setBackgroundColor(Color.BLUE);
    }

    /**
     * Method to check if the small ship is sunk
     */
    public void checkShipS()
    {
        for (ImageButton ib: ShipS){
            if (ib.getTag() .equals(1)) { return; }
        }
        ShipSSunk = true;
        ivShipS.setBackgroundColor(Color.RED);
    }

    /**
     * Method to check if the medium ship is sunk
     */
    public void checkShipM()
    {
        for (ImageButton ib: ShipM){
            if (ib.getTag().equals(1)) { return; }
        }
        ShipMSunk = true;
        ivShipM.setBackgroundColor(Color.RED);
    }

    /**
     * Method to check if the large ship is sunk
     */
    public void checkShipL()
    {
        for (ImageButton ib: ShipL){
            if (ib.getTag() .equals(1)) { return; }
        }
        ShipLSunk = true;
        ivShipL.setBackgroundColor(Color.RED);
    }

    /**
     * End activity that when given true will create a win activity, and when given false creates a lose activity
     */
    public void EndActivity(boolean b)
    {
        if (b)
        {
            Intent intent = new Intent(this, EndActivity.class);
            intent.putExtra("name", CurrentPlayer.name);
            intent.putExtra("id", CurrentPlayer.id);
            intent.putExtra("win", true);
            intent.putExtra("shots", shotsLeft);
            db.close();
            this.startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(this, EndActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("id", CurrentPlayer.id);
            intent.putExtra("win", false);
            db.close();
            this.startActivity(intent);
        }
    }
}