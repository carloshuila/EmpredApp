package edu.aplimovil.emprendapp.menu;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;

import edu.aplimovil.emprendapp.R;
import edu.aplimovil.emprendapp.menu.MainActivity;
import edu.aplimovil.emprendapp.menu.PedidosActivity;

public class PerfilActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        //variables
        //base datos
        FirebaseFirestore db= FirebaseFirestore.getInstance();
        //Barra navegacion
        BottomNavigationView navBar = findViewById(R.id.btnBarraNav);

        //Configuracion de barra de navegacion, rutas
        navBar.setSelectedItemId(R.id.PedidosActivity);
        navBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.MainActivity:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.PedidosActivity:
                        startActivity(new Intent(getApplicationContext(), PedidosActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.PerfilActivity:
                        return true;
                }
                return false;
            }
        });


    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {

    }
}