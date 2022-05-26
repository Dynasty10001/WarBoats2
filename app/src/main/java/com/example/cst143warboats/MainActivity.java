package com.example.cst143warboats;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    ImageView ivPic;
    ImageButton ibCamera;
    Button btnPlayGame;

    private ImageButton ib1;
    private ImageButton ib2;
    private ImageButton ib3;
    private ImageButton ib4;
    private ImageButton ib5;
    private ImageButton ib6;
    private ImageButton ib7;
    private ImageButton ib8;
    private ImageButton ib9;
    private ImageButton ib10;
    private ImageButton ib11;
    private ImageButton ib12;
    private ImageButton ib13;
    private ImageButton ib14;
    private ImageButton ib15;
    private ImageButton ib16;
    private ImageButton ib17;
    private ImageButton ib18;
    private ImageButton ib19;
    private ImageButton ib20;
    private ImageButton ib21;
    private ImageButton ib22;
    private ImageButton ib23;
    private ImageButton ib24;
    private ImageButton ib25;
    private ImageButton ib26;
    private ImageButton ib27;
    private ImageButton ib28;
    private ImageButton ib29;
    private ImageButton ib30;
    private ImageButton ib31;
    private ImageButton ib32;
    private ImageButton ib33;
    private ImageButton ib34;
    private ImageButton ib35;
    private ImageButton ib36;
    private ImageButton ib37;
    private ImageButton ib38;
    private ImageButton ib39;
    private ImageButton ib40;
    private ImageButton ib41;
    private ImageButton ib42;
    private ImageButton ib43;
    private ImageButton ib44;
    private ImageButton ib45;
    private ImageButton ib46;
    private ImageButton ib47;
    private ImageButton ib48;
    private ImageButton ib49;
    private ImageButton ib50;
    private ImageButton ib51;
    private ImageButton ib52;
    private ImageButton ib53;
    private ImageButton ib54;
    private ImageButton ib55;
    private ImageButton ib56;
    private ImageButton ib57;
    private ImageButton ib58;
    private ImageButton ib59;
    private ImageButton ib60;
    private ImageButton ib61;
    private ImageButton ib62;
    private ImageButton ib63;
    private ImageButton ib64;

    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            etName = findViewById(R.id.etName);
            ivPic = findViewById(R.id.ivPic);;
            ibCamera = findViewById(R.id.ibCamera);;
            btnPlayGame = findViewById(R.id.btnPlayGame);;

        ibCamera.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v)
            {

                checkPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE);
                checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE);
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED &&
                        checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    dispatchTakePictureIntent();
                }
                else {
                    Toast.makeText(MainActivity.this, "Permission Not Granted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnPlayGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                PlayGame();
            }
        });
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
                if (ContextCompat.checkSelfPermission(MainActivity.this, permission) == PackageManager.PERMISSION_GRANTED) {
                    return true;
                }
                else {
                    return false;
                }
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
//            Intent intent = new Intent(this, PlayGame.class);
//            intent.putExtra("name", etName.getText().toString());
//            intent.putExtra("img", ivPic.getDrawable().toString());
//            this.startActivity(intent);
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
            }
        }



}