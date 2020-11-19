package modelo;

public class ExpresionRegularPassword {
    static boolean aceptada = false;

    private static String alfabeto[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o",
	    "p", "q", "r", "s", "t", "u", "v", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
	    "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "X", "Y", "Z", "1", "2", "3", "4", "4", "5",
	    "6", "7", "8", "9" };

    public boolean buscar(String expresion, String texto) {

	if (!aceptarExpresion(expresion)) {
	    System.out.println("\nExpresión NO aceptada!");
	} else {
	    System.out.println("\nClave ACEPTADA!");
	}
	return aceptada;

    }

    private static boolean aceptarExpresion(String expresion) { // Aceptamos la expresión si todos sus caracteres están
	// en el alfabeto
	boolean encontrada;

	for (int x = 0; x < expresion.length() && aceptada; x++) { // Recorre los caracteres de la expresión
	    encontrada = false;
	    for (int y = 0; y < alfabeto.length && !encontrada; y++) { // Comprueba si el carácter pertenece al alfabeto

		if (Character.toString(expresion.charAt(x)).contentEquals(alfabeto[y]))
		    encontrada = true;
	    }
	    if (!encontrada)
		aceptada = false;
	    else
		aceptada = true;
	}

	return aceptada;
    }

}