package com.example.zegarpow;

import android.os.CountDownTimer;
import android.widget.TextView;

public class Zegar {
    private boolean running;
    private int sekundy;
    private TextView timeView;
    private CountDownTimer timer;

    public Zegar(boolean running, TextView timeView) {
        this.running = running;
        this.timeView = timeView;
    }

    public boolean isRunning(){
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setSekundy(int sekundy) {
        this.sekundy = sekundy;
    }

    public void startTimer(){
        timer = new CountDownTimer(sekundy*1000, 1000) {
            @Override
            public void onTick(long l) {
                sekundy = (int) l/1000;
                pokazCzas(sekundy);
            }

            @Override
            public void onFinish() {
                timeView.setText("Gotowe!!");
            }
        };
        timer.start();
        setRunning(true);
    }

    public void stopTimer(){
        timer.cancel();
        setRunning(false);
    }

    private void pokazCzas(int s){
        int minuty = s/60;
        int sek = s-minuty*60;
        timeView.setText(String.format("%02d : %02d", minuty, sek));
    }
}
