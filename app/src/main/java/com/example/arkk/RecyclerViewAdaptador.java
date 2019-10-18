package com.example.arkk;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {
    private Context context;
    private static RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;

    public RecyclerViewAdaptador(List<razaVacas> listaRazas, @NonNull RecyclerViewOnItemClickListener
            recyclerViewOnItemClickListener) {
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
        this.listaRazas = listaRazas;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView raza, descri;
        private ImageView foto;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            raza = (TextView) itemView.findViewById(R.id.nombreRaza);
            descri = (TextView) itemView.findViewById(R.id.desc);
            foto = (ImageView) itemView.findViewById(R.id.imagenBrahma);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            recyclerViewOnItemClickListener.onClick(view, getAdapterPosition());

        }
    }



    public List<razaVacas> listaRazas;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.razas_vacas,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.raza.setText(listaRazas.get(position).getNombre());
        holder.descri.setText(listaRazas.get(position).getDescripcion());
        holder.foto.setImageResource(listaRazas.get(position).getFotoRaza());




    }

    public int getItemCount(){
        return listaRazas.size();
    }


}
