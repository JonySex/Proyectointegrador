package com.example.proyectointegrador.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import androidx.annotation.NonNull;


public class BaseDeDatosGeneral extends SQLiteOpenHelper {
    private static final String NOMBRE_DB="Escuela.db";
    private static final int VERSION_ACTUAL=1;
    private final Context contexto;

    public BaseDeDatosGeneral(Context contexto)
    {
        super(contexto,NOMBRE_DB,null,VERSION_ACTUAL);
        this.contexto=contexto;
    }

    @Override
    public void onOpen(SQLiteDatabase db)
    {
        super.onOpen(db);
        if(!db.isReadOnly())
        {
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN)
            {
                db.setForeignKeyConstraintsEnabled(true);
            }
            else
            {
                db.execSQL("PRAGMA foreing_keys=ON");
            }
        }
    }

    @Override
    public void  onCreate( SQLiteDatabase db){
        db.execSQL("CREATE TABLE BDAlumnos (IdAlumnos text primary key,NombreA text not null, ApellidoP text not null,ApellidoM text, Telefono integer)");
        /*db.execSQL("CREATE TABLE BDMaterias (IdMaterias text primary key, NombreM text not null)");
        db.execSQL("CREATE TABLE BDProfesores(IdProfesores text primary key, NombreP text not null,ApellidoPP text not null, ApellidoMP text not null, TelefonoP integer)");
        db.execSQL("CREATE TABLE BDCalificaciones(IdCalificaciones text primary key, Calificacion integer not null, FOREIGN KEY(IdMaterias)REFERENCES BDMaterias(IdMaterias),"+
                "FOREIGN KEY(IdAlumnos) REFERENCES BDAlumnos(IdAlumnos), FOREIGN KEY(IdProfesores) REFERENCES BDProfesores(IdProfesores))");*/
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS BDAlumnos");
        db.execSQL("DROP TABLE IF EXISTS BDMaterias");
        db.execSQL("DROP TABLE IF EXISTS BDProfesores");
        db.execSQL("DROP TABLE IF EXISTS BDCalificaciones");
        onCreate(db);
    }

}
