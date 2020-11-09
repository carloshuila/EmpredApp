package edu.aplimovil.emprendapp.yogurt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import edu.aplimovil.emprendapp.R;
import edu.aplimovil.emprendapp.menu.MainActivity;
import edu.aplimovil.emprendapp.menu.PedidosActivity;
import edu.aplimovil.emprendapp.menu.PerfilActivity;
import edu.aplimovil.emprendapp.postres.Yogurt;

import static edu.aplimovil.emprendapp.R.id.btnBarraNav;

public class YogurtActivity extends AppCompatActivity {

    List<edu.aplimovil.emprendapp.postres.Yogurt> listaYogurt = new ArrayList<>();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_yogurt);


        //Barra navegacion
        BottomNavigationView navBar = findViewById(btnBarraNav);

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
        //Fin barra navegacion

        db.collection("yogurts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("Yogurts", document.getId() + " => " + document.getData());
                                edu.aplimovil.emprendapp.postres.Yogurt yogurt = document.toObject(edu.aplimovil.emprendapp.postres.Yogurt.class);
                                listaYogurt.add(yogurt);
                                EnviarListarRecyclerView(listaYogurt);
                            }
                        } else {
                            Log.w("Erorrrrr", "Error getting documents.", task.getException());
                        }
                    }
                });

    }
    public void  EnviarListarRecyclerView( List<Yogurt> misyogurts){
        RecyclerView myRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerView_yogurt);
        AdapterYogurt MyAdapter = new AdapterYogurt(this,misyogurts);
        myRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        myRecyclerView.setAdapter(MyAdapter);
    }
}