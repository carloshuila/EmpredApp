package edu.aplimovil.emprendapp.yogurt;

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
import edu.aplimovil.emprendapp.postres.Yogurt;
import edu.aplimovil.emprendapp.postres.PostreConectActivity;

public class AdapterYogurt extends RecyclerView.Adapter<AdapterYogurt.MyViewHolder> {

        private Context micontext;
        private List<Yogurt> listayogurt;
        FirebaseFirestore db = FirebaseFirestore.getInstance();


        public AdapterYogurt(Context micontext, List<Yogurt> listaYogurt) {
            this.micontext = micontext;
            listayogurt = listaYogurt;
        }

        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup miparent, int viewType) {

            View miview;
            LayoutInflater minflater = LayoutInflater.from(micontext);
            miview = minflater.inflate(R.layout.cardview_item_yogurt,miparent,false);
            return new MyViewHolder(miview);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

            holder.nombreYogurt.setText((listayogurt.get(position).getNombre()));
            Glide.with(micontext).load(listayogurt.get(position).getImagen()).into(holder.imgYogurt);

            final Yogurt yogurt = listayogurt.get(position);

            //Agregar click Listener
            holder.cardViewYogurt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(micontext, PostreConectActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Yogurt", yogurt);

                    //pasamos el objeto a la activity
                    intent.putExtras(bundle);

                    //Iniciamos la Activity
                    micontext.startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return listayogurt.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder{
            TextView nombreYogurt;
            ImageView imgYogurt;
            CardView cardViewYogurt;
            CardView cardViewEliminar;

            public MyViewHolder(View itemView){
                super(itemView);

                nombreYogurt = (TextView) itemView.findViewById(R.id.id_yogurt_nombre);
                imgYogurt = (ImageView) itemView.findViewById(R.id.id_yogurt_img);
                cardViewYogurt = (CardView) itemView.findViewById(R.id.id_cardViewYogurt);
                cardViewEliminar = (CardView) itemView.findViewById(R.id.id_cardViewEliminar);
            }
        }
}
