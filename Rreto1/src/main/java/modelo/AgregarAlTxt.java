package modelo;

import java.io.*;

public class AgregarAlTxt {
	
	public static boolean agregar(String resul){
		boolean correcto = true;
    try {
        FileWriter fstream = new FileWriter(".\\ficheros\\Libros.txt", true);
        BufferedWriter out = new BufferedWriter(fstream);
        
        out.write( "\n" + resul);
        out.close();
    } catch (IOException ex) {
        System.out.println("Error: "+ex.getMessage());
        correcto = false;
    }
    
    return correcto;
	}
}
