package com.example.exameninterfacesfinal3.ui.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exameninterfacesfinal3.Contacto;
import com.example.exameninterfacesfinal3.R;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {
    static RecyclerView rv_vista;
    Context contexto;
    List<Contacto> lista;
    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        Contacto c1=new Contacto("Alex","674916704",R.drawable.cc);
        Contacto c2=new Contacto("Fakus","123456789",R.drawable.cc);
        Contacto c3=new Contacto("Luismi","987654321",R.drawable.cc);
        Contacto c4=new Contacto("Jose","654321987",R.drawable.cc);
        lista=new ArrayList<>();
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        lista.add(c4);
        rv_vista=root.findViewById(R.id.rv_vista);
        rv_vista.setHasFixedSize(true);
        rv_vista.setLayoutManager(new LinearLayoutManager(contexto));
        rv_vista.setAdapter(new MyAdaptador(lista, contexto));
        return root;
    }
}