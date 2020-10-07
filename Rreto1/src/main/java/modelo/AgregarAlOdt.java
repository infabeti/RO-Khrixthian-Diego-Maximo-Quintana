package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import vista.VentanaConsultas;

public class AgregarAlOdt {
	
	public static String agregar(){
		
		String resul= VentanaConsultas.textPane.getText();
		String fich = LeerOdt.LecturadOdt();
		String resulfinal = fich + "\n" + resul;
	
    
    return resulfinal;
	}
}
