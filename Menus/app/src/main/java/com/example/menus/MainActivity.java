package com.example.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    TextView    txtmensaje;
    EditText    edtCaptura;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtmensaje  =   findViewById(R.id.txtMensaje);
        edtCaptura  =   findViewById(R.id.edtCaptura);

        registerForContextMenu(edtCaptura);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.my_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        txtmensaje.setText("");

        switch(item.getItemId()){
            case    R.id.item_uno:  txtmensaje.setText("Seleccionaste la opcion 1");    break;
            case    R.id.item_dos:  txtmensaje.setText("Seleccionaste la opcion 2");    break;
            case    R.id.item_tres: txtmensaje.setText("Seleccionaste la opcion 3");    break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        menu.setHeaderTitle("Menu Contextual");

        MenuInflater    menuInflater    =   getMenuInflater();

        menuInflater.inflate(R.menu.my_options_menu, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        txtmensaje.setText("");

        switch(item.getItemId()){
            case    R.id.item_cdos:     txtmensaje.setText("Seleccionaste el Contextual 2");    break;
            case    R.id.item_ctres:    txtmensaje.setText("Seleccionaste el Contextual 3");    break;
            case    R.id.item_cuatro:   txtmensaje.setText("Seleccionaste el Contextual 4");    break;
            case    R.id.item_cinco:    txtmensaje.setText("Seleccionaste el Contextual 5");    break;
            case    R.id.item_seis:     txtmensaje.setText("Seleccionaste el Contextual 6");    break;
            case    R.id.sub_uno:       txtmensaje.setText("Seleccionaste el Submenu 1");       break;
            case    R.id.sub_dos:       txtmensaje.setText("Seleccionaste el Submenu 2");       break;
        }

        return super.onContextItemSelected(item);
    }
}