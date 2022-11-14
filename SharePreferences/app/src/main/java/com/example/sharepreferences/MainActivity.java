package com.example.sharepreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences misDatos;
    private EditText edtNombre, edtCordX, edtCordY, edtReporte;
    private String nombre;
    private Float x, y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre = findViewById(R.id.edtNombre);
        edtCordX = findViewById(R.id.edtCordX);
        edtCordY = findViewById(R.id.edtCordY);
        edtReporte = findViewById(R.id.edtReporte);

        misDatos = getSharedPreferences("preferencias", MODE_PRIVATE);
        nombre = misDatos.getString("nombre", "Valor por default");
        x = misDatos.getFloat("x", 0.0f);
        y = misDatos.getFloat("y", 0.0f);

        edtReporte.append("Preferencias restauradas al reactivar la actividad\n");
    }

    @Override
    protected void onPause() {
        super.onPause();
        nombre = edtNombre.getText().toString();
        x = Float.parseFloat(edtCordX.getText().toString());
        y = Float.parseFloat(edtCordY.getText().toString());

        SharedPreferences.Editor editor = misDatos.edit();
        editor.putString("nombre", nombre);
        editor.putFloat("x", x);
        editor.putFloat("y", y);

        editor.apply();
        edtReporte.append("Preferencias guadardadas en onPause\n");
        Toast.makeText(this, "Preferencias guardadas", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        misDatos = getSharedPreferences("preferencias", MODE_PRIVATE);
        nombre = misDatos.getString("nombre", "Valor por default");
        x = misDatos.getFloat("x", 0.0f);
        y = misDatos.getFloat("y", 0.0f);

        edtReporte.append("Preferencias restauradas al reactivar la actividad\n");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        SharedPreferences.Editor editor = misDatos.edit();
        editor.putString("Clave", "Valor");
        editor.commit();
        super.onSaveInstanceState(outState);
    }
}