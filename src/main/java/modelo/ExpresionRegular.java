package modelo;
import java.util.StringTokenizer;

public class ExpresionRegular {
    private static String alfabeto[] = { "a", "b", "*" };
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
			+ numCoincidencias); // Para visualizar algoritmo
					     // en la palabra)

	    }
	}
	System.out.println("\n" + numCoincidencias + " coincidencias encontradas en " + numPalabras + " palabras.");
    }

    private static void encontrarCoincidenciasParciales(String expresion, String texto) {
	int numCoincidencias = 0;
	int numPalabras;
	int posicion = 1;
	StringTokenizer token;
	String palabra;
	String caracteres = "";
//	boolean hayPalabra;
	boolean encontrada = false;

	System.out.println("1 -->" + expresion);
	for (int z = 0; z < expresion.length(); z++) { // Recorre los caracteres de la expresión
	    if (Character.toString(expresion.charAt(z)).contentEquals("*"))
		;
	    else
		caracteres += expresion.charAt(z);
	}
	System.out.println("2 -->" + caracteres);
	expresion = caracteres;
	System.out.println("\nbuscando ...\n");
	token = new StringTokenizer(texto);
	numPalabras = token.countTokens();
	while (token.hasMoreTokens()) { // Recorro cada palabra del texto
	    palabra = token.nextToken();
//	    hayPalabra = true;
	    if (expresion == "")
		numCoincidencias = numPalabras;
	    else if (palabra.contains(expresion)) {// Busco la expresión en la palabra
		encontrada = false;
		for (int x = 0; x < palabra.length() && !encontrada; x++) {// Recorre la palabra hasta la coincidencia y
									   // guarda la posición para cortar la palabra
		    if (palabra.charAt(x) == expresion.charAt(0)) {
			posicion = x + 1;
			encontrada = true;
		    }
		}
		numCoincidencias += 1;
		System.out.println("Palabra: " + palabra + " posicion --> " + posicion + " Contador coincidencias: "
			+ numCoincidencias); // Para visualizar algoritmo
//		if (posicion == palabra.length())// En caso de que la coincidencia sea en la última posición, no queda
//						 // palabra
//		    hayPalabra = false;
//		else
//		    palabra = palabra.substring(posicion); // Corta el String (por si aparece la expresión más de 1 vez
//							   // en la palabra)

	    }
	}
	System.out.println("\n" + numCoincidencias + " coincidencias encontradas en " + numPalabras + " palabras.");
    }

    public static void main(String[] args) {
	// Busca el primer string cuantas veces aparece en el segundo

	buscar("a*", "kajhhkjs aba hfkdskhfab nmh ab");

    }

}