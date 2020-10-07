package modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModeloUsers {
	
	public boolean validarSoloAlfanumerico(String texto) {
		boolean validez;
		String regla = "^[a-zA-Z0-9]+$";
		
		Pattern patron = Pattern.compile(regla);
		Matcher matcher = patron.matcher(texto);
		
		validez = matcher.matches();
		return validez;
	}

}
