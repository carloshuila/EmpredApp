package edu.aplimovil.emprendapp.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import edu.aplimovil.emprendapp.R;
import edu.aplimovil.emprendapp.categorias.AdapterCategoria;
import edu.aplimovil.emprendapp.categorias.Categoria;
import edu.aplimovil.emprendapp.postres.AdapterPostres;
import edu.aplimovil.emprendapp.postres.Postre;
import edu.aplimovil.emprendapp.postres.PostreActivity;

import static edu.aplimovil.emprendapp.R.id.btnBarraNav;


public class MainActivity extends AppCompatActivity {

    public List<Categoria> listaCategorias = new ArrayList<>();
    public  FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Conect data base

        db.collection("categorias")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("Categoriasssss", document.getId() + " => " + document.getData());
                                Categoria categoria = document.toObject(Categoria.class);
                                listaCategorias.add(categoria);
                                EnviarListarRecyclerView(listaCategorias);
                            }
                        } else {
                            Log.w("Erorrrrr", "Error getting documents.", task.getException());
                        }
                    }
                });




        BottomNavigationView navBar = findViewById(btnBarraNav);

        navBar.setSelectedItemId(R.id.MainActivity);

        navBar.setOnNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.MainActivity:
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

    public void vercategorias(View view) {
        Intent intent = new Intent(this, PostreActivity.class);
        startActivity(intent);
    }


    public void  EnviarListarRecyclerView( List<Categoria> misCategorias){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView myRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerView_Categorias);
        myRecyclerView.setLayoutManager(layoutManager);
        AdapterCategoria MyAdapter = new AdapterCategoria(this,misCategorias);
        myRecyclerView.setAdapter(MyAdapter);
    }


}