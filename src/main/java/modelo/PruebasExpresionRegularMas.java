package modelo;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class PruebasExpresionRegularMas {

	 private static String alfabeto[] = { "a", "b", "j", "k", "*", "+"};
	    // private static String operadores[] = { "*" };

	    private static void buscar(String expresion, String texto) {
	    	
	    	if (!aceptarExpresion(expresion))
	    		System.out.println("\nExpresión NO aceptada. Algún carácter fuera del alfabeto");
	    	else {
	    		evaluarExpresion(expresion, texto);
	    	}
	    	
	    }

	    private static boolean aceptarExpresion(String expresion) { 
	    	boolean encontrada, aceptada;

	    	aceptada = true;
	    	
	    	for (int x = 0; x < expresion.length() && aceptada; x++) {
	    		encontrada = false;
	    		
	    		for (int y = 0; y < alfabeto.length && !encontrada; y++) {
	    			if (Character.toString(expresion.charAt(x)).contentEquals(alfabeto[y]))
	    				encontrada = true;
	    		}
	    		
	    		if (!encontrada) {
	    			aceptada = false;
	    		}else {
	    			aceptada = true;
	    		}
	    	}
	    	return aceptada;
	    	
	    }

	    private static void evaluarExpresion(String expresion, String texto) {
	    	boolean encontradoAsterisco = false;
	    	
	    	for (int x = 0; x < expresion.length(); x++) { // Recorre los caracteres de la expresión
	    		if (Character.toString(expresion.charAt(x)).contentEquals("+"))
	    			encontradoAsterisco = true;
	    	}
	    	
	    	if (encontradoAsterisco) {
	    		simboloMasAlPrincipio(expresion, texto);
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

	    private static void simboloMasAlPrincipio(String expresion, String texto) {
	    	int numCoincidencias = 0;
	    	int numPalabras;
	    	int posicion = 1;
	    	StringTokenizer token;
	    	String[] palabras;
	    	String caracteres = "";
	    	boolean encontrado;
	    	
	    	System.out.println("1 -->" + expresion);
	    	
	    	for (int z = 0; z < expresion.length(); z++) { // Recorre los caracteres de la expresión
	    		if (Character.toString(expresion.charAt(z)).contentEquals("+")) {
	    		} else {
	    			caracteres += expresion.charAt(z);
	    		}
	    	}
	    	
	    	System.out.println("2 -->" + caracteres);
	    	expresion = caracteres;
	    	System.out.println("\nbuscando ...\n");
	    	token = new StringTokenizer(texto);
	    	numPalabras = token.countTokens();
	    	palabras = new String[numPalabras];
	    	
	    	for(int i = 0; i < palabras.length-1; i++) {
	    		palabras[i] = token.nextToken();
	    	}
	    	
	    	System.out.println("******* ARRAY PALABRAS *******");
	    	for(int j = 0; j < palabras.length -1; j++) {
	    		System.out.println("Palabra nº " + j + ": " + palabras[j]);
	    	}
	    	System.out.println("******* FIN ARRAY PALABRAS *******\n");
	    		
	    	for(int i = 0; i < palabras.length-1; i++) {
	    		if (expresion == "") {
	    			numCoincidencias = numPalabras;
	    		}else if (palabras[i].contains(expresion)) {// Busco la expresión en la palabra
	    			for(int y = 0; y < expresion.length(); y++) {
	    				if(palabras[i].charAt(palabras[i].length() -1) == expresion.charAt(expresion.length() -1)) {
	    					posicion = i + 1;
	    					//encontrado = true;
	    				}//else {
	    					//encontrado = false;
	    				//}
	    			}
	    			numCoincidencias += 1;
	    			System.out.println("Palabra: " + palabras[i] + " posicion --> " + posicion + " Contador coincidencias: " + numCoincidencias);
	    		}
	    	}
	    	
	    	if(numCoincidencias >= 2) {
	    		System.out.println("\n" + numCoincidencias + " coincidencias encontradas en " + numPalabras + " palabras.");
	    	} else if(numCoincidencias == 1){
	    		System.out.println("NO HAY MAS DE UNA REPETICICION");
	    	} else {
	    		System.out.println("NO HAY COINCIDENCIAS");
	    	}
	    	
	    }

	    public static void main(String[] args) {
		// Busca el primer string cuantas veces aparece en el segundo

	    	buscar("+ba", "fdfhsjdfba hfhdfsjb dhfbahif hikba ba ab");
	    	System.out.println("----------------------------------------------------------------------");
	    	String dniRegexp = "[a-z]+";
	    	System.out.println(Pattern.matches(dniRegexp, "79143299T"));
	    	System.out.println(Pattern.matches(dniRegexp, "h"));

	    }
	
}
