package com.example.proyectointegrador;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQL extends SQLiteOpenHelper {

    public AdminSQL(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Admin(usuario text primary key, contra text)");
        String usuario = "admin";
        String contra = "12345";
        ContentValues datosAdmin = new ContentValues();
        datosAdmin.put("usuario", usuario);
        datosAdmin.put("contra", contra);
        db.insert("Admin", "usuario, contra", datosAdmin);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
