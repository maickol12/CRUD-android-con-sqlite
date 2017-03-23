package com.example.mand.crudsqliteandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void agregar(View v){
        Intent agregarActivy = new Intent(MainActivity.this,AgregarActivity.class);
        startActivity(agregarActivy);
    }
    public void mostrar(View v){
        Intent mostrarActivity = new Intent(MainActivity.this,MostrarActivity.class);
        startActivity(mostrarActivity);
    }
}
