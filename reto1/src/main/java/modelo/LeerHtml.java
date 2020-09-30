package modelo;

import java.io.*;

public class LeerHtml {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String cadena = ("E:\\DESARROLLO DE APLICACIONES MULTIMEDIA\\2 ANYO\\ACCESO A DATOS\\RETO1\\RO-Khrixthian-Ibai-M-ximo\\reto1\\ficheros\\Usuarios.html");
		muestraContenido(cadena);

	}
	
	public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();
    }

}
