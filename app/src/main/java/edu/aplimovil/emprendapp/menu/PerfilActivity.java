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

    ImageButton btnEditar;
    Button btnGuardar;
    EditText campoNombre;
    EditText campoApellido;
    EditText campoDireccion;
    EditText campoCiudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        //variables
        //base datos
        FirebaseFirestore db= FirebaseFirestore.getInstance();
        //Barra navegacion
        BottomNavigationView navBar = findViewById(R.id.btnBarraNav);
        //botones
        btnEditar = findViewById(R.id.imgBtn_editar);
        btnGuardar=findViewById(R.id.btnGuardar);
        btnGuardar.setEnabled(false);
        //campos de texto
        campoNombre = findViewById(R.id.ediText_campo_nombre);
        campoApellido = findViewById(R.id.ediText_campo_apellido);
        campoDireccion = findViewById(R.id.ediText_campo_direccion);
        campoCiudad = findViewById(R.id.ediText_campo_ciudad);

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

        btnEditar.setOnClickListener(this);
        btnGuardar.setOnClickListener(this);

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgBtn_editar:
                btnGuardar.setEnabled(true);
                campoNombre.setEnabled(true);
                campoApellido.setEnabled(true);
                campoDireccion.setEnabled(true);
                campoCiudad.setEnabled(true);
            break;
            case R.id.btnGuardar:
                if (campoNombre.getText().equals("")) {
                    campoNombre.setBackgroundColor(R.color.colorError);
                }
                else{
                    break;
                }

                break;
        }
    }
}