package com.example.oldfly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
public static int gameMode = 0;
public static int raz = 0;

public static boolean mus_mode = true;//для включения и выключения музыки

public static MediaPlayer back_ground_musik;

    public static int getGameMode() {
        return gameMode;
    }

    public static void setGameMode(int gameMode) {
        MainActivity.gameMode = gameMode;
    }

    private Paint backgroundPaintForMain = new Paint();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        if (mus_mode==true){
if (raz==0){ back_ground_musik = MediaPlayer.create(this,R.raw.back_musik);raz++;}
if (back_ground_musik.isPlaying()==false){
        back_ground_musik.start();}
        }

        ImageButton btFreeRun = findViewById(R.id.btFreeRun);
        btFreeRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AirplaneSelection.class);
                startActivity(i);
                setGameMode(1);
            }
        });//кнопка свободной игы (перенаправляет в AirplaneSelection) и даёт gameMode значение 1

        ImageButton btCareer = findViewById(R.id.btCareer);
        btCareer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, level.class);
                startActivity(i);
                setGameMode(2);
            }
        });//кнопка Career (перенаправляет в AirplaneSelection) и даёт gameMode значение 2




    }
}