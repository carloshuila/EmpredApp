package edu.aplimovil.emprendapp.postres;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import edu.aplimovil.emprendapp.R;

public class PostreActivity extends AppCompatActivity {

    List<Postre> listaPostres = new ArrayList<>();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_postres);

        db.collection("postres")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("Postres", document.getId() + " => " + document.getData());
                                Postre postre = document.toObject(Postre.class);
                                listaPostres.add(postre);
                                EnviarListarRecyclerView(listaPostres);
                            }
                        } else {
                            Log.w("Erorrrrr", "Error getting documents.", task.getException());
                        }
                    }
                });

    }
    public void  EnviarListarRecyclerView( List<Postre> mispostres){
        RecyclerView myRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerView_postres);
        AdapterPostres MyAdapter = new AdapterPostres(this,mispostres);
        myRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        myRecyclerView.setAdapter(MyAdapter);
    }
}