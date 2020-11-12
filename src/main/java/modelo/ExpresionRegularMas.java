package modelo;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ExpresionRegularMas {

		private static String alfabeto[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", 
											"m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "*", "+"};

	 	public static void buscar(String expresion, String texto) {
	    	
	    if (!aceptarExpresion(expresion))
	    	System.out.println("\nExpresi�n NO aceptada. Alg�n car�cter fuera del alfabeto");
	    else {
	    	evaluarExpresion(expresion, texto);
	    }
	    	
	 }

	 	public static boolean aceptarExpresion(String expresion) { 
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

	 	public static void evaluarExpresion(String expresion, String texto) {
	    boolean encontradoAsterisco = false;
	    	
	    for (int x = 0; x < expresion.length(); x++) { // Recorre los caracteres de la expresi�n
	    	if (Character.toString(expresion.charAt(x)).contentEquals("+"))
	    		encontradoAsterisco = true;
	    }
	    	
	    if (encontradoAsterisco) {
	    	encontrarSimbMas(expresion, texto);
	    } else {
	    	palabraSinRegex(expresion, texto);
	    }
	    	
	 }

	 	public static void palabraSinRegex(String expresion, String texto) {
	    StringTokenizer token;
	    String palabra;

	    token = new StringTokenizer(texto);
	    	
	    while (token.hasMoreTokens()) {
	    	palabra = token.nextToken();
	    	if (palabra.contentEquals(expresion)) {
	    		System.out.println("Palabra: " + palabra + " encontrada"); 
	    	}
	    }
	    
	 }

	    public static void encontrarSimbMas(String expresion, String texto) {
	    	    	
	    	if(Character.toString(expresion.charAt(0)).contentEquals("+")) {
	    		simboloMasAlPrincipio(expresion, texto);
	    	} else if(Character.toString(expresion.charAt(expresion.length() -1)).contentEquals("+")) {
	    		simboloMasAlFinal(expresion, texto);
	    	} else {
	    		simboloMasEnMedio(expresion, texto);
	    	}
	    	
	    }
	    
	    public static void simboloMasAlFinal(String expresion, String texto) {
	    	int numPalabras;
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
	    		if (palabras[i].contains(caracteres)) { // Busco la expresi�n en la palabra
	    			for(int j = 0; j < caracteres.length(); j++) {
	    				if((palabras[i].charAt(0) == caracteres.charAt(0))) {
	    					if(palabras[i].equals(caracteres)){
	    						palabras[i] = " ";
	    					}
	    					estaAlPrincipio = true;
	    				}else {
	    					estaAlPrincipio = false;
	    				}
	    			}
	    			if(estaAlPrincipio == true) {
	    				System.out.println("Palabra: " + palabras[i] + " encontrada");
	    			}
	    		}
	    	}
	    }
	    
	    public static void simboloMasAlPrincipio(String expresion, String texto) {
	    	int numPalabras;
	    	StringTokenizer token;
	    	String[] palabras;
	    	String caracteres = "";
	    	boolean estaAlFinal = false;
	    	
	    	System.out.println("1 -->" + expresion);
	    	
	    	for (int i = 0; i < expresion.length(); i++) { // Recorre los caracteres de la expresi�n
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
	    		if (palabras[i].contains(expresion)) { // Busco la expresi�n en la palabra
	    			for(int j = 0; j < expresion.length(); j++) {
	    				if((palabras[i].charAt(palabras[i].length() -1) == expresion.charAt(expresion.length() -1))) {
	    					if(palabras[i].equals(caracteres)){
	    						palabras[i] = " ";
	    					}
	    					estaAlFinal = true;
	    				}else {
	    					estaAlFinal = false;
	    				}
	    			}
	    			if(estaAlFinal == true) {
	    				System.out.println("Palabra: " + palabras[i] + " encontrada");
	    			}
	    		}
	    	}
	    }
	    
	    public static void simboloMasEnMedio(String expresion, String texto) {
	    	int numPalabras;
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
	    		if (palabras[i].contains(expre1)) {
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
		    					} else if(palabras[i].equals(expre1 + expre2)) {
		    						palabras[i] = " ";
		    					}
		    					estaEnMedio = true;
		    				}else {
		    					estaEnMedio = false;
		    				}
		    				
		    			}
	    				
	    				if(estaEnMedio == true) {
		    				System.out.println("Palabra: " + palabras[i] + " encontrada");
		    			}
	    			}
	    		}
	    	}
	    }

	    public static void main(String[] args) {
	    	String texto = "bahfhdsj hfhdfsjb badhfbahifab hjb abhfdhbab abababba abba hikba ghfdhba ba ba ab";
	    	String expresionRegular = "";
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("Introduce la expresion regular para encontrar una palabra en el texto: \n" + texto);
	    	System.out.print("Expresion regular: ");
	    	expresionRegular = sc.nextLine();
	    	System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|");
	    	buscar(expresionRegular, texto);
	    	System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|");

	    }
	
}
