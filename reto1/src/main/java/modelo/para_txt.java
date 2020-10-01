package modelo;

import java.io.*;
import java.util.*;

public class para_txt {

	public ArrayList leertxt() throws IOException {
	ArrayList array = new ArrayList();
	String contenido;
	String ruta = "E:\\DESARROLLO DE APLICACIONES MULTIMEDIA\\2 ANYO\\ACCESO A DATOS\\reto1\\ficheros\\txtprueba.txt";
	try {
		
		//FileWriter archivotxt =  new FileWriter(ruta);
		//archivotxt.write("esto es una prueba");
		//archivotxt.close();
		
		FileReader leerfic = new FileReader(ruta);
		int valor = leerfic.read();
		while(valor != -1) {
			System.out.print((char)valor);
			valor = leerfic.read();
			array.add(valor);
		}
		leerfic.close();
		
	}catch(Exception e) {
		System.out.println("Error E/S");
	}
	
	return array;	
	
	}

}
