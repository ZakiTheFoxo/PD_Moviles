package com.example.providers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtMusic;

    @SuppressLint({"MissingInflatedId", "Range"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMusic = findViewById(R.id.txtMusic);
        String[] columns = new String[] {MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.DURATION };
        Uri MyTunes = MediaStore.Audio.Media.INTERNAL_CONTENT_URI;
        Cursor cursor = managedQuery(MyTunes, columns,null,null, MediaStore.Audio.Media.DURATION);

        if (cursor.moveToFirst()) {
            String titulo;
            String duracion;
            do {
                titulo = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                duracion = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
                txtMusic.append( titulo + " - " + duracion + '\n' );
            } while (cursor.moveToNext());

        }
    }
}