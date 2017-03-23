package com.example.mand.crudsqliteandroid;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import BSHELPER.sqlite;

public class EditarActivity extends AppCompatActivity{
    private int usuarioEditar;
    private EditText nombre,apellidos,edad;
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_editar);
        Bundle extras = this.getIntent().getExtras();
        if(extras!=null){
            usuarioEditar = extras.getInt("id");
        }
        nombre = (EditText) findViewById(R.id.ETEditarNombre);
        apellidos = (EditText) findViewById(R.id.ETEditarApellidos);
        edad = (EditText) findViewById(R.id.ETEditarEdad);

        reflejarCampos();
    }
    public void reflejarCampos(){
        sqlite bh  = new sqlite(EditarActivity.this,"usuarios",null,1);
        if(bh!=null){
            SQLiteDatabase db = bh.getReadableDatabase();
            Cursor c = db.rawQuery("SELECT * FROM usuarios WHERE idusuario = "+usuarioEditar,null);
            try{
                if(c.moveToNext()){
                    nombre.setText(c.getString(1));
                    apellidos.setText(c.getString(2));
                    edad.setText(c.getString(3));
                }
            }finally {

            }
        }
    }
    public void editar(View v){
        sqlite bh = new sqlite(EditarActivity.this,"usuarios",null,1);
        if(bh!=null){
            SQLiteDatabase db = bh.getWritableDatabase();
            ContentValues val = new ContentValues();
            val.put("nombre",nombre.getText().toString());
            val.put("apellidos",apellidos.getText().toString());
            val.put("edad",Integer.parseInt(edad.getText().toString()));
            long response = db.update("usuarios",val,"idusuario="+usuarioEditar,null);
            if(response>0){
                Toast.makeText(EditarActivity.this,"Editado con exito",Toast.LENGTH_LONG).show();
                nombre.setText("");
                apellidos.setText("");
                edad.setText("");
            }else{
                Toast.makeText(EditarActivity.this,"Ocurrio un error",Toast.LENGTH_LONG).show();
            }
        }
    }
}
