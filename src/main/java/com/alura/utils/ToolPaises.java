package com.alura.utils;

import java.util.Arrays;
import java.util.Locale;

public class ToolPaises {
	
	
	public String[] GetPaisesOrdenados() {
		
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

	    return paisesOrdenados;
	}

}
