package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {
    int[] myGame = {2,2,2,2,2,2,2,2,2};
    int gameTrack = 0;
    public void imageTapped(View view){
        ImageView img = (ImageView) view;
        int imageTag = Integer.parseInt(img.getTag().toString());
        if (myGame[imageTag] == 2) {
            myGame[imageTag] = gameTrack;
            if (gameTrack == 0) {
                img.setImageResource(R.drawable.cross);
                img.animate().rotation(360).setDuration(500);
                gameTrack = 1;
            } else {
                img.setImageResource(R.drawable.circle);
                gameTrack = 0;
            }
        } else {
            Toast toast=Toast.makeText(getApplicationContext(),"Place is already filled !",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void playAgain(View view){
        for (int i = 0 ; i < myGame.length ; i++){
            myGame[i] = 2;
        }
        gameTrack = 0;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.line1);
        for (int i = 0 ; i < linearLayout.getChildCount() ; i++){
            ((ImageView) linearLayout.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayoutOne = (LinearLayout) findViewById(R.id.line2);
        for (int i = 0 ; i < linearLayoutOne.getChildCount() ; i++){
            ((ImageView) linearLayoutOne.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayoutTwo = (LinearLayout) findViewById(R.id.line3);
        for (int i = 0 ; i < linearLayoutTwo.getChildCount() ; i++){
            ((ImageView) linearLayoutTwo.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
