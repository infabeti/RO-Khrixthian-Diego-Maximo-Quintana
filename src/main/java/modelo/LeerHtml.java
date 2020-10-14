package modelo;

import java.io.*;

public class LeerHtml {

	private static String total = "";
	private static String cadena;
	private static String archivo;
	private static FileReader f = null;

	public String muestraContenido() {
		total ="";
		try {
			archivo = ".//ficheros//Usuarios.html"; 
			f = new FileReader(archivo);
		} catch (FileNotFoundException e) {
			new ControlExcepciones("Excepci�n de archivo no encontrado" + e.getMessage());
			System.out.println("No se ha podido encontrar el archivo. ERROR: " + e.toString());
		}

		BufferedReader b = new BufferedReader(f);

		try {
			while ((cadena = b.readLine()) != null) {
				total += cadena + "\n";
			}
		} catch (IOException e) {
			new ControlExcepciones("Excepci�n de Entrada/Salida" + e.getMessage());
			System.out.println("Excepci�n de Entrada/Salida" + e.getMessage());
		}

		try {
			b.close();
		} catch (IOException e) {
			new ControlExcepciones("Excepci�n de Entrada/Salida" + e.getMessage());
			System.out.println("Excepci�n de Entrada/Salida" + e.getMessage());
		}
	
		return total;
	}

}
