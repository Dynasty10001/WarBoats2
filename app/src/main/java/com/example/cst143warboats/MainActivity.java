package com.example.cst143warboats;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    ImageView ivPic;
    ImageButton ibCamera;
    Button btnPlayGame;
    Spinner playerSpin;

    private DBhelper db;
    private Cursor cursor;

    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;

    ArrayList<player> playerList;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            etName = findViewById(R.id.etName);
            ivPic = findViewById(R.id.ivPic);
            ibCamera = findViewById(R.id.ibCamera);
            btnPlayGame = findViewById(R.id.btnPlayGame);

            db = new DBhelper(this);
            db.open();

            Intent intent = new Intent(this, FireNotification.class);
            PendingIntent pIntent = PendingIntent.getService(this, 1000, intent, PendingIntent.FLAG_CANCEL_CURRENT);

            AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            //set to 7000 or 7 seconds for testing,otherwise set to 86400000 or 24 hours
            am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 86400000, pIntent);

            populateSpinner();

        ibCamera.setOnClickListener(v -> {

            checkPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE);
            checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE);
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED &&
                    checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                if(etName.getText().toString().matches(""))
                {
                    Toast.makeText(MainActivity.this, "Please Enter a Name First", Toast.LENGTH_LONG).show();
                }
                else
                {
                    dispatchTakePictureIntent();
                }

            }
            else {
                Toast.makeText(MainActivity.this, "Permission Not Granted", Toast.LENGTH_SHORT).show();
            }
        });

        btnPlayGame.setOnClickListener(v -> PlayGame());

    }

    // Function to check and request permission.
    public boolean checkPermission(String permission, int requestCode)
    {

            if (ContextCompat.checkSelfPermission(MainActivity.this, permission) == PackageManager.PERMISSION_GRANTED) {
                return true;
            }
            else {
                // Requesting the permission
                ActivityCompat.requestPermissions(MainActivity.this, new String[] { permission }, requestCode);
                return ContextCompat.checkSelfPermission(MainActivity.this, permission) == PackageManager.PERMISSION_GRANTED;
            }

    }

    // This function is called when the user accepts or decline the permission.
    // Request Code is used to check which permission called this function.
    // This request code is provided when the user is prompt for permission.

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode,
                permissions,
                grantResults);

        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this, "Camera Permission Granted", Toast.LENGTH_SHORT) .show();
            }
            else {
                Toast.makeText(MainActivity.this, "Camera Permission Denied", Toast.LENGTH_SHORT) .show();
            }
        }
        else if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this, "Storage Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Storage Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

        public void PlayGame() {
            if (etName.getText().toString().trim().length() == 0)
            {
                Toast.makeText(this, "You must enter a name", Toast.LENGTH_SHORT).show();
            }
            else {
                db.open();
                String s = Environment.getExternalStorageDirectory().toString() + "/";
                player CurrentPlayer = new player(etName.getText().toString().trim(), 0, s + etName.getText().toString().trim() + "Pic.png");
                playerList = db.getPlayerlist();

                boolean b = true;
                long id = 0;
                for (player player: playerList)
                {
                    if (CurrentPlayer.name.equals(player.name))
                    {
                        b=false;
                        CurrentPlayer.id = player.id;
                        if (player.score > 0)
                        {
                            CurrentPlayer.score = player.score;
                        }
                        File imgFile = new  File(CurrentPlayer.pic);

                        if(imgFile.exists()){

                        }
                        else
                        {
                            CurrentPlayer.pic = player.pic;
                            db.updatePlayer(CurrentPlayer);
                        }

                        id = player.id;
                        break;
                    }
                }

                if (b)
                {
                    db.createPlayer(CurrentPlayer);
                    Intent intent = new Intent(this, PlayGame.class);
                    intent.putExtra("name", CurrentPlayer.name);
                    intent.putExtra("id", id);
                    this.startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(this, PlayGame.class);
                    intent.putExtra("name", CurrentPlayer.name);
                    intent.putExtra("id", id);
                    this.startActivity(intent);

                }



            }
        }

        static final int REQUEST_IMAGE_CAPTURE = 1;

        private void dispatchTakePictureIntent() {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            try {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            } catch (ActivityNotFoundException e) {
                // display error state to the user
            }
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                ivPic.setImageBitmap(imageBitmap);
                String path = Environment.getExternalStorageDirectory().toString();
                File file = new File(path, etName.getText().toString().trim() + "Pic.png");
                try(FileOutputStream fileOut = new FileOutputStream(file)){
                    imageBitmap.compress(Bitmap.CompressFormat.PNG,100,fileOut);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void populateSpinner()
        {
            db.open();
            cursor = db.getAllPlayers();
            playerList = db.getPlayerlist();
            ArrayList<String> spinList = new ArrayList<>();
            for (player p :playerList)
            {
                    spinList.add(p.id + " " + p.name);
            }

            playerSpin = findViewById(R.id.playerSpin);
            ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinList);
            ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            playerSpin.setAdapter(ad);
            db.close();
        }

}