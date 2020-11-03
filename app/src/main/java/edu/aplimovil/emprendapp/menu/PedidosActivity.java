package edu.aplimovil.emprendapp.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import edu.aplimovil.emprendapp.R;
import edu.aplimovil.emprendapp.pedido.AdapterPedido;
import edu.aplimovil.emprendapp.pedido.Pedido;


public class PedidosActivity extends AppCompatActivity implements Serializable {



    List<Pedido> listaPedidos = new ArrayList<>();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private TextView tvTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        db.collection("pedidos")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int total= 0;
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("Pedidos", document.getId() + " => " + document.getData());
                                Pedido pedido = document.toObject(Pedido.class);

                                total = total+ pedido.getPrecioTotal();
                                tvTotal= (TextView) findViewById(R.id.totalPagar);



                                tvTotal.setText(String.valueOf(total));


                                listaPedidos.add(pedido);
                                EnviarListarRecyclerView(listaPedidos);

                            }
                        } else {
                            Log.w("Erorrrrr", "Error getting documents.", task.getException());
                        }
                    }
                });


        BottomNavigationView navBar = findViewById(R.id.btnBarraNav);
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

    public void  EnviarListarRecyclerView( List<Pedido> mispedidos){
        RecyclerView myRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerView_pedidos);
        AdapterPedido MyAdapter = new AdapterPedido(this,mispedidos);
        myRecyclerView.setLayoutManager(new GridLayoutManager(this,1));
        myRecyclerView.setAdapter(MyAdapter);
    }
}