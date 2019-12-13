package com.example.byktwd_2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    MediaPlayer song;
    SoundPool secondtry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        song = MediaPlayer.create(this, R.raw.bgmusic_by_jay_oglesby);
        //        song.setVolume(2, 2);
        song.setLooping(true);
        song.start();

//        song.setVolume(200f, 2000f);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                song.release();
                startActivity(new Intent(SplashActivity.this, GameActivity.class));
            }
        });
    }

/*    public void playIntro(View view) {
        song.start();
    }*/
}
