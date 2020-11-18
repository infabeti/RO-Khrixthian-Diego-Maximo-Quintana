package modelo;

import java.awt.Color;
import java.util.StringTokenizer;

import vista.VentanaConsultas;

public class ExpresionRegular {
 //	private static boolean colorear=true;
	static boolean coincidencia = false;

	private static String alfabeto[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "�", "o",
			"p", "q", "r", "s", "t", "u", "v", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
			"L", "M", "N", "�", "O", "P", "Q", "R", "S", "T", "U", "V", "X", "Y", "Z", "�", "�", "�", "�", "�", "0",
			"1", "2", "3", "4", "4", "5", "6", "7", "8", "9", "<", ">", ",", "*", "+" };
	// private static String operadores[] = { "*" };
	
	public static boolean buscar(String expresion, String texto) {
//		VentanaConsultas v = new VentanaConsultas();
//		String textoPintado = "";
//		StringTokenizer cadaPalabra = new StringTokenizer(texto);
//		v.textPane.setText("");
//		while (cadaPalabra.hasMoreTokens()) { // Recorro cada palabra del texto
//
//			if (colorear) {
//				v.pintarCambios(VentanaConsultas.textPane, cadaPalabra.toString(), Color.MAGENTA);
//				textoPintado += cadaPalabra.toString() + " ";
//			} else
//				textoPintado += cadaPalabra + " ";
//			VentanaConsultas.textPane.setText(textoPintado);
//		}
		
		if (!aceptarExpresion(expresion)) {
			System.out.println("\nExpresi�n NO aceptada. Alg�n car�cter fuera del alfabeto");
		} else {
			evaluarExpresion(expresion, texto);
		}
		return coincidencia;

	}

	private static boolean aceptarExpresion(String expresion) { // Aceptamos la expresi�n si todos sus caracteres est�n
		// en el alfabeto
		boolean encontrada, aceptada;

		aceptada = true;
		for (int x = 0; x < expresion.length() && aceptada; x++) { // Recorre los caracteres de la expresi�n
			encontrada = false;
			for (int y = 0; y < alfabeto.length && !encontrada; y++) { // Comprueba si el car�cter pertenece al alfabeto

				if (Character.toString(expresion.charAt(x)).contentEquals(alfabeto[y]))
					encontrada = true;
//		System.out.println("Caracter de expresi�n = " + Character.toString(expresion.charAt(x))
//			+ " y en alfabeto = " + alfabeto[y] + " --> " + encontrada); // Para comprobar recorridos
			}
			if (!encontrada)
				aceptada = false;
			else
				aceptada = true;
		}

		return aceptada;
	}

	private static void evaluarExpresion(String expresion, String texto) {
		boolean encontradoAsterisco = false;
		for (int x = 0; x < expresion.length(); x++) { // Recorre los caracteres de la expresi�n
			if (Character.toString(expresion.charAt(x)).contentEquals("*"))
				encontradoAsterisco = true;
		}
		if (encontradoAsterisco) {
			encontrarCoincidenciasParciales(expresion, texto);
		} else {
			encontrarCoincidenciasTotales(expresion, texto);
		}
	}

	// Cuando no existe ning�n operador, s�lo caracteres
	private static void encontrarCoincidenciasTotales(String expresion, String texto) {
		int numCoincidencias = 0;
		int numPalabras;
		int posicion = 1;
		StringTokenizer token;
		String palabra;

		token = new StringTokenizer(texto);
		numPalabras = token.countTokens();
		while (token.hasMoreTokens()) { // Recorro cada palabra del texto
			palabra = token.nextToken();
			if (palabra.contentEquals(expresion)) {// Busco la expresi�n en la palabra

				numCoincidencias += 1;
				System.out.println("Palabra: " + palabra + " posicion --> " + posicion + " Contador coincidencias: "
						+ numCoincidencias); // Para visualizar algoritmo en la palabra)
			}
		}
		System.out.println("\n" + numCoincidencias + " coincidencias encontradas en " + numPalabras + " palabras.");
	}

	private static void encontrarCoincidenciasParciales(String expresion, String texto) {

		int pos = 0;
		String expresion1 = "", expresion2 = "";

		System.out.println("1 -->" + expresion);
		if (Character.toString(expresion.charAt(0)).contentEquals("*")) { // Quito el "*" si est� al principio y hago la
																			// b�squeda
			expresion = expresion.substring(1);
			System.out.println("2 -->" + expresion);
			asteriscoAlPrincipio(expresion, texto);
		} else if (Character.toString(expresion.charAt(expresion.length() - 1)).contentEquals("*")) { // Quito el "*" si
																										// est� al final
																										// y hago la
																										// b�squeda
			expresion = expresion.substring(0, expresion.length() - 1);
			System.out.println("2 -->" + expresion);
			asteriscoAlFinal(expresion, texto);
		} else { // Quito el "*" si est� por el medio de la palabra pero guardo su posicion
			for (int z = 1; z < expresion.length() - 1; z++) { // Recorre los caracteres de la expresi�n
				if (Character.toString(expresion.charAt(z)).contentEquals("*")) {
					pos = z;
					asteriscoEnMedio(expresion, pos, texto);
				}
			}
		}
	}

	public static void asteriscoAlFinal(String expresion, String texto) {
		int numCoincidencias = 0;
		int numPalabras;
		int posicion = 1;
		StringTokenizer token;
		String palabra;
		boolean encontrada = false;

		System.out.println("\nbuscando ...\n");
		token = new StringTokenizer(texto);
		numPalabras = token.countTokens();

		while (token.hasMoreTokens()) { // Recorro cada palabra del texto
			palabra = token.nextToken();
			if (expresion == "")
				numCoincidencias = numPalabras;
			else if (palabra.contains(expresion)) {// Busco la expresi�n en la palabra
				for (int x = 0; x < expresion.length(); x++) { // Me aseguro que la expresi�n est� al principio
					if (palabra.charAt(x) == expresion.charAt(x))
						encontrada = true;
					else
						encontrada = false;
				}
				if (encontrada) {
					numCoincidencias += 1;
					System.out.println("Palabra: " + palabra + " posicion --> " + posicion + " Contador coincidencias: "
							+ numCoincidencias); // Para visualizar algoritmo
					coincidencia = true;
				}
			}
		}
		if (numCoincidencias == 0)
			System.out.println("NINGUNA coincidencia encontrada");
	}

	public static void asteriscoAlPrincipio(String expresion, String texto) {
		int numCoincidencias = 0;
		int numPalabras;
		int posicion = 1;
		StringTokenizer token;
		String palabra;
		boolean encontrada = false;
		VentanaConsultas v = new VentanaConsultas();
		v.textPane.setText("");

		System.out.println("\nbuscando ...\n");
		token = new StringTokenizer(texto);
		numPalabras = token.countTokens();
		while (token.hasMoreTokens()) { // Recorro cada palabra del texto
			palabra = token.nextToken();
			if (expresion == "")
				numCoincidencias = numPalabras;
			else if (palabra.contains(expresion)) {// Busco la expresi�n en la palabra
				for (int x = 0; x < expresion.length(); x++) { // Me aseguro que la expresi�n est� al final
					if (palabra.charAt(palabra.length() - 1 - x) == expresion.charAt(expresion.length() - 1 - x))
						encontrada = true;
					else
						encontrada = false;
				}
				if (encontrada) {
//					colorear = true;
					// -------------------------------------------------------------------------------------------

					v.pintarCambios(VentanaConsultas.textPane, palabra, Color.MAGENTA);

					// --------------------------------------------------------------------------------------------
					numCoincidencias += 1;
					System.out.println("Palabra ENCONTRADA: " + palabra + " posicion --> " + posicion
							+ " Contador coincidencias: " + numCoincidencias); // Para visualizar algoritmo
					coincidencia = true;
				}
			}
		}
		if (numCoincidencias == 0)
			System.out.println("NINGUNA coincidencia encontrada");
	}

	public static void asteriscoEnMedio(String expresion, int pos, String texto) {
		int numCoincidencias = 0;
		int numPalabras;
		int posicion = 1;
		StringTokenizer token;
		String expresion1 = "";
		String expresion2 = "";
		String palabra = "";
		boolean encontrada = false;
		VentanaConsultas v = new VentanaConsultas();
		v.textPane.setText("");

		System.out.println("\nbuscando ...\n");
		token = new StringTokenizer(texto);
		numPalabras = token.countTokens();

		expresion1 = expresion.substring(0, pos);
		expresion2 = expresion.substring(pos + 1, expresion.length());
		System.out.println("Expresion 1 --> " + expresion1 + " - Expresion 2 --> " + expresion2);
		System.out.println(texto);
		System.out.println(coincidencia);

		while (token.hasMoreTokens()) { // Recorro cada palabra del texto
			palabra = token.nextToken();
			if (palabra.contains(expresion1)) {// Busco la expresi�n en la palabra
				for (int x = 0; x < expresion1.length(); x++) { // Me aseguro que la expresi�n est� al principio
					if (palabra.charAt(x) == expresion1.charAt(x)) {
//						encontrada = true;

						if (palabra.contains(expresion2)) {// Busco la expresi�n en la palabra
							if (palabra.charAt(palabra.length() - 1) == ',') {
								palabra = palabra.substring(0, palabra.length() - 1);
							}
							for (int y = 0; y < expresion2.length(); y++) { // Me aseguro que la expresi�n est� al final
								if (palabra.charAt(palabra.length() - 1 - y) == expresion2
										.charAt(expresion2.length() - 1 - y)) {
									encontrada = true;
									numCoincidencias += 1;

								} else
									encontrada = false;

							}
						}
					} else {
						encontrada = false;
						v.pintarCambios(VentanaConsultas.textPane, palabra, Color.DARK_GRAY);
					}
				}

			} else
				encontrada = false;

			if (encontrada) {
//				colorear = true;
				// -------------------------------------------------------------------------------------------

				v.pintarCambios(VentanaConsultas.textPane, palabra, Color.MAGENTA);

				// --------------------------------------------------------------------------------------------
				System.out.println("Palabra: " + palabra + " posicion --> " + posicion + " Contador coincidencias: "
						+ numCoincidencias); // Para visualizar algoritmo
				coincidencia = true;
			} else {
				encontrada = false;
				v.pintarCambios(VentanaConsultas.textPane, palabra + " ", Color.DARK_GRAY);
			}

		}

		if (numCoincidencias == 0) {
			System.out.println("NINGUNA coincidencia encontrada");
		}
		encontrada = false;
	}

}