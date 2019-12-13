package com.example.byktwd_2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;


// this class is currently not being used

public class NOTGameActivity extends AppCompatActivity {

    private NOTGameView NOTgameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /*Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);*/

////////        NOTgameView = new NOTGameView(this);

        setContentView(NOTgameView);
//        setContentView(R.layout.activity_game_screen);
    }

    @Override
    protected void onPause() {
        super.onPause();
        NOTgameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        NOTgameView.resume();
    }
}