package com.nicolaciar.conversormonedas.externo;

import com.nicolaciar.conversormonedas.modelo.Divisa;
import com.nicolaciar.conversormonedas.modelo.TasaDeCambio;

public interface Conversor {
    TasaDeCambio obtenerTasa(Divisa desde, Divisa hacia);
}
