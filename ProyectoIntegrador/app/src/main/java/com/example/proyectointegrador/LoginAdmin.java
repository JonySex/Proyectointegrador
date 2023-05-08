package com.example.proyectointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginAdmin extends AppCompatActivity {

     EditText UsuarioI, ContraI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        UsuarioI=(EditText)findViewById(R.id.UsuaioIngresado);
        ContraI=(EditText)findViewById(R.id.ContraIngresado);
    }

    public void ingresar(View view){
        try {
            AdminSQL admin = new AdminSQL(this, "administracion", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String usuario = UsuarioI.getText().toString();
            String contra = ContraI.getText().toString();
            Cursor fila = bd.rawQuery("Select usuario,contra from Admin where usuario='"+usuario+"'and contra='"+contra+"'",null);

            if(fila.moveToFirst()){
                Intent i = new Intent(this, Administradores.class);
                i.putExtra("cedula", usuario);
                startActivity(i);

            }
        }catch (Exception e){

        }
    }
}