package modelo;

import java.io.File;
import java.io.IOException;

import org.jopendocument.dom.text.TextDocument;

public class LeerOdt {
	private String contenidoOdt = "";
	// Obtengo el documento, a partir del Odt
	private static String Dir = ".//ficheros//trabajadores.odt";
	private static File archivo = new File(Dir);

	public String LecturadOdt() {

		try {
			// Cojo el contenido del documento
			contenidoOdt = TextDocument.createFromFile(archivo).getCharacterContent(true);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contenidoOdt;
	}

}
