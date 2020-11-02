package edu.aplimovil.emprendapp.postres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import edu.aplimovil.emprendapp.R;

public class PostreConectActivity extends AppCompatActivity {

    private TextView tvNombre, tvDescripcion,tvPrecio;
    private ImageView ivImagen;
    private Context micontext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postre);

        tvNombre = (TextView) findViewById(R.id.id_nombre_postre_Act);
        tvDescripcion = (TextView) findViewById(R.id.id_descripcion_Postre_Act);
        tvPrecio = (TextView) findViewById(R.id.id_precio_Postre_Act);
        ivImagen = (ImageView) findViewById(R.id.id_imagen_postre_Act);

        //Recibir datos
        Bundle postreEnviado = getIntent().getExtras();
        Postre postre = null;
        if (postreEnviado != null){
            postre = (Postre) postreEnviado.getSerializable("Postre");



            //Pasa los valores para mostrar
            tvNombre.setText(postre.getNombre().toString());
            tvDescripcion.setText(postre.getDescripcion().toString());
            tvPrecio.setText(String.valueOf(postre.getPrecio()));

            Glide.with(this).load(postre.getImagen()).into(ivImagen);


        }


    }
}