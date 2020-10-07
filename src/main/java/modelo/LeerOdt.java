package modelo;

import java.io.File;
import java.io.IOException;

import org.jopendocument.dom.text.TextDocument;

public class LeerOdt {
	public static String LecturadOdt() {
		String contenidoOdt = "";

		// Obtengo el documento, a partir del Odt
		String Dir = ".//ficheros//trabajadores.odt";
		File archivo = new File(Dir);

		try {
			// Cojo el contenido del documento
			contenidoOdt = TextDocument.createFromFile(archivo).getCharacterContent(true);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contenidoOdt;
	}

}
