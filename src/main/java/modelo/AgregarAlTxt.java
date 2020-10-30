package modelo;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AgregarAlTxt {

	private FileWriter fstream;
	private BufferedWriter out;
	private FileReader fr;
	private String aux, nuevoFormateado = " ", auxorigen;
	private LeerTxt contenidoFichTxt = new LeerTxt();
	private final String ruta = ".//ficheros//Libros.txt";

	public void agregar(String x) {

		try {

			fr = new FileReader(ruta);
			auxorigen = contenidoFichTxt.leertxt(fr);

			String nuevo = x.substring(auxorigen.length());

			for (int i = 0; i < nuevo.length(); i++) {

				if (nuevo.charAt(i) == 13) {
					nuevoFormateado += (char) 13;
					nuevoFormateado += (char) 32;
					System.out.println("entro en el if " + nuevoFormateado);

				} else if (nuevo.charAt(i) == 65535) {
					i += 1;

				} else {
					nuevoFormateado += nuevo.charAt(i);
				}

			}
			aux = auxorigen + nuevoFormateado;

			fstream = new FileWriter(ruta);
			out = new BufferedWriter(fstream);

			out.write(aux);
			out.close();

		} catch (IOException ex) {
			new ControlExcepciones("Excepci�n de archivo no encontrado" + ex.getMessage());
		}
	}
}
