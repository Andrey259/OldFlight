package com.example.oldfly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

public class transition extends AppCompatActivity {
public static int plane =1;

public static MediaPlayer mus_for_game;


    public static FrameLayout fl_surfaceview_container;

    public static ImageButton replay;
    public static ImageButton restart;
    public static ImageView background_for_pause;


    public static int getPlane() {
        return plane;
    }

    public static void setPlane(int plane) {
        transition.plane = plane;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivity.back_ground_musik.stop();
        mus_for_game = MediaPlayer.create(this,R.raw.mus_for_game);
        mus_for_game.start();

        DrawView drawView = new DrawView(this);
        setContentView(R.layout.activity_transition);

        fl_surfaceview_container = (FrameLayout) findViewById(R.id.fragment_file_videoplayer_surface_container);

        TimeForHealthe timeForHealthe = new TimeForHealthe();
        timeForHealthe.start();//запуск потока для подсчета времени

        getSupportActionBar().hide();

        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();  // deprecated
        int height = display.getHeight();  // deprecated


        DrawView videoSurface = new DrawView(this);
        fl_surfaceview_container.addView(videoSurface);
        //fl_surfaceview_container.removeAllViews();

        background_for_pause = (ImageView) findViewById(R.id.background_pause);//задний фон меню паузы


        if (getPlane() == 1) {
            if(MainActivity.getGameMode() == 1) {
                ImageButton FuelBonus = new ImageButton(this);
                FuelBonus.setImageResource(R.drawable.petrol_buttom);

                FuelBonus.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (TimeForHealthe.flag == true) {
                            DrawThread.fuel += 200;
                            TimeForHealthe.flag = false;

                        }
                    }
                });
                ConstraintLayout.LayoutParams newLayoutParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                newLayoutParams.topMargin = height - 300;
                newLayoutParams.leftMargin = width - 400;
                this.addContentView(FuelBonus, newLayoutParams);// кнопка способности первого корабля (пополнение здоровья)
            }

        }

        if (getPlane() == 2) {
            ImageButton stop_time = new ImageButton(this);
            stop_time.setImageResource(R.drawable.bt_stop_time);
            stop_time.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (TimeForHealthe.flag == true) {
                        TimeForHealthe.flag = false;
                        DrawThread.for_stop_time = 300;
                        DrawThread.stop_time = true;

                    }
                }
            });
            ConstraintLayout.LayoutParams newLayoutParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            newLayoutParams.topMargin = height - 300;
            newLayoutParams.leftMargin = width - 400;
            this.addContentView(stop_time, newLayoutParams);// кнопка способности первого корабля (пополнение здоровья)
        }

        if (getPlane() == 3) {
            ImageButton gun = new ImageButton(this);
            gun.setImageResource(R.drawable.bt_shot);
            gun.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (TimeForHealthe.flag == true) {
                        TimeForHealthe.flag = false;
                        DrawThread.blasterX = DrawThread.towardPointX;
                        DrawThread.blasterY = DrawThread.towardPointY;
                    }
                }
            });
            ConstraintLayout.LayoutParams newLayoutParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            newLayoutParams.topMargin = height - 300;
            newLayoutParams.leftMargin = width - 400;
            this.addContentView(gun, newLayoutParams);// кнопка способности первого корабля (пополнение здоровья)
        }

        if (getPlane() == 4) {
            ImageButton shield = new ImageButton(this);
            shield.setImageResource(R.drawable.bt_shield);
            shield.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (TimeForHealthe.flag == true) {
                        TimeForHealthe.flag = false;
                        DrawThread.shield = true;


                    }
                }
            });
            ConstraintLayout.LayoutParams newLayoutParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            newLayoutParams.topMargin = height - 300;
            newLayoutParams.leftMargin = width - 400;
            this.addContentView(shield, newLayoutParams);// кнопка способности первого корабля (пополнение здоровья)
        }

        ImageButton btPause = findViewById(R.id.bt_pause);
        btPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replay.setVisibility(replay.getVisibility()== View.VISIBLE?View.INVISIBLE:View.VISIBLE);
                background_for_pause.setVisibility(background_for_pause.getVisibility()== View.VISIBLE?View.INVISIBLE:View.VISIBLE);
                restart.setVisibility(restart.getVisibility()== View.VISIBLE?View.INVISIBLE:View.VISIBLE);
                DrawThread.pause();
            }
        });//кнопка паузы


        replay = (ImageButton) findViewById(R.id.bt_for_replay);
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replay.setVisibility(replay.getVisibility()== View.VISIBLE?View.INVISIBLE:View.VISIBLE);
                background_for_pause.setVisibility(background_for_pause.getVisibility()== View.VISIBLE?View.INVISIBLE:View.VISIBLE);
                restart.setVisibility(restart.getVisibility()== View.VISIBLE?View.INVISIBLE:View.VISIBLE);
                DrawThread.pause();
                DrawThread.restartGame();
                fl_surfaceview_container.removeAllViews();
            }
        });//кнопка возврата в главное меню

        restart = (ImageButton) findViewById(R.id.bt_restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawThread.restartGame();
            }
        });//кнопка для перезапуска игры (сбивает все параметры )

    }
    }