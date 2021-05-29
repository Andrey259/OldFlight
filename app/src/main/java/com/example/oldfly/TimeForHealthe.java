package com.example.oldfly;


class TimeForHealthe extends Thread {
    public static boolean flag = false;
    @Override
    public void run() {
        while (true) {
            if (flag == false) {
                flag = true;
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}