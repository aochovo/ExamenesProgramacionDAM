package com.example.examenmoviles1evaluacion2;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "Camaras", strict=false)
public class RaizCamara {

    @ElementList(name="Camara", inline = true)
    private List<Camara> camara;


    public List<Camara> getCamara() {
        return camara;
    }

    public void setCamara(List<Camara> camara) {
        this.camara = camara;
    }

    @Override
    public String toString() {
        return "RaizCamara{" +
                "camara=" + camara +
                '}';
    }
}