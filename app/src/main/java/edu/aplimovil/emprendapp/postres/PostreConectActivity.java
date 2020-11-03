package edu.aplimovil.emprendapp.postres;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.aplimovil.emprendapp.R;
import edu.aplimovil.emprendapp.pedido.Pedido;

public class PostreConectActivity extends AppCompatActivity {

    private TextView tvNombre, tvDescripcion,tvPrecio, tvTotal;
    private ImageView ivImagen;
    private Context micontext;
    private Button agregraCarrito;
    public ElegantNumberButton cantidad;


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Postre postre = null;
    public  String num;
    public  int cantidadTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postre);

        tvNombre = (TextView) findViewById(R.id.id_nombre_postre_Act);
        tvDescripcion = (TextView) findViewById(R.id.id_descripcion_Postre_Act);
        tvPrecio = (TextView) findViewById(R.id.id_precio_Postre_Act);
        ivImagen = (ImageView) findViewById(R.id.id_imagen_postre_Act);
        tvTotal = (TextView) findViewById(R.id.id_total);

        //Recibir datos
        Bundle postreEnviado = getIntent().getExtras();
        if (postreEnviado != null){
            postre = (Postre) postreEnviado.getSerializable("Postre");

            //Pasa los valores para mostrar
            tvNombre.setText(postre.getNombre().toString());
            tvDescripcion.setText(postre.getDescripcion().toString());
            tvPrecio.setText(String.valueOf(postre.getPrecio()));
            tvTotal.setText(String.valueOf(postre.getPrecio()));

            Glide.with(this).load(postre.getImagen()).into(ivImagen);

        }
      // Obteber cantidad seleccionada
        final ElegantNumberButton btnCantidad = (ElegantNumberButton) findViewById(R.id.btn_cantidad);
        btnCantidad.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                num= btnCantidad.getNumber();
                Log.d("Cantidaddd", num);
                cantidadTotal = (Integer.parseInt(num))*postre.getPrecio();
                Log.d("PRECIOO",String.valueOf (cantidadTotal));
                tvTotal.setText(String.valueOf(cantidadTotal));
            }
        });




    }







    public void agregarCarrito(View view) {



        // Create a new user with a first, middle, and last name
        Map<String, Object> Pedido = new HashMap<>();
        Pedido.put("id", postre.getId());
        Pedido.put("nombre", postre.getNombre());
        Pedido.put("precioTotal", cantidadTotal);
        Pedido.put("cantidad", Integer.parseInt(num));
        Pedido.put("imagen", postre.getImagen());

        // Add a new document with a generated ID
        db.collection("pedidos")
                .add(Pedido)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("Pedidos", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("ERRORRR", "Error adding document", e);
                    }
                });
    }
}