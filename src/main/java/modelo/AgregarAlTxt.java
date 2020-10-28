package modelo;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AgregarAlTxt {

	private FileWriter fstream;
	private BufferedWriter out;
	private FileReader aa;
	private String aux, ruta, nuevoFormateado = " ", auxorigen;
	LeerTxt aaa = new LeerTxt();

	public void agregar(String x) {

		try {

			String aux = formatFich(x);
			ruta = ".//ficheros//Libros.txt";
			fstream = new FileWriter(ruta);
			out = new BufferedWriter(fstream);

			out.write(aux);
			out.close();

		} catch (IOException ex) {
			new ControlExcepciones("Excepci�n de archivo no encontrado" + ex.getMessage());
		}
	}

	public String formatFich(String x) throws FileNotFoundException {
		ruta = ".//ficheros//Libros.txt";
		aa = new FileReader(ruta);
		auxorigen = aaa.leertxt(aa);

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
		return aux;
	}
}
