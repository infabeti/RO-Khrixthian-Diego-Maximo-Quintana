package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AgregarAlTxt {
	
	public void agregar(String x){
		
		try {
			
			FileWriter fstream = new FileWriter(".//ficheros//Libros.txt");
			BufferedWriter out = new BufferedWriter(fstream);

			out.write(x);
			out.close();
			
		} catch (IOException ex) {
			new ControlExcepciones("Excepción de archivo no encontrado" + ex.getMessage());
		}
	}
}
