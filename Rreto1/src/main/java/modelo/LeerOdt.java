package modelo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.jopendocument.dom.text.TextDocument;

public class LeerOdt {
	public static String LecturadOdt() {
		String contenidoOdt = "";

		// Obtengo el documento, a partir del Odt
		//	String Dir = ".//ficheros//trabajadores.odt";
		//	File archivo = new File(Dir);

	//	try {
			// Cojo el contenido del documento
		//		contenidoOdt = TextDocument.createFromFile(archivo).getCharacterContent(true);
		
		//	} catch (IOException e) {
		//		e.printStackTrace();
			//	}
		
		//prueba que funciona
		try {
            FileReader entrada=new FileReader(".//ficheros//trabajadores.odt");

                int c=0;

                while(c!=-1) {
                    c=entrada.read();

                    char letra=(char)c;

                    contenidoOdt+=letra;
                }

                entrada.close();

                System.out.println(contenidoOdt);

        } catch (IOException e) {

            System.out.println("No se ha encontrado el archivo");
        }
		// fin prueba

		return contenidoOdt;
	}

}
