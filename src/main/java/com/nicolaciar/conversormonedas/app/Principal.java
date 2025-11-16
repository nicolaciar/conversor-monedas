package com.nicolaciar.conversormonedas.app;

import com.nicolaciar.conversormonedas.externo.ConsultaAPIConversor;
import com.nicolaciar.conversormonedas.externo.Conversor;
import com.nicolaciar.conversormonedas.modelo.Divisa;
import com.nicolaciar.conversormonedas.servicios.Conversion;

public class Principal {
    public static void main(String[] args) {
        Divisa divisa1 = new Divisa("USD");
        Divisa divisa2 = new Divisa("ARS");
        double monto = 1;
        var api = new ConsultaAPIConversor();
        var conversor = new Conversion(api);
        System.out.println(conversor.convertir(divisa1,divisa2,monto));
    }
}
