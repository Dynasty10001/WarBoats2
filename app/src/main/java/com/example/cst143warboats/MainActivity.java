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
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    ImageView ivPic;
    ImageButton ibCamera;
    Button btnPlayGame;

    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            etName = findViewById(R.id.etName);
            ivPic = findViewById(R.id.ivPic);
            ibCamera = findViewById(R.id.ibCamera);
            btnPlayGame = findViewById(R.id.btnPlayGame);

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
            Intent intent = new Intent(this, PlayGame.class);
            intent.putExtra("name", etName.getText().toString());
//            intent.putExtra("img", ivPic.getDrawable().toString());
            this.startActivity(intent);
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
                String s = Cody();
            }
        }

        public void writePic(Bitmap imageBitmap) {
            try {
                File path = Environment.getExternalStorageDirectory();
                File file = new File(path, etName.getText().toString() + "Pic.png");
                FileOutputStream fileout = new FileOutputStream(file);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.close();
            }
            catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }




        public String Cody()
        {
            return null;
        }

}