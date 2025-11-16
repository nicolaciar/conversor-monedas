package com.nicolaciar.conversormonedas.servicios;

import com.nicolaciar.conversormonedas.externo.Conversor;
import com.nicolaciar.conversormonedas.modelo.Divisa;
import com.nicolaciar.conversormonedas.modelo.TasaDeCambio;

public class Conversion {
    private final Conversor conversor;

    public Conversion(Conversor conversor) {
        this.conversor = conversor;
    }

    public double convertir(Divisa desde, Divisa hacia, double monto) {
        double tasa = Double.parseDouble(conversor.obtenerTasa(desde, hacia).tasaDeCambio());
        return monto * tasa;
    }
}