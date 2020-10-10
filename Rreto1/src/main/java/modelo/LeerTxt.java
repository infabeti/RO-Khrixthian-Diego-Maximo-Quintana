package modelo;

import java.io.*;

public class LeerTxt {

	public static String leertxt() {

		String contenido = "  ";
		String ruta = ".\\ficheros\\Libros.txt";
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
