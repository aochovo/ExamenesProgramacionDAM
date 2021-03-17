package com.example.examenmoviles1evaluacion2;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PeticionInterface {
    @GET("components/com_hotspots/datos/camaras.xml")
    Call<RaizCamara> getCamaras();
}
