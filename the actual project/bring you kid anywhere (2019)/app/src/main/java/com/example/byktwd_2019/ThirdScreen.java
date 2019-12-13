///////////// DEPRECATED

/*
package com.example.byktwd_2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ThirdScreen extends AppCompatActivity {
    ImageView katImage;

    */
/*ImageView bowWowImage;
    ImageView euniceImage;
//    AnimationDrawable anim;
    public int score = 0;
    TextView scoreText;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    private List<User> list_users = new ArrayList<>();*//*


    GameActivity doIt = new GameActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

////        GameActivity.callMe();

        katImage = findViewById(R.id.kat);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.old_activity_game_screen);

*/
/*        // Firebase! (i hope...)
        initFirebase();
        addEventFireBaseListener();

        bowWowImage = (ImageView)findViewById(R.id.bowWow);
        euniceImage = (ImageView)findViewById(R.id.eunice);
        scoreText = (TextView)findViewById(R.id.score);


        // load score
        SharedPreferences myScore = this.getSharedPreferences("MyAwesomeScore", Context.MODE_PRIVATE);
        score = myScore.getInt("score", 0);

        // update score
        scoreText.setText("score: " + score);

        findViewById(R.id.bowWow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(ThirdScreen.this, .class));
                score += 100;

                // save the score to user device
                SharedPreferences myScore = getSharedPreferences("MyAwesomeScore", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = myScore.edit();
                editor.putInt("score", score);
                editor.commit();

                scoreText.setText("score: " + score);
            }
        });*//*


        katImage.setOnClickListener(new View.OnClickListener() {
//            @Override
            public void onClick(View view) {
//                doIt.callMe();
            }
        });
    }

*/
/*    @Override
    protected void doEt() {

    }*//*


*/
/*    private void addEventFireBaseListener() {
        //Progressing?
//        circular_progress.setVisibility(View.VISIBLE);
//        list_data.setVisibility(View.VISIBLE);

        // is all this super relevant or necessary?

    }

    private void initFirebase() {
        FirebaseApp.initializeApp(this);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference();
    }*//*

}
*/
