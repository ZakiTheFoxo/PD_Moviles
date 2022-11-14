package com.example.intents2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button  btnBoton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBoton1   =   findViewById(R.id.btnBoton1);

        // Clase compleja, crea un objeto tipo OnclickListener con override y onClick (Explicito)
        btnBoton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent = new Intent();
                String  packageName = "com.example.intents2",
                        className = "com.example.intents2.SecondActivity";

                intent.setClassName(packageName, className);

                startActivity(intent);
            }
        });
    }
}