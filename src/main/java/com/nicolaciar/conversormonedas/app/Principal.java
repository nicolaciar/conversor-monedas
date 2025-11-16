package com.nicolaciar.conversormonedas.app;

import com.nicolaciar.conversormonedas.externo.ConsultaAPIConversor;
import com.nicolaciar.conversormonedas.modelo.Divisa;
import com.nicolaciar.conversormonedas.servicios.Conversion;

import java.util.Locale;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        var consola = new Scanner(System.in);
        var menu = new Menu();
        var api = new ConsultaAPIConversor();
        var conversor = new Conversion(api);
        while (true) {
            menu.mostrar();
            String entradaOpcion = consola.nextLine();

            int opcion;

            // Validación robusta de la opción del menú
            try {
                opcion = Integer.parseInt(entradaOpcion);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número. Intente de nuevo.");
                continue; // vuelve al menú
            }

            if (opcion == 7) {
                break;
            }

            if (opcion < 1 || opcion > 7) {
                System.out.println("Opción fuera de rango. Intente nuevamente.");
                continue;
            }

            Divisa desde = null;
            Divisa hacia = null;

            switch (opcion) {
                case 1 -> { desde = Divisa.USD;  hacia = Divisa.ARS; }
                case 2 -> { desde = Divisa.ARS;  hacia = Divisa.USD; }
                case 3 -> { desde = Divisa.USD;  hacia = Divisa.BRL; }
                case 4 -> { desde = Divisa.BRL;  hacia = Divisa.USD; }
                case 5 -> { desde = Divisa.USD;  hacia = Divisa.COP; }
                case 6 -> { desde = Divisa.COP;  hacia = Divisa.USD; }
            }

            // Pedir monto de forma segura
            double monto;
            while (true) {
                System.out.print("Ingrese el monto que desea convertir: ");
                String entradaMonto = consola.nextLine();

                try {
                    monto = Double.parseDouble(entradaMonto);
                    if (monto <= 0) {
                        System.out.println("Debe ingresar un monto positivo.\n");
                        continue;
                    }
                    break; // monto válido
                } catch (NumberFormatException e) {
                    System.out.println("Monto inválido. Ingrese un número.\n");
                }
            }

            double conversion = conversor.convertir(desde, hacia, monto);
            System.out.println(
                    "\n"+ String.format(Locale.US, "%.2f", monto)
                            + " [" + desde.name() + "] equivalen a "
                            + String.format(Locale.US, "%.2f", conversion)
                            + " [" + hacia.name() + "]\n"
            );
        }
        System.out.println("\nGracias por usar nuestro servicio.");
    }
}

