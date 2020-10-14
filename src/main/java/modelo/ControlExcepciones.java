package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControlExcepciones {
	private File file = null;
	private BufferedWriter escritorBuffer = null;
	private FileWriter escritorArchivo = null;
	private Date fecha;
	private DateFormat formatoHora;
	private String hora;
	
	//Método que recibe la excepción y la añade al archivo .log, con su fecha
	public ControlExcepciones(String excepcion) {
		
		try {
			file = new File(".//ficheros//errores.log");
			// Si el archivo no existe, se crea!
			if (!file.exists()) {
				file.createNewFile();
			}
			// Cojo la fecha y le doy formato
			fecha = new Date();
			formatoHora = new SimpleDateFormat("HH:mm:ss dd/mm/yyyy");
		    hora = formatoHora.format(fecha);
			escritorArchivo = new FileWriter(file.getAbsoluteFile(), true); // Añado el append como true --> indica adjuntar información al archivo.
			escritorBuffer = new BufferedWriter(escritorArchivo);
			escritorBuffer.write(excepcion + " Hora --> " + hora + "\n");
			System.out.println("Excepción agregada al fichero .log!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// Cierra instancias del escritorArchivo y escritorBuffer
				if (escritorBuffer != null)
					escritorBuffer.close();
				if (escritorArchivo != null)
					escritorArchivo.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
