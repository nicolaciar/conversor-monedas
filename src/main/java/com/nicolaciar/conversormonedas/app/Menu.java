package com.nicolaciar.conversormonedas.app;

public class Menu {

    public void mostrar(){
        String contenido = """
                 *************************************
                 Sea bienvenido/a al Conversor de Moneda =]
                 \s
                 1) Dólar ==> Peso argentino
                 2) Peso argentino ==> Dólar
                 3) Dólar ==> Real brasileño
                 4) Real brasileño ==> Dólar
                 5) Dólar ==> Peso colombiano
                 6) Peso colombiano ==> Dólar
                 7) Salir
                 Elija una opción válida:\s""";
        System.out.print(contenido);
    }
}
