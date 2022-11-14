package com.example.intents3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MediaPlayer myPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(myPlayer != null)
                myPlayer.release();

        myPlayer = MediaPlayer.create(getApplicationContext() ,R.raw.splash);

        myPlayer.seekTo(0);
        myPlayer.start();

        Thread timer = new Thread(){
            @Override
            public void run(){  // Esta es la parte donde se carga el rpograma de datos y los recursos para el inicio
                try{
                    sleep(5000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent();
                    intent.setClassName("com.example.intents3", "com.example.intents3.SecondActivity");
                    startActivity(intent);
                }
            }
        };
        timer.start();

    }

    @Override
    protected void onPause() {
        super.onPause();

        myPlayer.release();
        finish();       // Sirve para quitar la splash screen
    }
}