package com.example.examenmoviles1evaluacion2;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class PeticionXML {
    private static ComunicacionPedirCamaras clase_llamante;
    public PeticionXML(ComunicacionPedirCamaras clase_llamante) {
        this.clase_llamante = clase_llamante;
    }

    public static void pedirFotos()
    {
        //http://www.mc30.es/components/com_hotspots/datos/camaras.xml
        String base="http://www.mc30.es/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base).addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        PeticionInterface servicio=retrofit.create(PeticionInterface.class);
        Call<RaizCamara> llamada=servicio.getCamaras();
        llamada.enqueue(new Callback<RaizCamara>() {
            @Override
            public void onResponse(Call<RaizCamara> call, Response<RaizCamara> rspns) {
                RaizCamara camaras=rspns.body();
                Log.d("camara", camaras.toString());

                clase_llamante.mostrarDatos(camaras);

            }

            @Override
            public void onFailure(Call<RaizCamara> call, Throwable thrwbl) {
                System.out.println("ERROR: "+thrwbl.getLocalizedMessage());
            }
        });


    }
    public interface ComunicacionPedirCamaras{
        public void mostrarDatos(RaizCamara r);
    }
}
