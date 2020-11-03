package edu.aplimovil.emprendapp.pedido;

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


public class AdapterPedido extends RecyclerView.Adapter<AdapterPedido.MyViewHolder> {


    public Context micontext;
    public List<Pedido> listaPedidos;

    public AdapterPedido(Context micontext, List<Pedido> listaPedidos) {
        this.micontext = micontext;
        this.listaPedidos = listaPedidos;
    }

    @Override
    public AdapterPedido.MyViewHolder onCreateViewHolder(@NonNull ViewGroup miparent, int viewType) {

        View miview;
        LayoutInflater minflater = LayoutInflater.from(micontext);
        miview = minflater.inflate(R.layout.cardview_item_pedidos,miparent,false);
        return new AdapterPedido.MyViewHolder(miview);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPedido.MyViewHolder holder, final int position) {
        holder.nombrePedido.setText((listaPedidos.get(position).getNombre()));
        holder.precioTotal.setText((String.valueOf(listaPedidos.get(position).getPrecioTotal())));
        holder.cantidad.setText((String.valueOf(listaPedidos.get(position).getCantidad())));



        Glide.with(micontext).load(listaPedidos.get(position).getImagen()).into(holder.imgPedido);

        //Agregar click Listener
        holder.cardViewPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //--------Iniciamos la Activity

            }
        });

    }

    @Override
    public int getItemCount() {
        return listaPedidos.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nombrePedido;
        ImageView imgPedido;
        CardView cardViewPedido;
        TextView precioTotal;
        TextView cantidad;
        public MyViewHolder(View itemView){
            super(itemView);

            cardViewPedido= (CardView) itemView.findViewById(R.id.id_cardViewPedidos);
            imgPedido = (ImageView) itemView.findViewById(R.id.id_pedido_img);
            nombrePedido = (TextView) itemView.findViewById(R.id.id_pedido_nombre);
            precioTotal = (TextView) itemView.findViewById(R.id.id_pedidos_total);
            cantidad = (TextView) itemView.findViewById(R.id.id_pedido_cant);



        }
    }
}