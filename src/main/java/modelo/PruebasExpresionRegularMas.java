package modelo;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class PruebasExpresionRegularMas {

	private static String alfabeto[] = { "a", "b", "j", "k", "*", "+"};

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
	    		if (Character.toString(expresion.charAt(x)).contentEquals(alfabeto[y])) {
	    			encontrada = true;
	    		}
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
	    	encontrarSimbMas(expresion, texto);
	    } else {
	    	palabraSinRegex(expresion, texto);
	    }
	    	
	 }

	 private static void palabraSinRegex(String expresion, String texto) {
	    int numCoincidencias = 0;
	    int numPalabras;
	    int posicion = 1;
	    StringTokenizer token;
	    String palabra;

	    token = new StringTokenizer(texto);
	    numPalabras = token.countTokens();
	    	
	    while (token.hasMoreTokens()) {
	    	palabra = token.nextToken();
	    	if (palabra.contentEquals(expresion)) {
	    		numCoincidencias += 1;
	    		System.out.println("Palabra: " + palabra + " posicion --> " + posicion + " Contador coincidencias: " + numCoincidencias); 
	    	}
	    }
	    	
	    System.out.println("\n" + numCoincidencias + " coincidencias encontradas en " + numPalabras + " palabras.");
	    
	 }

	    private static void encontrarSimbMas(String expresion, String texto) {
	    	    	
	    	if(Character.toString(expresion.charAt(0)).contentEquals("+")) {
	    		simboloMasAlPrincipio(expresion, texto);
	    	} else if(Character.toString(expresion.charAt(expresion.length() -1)).contentEquals("+")) {
	    		simboloMasAlFinal(expresion, texto);
	    	} else {
	    		simboloMasEnMedio(expresion, texto);
	    	}
	    	
	    }
	    
	    private static void simboloMasAlFinal(String expresion, String texto) {
	    	int numCoincidencias = 0;
	    	int numPalabras;
	    	int posicion = 1;
	    	StringTokenizer token;
	    	String[] palabras;
	    	String caracteres = "";
	    	boolean estaAlPrincipio = false;
	    	
	    	System.out.println("1 -->" + expresion);
	    	
	    	for (int i = 0; i < expresion.length(); i++) {
	    		if (Character.toString(expresion.charAt(i)).contentEquals("+")) {
	    		} else {
	    			caracteres += expresion.charAt(i);
	    		}
	    	}
	    	
	    	System.out.println("2 -->" + caracteres);
	    	token = new StringTokenizer(texto);
	    	numPalabras = token.countTokens();
	    	palabras = new String[numPalabras];
	    	
	    	for(int i = 0; i < palabras.length-1; i++) {
	    		palabras[i] = token.nextToken();
	    		if (caracteres == "") {
	    			numCoincidencias = numPalabras;
	    		}else if (palabras[i].contains(caracteres)) { // Busco la expresión en la palabra
	    			for(int j = 0; j < caracteres.length(); j++) {
	    				if((palabras[i].charAt(0) == caracteres.charAt(0))) {
	    					if(palabras[i].equals(caracteres)){
	    						palabras[i] = " ";
	    					}
	    					posicion = i + 1;
	    					estaAlPrincipio = true;
	    				}else {
	    					estaAlPrincipio = false;
	    					posicion = 23;
	    				}
	    			}
	    			if(estaAlPrincipio == true) {
	    				numCoincidencias += 1;
	    				System.out.println("Palabra: " + palabras[i] + " posicion --> " + posicion + " Contador coincidencias: " + numCoincidencias);
	    			}
	    		}
	    	}
	    }
	    
	    private static void simboloMasAlPrincipio(String expresion, String texto) {
	    	int numCoincidencias = 0;
	    	int numPalabras;
	    	int posicion = 1;
	    	StringTokenizer token;
	    	String[] palabras;
	    	String caracteres = "";
	    	boolean estaAlFinal = false;
	    	
	    	System.out.println("1 -->" + expresion);
	    	
	    	for (int i = 0; i < expresion.length(); i++) { // Recorre los caracteres de la expresión
	    		if (Character.toString(expresion.charAt(i)).contentEquals("+")) {
	    		} else {
	    			caracteres += expresion.charAt(i);
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
	    		if (expresion == "") {
	    			numCoincidencias = numPalabras;
	    		}else if (palabras[i].contains(expresion)) { // Busco la expresión en la palabra
	    			for(int j = 0; j < expresion.length(); j++) {
	    				if((palabras[i].charAt(palabras[i].length() -1) == expresion.charAt(expresion.length() -1))) {
	    					if(palabras[i].equals(caracteres)){
	    						palabras[i] = " ";
	    					}
	    					posicion = i + 1;
	    					estaAlFinal = true;
	    				}else {
	    					estaAlFinal = false;
	    					posicion = 23;
	    				}
	    			}
	    			if(estaAlFinal == true) {
	    				numCoincidencias += 1;
	    				System.out.println("Palabra: " + palabras[i] + " posicion --> " + posicion + " Contador coincidencias: " + numCoincidencias);
	    			}
	    		}
	    	}
	    }
	    
	    public static void simboloMasEnMedio(String expresion, String texto) {
	    	int numCoincidencias = 0;
	    	int numPalabras;
	    	int posicion = 1;
	    	StringTokenizer token;
	    	String[] palabras;
	    	String expre1 = "", expre2 = "", caracteres = "";
	    	boolean estaEnMedio = false;
	    	
	    	System.out.println("1 -->" + expresion);
	    	
	    	for (int i = 0; i < expresion.length(); i++) {
	    		if (Character.toString(expresion.charAt(i)).contentEquals("+")) {
	    			expre1 = expresion.substring(0, i);
	    			expre2 = expresion.substring(i+1, expresion.length());
	    		} else {
	    			caracteres += expresion.charAt(i);
	    		}
	    	}
	    	System.out.println("Expresion 1 --> " + expre1 + ", Expresion 2 --> " + expre2);
	    	
	    	token = new StringTokenizer(texto);
	    	numPalabras = token.countTokens();
	    	palabras = new String[numPalabras];
	    		
	    	for(int i = 0; i < palabras.length-1; i++) {
	    		palabras[i] = token.nextToken();
	    		if (expre1 == "") {
	    			numCoincidencias = numPalabras;
	    		}else if (palabras[i].contains(expre1)) {
	    			for(int j = 0; j < expre1.length(); j++) {
	    				if((palabras[i].charAt(0) == expre1.charAt(0))) {
	    					if(palabras[i].equals(expre1)){
	    						palabras[i] = " ";
	    					}
	    					estaEnMedio = true;
	    				}else {
	    					estaEnMedio = false;
	    				}
	    			}
	    			
	    			if(palabras[i].contains(expre2) && estaEnMedio == true) {
	    				for(int k = 0; k < expre2.length(); k++) {
		    				if((palabras[i].charAt(palabras[i].length() -1) == expre2.charAt(expre2.length() -1))) {
		    					if(palabras[i].equals(expre2)){
		    						palabras[i] = " ";
		    					}
		    					posicion = i + 1;
		    					estaEnMedio = true;
		    				}else {
		    					estaEnMedio = false;
		    				}
		    			}
	    			}
	    			if(estaEnMedio == true) {
	    				numCoincidencias += 1;
	    				System.out.println("Palabra: " + palabras[i] + " posicion --> " + posicion + " Contador coincidencias: " + numCoincidencias);
	    			}
	    		}
	    	}
	    }

	    public static void main(String[] args) {

	    	buscar("ba+ab", "bahfhdsj hfhdfsjb badhfbahifab hikba ghfdhba ba ba ab");
	    	System.out.println("----------------------------------------------------------------------");
	    	String dniRegexp = "[a-z]+";
	    	System.out.println(Pattern.matches(dniRegexp, "79143299T"));
	    	System.out.println(Pattern.matches(dniRegexp, "h"));

	    }
	
}
