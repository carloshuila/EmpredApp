package edu.aplimovil.emprendapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.aplimovil.emprendapp.categorias.postres.CategoriaPostreActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void vercategorias(View view) {
        Intent intent = new Intent(this, CategoriaPostreActivity.class);
        startActivity(intent);
    }
}