package com.example.proyectointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Administradores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administradores);
    }

    public void AbrirAlumnos(View v) {
        Intent intent = new Intent(this, AdminAlumnos.class);
        startActivity(intent);
    }
}