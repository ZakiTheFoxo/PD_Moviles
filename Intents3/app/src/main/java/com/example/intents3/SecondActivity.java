package com.example.intents3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity{
    Button      btnshare;
    EditText    edtShare;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnshare    =   findViewById(R.id.btnShare);
        edtShare    =   findViewById(R.id.edtShare);

        btnshare.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String msg      =   edtShare.getText().toString();
                Intent intent   =   new Intent(Intent.ACTION_SEND);

                intent.setType("Text/html");
                intent.putExtra(intent.EXTRA_TEXT,msg);

                startActivity(intent);
            }
        });
    }
}