package com.zakigames.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    // Variables
    Button btnAceptar;
    TextView txtSaludo;
    EditText edtCaptura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAceptar = findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(this);

        txtSaludo = findViewById(R.id.txtSaludo);
        txtSaludo.setText(R.string.nuevosaludo);

        edtCaptura = findViewById(R.id.edtCaptura);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnAceptar){
            String cadena = edtCaptura.getText().toString();
            txtSaludo.setText(cadena);

            Toast.makeText(this, "Cadena copiada en el texto", Toast.LENGTH_SHORT).show();
        }
    }
}