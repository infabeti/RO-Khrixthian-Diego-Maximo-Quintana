package modelo;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ExpresionRegularMas {

		private static String alfabeto[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o",
				"p", "q", "r", "s", "t", "u", "v", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
				"L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "X", "Y", "Z", "á", "é", "í", "ó", "ú", "0",
				"1", "2", "3", "4", "4", "5", "6", "7", "8", "9", "<", ">", ",", "*", "+" };
		
	 	public static void buscar(String expresion, String texto) {
	    	
	 		if (!aceptarExpresion(expresion))
	 			System.out.println("\nExpresión NO aceptada. Algún carácter fuera del alfabeto");
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
	 		boolean encontradoSimbMas = false;
	    	
	 		for (int x = 0; x < expresion.length(); x++) { // Recorre los caracteres de la expresión
	 			if (Character.toString(expresion.charAt(x)).contentEquals("+"))
	 				encontradoSimbMas = true;
	 		}
	    	
	 		if (encontradoSimbMas == true) {
	 			encontrarSimbMas(expresion, texto);
	 		} else {
	 			System.out.println("NO SE HA ENCONTRADO EL CARACTER COMODIN.");
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
	    		if (palabras[i].contains(caracteres)) { // Busco la expresión en la palabra
					if (palabras[i].charAt(palabras[i].length() - 1) == ',') { //Si la palabra acaba en ",", se la quito
						palabras[i] = palabras[i].substring(0, palabras[i].length() - 1);
					}
					if (palabras[i].charAt(palabras[i].length() - 1) == '.') {//Si la palabra acaba en ".", se la quito
						palabras[i] = palabras[i].substring(0, palabras[i].length() - 1);
					}
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
	    		if (palabras[i].contains(expresion)) { // Busco la expresión en la palabra
					if (palabras[i].charAt(palabras[i].length() - 1) == ',') { //Si la palabra acaba en ",", se la quito
						palabras[i] = palabras[i].substring(0, palabras[i].length() - 1);
					}
					if (palabras[i].charAt(palabras[i].length() - 1) == '.') {//Si la palabra acaba en ".", se la quito
						palabras[i] = palabras[i].substring(0, palabras[i].length() - 1);
					}
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
						if (palabras[i].charAt(palabras[i].length() - 1) == ',') { //Si la palabra acaba en ",", se la quito
							palabras[i] = palabras[i].substring(0, palabras[i].length() - 1);
						}
						if (palabras[i].charAt(palabras[i].length() - 1) == '.') {//Si la palabra acaba en ".", se la quito
							palabras[i] = palabras[i].substring(0, palabras[i].length() - 1);
						}
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
	    	
	    	String texto = "9999, El Señor de los anillos, JR Tolkien, novela fantástica.\r\n"
	    			+ "8888, La columna de la muerte, Francisco Espinosa, ensayo histórico.\r\n"
	    			+ "7777, El enemigo conoce el sistema, Marta Peirano, ensayo sobre la aplicación capitalista de la informática.\r\n"
	    			+ "6666, El segundo sexo, Simone de lamer Beauvoir, ensayo sobre la opresión de la mujer. ";
	    	String expresionRegular = "";
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("Introduce la expresion regular para encontrar una palabra en el texto: \n\n" + texto);
	    	System.out.println("\nExpresion regular: ");
	    	expresionRegular = sc.nextLine();
	    	System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|");
	    	buscar(expresionRegular, texto);
	    	System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|");

	    }
	
}
