package com.example.oldfly;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;



public class DrawThread extends Thread {
    private SurfaceHolder surfaceHolder;

public static boolean pause = false;
public static boolean stop_time = false;
public static int for_stop_time = 0;
public static boolean shield = false;
public static int for_help = 500;
public static int amount_fuel = 0;

    private volatile boolean running = true;
    private Paint backgroundPaint = new Paint();
    private Paint forfuel = new Paint();
    private Paint okantFuel = new Paint();
    private Bitmap FirstShip;
    private Bitmap shoting;
    private Bitmap SecondShip;
    private Bitmap FourShip;
    private Bitmap FourShip_with;
    private Bitmap ThreeShip;
    private Bitmap enemy;
    private Bitmap enemy2;
    private Bitmap petrol;
    private Bitmap helth1;
    private Bitmap helth2;
    private Bitmap helth3;
    private Bitmap rocket;
    private Bitmap star_for_background;
    public static byte health = 3;
    static int enemyX = 1000;
    static int enemyY = 500;

    static int enemy2X = 1000;
    static int enemy2Y = 800;

    static int rocketX = 1500;
    static int rocketY = 300;

    static int blasterX = 90000;
    static int blasterY = 60000;

    private static int flying = 0;

    static int petrolX = 1000;
    static int petrolY = 700;
    private static int points;
    public static int towardPointX = 10;
    public static int towardPointY = 0;
    public static double fuel = 700;
    {
        backgroundPaint.setColor(Color.BLACK);
        backgroundPaint.setStyle(Paint.Style.FILL);
    }
    {
        forfuel.setColor(Color.GREEN);
        forfuel.setStyle(Paint.Style.FILL);
    }
    {
        okantFuel.setColor(Color.RED);
        okantFuel.setStyle(Paint.Style.STROKE);
    }
    public void setTowardPoint(int x, int y) {
        towardPointX = x;
        towardPointY -= 250;
    }

    public static int getFlying() {
        return flying;
    }

    public static void setFlying(int flying) {
        DrawThread.flying = flying;
    }

    public DrawThread(Context context, SurfaceHolder surfaceHolder) {

        FirstShip = BitmapFactory.decodeResource(context.getResources(), R.drawable.firstship);

        SecondShip = BitmapFactory.decodeResource(context.getResources(), R.drawable.secondship);

        ThreeShip = BitmapFactory.decodeResource(context.getResources(), R.drawable.three_ship);

        FourShip = BitmapFactory.decodeResource(context.getResources(), R.drawable.four_ship);
        FourShip_with = BitmapFactory.decodeResource(context.getResources(), R.drawable.four_ship_with_sheat);

        shoting =  BitmapFactory.decodeResource(context.getResources(), R.drawable.blaster);

        star_for_background = BitmapFactory.decodeResource(context.getResources(), R.drawable.star_back);

        rocket = BitmapFactory.decodeResource(context.getResources(), R.drawable.raceta);
        enemy = BitmapFactory.decodeResource(context.getResources(), R.drawable.meteor);
        enemy2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy2);
        petrol = BitmapFactory.decodeResource(context.getResources(), R.drawable.petrol_for_game);
        helth1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.helth1);
        helth2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.helth2);
        helth3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.helth3);
        this.surfaceHolder = surfaceHolder;
    }
    public void requestStop() {
        running = false;
    }

    public static void pause(){pause=!pause;}//метод для паузы

    public void teleportenemy(){//телепорт метеорита на исходную посизицию
        enemyX = 2000;
        enemyY = ((int) (Math.random()*1700));
    }
    public void teleportenemy2(){//телепорт противника корабля на исходную посизицию
        enemy2X = 2000;
        enemy2Y = ((int) (Math.random()*1800));
    }
    public void teleportRocket(){
        rocketX = 2000;
        rocketY = ((int) (Math.random()*1600));
    }

    public void teleportpetrol(){ //телепорт топлива на исходную посизицию
        petrolX = 2000;
        petrolY = ((int) (Math.random()*1600));
    }

public static void restartGame(){//для перезапуска игры
        fuel = 700;
        health = 3;
 enemyX = 1000;
 enemyY = 500;
 enemy2X = 1000;
 enemy2Y = 800;
 petrolX = 1000;
 petrolY = 700;
 points = 0;
 amount_fuel = 0;
 rocketX = 1500;
 rocketY = 350;
}

    @Override
    public void run() {
        int shipX = 10;
        int shipY = 0;
fuel = 700;
health = 3;
for_help = 500;
amount_fuel = 0;
        Paint ForGameOver = new Paint();
        ForGameOver.setAntiAlias(true);
        ForGameOver.setTextSize(200.0f);
        ForGameOver.setColor(Color.WHITE);

        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setTextSize(55.0f);
        p.setColor(Color.WHITE);

        while (running) {
            if (pause==false) {
            if (MainActivity.mus_mode==true){
            if (transition.mus_for_game.isPlaying()==false){
                transition.mus_for_game.start();
            }}
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                try {
                    canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), backgroundPaint);//черный прямоугольник

                    if (towardPointY < -30) {
                        towardPointY += 50; }
                    if (towardPointY > canvas.getHeight() - 300) {
                        towardPointY -= 150; }


                    if (flying == 0) {
                        towardPointY += 7; }// полет игрока
                    else {
                        towardPointY -= 25;
                        flying--; }

                    blasterX +=10;//выстрел игрока
                    shipY = towardPointY;

                    if (stop_time==true){
                        for_stop_time--;
                    }
                    if (for_stop_time==0){stop_time=false;}// остановка времени

                    canvas.drawBitmap(star_for_background, canvas.getWidth() - 100, 200, backgroundPaint);
                    canvas.drawBitmap(star_for_background, canvas.getWidth() - 100, canvas.getHeight() - 500, backgroundPaint);
                    canvas.drawBitmap(star_for_background, 200, canvas.getHeight() - 500, backgroundPaint); //background
                    canvas.drawBitmap(star_for_background, 100, canvas.getHeight() - 300, backgroundPaint);
                    canvas.drawBitmap(star_for_background, 150, canvas.getHeight() - 200, backgroundPaint);
                    canvas.drawBitmap(star_for_background, 300, canvas.getHeight() - 100, backgroundPaint);
                    canvas.drawBitmap(star_for_background, 50, canvas.getHeight() - 50, backgroundPaint);
                    canvas.drawBitmap(star_for_background, canvas.getWidth()-150, canvas.getHeight() - 450, backgroundPaint);
                    canvas.drawBitmap(star_for_background, canvas.getWidth()-250, canvas.getHeight() - 530, backgroundPaint);
                    canvas.drawBitmap(star_for_background, canvas.getWidth()-250, 300, backgroundPaint);
                    canvas.drawBitmap(star_for_background, canvas.getWidth()-200, 350, backgroundPaint);
                    canvas.drawBitmap(star_for_background, canvas.getWidth()-300, 220, backgroundPaint);

                    canvas.drawBitmap(shoting, blasterX, blasterY, backgroundPaint);//отрисовка выстрела 3 корабля

                    if (transition.getPlane() == 1) {//------------отриовка корабля по выбору игрока
                        canvas.drawBitmap(FirstShip, shipX, shipY, backgroundPaint);
                    }
                    if (transition.getPlane() == 2) {
                        canvas.drawBitmap(SecondShip, shipX, shipY, backgroundPaint);
                    }
                    if (transition.getPlane() == 3) {
                        canvas.drawBitmap(ThreeShip, shipX, shipY, backgroundPaint);
                    }
                    if (transition.getPlane() == 4) {
                        if (shield == false){
                            canvas.drawBitmap(FourShip, shipX, shipY, backgroundPaint);}
                        else {
                            canvas.drawBitmap(FourShip_with, shipX, shipY, backgroundPaint);}
                    }//--------------

                    canvas.drawBitmap(petrol, petrolX, petrolY, backgroundPaint);// отрисовка бензина
                    canvas.drawBitmap(enemy, enemyX, enemyY, backgroundPaint);// отрисовка метеорита
                    if (points >= 100) {
                        canvas.drawBitmap(enemy2, enemy2X, enemy2Y, backgroundPaint); } //отрисовка второго врага
                    if (points>=500){canvas.drawBitmap(rocket,rocketX,rocketY,backgroundPaint);}// отрисовка ракеты

                    canvas.drawText(points + "", 680, 290, p);//показ очков


                    if (MainActivity.getGameMode() == 2) {
                        if (health == 3) {
                            canvas.drawBitmap(helth3, 600, 10, backgroundPaint);
                        }
                        if (health == 2) {
                            canvas.drawBitmap(helth2, 600, 10, backgroundPaint);
                        } // для карьеры
                        if (health == 1) {
                            canvas.drawBitmap(helth1, 600, 10, backgroundPaint);
                        }
                        // для первого лвл
                        if (level.getNumberLevel() == 1) {// для первого уровня
                            if (for_help >= 0){
                            canvas.drawText("You need to get", 650, 450, p);
                            canvas.drawText("1000 points", 740, 530, p);
                            for_help--;}
                            if (points>=1000){
                                canvas.drawText("YOU WIN", 100, 1000, ForGameOver);
                                requestStop();
                            }
                        }//для первого уровня

                        if (level.getNumberLevel() == 2) {//для второго уровня
                            if (for_help >= 0){
                                canvas.drawText("You need to get", 650, 450, p);
                                canvas.drawText("5000 points", 740, 530, p);
                                for_help--;}
                            if (points>=5000){
                                canvas.drawText("YOU WIN", 100, 1000, ForGameOver);
                                requestStop();
                            }
                        }//для второго уровня
                        if (level.getNumberLevel() == 3) {//для 3 уровня
                            if (for_help >= 0){
                                canvas.drawText("You need to collect", 600, 450, p);
                                canvas.drawText("50 fuel", 740, 530, p);
                                for_help--;}
                            canvas.drawText("amount fuel "+amount_fuel, 200, 330, p);
                            if (amount_fuel>=50){
                                canvas.drawText("YOU WIN", 100, 1000, ForGameOver);
                                requestStop();
                            }}

                        if (health <= 0) {// if player lose
                            transition.mus_for_game.stop();
                            canvas.drawText("YOU LOSE", 100, 1000, ForGameOver);
                            requestStop();
                        } //кончание игры если здоровье = 0
                    }

                    if (MainActivity.getGameMode() == 1) {// ======================================================== для свободной игры
                        if (fuel > 700) {
                            fuel = 700;
                        }
                            fuel -= 0.2;//уменьшение количества топлива на 0.2 каждый цикл

                            canvas.drawRect(300, 10, 300 + (int) fuel, 150, forfuel);
                            canvas.drawRect(300, 10, 1000, 150, okantFuel);
                            canvas.drawText("fuel", 600, 90, p);

                        if (fuel <= 0) {// if player lose
                            transition.mus_for_game.stop();
                            fuel = 0;
                            canvas.drawRect(300, 10, 300 + (int) fuel, 150, forfuel);
                            canvas.drawRect(300, 10, 1000, 150, okantFuel);
                            canvas.drawText("YOU LOSE", 100, 1000, ForGameOver);
                            requestStop();
                        } //кончание игры если топливо = 0

                    }//====================================================================================================== часть для свободной игры

                    // проверка столкновений
                    if ((shipX + FirstShip.getWidth() > enemyX) && (shipY < enemyY + enemy.getHeight()) && (shipY + FirstShip.getHeight() > enemyY) && (enemyX + enemy.getWidth() > shipX)) {
                        if(shield==false){points -= 30;
                        teleportenemy();
                        health--;} else {shield=false;teleportenemy();fuel+=300;}
                        if ((fuel -= 300) <= 0) {
                            fuel = 0;
                        }
                    }//проверка столкновения корабля и метеорита

                    if (points >= 100) {
                        if ((shipX + FirstShip.getWidth() > enemy2X) && (shipY < enemy2Y + enemy2.getHeight()) && (shipY + FirstShip.getHeight() > enemy2Y) && (enemy2X + enemy2.getWidth() > shipX)) {
                            if (shield == false){points -= 30;
                            teleportenemy2();
                            health--;} else {shield=false;teleportenemy2(); fuel += 350;}
                            if ((fuel -= 350) <= 0) {
                                fuel = 0;
                            }
                        }
                    }//проверка столкновения игрока и второго корабля(врага)

                    if (points >= 500) {
                        if ((shipX + FirstShip.getWidth() > rocketX) && (shipY < rocketY + rocket.getHeight()) && (shipY + FirstShip.getHeight() > rocketY) && (rocketX + rocket.getWidth() > shipX)) {
                            if (shield == false){points -= 40;
                                teleportRocket();
                                health--;} else {shield=false;teleportRocket(); fuel += 350;}
                            if ((fuel -= 350) <= 0) {
                                fuel = 0;
                            }
                        }
                    }//проверка столкновения игрока и ракеты

                    if ((shipX + FirstShip.getWidth() > petrolX) && (shipY < petrolY + petrol.getHeight()) && (shipY + FirstShip.getHeight() > petrolY) && (petrolX + petrol.getWidth() > shipX)) {
                        points += 20;
                        if (MainActivity.getGameMode() == 2){amount_fuel++;}
                        teleportpetrol();
                        fuel += 150;
                    }// проверка столкновения бензина и игрока
                    /* ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */

                    if (((petrolY + petrol.getHeight() > enemyY) && (petrolY + petrol.getHeight() < enemyY + enemy.getHeight())) || ((petrolY < enemyY + enemy.getHeight()) && (petrolY > enemyY))) {
                        teleportpetrol();
                    }//если за метеоритом летит бензин
                    if (((enemyY + enemy.getHeight() > petrolY) && (enemyY + enemy.getHeight() < petrolY + petrol.getHeight())) || ((enemyY < petrolY + petrol.getHeight()) && (enemyY > petrolY))) {
                        teleportenemy();
                    }//если за бензином летит метеорит

                    if ((blasterX + shoting.getWidth() > enemy2X) && (blasterY < enemy2Y + enemy2.getHeight()) && (blasterY + shoting.getHeight() > enemy2Y) && (enemy2X + enemy2.getWidth() > shipX)) {
                        teleportenemy2();
                    }
                    if ((blasterX + shoting.getWidth() > enemyX) && (blasterY < enemyY + enemy.getHeight()) && (blasterY + shoting.getHeight() > enemyY) && (enemyX + enemy.getWidth() > blasterX)) {
                        teleportenemy();
                    }
                    if ((blasterX + shoting.getWidth() > rocketX) && (blasterY < rocketY + rocket.getHeight()) && (blasterY + shoting.getHeight() > rocketY) && (rocketX + rocket.getWidth() > blasterX)) {
                        teleportRocket();
                    }

                    if (points >= 100) {
                        if (((enemyY < enemyY + enemy2.getHeight()) && (enemyY + enemy.getHeight() > enemy2Y + enemy2.getHeight())) || ((enemy2Y < enemyY + enemy.getHeight()) && (enemy2Y > enemyY))) {
                            teleportenemy2();
                        }//если за метеоритом летит второй враг
                        }
                    // движение
                    if (stop_time == false){
                    if (enemyX < -750) {
                        teleportenemy();
                        points += 10;
                    } else {
                        enemyX -= 10;
                    }
                    if (points >= 100) {
                        if (enemy2X < -650) {
                            teleportenemy2();
                            points += 10;
                        } else {
                            enemy2X -= 5;
                        }
                    }
                    if (points>= 500){
                        if (rocketX < -650) {
                            teleportRocket();
                            points += 10;
                        } else {
                            rocketX -= 15;
                        }
                    }
                }
                        if (petrolX < -600) {
                            teleportpetrol();
                        } else {
                            petrolX -= 10;
                        }

                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
        }
    }
}
