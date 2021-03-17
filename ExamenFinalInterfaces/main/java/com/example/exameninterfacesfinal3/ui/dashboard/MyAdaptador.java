package com.example.exameninterfacesfinal3.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exameninterfacesfinal3.Contacto;
import com.example.exameninterfacesfinal3.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdaptador  extends RecyclerView.Adapter<MyAdaptador.ViewHolder>{
    List<Contacto> lista;
    private Context contexto;

    public MyAdaptador(List<Contacto> lista, Context contexto) {

        this.lista=lista;
        this.contexto=contexto;

    }


    @NonNull
    @Override
    public MyAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_contactos,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_nombre.setText(lista.get(position).getNombre());
        holder.tv_telefono.setText(lista.get(position).getTelefono());
        holder.img.setImageResource(lista.get(position).getImg_contacto());
    }


    @Override
    public int getItemCount() {
        return   lista.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nombre;
        TextView tv_telefono;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nombre=itemView.findViewById(R.id.tv_nombre);
            tv_telefono=itemView.findViewById(R.id.tv_telefono);
            img=itemView.findViewById(R.id.img);

        }
    }
}
