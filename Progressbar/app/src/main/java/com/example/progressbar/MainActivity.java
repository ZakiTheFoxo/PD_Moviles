package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity{

    ProgressBar prbProgress;

    Handler handler= new Handler(
        @Override
        public void handleMessage(Message msg){
            prbProgress.incrementProgressBy(5);
            super.handleMessage(msg);
        }
    );

    AtomicBoolean isRunning=new AtomicBoolean();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prbProgress=findViewById(R.id.prbProgress);


    }

    @Override
    protected void onStart() {
        super.onStart();
        prbProgress.setProgress(0);
        Thread background =new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0;i<20;i++){
                        Thread.sleep(1500);
                        handler.sendMessage(handler.obtainMessage());
                    }
                }catch (Throwable e){
                    e.printStackTrace();
                }
            }
        });
        isRunning.set(true);
        background.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        isRunning.set(false);
    }


}