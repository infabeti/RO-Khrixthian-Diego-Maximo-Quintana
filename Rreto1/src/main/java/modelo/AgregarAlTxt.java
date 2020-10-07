package modelo;

import java.io.*;

import vista.VentanaConsultas;

public class AgregarAlTxt {
	
	public static String agregar(){
		String resul= VentanaConsultas.textPane.getText();
		String fich = LeerTxt.leertxt();
		String resulfinal = fich + "\n" + resul;   
    
    return resulfinal;
	}
}
