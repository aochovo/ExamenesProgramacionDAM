package com.example.exameninterfacesfinal3.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.exameninterfacesfinal3.Contacto;
import com.example.exameninterfacesfinal3.R;

import java.sql.Array;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    static EditText et_nombre, et_telefono;
    static Button btn_grabar;
    static ProgressBar pb;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        et_nombre=root.findViewById(R.id.et_nombre);
        et_telefono=root.findViewById(R.id.et_telefono);
        btn_grabar=root.findViewById(R.id.btn_grabar);
        pb=root.findViewById(R.id.pb);
        final ArrayList<Contacto> lista=new ArrayList<>();
        btn_grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre=et_nombre.getText().toString();
                String telefono=et_telefono.getText().toString();
                Contacto c=new Contacto(nombre,telefono);
                lista.add(c);
                et_nombre.setText("");
                et_telefono.setText("");
                pb.setVisibility(View.VISIBLE);
            }
        });
        for(int j=0; j<20; j++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(j==19)
            {
                pb.setVisibility(View.INVISIBLE);
            }
        }



        return root;
    }

}