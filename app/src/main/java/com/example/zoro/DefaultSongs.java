package com.example.zoro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class DefaultSongs extends AppCompatActivity {

    TextView titleTv;
    MediaPlayer mediaPlayer0,mediaPlayer1,mediaPlayer4,mediaPlayer5,mediaPlayer6,mediaPlayer2,mediaPlayer3;
    Button play0,play1,play2,play3,play4,play5,play6,pause0,pause1,pause2,pause3,pause4,pause5,pause6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_songs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        mediaPlayer0 = MediaPlayer.create(this, R.raw.nakka_mukka);
        mediaPlayer1 = MediaPlayer.create(this, R.raw.po_po_po);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.kan_peasum_varthaigal);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.nenjai_kasaki);
        mediaPlayer4 = MediaPlayer.create(this, R.raw.vaada_va_machi);
        mediaPlayer5 = MediaPlayer.create(this, R.raw.venmegam_pennaga);
        mediaPlayer6 = MediaPlayer.create(this, R.raw.mr_bean_song);


        play0 = (Button) findViewById(R.id.play0);
        play1 = (Button) findViewById(R.id.play1);
        play2 = (Button) findViewById(R.id.play2);
        play3 = (Button) findViewById(R.id.play3);
        play4 = (Button) findViewById(R.id.play4);
        play5 = (Button) findViewById(R.id.play5);
        play6 = (Button) findViewById(R.id.play6);

        pause0 = (Button) findViewById(R.id.pause0);
        pause1 = (Button) findViewById(R.id.pause1);
        pause2 = (Button) findViewById(R.id.pause2);
        pause3 = (Button) findViewById(R.id.pause3);
        pause4 = (Button) findViewById(R.id.pause4);
        pause5 = (Button) findViewById(R.id.pause5);
        pause6 = (Button) findViewById(R.id.pause6);



        play0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer0.start();
            }
        });
        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer1.start();
            }
        });
        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer2.start();
            }
        });
        play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer3.start();
            }
        });
        play4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer4.start();
            }
        });
        play5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer5.start();
            }
        });
        play6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer6.start();
            }
        });
        pause0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer0.pause();
            }
        });
        pause1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer1.pause();
            }
        });
        pause2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer2.pause();
            }
        });
        pause3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer3.pause();
            }
        });
        pause4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer4.pause();
            }
        });
        pause5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer5.pause();
            }
        });
        pause6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer6.pause();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        if(item.getItemId() == R.id.Downloads){
            startActivity(new Intent(DefaultSongs.this, DefaultSongs.class));
        }
        if(item.getItemId() == R.id.Songs){
            startActivity(new Intent(DefaultSongs.this, Song_home.class));
        }
        if(item.getItemId() == R.id.logout){
            startActivity(new Intent(DefaultSongs.this, Login_page.class));
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

}
