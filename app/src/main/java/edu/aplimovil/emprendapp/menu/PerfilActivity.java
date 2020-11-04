package edu.aplimovil.emprendapp.menu;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import edu.aplimovil.emprendapp.R;
import edu.aplimovil.emprendapp.categorias.Categoria;
import edu.aplimovil.emprendapp.menu.MainActivity;
import edu.aplimovil.emprendapp.menu.PedidosActivity;
import edu.aplimovil.emprendapp.postres.AdapterPostres;
import edu.aplimovil.emprendapp.postres.Postre;
import edu.aplimovil.emprendapp.usuario.AdapterUsuario;
import edu.aplimovil.emprendapp.usuario.Usuario;

public class PerfilActivity extends AppCompatActivity  {

    public List<Usuario> listaUsuarios = new ArrayList<>();
    public  FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        //Conect data base

        db.collection("usuarios")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("Usuarios", document.getId() + " => " + document.getData());
                                Usuario usuario= document.toObject(Usuario.class);
                                listaUsuarios.add(usuario);
                                EnviarUsuariosRecyclerView(listaUsuarios);
                            }
                        } else {
                            Log.w("Erorrrrr", "Error getting documents.", task.getException());
                        }
                    }
                });
        //Barra navegacion
        BottomNavigationView navBar = findViewById(R.id.btnBarraNav);

        //Configuracion de barra de navegacion, rutas
        navBar.setSelectedItemId(R.id.PerfilActivity);
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

   public void EnviarUsuariosRecyclerView(List<Usuario> misUsuarios){
        RecyclerView myRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerView_perfil);
        AdapterUsuario MyAdapter = new AdapterUsuario(this,misUsuarios);
        myRecyclerView.setLayoutManager(new GridLayoutManager(this,1));
        myRecyclerView.setAdapter(MyAdapter);
    }



}
