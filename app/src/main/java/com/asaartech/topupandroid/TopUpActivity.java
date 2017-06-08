package com.asaartech.topupandroid;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
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

            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getPath());
            int width = myBitmap.getWidth();
            int height = myBitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postRotate(90);

            Bitmap resizedBitmap = Bitmap.createBitmap(myBitmap, 0, 0,
                    width, height, matrix, true);

            // make a Drawable from Bitmap to allow to set the BitMap
            // to the ImageView, ImageButton or what ever
            BitmapDrawable bitmapDrawable = new BitmapDrawable(resizedBitmap);

            imageView.setImageDrawable(bitmapDrawable);

            // center the Image
            imageView.setScaleType(ImageView.ScaleType.FIT_START);


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
