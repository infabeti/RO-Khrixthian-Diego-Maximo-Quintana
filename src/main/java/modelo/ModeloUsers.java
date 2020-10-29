package modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModeloUsers {
	private boolean validez;
	private static String regla;

	public boolean validarSoloAlfanumerico(String texto) {
		Pattern patron;
		Matcher matcher;

		regla = "^[a-zA-Z0-9]+$";

		patron = Pattern.compile(regla);
		matcher = patron.matcher(texto);

		validez = matcher.matches();
		return validez;
	}

}
