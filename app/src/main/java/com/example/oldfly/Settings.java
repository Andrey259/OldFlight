package com.example.oldfly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Settings extends AppCompatActivity {
   public static ImageButton bt_mus_on;
   public static ImageButton bt_mus_off;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().hide();


        ImageButton BackSet = findViewById(R.id.btBackToMenu);
        BackSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Settings.this, MainActivity.class);
                startActivity(i);
            }
        });//кнопка возврата в главное меню


            bt_mus_on = findViewById(R.id.bt_mus_on);
            bt_mus_on.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bt_mus_off.setVisibility(View.VISIBLE);
                    bt_mus_on.setVisibility(View.INVISIBLE);
                    MainActivity.mus_mode = false;
                    MainActivity.back_ground_musik.stop();
                }
            });//кнопка возврата в главное меню

            bt_mus_off = findViewById(R.id.bt_mus_off);
            bt_mus_off.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bt_mus_off.setVisibility(View.INVISIBLE);
                    bt_mus_on.setVisibility(View.VISIBLE);
                    MainActivity.mus_mode = true;
                }
            });//кнопка возврата в главное меню


    }
}