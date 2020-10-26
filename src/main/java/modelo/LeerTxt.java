package modelo;

import java.io.FileReader;

public class LeerTxt {
	private String contenido = " ";
	final String ruta = ".//ficheros//Libros.txt";

	public String leertxt(FileReader file) {

		try {
			file = new FileReader(ruta);
			int valor = file.read();
			while (valor != -1) {
				valor = file.read();
				if (valor == 10) {
					valor = 32;
					contenido += (char) valor;
				} else
					contenido += (char) valor;
			}
			contenido = contenido.substring(0, contenido.length() - 1);
			file.close();
		} catch (Exception e) {
			new ControlExcepciones("Excepci�n de Entrada/Salida" + e.getMessage());
			System.out.println("Excepci�n de Entrada/Salida" + e.getMessage());
		}

		return contenido;
	}

}
