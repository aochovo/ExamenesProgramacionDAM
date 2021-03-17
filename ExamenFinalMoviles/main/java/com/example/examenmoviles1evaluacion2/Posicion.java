package com.example.examenmoviles1evaluacion2;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Posicion", strict = false)
public class Posicion {
    @Element(name = "Latitud", required = false)
    private String latitud;
    @Element(name = "Longitud", required = false)
    private String longitud;

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Posicion{" +
                "latitud='" + latitud + '\'' +
                ", longitud='" + longitud + '\'' +
                '}';
    }
}
