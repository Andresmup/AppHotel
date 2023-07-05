package com.alura.prueba;

import java.util.Arrays;
import java.util.Locale;

public class PruebaPaisesOrdenados {
    public static void main(String[] args) {

        String[] codigosPaises = Locale.getISOCountries();

        Locale[] locales = new Locale[codigosPaises.length];
        for (int i = 0; i < codigosPaises.length; i++) {
            locales[i] = new Locale("", codigosPaises[i]);
        }


        Arrays.sort(locales, (l1, l2) -> l1.getDisplayCountry().compareTo(l2.getDisplayCountry()));

        String[] paisesOrdenados = new String[locales.length];
        for (int i = 0; i < locales.length; i++) {
            paisesOrdenados[i] = locales[i].getDisplayCountry();
        }

        for (String pais : paisesOrdenados) {
            System.out.println(pais);
        }
    }
}
