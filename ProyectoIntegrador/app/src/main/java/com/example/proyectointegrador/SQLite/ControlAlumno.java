package com.example.proyectointegrador.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectointegrador.Modelos.Alumnos;

public class ControlAlumno {
    BaseDeDatosGeneral manejador;
    SQLiteDatabase bd;

    public ControlAlumno (Context c)
    {
        manejador=new BaseDeDatosGeneral(c);
        bd=manejador.getWritableDatabase();
    }

    public void InsertarAlumnos(Alumnos Alum){
        ContentValues registro = new ContentValues();
        registro.put("IdAlumnos", Alum.idAlumno);
        registro.put("NombreA", Alum.Nombre);
        registro.put("ApellidoP", Alum.ApellidoP);
        registro.put("ApellidoM", Alum.ApellidoM);
        registro.put("Telefono", Alum.NumeroTel);

        bd.insert("BDAlumnos", null, registro);
        bd.close();
    }

    public Cursor DesplegarAlumnos(){
        Cursor cursor = null;
        try {
            SQLiteDatabase bd = manejador.getReadableDatabase();
            cursor = bd.rawQuery("select * from BDAlumnos", null);
        }catch (Exception e){

        }
        return cursor;
    }
}
