package com.example.byktwd_2019;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.SharedPreferences;

public class GameActivity extends AppCompatActivity {

    ImageView bowWowImage;
    ImageView euniceImage;
    ImageView tankImage;
    ImageView katImage;
    ImageView characterImage;
    ImageView flowerImage;
    ImageView computerImage;

    TextView scoreText;
    public int score = 0;
//    Boolean alreadySelected = false;
    MediaPlayer song;
    SoundPool sound;
    int smackId;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        song = MediaPlayer.create(GameActivity.this, R.raw.memo_evan_king);
//        song.setVolume(2, 2);
        song.setLooping(true);
        song.start();


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            sound = new SoundPool.Builder()
                    .setMaxStreams(10)

                    .build();
            smackId = sound.load(this, R.raw.smacksound, 1);
        } else {
            sound = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);
            smackId = sound.load(this, R.raw.smacksound, 1);
        }


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_game_screen);

        bowWowImage = findViewById(R.id.bowWow);
        euniceImage = findViewById(R.id.eunice);
        tankImage = findViewById(R.id.tank);
        katImage = findViewById(R.id.kat);
        characterImage = findViewById(R.id.character_selected);
        flowerImage = findViewById(R.id.flower_a);
        computerImage = findViewById(R.id.computer_a);


//        if (bowWowImage.performClick()) {
//            euniceImage.setVisibility(View.INVISIBLE); // something i wanted to call the method with. still didn't work tho.
//        }


        ////////// character selection listeners!

        bowWowImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(GameActivity.this, ThirdScreen.class));
                bowWowImage.setVisibility(View.INVISIBLE);
                euniceImage.setVisibility(View.INVISIBLE);
                tankImage.setVisibility(View.INVISIBLE);
                katImage.setVisibility(View.INVISIBLE);
                characterImage.setImageResource(R.drawable.bback);
                characterImage.setVisibility(View.VISIBLE);
            }
        });

        euniceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(GameActivity.this, ThirdScreen.class));
                bowWowImage.setVisibility(View.INVISIBLE);
                euniceImage.setVisibility(View.INVISIBLE);
                tankImage.setVisibility(View.INVISIBLE);
                katImage.setVisibility(View.INVISIBLE);
                characterImage.setVisibility(View.VISIBLE);

                characterImage.setImageResource(R.drawable.euniceidle);
                AnimationDrawable euniceDrawable = (AnimationDrawable) characterImage.getDrawable();
                euniceDrawable.start();

            }
        });

        tankImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(GameActivity.this, ThirdScreen.class));
                bowWowImage.setVisibility(View.INVISIBLE);
                euniceImage.setVisibility(View.INVISIBLE);
                tankImage.setVisibility(View.INVISIBLE);
                katImage.setVisibility(View.INVISIBLE);
                characterImage.setImageResource(R.drawable.tfront);
                characterImage.setVisibility(View.VISIBLE);
            }
        });

        katImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(GameActivity.this, ThirdScreen.class));
////                callMe();
                bowWowImage.setVisibility(View.INVISIBLE);
                euniceImage.setVisibility(View.INVISIBLE);
                tankImage.setVisibility(View.INVISIBLE);
                katImage.setVisibility(View.INVISIBLE);
                characterImage.setImageResource(R.drawable.kfront);
                characterImage.setVisibility(View.VISIBLE);
//                callMe(R.drawable.kfront);
            }
        });

        characterImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(GameActivity.this, ThirdScreen.class));
                bowWowImage.setVisibility(View.INVISIBLE);
                euniceImage.setVisibility(View.INVISIBLE);
                tankImage.setVisibility(View.INVISIBLE);
                katImage.setVisibility(View.INVISIBLE);
                characterImage.setVisibility(View.VISIBLE);

                characterImage.setImageResource(R.drawable.euniceboop);
                AnimationDrawable euniceDrawable = (AnimationDrawable) characterImage.getDrawable();
                euniceDrawable.start();
            }
        });


        /////////////////// NEXT: implement animation.
        /// and a better score system.



        /////////// muuuuuusiiiiiiiiiiiiic!~



        //////////// score related things!

        scoreText = findViewById(R.id.score);


        // load score
        SharedPreferences myScore = this.getSharedPreferences("MyAwesomeScore", Context.MODE_PRIVATE);
        score = myScore.getInt("score", 0);

        // update score
        scoreText.setText("score: " + score);

        // if user touches an object (the flower in this case) then move towards said object.
        flowerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                startActivity(new Intent(ThirdScreen.this, .class));
                score += 100;

                // save the score to user device
                SharedPreferences myScore = getSharedPreferences("MyAwesomeScore", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = myScore.edit();
                editor.putInt("score", score);
                editor.apply();

                scoreText.setText("score: " + score);

                flowerImage.setImageResource(R.drawable.flower_b);

                characterImage.setX(flowerImage.getX() - 100);
                characterImage.setY(flowerImage.getY() + 100);
                characterImage.setImageResource(R.drawable.eunicewalkright);
                AnimationDrawable euniceDrawable = (AnimationDrawable) characterImage.getDrawable();
                euniceDrawable.start();
            }
        });

        // if user touches an object (the computer in this case) then move towards said object.
        computerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                startActivity(new Intent(ThirdScreen.this, .class));
                score += 1000;

                // save the score to user device
                SharedPreferences myScore = getSharedPreferences("MyAwesomeScore", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = myScore.edit();
                editor.putInt("score", score);
                editor.apply();

                scoreText.setText("score: " + score);

                computerImage.setImageResource(R.drawable.computer_b);

                characterImage.setX(computerImage.getX());
                characterImage.setY(computerImage.getY() + 300);
                characterImage.setImageResource(R.drawable.eunicestandback);
                AnimationDrawable euniceDrawable = (AnimationDrawable) characterImage.getDrawable();
                euniceDrawable.start();
            }
        });
    }

    public void playSmack(View view) {
        sound.play(smackId, 1, 1, 1, 0, 1);
    }

    public void callMe(Drawable woah) { // some sad attempt at shoving the click listeners in one single neat little method
/*        bowWowImage.setVisibility(View.INVISIBLE);
        euniceImage.setVisibility(View.INVISIBLE);
        tankImage.setVisibility(View.INVISIBLE);
        katImage.setVisibility(View.INVISIBLE);
        characterImage.setImageResource(woah);
        characterImage.setVisibility(View.VISIBLE);

        woah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(ThirdScreen.this, .class));
                score += 100;

                // save the score to user device
                SharedPreferences myScore = getSharedPreferences("MyAwesomeScore", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = myScore.edit();
                editor.putInt("score", score);
                editor.apply();

                scoreText.setText("score: " + score);
            }
        });*/
    }

    protected void onPause() {
        super.onPause();
////        song.release();
    }
}

