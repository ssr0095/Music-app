package com.example.zoro;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.Objects;

public class Profile_page extends AppCompatActivity {

    ShapeableImageView profile;
    FloatingActionButton button;
    ImageView profile_icon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        button = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        profile = (ShapeableImageView) findViewById(R.id.profile);
//      profile_icon = (ShapeableImageView) findViewById(R.id.profile_icon);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.with(Profile_page.this)
                        .crop()                    //Crop image(Optional), Check Customization for more option
                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)    //Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        });

    }

        @Override
        public boolean onOptionsItemSelected (@NonNull MenuItem item){
            profile_icon = findViewById(R.id.profile_icon);

            if (item.getItemId() == android.R.id.home) {
                finish();
            }
            if(item.getItemId() == R.id.Downloads){
                startActivity(new Intent(Profile_page.this, DefaultSongs.class));
            }
            if(item.getItemId() == R.id.Songs){
                startActivity(new Intent(Profile_page.this, Song_home.class));
            }
            if (item.getItemId() == R.id.logout) {
                startActivity(new Intent(Profile_page.this, Login_page.class));
            }
            if (item.getItemId() == R.id.profile_icon) {
                startActivity(new Intent(Profile_page.this, Login_page.class));
            }
            return super.onOptionsItemSelected(item);
        }


        @Override
        public void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            assert data != null;
            Uri uri = data.getData();
            profile.setImageURI(uri);
//        profile_icon.setImageURI(uri);
        }

}