package com.example.dbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {
    private DataBaseHelper db       = null;
    private Cursor constantsCursor  = null;
    private static final int ADD_ID = Menu.FIRST + 1;
    private static final int DELETE_ID = Menu.FIRST + 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = new DataBaseHelper(this);
        constantsCursor = db.getReadableDatabase().rawQuery("SELECT _ID title, value FROM constants ORDER BY title",null);
        ListAdapter adapter = new SimpleCursorAdapter(this,R.layout.row, constantsCursor, new String[] {DataBaseHelper.TITLE, DataBaseHelper.VALUE },
                new int[] { R.id.txtTitle, R.id.txtValue});

        setListAdapter(adapter);
        registerForContextMenu(getListView());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        constantsCursor.close();
        db.close();
    }

    public static class DialogWrapper {
        EditText    campoTitulo, campoValor;
        View        base;

        public DialogWrapper(View base) {
            this.base = base;
            campoValor = base.findViewById(R.id.edtValor);
        }

        public EditText getCampoTitulo() {
            if(campoTitulo == null)
                campoTitulo = base.findViewById(R.id.edtTitulo);
            return campoTitulo;
        }

        public EditText getCampoValor() {
            if(campoValor == null)
                campoValor = base.findViewById(R.id.edtValor);
            return campoValor;
        }

        public String getTitulo() {
            return (getCampoTitulo().getText().toString());
        }

        public float getValor() {
            return Float.parseFloat(getCampoValor().getText().toString());
        }
    }

    private void add() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View addView = inflater.inflate(R.layout.add_edit, null);
        final DialogWrapper dialogWrapper = new DialogWrapper(addView);
    }
}