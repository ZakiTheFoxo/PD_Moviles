package com.example.files;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private TextView    txtTexto;
    private String      linea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTexto    = findViewById(R.id.txtTexto);

        InputStream         inputStream         = getResources().openRawResource(R.raw.texto);
        InputStreamReader   inputStreamReader   = new InputStreamReader(inputStream);

        BufferedReader      bufferedReader      = new BufferedReader(inputStreamReader, 1000);

        try {
            while (true) {
                linea   = bufferedReader.readLine();

                if(linea == null)
                    break;

                txtTexto.append(linea + '\n');
            }

            bufferedReader      .close();
            inputStreamReader   .close();
            inputStream         .close();

        } catch(IOException e) {
            e.printStackTrace();
        }

        txtTexto.append("Fin del Archivo");
    }
}