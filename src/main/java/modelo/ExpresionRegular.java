package modelo;

import java.util.StringTokenizer;

public class ExpresionRegular {
	private static String alfabeto[] = { "a", "b", "*", "+" };
	// private static String operadores[] = { "*" };

	private static void buscar(String expresion, String texto) {
		if (!aceptarExpresion(expresion))
			System.out.println("\nExpresión NO aceptada. Algún carácter fuera del alfabeto");
		else {
			evaluarExpresion(expresion, texto);
		}

	}

	private static boolean aceptarExpresion(String expresion) { // Aceptamos la expresión si todos sus caracteres están
		// en el alfabeto
		boolean encontrada, aceptada;

		aceptada = true;
		for (int x = 0; x < expresion.length() && aceptada; x++) { // Recorre los caracteres de la expresión
			encontrada = false;
			for (int y = 0; y < alfabeto.length && !encontrada; y++) { // Comprueba si el carácter pertenece al alfabeto

				if (Character.toString(expresion.charAt(x)).contentEquals(alfabeto[y]))
					encontrada = true;
//		System.out.println("Caracter de expresión = " + Character.toString(expresion.charAt(x))
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
		for (int x = 0; x < expresion.length(); x++) { // Recorre los caracteres de la expresión
			if (Character.toString(expresion.charAt(x)).contentEquals("*"))
				encontradoAsterisco = true;
		}
		if (encontradoAsterisco) {
			encontrarCoincidenciasParciales(expresion, texto);
		} else {
			encontrarCoincidenciasTotales(expresion, texto);
		}
	}

	// Cuando no existe ningún operador, sólo caracteres
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
			if (palabra.contentEquals(expresion)) {// Busco la expresión en la palabra

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
		if (Character.toString(expresion.charAt(0)).contentEquals("*")) { // Quito el "*" si está al principio y hago la
																			// búsqueda
			expresion = expresion.substring(1);
			System.out.println("2 -->" + expresion);
			asteriscoAlPrincipio(expresion, texto);
		} else if (Character.toString(expresion.charAt(expresion.length() - 1)).contentEquals("*")) { // Quito el "*" si
																										// está al final
																										// y hago la
																										// búsqueda
			expresion = expresion.substring(0, expresion.length() - 1);
			System.out.println("2 -->" + expresion);
			asteriscoAlFinal(expresion, texto);
		} else { // Quito el "*" si está por el medio de la palabra pero guardo su posicion
			for (int z = 1; z < expresion.length() - 1; z++) { // Recorre los caracteres de la expresión
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
			else if (palabra.contains(expresion)) {// Busco la expresión en la palabra
				for (int x = 0; x < expresion.length(); x++) { // Me aseguro que la expresión esté al principio
					if (palabra.charAt(x) == expresion.charAt(x))
						encontrada = true;
					else
						encontrada = false;
				}
				if (encontrada) {
					numCoincidencias += 1;
					System.out.println("Palabra: " + palabra + " posicion --> " + posicion + " Contador coincidencias: "
							+ numCoincidencias); // Para visualizar algoritmo
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

		System.out.println("\nbuscando ...\n");
		token = new StringTokenizer(texto);
		numPalabras = token.countTokens();
		while (token.hasMoreTokens()) { // Recorro cada palabra del texto
			palabra = token.nextToken();
			if (expresion == "")
				numCoincidencias = numPalabras;
			else if (palabra.contains(expresion)) {// Busco la expresión en la palabra
				for (int x = 0; x < expresion.length(); x++) { // Me aseguro que la expresión esté al final
					if (palabra.charAt(palabra.length() - 1 - x) == expresion.charAt(expresion.length() - 1 - x))
						encontrada = true;
					else
						encontrada = false;
				}
				if (encontrada) {
					numCoincidencias += 1;
					System.out.println("Palabra ENCONTRADA: " + palabra + " posicion --> " + posicion
							+ " Contador coincidencias: " + numCoincidencias); // Para visualizar algoritmo
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
		String palabra;
		boolean encontrada = false;

		System.out.println("\nbuscando ...\n");
		token = new StringTokenizer(texto);
		numPalabras = token.countTokens();

		expresion1 = expresion.substring(0, pos);
		expresion2 = expresion.substring(pos + 1, expresion.length());
		System.out.println("Expresion 1 --> " + expresion1 + " - Expresion 2 --> " + expresion2);

		while (token.hasMoreTokens()) { // Recorro cada palabra del texto
			palabra = token.nextToken();
			if (expresion1 == "")
				numCoincidencias = numPalabras;
			else if (palabra.contains(expresion1)) {// Busco la expresión en la palabra
				for (int x = 0; x < expresion1.length(); x++) { // Me aseguro que la expresión esté al principio
					if (palabra.charAt(x) == expresion1.charAt(x))
						encontrada = true;
					else
						encontrada = false;
				}
				if (expresion2 == "")
					numCoincidencias = numPalabras;
				else if (palabra.contains(expresion2) && encontrada) {// Busco la expresión en la palabra
					for (int x = 0; x < expresion2.length(); x++) { // Me aseguro que la expresión esté al final

						if (palabra.charAt(palabra.length() - 1 - x) == expresion2.charAt(expresion2.length() - 1 - x))
							encontrada = true;
						else
							encontrada = false;
					}
				}
			}

			if (encontrada) {
				numCoincidencias += 1;
				System.out.println("Palabra: " + palabra + " posicion --> " + posicion + " Contador coincidencias: "
						+ numCoincidencias); // Para visualizar algoritmo
			}
			encontrada = false;
		}
		if (numCoincidencias == 0)
			System.out.println("NINGUNA coincidencia encontrada");

	}

	public static void main(String[] args) {
		// Busca el primer string cuantas veces aparece en el segundo

		buscar("bb*ba", "kajhhkjs aba bbjhgjhfdgabba bbfkdbaskhfa nmh ab");

	}
}