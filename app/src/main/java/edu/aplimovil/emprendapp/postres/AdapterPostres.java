package edu.aplimovil.emprendapp.postres;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import edu.aplimovil.emprendapp.R;

public class AdapterPostres extends RecyclerView.Adapter<AdapterPostres.MyViewHolder> {

        private Context micontext;
        private List<Postre> listapostres;

        public AdapterPostres(Context micontext, List<Postre> listaPostres) {
            this.micontext = micontext;
            listapostres = listaPostres;
        }

        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup miparent, int viewType) {

            View miview;
            LayoutInflater minflater = LayoutInflater.from(micontext);
            miview = minflater.inflate(R.layout.cardview_item_postres,miparent,false);
            return new MyViewHolder(miview);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

            holder.nombrePostre.setText((listapostres.get(position).getNombre()));
            Glide.with(micontext).load(listapostres.get(position).getImagen()).into(holder.imgPostre);

            //Agregar click Listener
            holder.cardViewPostre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(micontext, PostreConectActivity.class);

                    // Pasamos datos a la PostreActicity
                    intent.putExtra("Id", listapostres.get(position).getId());
                    intent.putExtra("Nombre", listapostres.get(position).getNombre());
                    intent.putExtra("Descripcion", listapostres.get(position).getDescripcion());
                    intent.putExtra("Precio", listapostres.get(position).getPrecio());
                    intent.putExtra("Imagen", listapostres.get(position).getImagen());

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

            public MyViewHolder(View itemView){
                super(itemView);

                nombrePostre = (TextView) itemView.findViewById(R.id.id_postre_nombre);
                imgPostre  = (ImageView) itemView.findViewById(R.id.id_postre_img);
                cardViewPostre = (CardView) itemView.findViewById(R.id.id_cardViewPostre);
            }
        }
}
