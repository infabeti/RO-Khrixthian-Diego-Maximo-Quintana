package modelo;

import java.io.File;
import java.io.IOException;

import org.jopendocument.dom.text.TextDocument;

public class LeerOdt {
	private String contenidoOdt;
	private String contenidoOdtConSaltosDeLinea;
	// Obtengo el documento, a partir del Odt
	private static String Dir = ".//ficheros//trabajadores.odt";
	private static File archivo = new File(Dir);

	public String LecturadOdt() {
		contenidoOdt = "";
		contenidoOdtConSaltosDeLinea = "";

		try {
			// Cojo el contenido del documento
			contenidoOdt = TextDocument.createFromFile(archivo).getCharacterContent(true);

		} catch (IOException e) {
			new ControlExcepciones("Excepción de Entrada/Salida" + e.getMessage());
			System.out.println("Excepción de Entrada/Salida" + e.getMessage());
		}
		String contenidoLimpio = formatFich();
		return contenidoLimpio;
	}

	public String formatFich() {
		for (int x = 0; x < contenidoOdt.length(); x++) {
			if ((int) contenidoOdt.charAt(x) == 46) {
				contenidoOdtConSaltosDeLinea += contenidoOdt.charAt(x);
				contenidoOdtConSaltosDeLinea += (char) 10; // Salto de linea
				x++; // No acumulo el espacio en blanco que sigue al punto
			} else {
				contenidoOdtConSaltosDeLinea += contenidoOdt.charAt(x);
			}
		}
		System.out.println(contenidoOdtConSaltosDeLinea);
		return contenidoOdtConSaltosDeLinea;

	}

}
