package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AgregarAlOdt {
	
	public static boolean agregar(String resul){
		
		boolean correcto = true;
		
    try {
        FileWriter fstream = new FileWriter(".\\ficheros\\Trabajadores.odt", true);
        BufferedWriter out = new BufferedWriter(fstream);
        
        out.write( "\n" + resul);
        out.close();
    } catch (IOException ex) {
        System.out.println("Error: "+ex.getMessage());
        correcto = false;
    }
    
    return correcto;
	}
	
	public static void main(String[] args) {
		AgregarAlOdt.agregar("hola");
	}
}
