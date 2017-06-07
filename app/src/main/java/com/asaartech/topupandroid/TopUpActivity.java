package com.asaartech.topupandroid;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class TopUpActivity extends AppCompatActivity {

    String carrier;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        carrier = getIntent().getStringExtra("CARRIER");
        setTitle(carrier);

        imageView = (ImageView) findViewById(R.id.imageView);


        loadImage();


    }

    public void loadImage(){
        File imageFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File imgFile = new File(imageFile + "/stu/myImage.jpg");

        if(imgFile.exists()){

//            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

//            Uri uri = Uri.fromFile(imgFile);
//            imageView.setImageURI(uri);
//            performCrop(uri);

            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getPath());
//            myBitmap.setWidth(imageView.getWidth());
//            myBitmap.setHeight(imageView.getHeight());

            imageView.setImageBitmap(myBitmap);
            imageView.setRotation(90);



            Toast.makeText(this, "Image Loaded", Toast.LENGTH_SHORT).show();

        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
