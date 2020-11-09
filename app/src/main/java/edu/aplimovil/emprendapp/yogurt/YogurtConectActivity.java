package edu.aplimovil.emprendapp.yogurt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import edu.aplimovil.emprendapp.R;
import edu.aplimovil.emprendapp.menu.MainActivity;
import edu.aplimovil.emprendapp.menu.PedidosActivity;
import edu.aplimovil.emprendapp.menu.PerfilActivity;
import edu.aplimovil.emprendapp.postres.Yogurt;

import static android.widget.Toast.LENGTH_SHORT;
import static edu.aplimovil.emprendapp.R.id.btnBarraNav;

public class YogurtConectActivity extends AppCompatActivity {

    private TextView tvNombre, tvDescripcion,tvPrecio, tvTotal;
    private ImageView ivImagen;
    private Context micontext;
    private Button agregraCarrito;
    public ElegantNumberButton cantidad;
    private ImageButton btnAtras;


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Yogurt yogurt = null;
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


        //Barra superior
        //boton atras
        btnAtras = (ImageButton) findViewById(R.id.btnAtras);
        btnAtras.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            onBackPressed();
                                        }
                                    }
        );
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

        //Recibir datos
        Bundle yogurtEnviado = getIntent().getExtras();
        if (yogurtEnviado != null){
            yogurt = (Yogurt) yogurtEnviado.getSerializable("Yogurt");

            //Pasa los valores para mostrar
            tvNombre.setText(yogurt.getNombre().toString());
            tvDescripcion.setText(yogurt.getDescripcion().toString());
            tvPrecio.setText(String.valueOf(yogurt.getPrecio()));
            tvTotal.setText(String.valueOf(yogurt.getPrecio()));

            Glide.with(this).load(yogurt.getImagen()).into(ivImagen);

        }
      // Obteber cantidad seleccionada
        final ElegantNumberButton btnCantidad = (ElegantNumberButton) findViewById(R.id.btn_cantidad);
        btnCantidad.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                num= btnCantidad.getNumber();
                Log.d("Cantidaddd", num);
                cantidadTotal = (Integer.parseInt(num))*yogurt.getPrecio();
                Log.d("PRECIOO",String.valueOf (cantidadTotal));
                tvTotal.setText(String.valueOf(cantidadTotal));
            }
        });
    }


    public void agregarCarrito(View view) {
        Toast.makeText(this, "Se agrego un producto a tu pedido", LENGTH_SHORT).show();
        // Create a new user with a first, middle, and last name
        Map<String, Object> Pedido = new HashMap<>();
        Pedido.put("id", yogurt.getId());
        Pedido.put("nombre", yogurt.getNombre());
        Pedido.put("precioTotal", cantidadTotal);
        Pedido.put("cantidad", Integer.parseInt(num));
        Pedido.put("imagen", yogurt.getImagen());

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