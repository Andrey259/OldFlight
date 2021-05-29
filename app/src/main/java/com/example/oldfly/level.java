package com.example.oldfly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class level extends AppCompatActivity {

    public static int getNumberLevel() {
        return NumberLevel;
    }

    public static void setNumberLevel(int numberLevel) {
        NumberLevel = numberLevel;
    }

    public static int NumberLevel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        getSupportActionBar().hide();

        ImageButton first = findViewById(R.id.bt_first_level);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberLevel = 1;
                Intent i = new Intent(level.this, AirplaneSelection.class);
                startActivity(i);
            }
        }); //кнопка первого лвл

        ImageButton second = findViewById(R.id.bt_second_level);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberLevel = 2;
                Intent i = new Intent(level.this, AirplaneSelection.class);
                startActivity(i);
            }
        }); //кнопка второго лвл

        ImageButton third = findViewById(R.id.bt_third_level);
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberLevel = 3;
                Intent i = new Intent(level.this, AirplaneSelection.class);
                startActivity(i);
            }
        }); //кнопка третьего лвл

        ImageButton btBackToMenu = findViewById(R.id.btBackLevel);
        btBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(level.this, MainActivity.class);
                startActivity(i);
            }
        }); //кнопка третьего лвл


    }
}