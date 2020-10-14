package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AgregarAlTxt {
	
	private FileWriter fstream;
	private BufferedWriter out;
	
	public void agregar(String x){
		
		try {
			fstream = new FileWriter(".//ficheros//Libros.txt");
			out = new BufferedWriter(fstream);

			out.write(x);
			out.close();
			
		} catch (IOException ex) {
			new ControlExcepciones("Excepción de archivo no encontrado" + ex.getMessage());
		}
	}
}
