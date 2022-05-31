package com.example.cst143warboats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PlayGame extends AppCompatActivity implements View.OnClickListener {

    TextView tvName;
    TextView tvBest;
    TextView tvRemain;

    String name;

    ImageButton[] ShipS = new ImageButton[2];
    ImageButton[] ShipM = new ImageButton[3];
    ImageButton[] ShipL = new ImageButton[4];

    int shotsLeft = 30;

    boolean ShipSSunk = false;
    boolean ShipMSunk = false;
    boolean ShipLSunk = false;

    //TODO Look Into SVG (Font Awesome?)

    Drawable hit;
    Drawable miss;

    ImageButton ib1,ib2,ib3,ib4,ib5,ib6,ib7,ib8,ib9,ib10,ib11,ib12,ib13,ib14,ib15,ib16,ib17,ib18,ib19,ib20,ib21,ib22,ib23,ib24,ib25,ib26,ib27,ib28,ib29,ib30,ib31,ib32,ib33,ib34,ib35,ib36,ib37,ib38,ib39,ib40,
            ib41,ib42,ib43,ib44,ib45,ib46,ib47,ib48,ib49,ib50,ib51,ib52,ib53,ib54,ib55,ib56,ib57,ib58,ib59,ib60,ib61,ib62,ib63,ib64;


    private ImageButton[] Buttons = {ib1,ib2,ib3,ib4,ib5,ib6,ib7,ib8,ib9,ib10,ib11,ib12,ib13,ib14,ib15,ib16,ib17,ib18,ib19,ib20,ib21,ib22,ib23,ib24,ib25,ib26,ib27,ib28,ib29,ib30,ib31,ib32,ib33,ib34,ib35,ib36,ib37,ib38,ib39,ib40,
            ib41,ib42,ib43,ib44,ib45,ib46,ib47,ib48,ib49,ib50,ib51,ib52,ib53,ib54,ib55,ib56,ib57,ib58,ib59,ib60,ib61,ib62,ib63,ib64};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        name = b.getString("name");

        tvBest = findViewById(R.id.tvBest);
        tvName = findViewById(R.id.tvName);
        tvRemain = findViewById(R.id.tvRemain);

        tvName.setText("Capn' " + name);
        tvRemain.setText("Number of Shots Left: " + shotsLeft);

        miss = getResources().getDrawable(R.drawable.ic_sploosh);
        hit = getResources().getDrawable(R.drawable.ic_explosion);

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

        Buttons[0].setOnClickListener(this);
        Buttons[1].setOnClickListener(this);
        Buttons[2].setOnClickListener(this);
        Buttons[3].setOnClickListener(this);
        Buttons[4].setOnClickListener(this);
        Buttons[5].setOnClickListener(this);
        Buttons[6].setOnClickListener(this);
        Buttons[7].setOnClickListener(this);
        Buttons[8].setOnClickListener(this);
        Buttons[9].setOnClickListener(this);
        Buttons[10].setOnClickListener(this);
        Buttons[11].setOnClickListener(this);
        Buttons[12].setOnClickListener(this);
        Buttons[13].setOnClickListener(this);
        Buttons[14].setOnClickListener(this);
        Buttons[15].setOnClickListener(this);
        Buttons[16].setOnClickListener(this);
        Buttons[17].setOnClickListener(this);
        Buttons[18].setOnClickListener(this);
        Buttons[19].setOnClickListener(this);
        Buttons[20].setOnClickListener(this);
        Buttons[21].setOnClickListener(this);
        Buttons[22].setOnClickListener(this);
        Buttons[23].setOnClickListener(this);
        Buttons[24].setOnClickListener(this);
        Buttons[25].setOnClickListener(this);
        Buttons[26].setOnClickListener(this);
        Buttons[27].setOnClickListener(this);
        Buttons[28].setOnClickListener(this);
        Buttons[29].setOnClickListener(this);
        Buttons[30].setOnClickListener(this);
        Buttons[31].setOnClickListener(this);
        Buttons[32].setOnClickListener(this);
        Buttons[33].setOnClickListener(this);
        Buttons[34].setOnClickListener(this);
        Buttons[35].setOnClickListener(this);
        Buttons[36].setOnClickListener(this);
        Buttons[37].setOnClickListener(this);
        Buttons[38].setOnClickListener(this);
        Buttons[39].setOnClickListener(this);
        Buttons[40].setOnClickListener(this);
        Buttons[41].setOnClickListener(this);
        Buttons[42].setOnClickListener(this);
        Buttons[43].setOnClickListener(this);
        Buttons[44].setOnClickListener(this);
        Buttons[45].setOnClickListener(this);
        Buttons[46].setOnClickListener(this);
        Buttons[47].setOnClickListener(this);
        Buttons[48].setOnClickListener(this);
        Buttons[49].setOnClickListener(this);
        Buttons[50].setOnClickListener(this);
        Buttons[51].setOnClickListener(this);
        Buttons[52].setOnClickListener(this);
        Buttons[53].setOnClickListener(this);
        Buttons[54].setOnClickListener(this);
        Buttons[55].setOnClickListener(this);
        Buttons[56].setOnClickListener(this);
        Buttons[57].setOnClickListener(this);
        Buttons[58].setOnClickListener(this);
        Buttons[59].setOnClickListener(this);
        Buttons[60].setOnClickListener(this);
        Buttons[61].setOnClickListener(this);
        Buttons[62].setOnClickListener(this);
        Buttons[63].setOnClickListener(this);

        RandomiseLocation();

    }

    private void RandomiseLocation() {
        //Checking horizontal or vertical orientation of ship

        int[] locations = new int[64];
        for (int i = 0; i<locations.length; i++) {
            locations[i] = i;
        }

        int[] tempS = new int[2];
        int[] tempM = new int[3];
        int[] tempL = new int[4];

        boolean b1 = (Math.random() > 0.5);
        boolean b2 = (Math.random() > 0.5);
        boolean b3 = (Math.random() > 0.5);


        if (b1){
            int l = 9 - tempL.length;
            boolean b = true;
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
                    }
                }
            } while (b);
        }
        else {
            int l = 9 - tempL.length;
            boolean b = true;
            do {
                b=false;
                //vertical
                int y = (int) Math.floor(Math.random() * l) + 1;//5
                int x = (int) Math.floor(Math.random() * 8) + 1;//2
                for (int i = 0; i < tempL.length; i++) {
                    int temp = ((y -1) * 8) + x + (i * 8);
                    tempL[i] = temp;
                }
                for (int i = 0; i<tempL.length; i++) {
                    if (locations[tempL[i] - 1] == -1) {
                        b = true;
                    }
                }
            } while (b);
        }

        for (int i = 0; i<tempL.length; i++) { locations[tempL[i] - 1] = -1; }

        if (b2){
            int l = 9 - tempM.length;
            boolean b = true;
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
                    }
                }
            } while (b);
        }
        else {
            int l = 9 - tempM.length;
            boolean b = true;
            do {
                b=false;
                //vertical
                int y = (int) Math.floor(Math.random() * l) + 1;
                int x = (int) Math.floor(Math.random() * 8) + 1;
                for (int i = 0; i < tempM.length; i++) {
                    int temp = ((y -1) * 8) + x + (i * 8);
                    tempM[i] = temp;
                }
                for (int i = 0; i<tempM.length; i++) {
                    if (locations[tempM[i] - 1] == -1) {
                        b = true;
                    }
                }
            } while (b);
        }

        for (int i = 0; i<tempM.length; i++) { locations[tempM[i] - 1] = -1; }

        if (b3){
            int l = 9 - tempS.length;
            boolean b = true;
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
                    }
                }
            } while (b);
        }
        else {
            int l = 9 - tempS.length;
            boolean b = true;
            do {
                b=false;
                //vertical
                int y = (int) Math.floor(Math.random() * l) + 1;
                int x = (int) Math.floor(Math.random() * 8) + 1;
                for (int i = 0; i < tempS.length; i++) {
                    int temp = ((y -1) * 8) + x + (i * 8);
                    tempS[i] = temp;
                }
                for (int i = 0; i<tempS.length; i++) {
                    if (locations[tempS[i] - 1] == -1) {
                        b = true;
                    }
                }
            } while (b);
        }

        for (int i = 0; i<tempS.length; i++) { locations[tempS[i] - 1] = -1; }

        for (int i =0; i< ShipL.length; i++) { ShipL[i] = Buttons[tempL[i]]; }
        for (int i =0; i< ShipM.length; i++) { ShipM[i] = Buttons[tempM[i]]; }
        for (int i =0; i< ShipS.length; i++) { ShipS[i] = Buttons[tempS[i]]; }
    }

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

        if(ShipSSunk && ShipMSunk && ShipLSunk){
            EndActivity(true);
        }
        if(!ShipSSunk){ checkShipS(); }
        if(!ShipMSunk){ checkShipM(); }
        if(!ShipLSunk){ checkShipL(); }

    }

    public boolean checkHit(ImageButton ib)
    {

        for (ImageButton i: ShipS) {
            if (i == ib) {
                ib.setImageDrawable(hit);
                return true;
            }
        }
        for (ImageButton i: ShipM) {
            if (i == ib) {
                ib.setImageDrawable(hit);
                return true;
            }
        }
        for (ImageButton i: ShipL) {
            if (i == ib) {
                ib.setImageDrawable(hit);
                return true;
            }
        }

        ib.setImageDrawable(miss);
        return false;
    }

    public void checkShipS()
    {
        for (ImageButton ib: ShipS){
            if (ib.isClickable()) { return; }
        }
        ShipSSunk = true;
    }

    public void checkShipM()
    {
        for (ImageButton ib: ShipM){
            if (ib.isClickable()) { return; }
        }
        ShipMSunk = true;
    }

    public void checkShipL()
    {
        for (ImageButton ib: ShipL){
            if (ib.isClickable()) { return; }
        }
        ShipLSunk = true;
    }

    public void EndActivity(boolean b)
    {
        if (b)
        {
            Intent intent = new Intent(this, EndActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("win", false);
            intent.putExtra("shots", shotsLeft);
            this.startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(this, EndActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("win", false);
            this.startActivity(intent);
        }

    }
}