package com.example.examenmoviles1evaluacion2;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Camara", strict = false)
public class Camara {
    @Element(name = "Posicion", required = false)
    private Posicion posicion;
    @Element(name = "URL", required = false)
    private String url;

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Camara{" +
                "posicion=" + posicion +
                ", url='" + url + '\'' +
                '}';
    }
}
