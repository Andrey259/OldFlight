package com.example.oldfly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AirplaneSelection extends AppCompatActivity {

    public static boolean flag_for_stop = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airplane_selection);
        getSupportActionBar().hide();

        ImageButton Back = findViewById(R.id.btBackToMenuAir);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AirplaneSelection.this, MainActivity.class);
                startActivity(i);
            }
        }); //Кнопка возврата в меню

        Button First = findViewById(R.id.btFirst);
        First.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(AirplaneSelection.this, transition.class);
                startActivity(i);
                transition.setPlane(1);
            }
        });//Кнопка выбора первого корабля

        Button Second = findViewById(R.id.btSecond);
        Second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(AirplaneSelection.this, transition.class);
                startActivity(i);
                transition.setPlane(2);
            }
        });//Кнопка выбора второго корабля

        Button Threa = findViewById(R.id.btTherd);
        Threa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AirplaneSelection.this, transition.class);
                startActivity(i);
               transition.setPlane(3);
            }
        });//Кнопка выбора третьего корабля

        Button Four = findViewById(R.id.btFourth);
        Four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AirplaneSelection.this, transition.class);
                startActivity(i);
               transition.setPlane(4);
            }
        });//Кнопка выбора четвертого корабля

    }
}