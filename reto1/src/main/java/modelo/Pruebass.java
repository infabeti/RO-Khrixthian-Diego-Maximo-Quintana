package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Pruebass {

public static void main(String[] args) throws IOException {
String ruta = "E:\\DESARROLLO DE APLICACIONES MULTIMEDIA\\2 ANYO\\ACCESO A DATOS\\reto1\\ficheros\\wordklase.docx";
	
	File archivodoc = new File(ruta);
		
		try {
			
			//FileWriter esc_fic = new FileWriter("E:\\DESARROLLO DE APLICACIONES MULTIMEDIA\\2 ANYO\\ACCESO A DATOS\\reto1\\ficheros\\wordklase.docx");
			//esc_fic.write("Esto es una prueba en gggggggg.docx \n");
			//esc_fic.write("2 linea de la prueba en ggggggggggg.docx");
			//esc_fic.close();
			
			//FileReader leer_fic = new FileReader("E:\\DESARROLLO DE APLICACIONES MULTIMEDIA\\2 ANYO\\ACCESO A DATOS\\reto1\\ficheros\\prueba0.pdf");
			//int valor = leer_fic.read();
			//while(valor != -1) {
				//System.out.print((char) valor);
				//valor = leer_fic.read();
			//}
	

	
	InputStream fis = new FileInputStream(archivodoc);
	InputStream entradaArch = fis; 
			
		}catch (IOException e) {
			System.out.println("Error E/S: " + e);
		}
		
		String texto = "entradaArch";
	
	
	}

}
