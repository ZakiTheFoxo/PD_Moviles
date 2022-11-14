package com.example.intents2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    private Button  btnBoton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnBoton2   =   findViewById(R.id.btnBoton2);

        // Clase compleja, crea un objeto tipo OnclickListener con override y onClick (Implicito)
        btnBoton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(MediaStore.Images.Media.INTERNAL_CONTENT_URI);

                startActivity(intent);
            }
        });
    }
}