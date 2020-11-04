package edu.aplimovil.emprendapp.pago;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import edu.aplimovil.emprendapp.R;
import edu.aplimovil.emprendapp.menu.*;
import static edu.aplimovil.emprendapp.R.id.btnBarraNav;

public class MetodoPagoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodo_pago);

        BottomNavigationView navBar=findViewById(btnBarraNav);

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
                        startActivity(new Intent(getApplicationContext(), PerfilActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}