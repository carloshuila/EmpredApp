package edu.aplimovil.emprendapp.categorias.postres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import edu.aplimovil.emprendapp.R;

public class PostreActivity extends AppCompatActivity {

    private TextView tvNombre, tvDescripcion,tvPrecio;
    private ImageView ivImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postre);

        tvNombre = (TextView) findViewById(R.id.id_nombre_postre_Act);
        tvDescripcion = (TextView) findViewById(R.id.id_descripcion_Postre_Act);
        tvPrecio = (TextView) findViewById(R.id.id_precio_Postre_Act);
        ivImagen = (ImageView) findViewById(R.id.id_imagen_postre_Act);

        //Recibir datos
        Intent intent = getIntent();
        String nombre = intent.getExtras().getString("Nombre");
        String descripcion = intent.getExtras().getString("Descripcion");
        String precio = intent.getExtras().getString("Precio");
        int imagen = intent.getExtras().getInt("Imagen");

        //Modificams los valores
        tvNombre.setText(nombre);
        tvDescripcion.setText(descripcion);
        tvPrecio.setText(precio);
        ivImagen.setImageResource(imagen);
    }
}