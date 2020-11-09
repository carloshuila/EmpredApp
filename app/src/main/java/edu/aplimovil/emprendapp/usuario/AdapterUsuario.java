package edu.aplimovil.emprendapp.usuario;

import android.content.Context;
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

public class AdapterUsuario extends RecyclerView.Adapter<AdapterUsuario.MyViewHolder>  {

    private Context micontext;
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
        miview = minflater.inflate(R.layout.cardview_item_perfil,miparent,false);
        return new AdapterUsuario.MyViewHolder(miview);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterUsuario.MyViewHolder holder, final int position) {

        holder.nombreUsuario.setText((listaUsuarios.get(position).getNombre()));
        holder.apellidosUsuario.setText((listaUsuarios.get(position).getApellido()));
        holder.ciudadUsuario.setText((listaUsuarios.get(position).getCiudad()));
        holder.direccionUsuario.setText((listaUsuarios.get(position).getDireccion()));
        holder.emailUsuario.setText((listaUsuarios.get(position).getEmail()));

        Glide.with(micontext).load(listaUsuarios.get(position).getFoto()).into(holder.imgUsuario);

        final Usuario usuario = listaUsuarios.get(position);



    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nombreUsuario, apellidosUsuario, direccionUsuario, ciudadUsuario, emailUsuario;
        ImageView imgUsuario;
        CardView cardViewUsuario;

        public MyViewHolder(View itemView){
            super(itemView);

            nombreUsuario = (TextView) itemView.findViewById(R.id.id_usuario_nombre);
            apellidosUsuario = (TextView) itemView.findViewById(R.id.id_apellido);
            direccionUsuario = (TextView) itemView.findViewById(R.id.id_direccion);
            ciudadUsuario = (TextView) itemView.findViewById(R.id.id_ciudad);
            emailUsuario = (TextView) itemView.findViewById(R.id.id_email);
            imgUsuario  = (ImageView) itemView.findViewById(R.id.id_pelfil_img);
            cardViewUsuario = (CardView) itemView.findViewById(R.id.id_cardViewUsuario);
        }
    }
}
