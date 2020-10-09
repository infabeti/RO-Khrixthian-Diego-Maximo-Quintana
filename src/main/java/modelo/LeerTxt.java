package modelo;

import java.io.*;

public class LeerTxt {
	private static String contenido = "";
	private static String ruta = ".//ficheros//Libros.txt";
	
	public static String leertxt() {

		try {
			FileReader leerfic = new FileReader(ruta);
			int valor = leerfic.read();
			while (valor != -1) {
				valor = leerfic.read();
				contenido += (char) valor;
			}
			leerfic.close();

		} catch (Exception e) {
			System.out.println("Error E/S");
		}

		return contenido;
	}

}
