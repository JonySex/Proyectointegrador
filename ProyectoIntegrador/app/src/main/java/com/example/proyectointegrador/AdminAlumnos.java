package com.example.proyectointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.proyectointegrador.Modelos.Alumnos;
import com.example.proyectointegrador.SQLite.BaseDeDatosGeneral;
import com.example.proyectointegrador.SQLite.ControlAlumno;

public class AdminAlumnos extends AppCompatActivity {


    private EditText texto1, texto2, texto3, texto4, texto5;
    private TextView TextoDeplegar;
    private Button Guardar, Limpiar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_alumnos);
        texto1 = findViewById(R.id.txt1);
        texto2 = findViewById(R.id.txt2);
        texto3 = findViewById(R.id.txt3);
        texto4 = findViewById(R.id.txt4);
        texto5 = findViewById(R.id.txt5);
        Guardar = findViewById(R.id.btnGuardar);
        Limpiar = findViewById(R.id.btnCanacelar);
        TextoDeplegar = findViewById(R.id.txtDeplegar);
    }

    public void MostrarInvisibles(View v){
        texto1.setHint("Matricula");
        texto1.setVisibility(View.VISIBLE);
        texto2.setHint("Nombre");
        texto2.setVisibility(View.VISIBLE);
        texto3.setHint("Apellido Paterno");
        texto3.setVisibility(View.VISIBLE);
        texto4.setHint("Apellido Materno");
        texto4.setVisibility(View.VISIBLE);
        texto5.setHint("Telefono");
        texto5.setVisibility(View.VISIBLE);
        Guardar.setVisibility(View.VISIBLE);
        Limpiar.setVisibility(View.VISIBLE);
        TextoDeplegar.setVisibility(View.VISIBLE);
    }

    public void limpiar(View v)
    {
        texto1.setText("");
        texto2.setText("");
        texto3.setText("");
        texto4.setText("");
        texto5.setText("");
    }

    public void guardar(View v)
    {
        ControlAlumno cont=new ControlAlumno(this);
        com.example.proyectointegrador.Modelos.Alumnos Al=new com.example.proyectointegrador.Modelos.Alumnos();
        Al.idAlumno = texto1.getText().toString();
        Al.Nombre = texto2.getText().toString();
        Al.ApellidoP = texto3.getText().toString();
        Al.ApellidoM = texto4.getText().toString();
        Al.NumeroTel = Integer.parseInt(texto5.getText().toString());
        cont.InsertarAlumnos(Al);
        limpiar(v);
    }

    public void MostrarAlumnos() {
        ControlAlumno cont = new ControlAlumno(this);
        Cursor filas= cont.DesplegarAlumnos();
        TextoDeplegar.append("\nAlumnos\n");
        if(filas.moveToFirst())
        {
            do{
                TextoDeplegar.append(filas.getString(0));
                TextoDeplegar.append(" ");
                TextoDeplegar.append(filas.getString(1));
                TextoDeplegar.append(" ");
                TextoDeplegar.append(filas.getString(2));
                TextoDeplegar.append(" ");
                TextoDeplegar.append(filas.getString(3));
                TextoDeplegar.append(" ");
                TextoDeplegar.append(filas.getString(4));
                TextoDeplegar.append("\n");
            }while(filas.moveToNext());
        }
    }
}