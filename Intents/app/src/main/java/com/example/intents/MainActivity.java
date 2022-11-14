package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Manejadores
    private EditText    edtLatitud,edtLongitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLatitud  =   findViewById(R.id.edtLatitud);
        edtLongitud =   findViewById(R.id.edtLongitud);
    }

    public void showMe(View view){
        String  latitud     =   edtLatitud.getText().toString(),
                longitud    =   edtLongitud.getText().toString();

        Uri uri =   Uri.parse("geo:" + latitud + ", " + longitud);
        Toast.makeText(getApplicationContext(), "geo:" + latitud + ", " + longitud, Toast.LENGTH_SHORT).show();
        // Toast.makeText(getApplicationContext(), uri.toString(), Toast.LENGTH_SHORT).show();

        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}