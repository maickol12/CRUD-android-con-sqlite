package com.example.mand.crudsqliteandroid;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import BSHELPER.sqlite;
public class AgregarActivity extends AppCompatActivity{
    private EditText nombre,apellidos,edad;
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_agregar);

        nombre = (EditText) findViewById(R.id.ETNombre);
        apellidos = (EditText) findViewById(R.id.ETApellidos);
        edad = (EditText) findViewById(R.id.ETEdad);
    }
    public void agregar(View v){
        if(ComprobarCampos()){
            String nom,ape;
            int ed;
            nom = nombre.getText().toString();
            ape = apellidos.getText().toString();
            ed = Integer.parseInt(edad.getText().toString());

            sqlite bh = new sqlite(AgregarActivity.this,"usuarios",null,1);
            if(bh!=null){
                SQLiteDatabase db = bh.getWritableDatabase();
                ContentValues con = new ContentValues();
                con.put("nombre",nom);
                con.put("apellidos",ape);
                con.put("edad",ed);
                long insertado = db.insert("usuarios",null,con);
                if(insertado>0){
                    Toast.makeText(AgregarActivity.this,"Insertado con exito",Toast.LENGTH_SHORT).show();
                    nombre.setText("");
                    apellidos.setText("");
                    edad.setText("");
                }else{
                    Toast.makeText(AgregarActivity.this,"No se inserto",Toast.LENGTH_SHORT).show();
                }
            }
        }else{
            Toast.makeText(AgregarActivity.this,"hay campos vacios",Toast.LENGTH_LONG).show();
        }
    }
    public boolean ComprobarCampos(){
        if(nombre.getText().toString().isEmpty() || apellidos.getText().toString().isEmpty() || edad.getText().toString().isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
