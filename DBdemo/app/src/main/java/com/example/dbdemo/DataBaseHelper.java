package com.example.dbdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.SensorManager;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db";
    static final String TITLE = "title";
    static final String VALUE = "value";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE constants (_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, value REAL);");

        ContentValues cv = new ContentValues();

        cv.put(TITLE, "Gravity, Death Star I");
        cv.put(VALUE, SensorManager.GRAVITY_DEATH_STAR_I);
        db.insert("constants", TITLE, cv);

        cv.put(TITLE, "Gravity, Earth");
        cv.put(VALUE, SensorManager.GRAVITY_EARTH);
        db.insert("constants", TITLE, cv);

        cv.put(TITLE, "Gravity, Jupiter");
        cv.put(VALUE, SensorManager.GRAVITY_JUPITER);
        db.insert("constants", TITLE, cv);

        cv.put(TITLE, "Gravity, Mars");
        cv.put(VALUE, SensorManager.GRAVITY_MARS);
        db.insert("constants", TITLE, cv);

        cv.put(TITLE, "Gravity, Mercury");
        cv.put(VALUE, SensorManager.GRAVITY_MERCURY);
        db.insert("constants", TITLE, cv);

        cv.put(TITLE, "Gravity, Moon");
        cv.put(VALUE, SensorManager.GRAVITY_MOON);
        db.insert("constants", TITLE, cv);

        cv.put(TITLE, "Gravity, Neptune");
        cv.put(VALUE, SensorManager.GRAVITY_NEPTUNE);
        db.insert("constants", TITLE, cv);

        cv.put(TITLE, "Gravity, Pluto");
        cv.put(VALUE, SensorManager.GRAVITY_PLUTO);
        db.insert("constants", TITLE, cv);

        cv.put(TITLE, "Gravity, Saturn");
        cv.put(VALUE, SensorManager.GRAVITY_SATURN);
        db.insert("constants", TITLE, cv);

        cv.put(TITLE, "Gravity, Sun1");
        cv.put(VALUE, SensorManager.GRAVITY_SUN);
        db.insert("constants", TITLE, cv);

        cv.put(TITLE, "Gravity, Uranus");
        cv.put(VALUE, SensorManager.GRAVITY_URANUS);
        db.insert("constants", TITLE, cv);

        cv.put(TITLE, "Gravity, Venus");
        cv.put(VALUE, SensorManager.GRAVITY_VENUS);
        db.insert("constants", TITLE, cv);

        cv.put(TITLE, "Gravity, The Island");
        cv.put(VALUE, SensorManager.GRAVITY_THE_ISLAND);
        db.insert("constants", TITLE, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        android.util.Log.w("constants", "Actualizando Base de Datos, se destruir?? la informaci??n anterior.");
    }
}
