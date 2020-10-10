package modelo;

import java.io.*;

public class LeerTxt {
	private String contenido = "";

	public String leertxt() {
		final String ruta = ".//ficheros//Libros.txt";
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
