package com.example.coursework3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent in = getIntent();
        int index = in.getIntExtra("itemIndex", -1);

        if (index > -1) {
            int pic = getImage(index);
            ImageView imageView = findViewById(R.id.imageView);
            scaleImage(imageView, pic);
        }

    }

    private int getImage(int index){
        switch (index){
            case 0: return R.drawable.peach;
            case 1: return R.drawable.tomato;
            case 2: return R.drawable.squash;
            default: return -1;
        }
    }

    private void scaleImage(ImageView img, int pic){
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if(imgWidth > screenWidth) {
            int ration = Math.round( imgWidth / screenWidth );
            options.inSampleSize = ration;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImage = BitmapFactory.decodeResource(getResources(), pic, options);

        img.setImageBitmap(scaledImage);
    }
}