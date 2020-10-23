package modelo;

import java.io.FileReader;

public class LeerTxt {
	private String contenido = " ";

	public String leertxt(FileReader x) {
		String ruta = ".//ficheros//Libros.txt";

		try {
			x = new FileReader(ruta);
			int valor = x.read();
			while (valor != -1) {
				valor = x.read();
				if (valor == 10) {
					valor = 32;
					contenido += (char) valor;
				} else
					contenido += (char) valor;
			}
			contenido = contenido.substring(0, contenido.length() - 1);
			x.close();
		} catch (Exception e) {
			new ControlExcepciones("Excepci�n de Entrada/Salida" + e.getMessage());
			System.out.println("Excepci�n de Entrada/Salida" + e.getMessage());
		}

		return contenido;
	}

}
