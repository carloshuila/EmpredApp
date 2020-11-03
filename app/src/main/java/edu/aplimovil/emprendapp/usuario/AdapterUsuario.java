package edu.aplimovil.emprendapp.usuario;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import edu.aplimovil.emprendapp.R;
import edu.aplimovil.emprendapp.postres.AdapterPostres;
import edu.aplimovil.emprendapp.postres.Postre;
import edu.aplimovil.emprendapp.postres.PostreConectActivity;

public class AdapterUsuario  {

   /* private Context micontext;
    private List<Usuario> listaUsuarios;
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    public AdapterUsuario(Context micontext, List<Usuario> listaUsuarios) {
        this.micontext = micontext;
        this.listaUsuarios = listaUsuarios;
    }

    @Override
    public AdapterUsuario.MyViewHolder onCreateViewHolder(@NonNull ViewGroup miparent, int viewType) {

        View miview;
        LayoutInflater minflater = LayoutInflater.from(micontext);
        miview = minflater.inflate(R.layout.cardview_item_postres,miparent,false);
        return new AdapterPostres.MyViewHolder(miview);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPostres.MyViewHolder holder, final int position) {

        holder.nombrePostre.setText((listapostres.get(position).getNombre()));
        Glide.with(micontext).load(listapostres.get(position).getImagen()).into(holder.imgPostre);

        final Postre postre = listapostres.get(position);

        //Agregar click Listener
        holder.cardViewPostre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(micontext, PostreConectActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Postre", postre);

                //pasamos el objeto a la activity
                intent.putExtras(bundle);

                //Iniciamos la Activity
                micontext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listapostres.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nombrePostre;
        ImageView imgPostre;
        CardView cardViewPostre;
        CardView cardViewEliminar;

        public MyViewHolder(View itemView){
            super(itemView);

            nombrePostre = (TextView) itemView.findViewById(R.id.id_postre_nombre);
            imgPostre  = (ImageView) itemView.findViewById(R.id.id_postre_img);
            cardViewPostre = (CardView) itemView.findViewById(R.id.id_cardViewPostre);
            cardViewEliminar = (CardView) itemView.findViewById(R.id.id_cardViewEliminar);
        }
    }*/
}
