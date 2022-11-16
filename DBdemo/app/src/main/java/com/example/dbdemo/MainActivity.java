package com.example.dbdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterViewAnimator;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.Objects;

public class MainActivity extends ListActivity {
    private DataBaseHelper db       = null;
    private Cursor constantsCursor  = null;
    private static final int ADD_ID = Menu.FIRST + 1;
    private static final int DELETE_ID = Menu.FIRST + 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = new DataBaseHelper(this);
        constantsCursor = db.getReadableDatabase().rawQuery("SELECT _ID, title, value FROM constants ORDER BY title",null);
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
        LayoutInflater inflater             = LayoutInflater.from(this);
        View addView                        = inflater.inflate(R.layout.add_edit, null);
        final DialogWrapper dialogWrapper   = new DialogWrapper(addView);

        new AlertDialog.Builder(this)
                .setTitle(R.string.add)
                .setView(addView)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        processAdd(dialogWrapper);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Do nothing
                    }
                })
                .show();
    }

    private void delete(final long rowId) {
        if(rowId > 0) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.delete)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            processDelete(rowId);
                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // Do Nothing
                        }
                    })
                    .show();
        }
    }

    public void processAdd(DialogWrapper dialogWrapper) {
        ContentValues cv = new ContentValues(2);

        cv.put(DataBaseHelper.TITLE, dialogWrapper.getTitulo());
        cv.put(DataBaseHelper.VALUE, dialogWrapper.getValor());

        db.getReadableDatabase().insert("constants", DataBaseHelper.TITLE, cv);

        constantsCursor.requery();
    }

    public void processDelete(long rowId) {
            String[] args = { String.valueOf(rowId) };

            db.getReadableDatabase().delete("constants", "_ID = ?", args);

            constantsCursor.requery();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(Menu.NONE, ADD_ID, Menu.NONE, "Agregar...").setAlphabeticShortcut('a');
        menu.add(Menu.NONE, DELETE_ID, Menu.NONE, "Borrar...").setAlphabeticShortcut('b');
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case ADD_ID:    add(); break;
            case DELETE_ID:
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                delete(info.id);
        }

        return super.onContextItemSelected(item);
    }
}