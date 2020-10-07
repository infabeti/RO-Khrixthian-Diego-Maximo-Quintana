package modelo;

import java.io.*;

public class LeerHtml {

	public static String muestraContenido() {
		String total = "";
        String cadena;
        String archivo;
        FileReader f = null;
        
		try {
			archivo = "ficheros\\Usuarios.html";
			f = new FileReader(archivo);
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el archivo. ERROR: " + e.toString());
		}
		
        BufferedReader b = new BufferedReader(f);
        
        try {
			while((cadena = b.readLine())!=null) {
			    total += cadena + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        try {
			b.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return total;
    }

}
