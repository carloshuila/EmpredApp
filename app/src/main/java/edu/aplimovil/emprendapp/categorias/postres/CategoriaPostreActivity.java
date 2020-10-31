package edu.aplimovil.emprendapp.categorias.postres;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import edu.aplimovil.emprendapp.R;

public class CategoriaPostreActivity extends AppCompatActivity {

    List<Postre> listaPostres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_postre);



        listaPostres = new ArrayList<>();
        listaPostres.add(new Postre("1", "Mora", "Postres", "Mora", "Postre Natural", "4000", R.drawable.postres));
        listaPostres.add(new Postre("2", "Piña", "Postres", "Mora1", "Postre Natural", "5500", R.drawable.queso));
        listaPostres.add(new Postre("3", "Lulo", "Postres", "Mora2", "Postre Natural", "6000", R.drawable.kumis));
        listaPostres.add(new Postre("4", "Mora", "Postres", "Mora3", "Postre Natural", "7000", R.drawable.yogurt));
        listaPostres.add(new Postre("1", "Mora", "Postres", "Mora4", "Postre Natural", "8000", R.drawable.postres));
        listaPostres.add(new Postre("2", "Mora", "Postres", "Mora5", "Postre Natural", "9000", R.drawable.queso));
        listaPostres.add(new Postre("3", "Mora", "Postres", "Mora6", "Postre Natural", "11000", R.drawable.kumis));
        listaPostres.add(new Postre("4", "Mora", "Postres", "Mora", "Postre Natural", "4500", R.drawable.yogurt));
        listaPostres.add(new Postre("1", "Mora", "Postres", "Mora", "Postre Natural", "45600", R.drawable.postres));
        listaPostres.add(new Postre("2", "Mora", "Postres", "Mora", "Postre Natural", "400780", R.drawable.queso));
        listaPostres.add(new Postre("3", "Mora", "Postres", "Mora", "Postre Natural", "400054", R.drawable.kumis));
        listaPostres.add(new Postre("4", "Mora", "Postres", "Mora", "Postre Natural", "400078", R.drawable.yogurt));

        RecyclerView myRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerView_postres);
        AdapterPostres MyAdapter = new AdapterPostres(this,listaPostres);
        myRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        myRecyclerView.setAdapter(MyAdapter);

    }
}