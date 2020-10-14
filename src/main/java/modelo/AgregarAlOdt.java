package modelo;

import java.io.File;
import java.io.IOException;

import org.jopendocument.dom.text.TextDocument;

public class AgregarAlOdt {

	private String Dir = ".//ficheros//trabajadores.odt";
	private File archivo = new File(Dir);
	private TextDocument contenidoOdt;
	 
	public void EscribirOdt(String textoNuevo) {
		
		try {
			contenidoOdt = TextDocument.createEmpty(textoNuevo);

			contenidoOdt.saveAs(archivo);
			
		} catch (IOException e) {
			new ControlExcepciones("Excepción de Entrada/Salida" + e.getMessage());
			e.printStackTrace();
		}

		}
}
