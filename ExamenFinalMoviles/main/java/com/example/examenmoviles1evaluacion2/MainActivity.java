package com.example.examenmoviles1evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PeticionXML.ComunicacionPedirCamaras{
    Button btn_siguiente,btn_peticion,btn_anterior;
    ImageView img;
    TextView lbl_latitud2, lbl_longitud2;
    PeticionXML p1;
    List<Camara> lista_camaras;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_siguiente=findViewById(R.id.btn_siguiente);
        btn_anterior=findViewById(R.id.btn_anterior);
        btn_peticion=findViewById(R.id.btn_peticion);
        img=findViewById(R.id.img);
        lbl_latitud2=findViewById(R.id.lbl_latitud2);
        lbl_longitud2=findViewById(R.id.lbl_longitud2);
        p1=new PeticionXML(this);
        View.OnClickListener oyente=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1.pedirFotos();

            }
        };
        btn_peticion.setOnClickListener(oyente);
    }

    @Override
    public void mostrarDatos(RaizCamara r) {
        lista_camaras=r.getCamara();
        Picasso.with(context).setLoggingEnabled(true);
        Picasso.with(context).load("http://"+lista_camaras.get(0).getUrl()).into(img);

        lbl_latitud2.setText(lista_camaras.get(0).getPosicion().getLatitud());
        lbl_longitud2.setText(lista_camaras.get(0).getPosicion().getLongitud());
    }
}