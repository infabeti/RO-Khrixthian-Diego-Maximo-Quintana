package modelo;

import java.io.*;

public class LeerTxt {
	private String contenido = "";

<<<<<<< HEAD:src/main/java/modelo/LeerTxt.java
	public String leertxt() {
		final String ruta = ".//ficheros//Libros.txt";
=======
	public static String leertxt() {

		String contenido = "  ";
		String ruta = ".\\ficheros\\Libros.txt";
>>>>>>> sprint2:Rreto1/src/main/java/modelo/LeerTxt.java
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
