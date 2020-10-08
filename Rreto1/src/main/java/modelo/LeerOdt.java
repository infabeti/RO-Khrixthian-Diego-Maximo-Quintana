package modelo;

import java.io.FileReader;
import java.io.IOException;

public class LeerOdt {
	public static String LecturadOdt() {
		String contenidoOdt = "";
		try {
            FileReader entrada=new FileReader(".//ficheros//trabajadores.odt");

                int c=0;

                while(c!=-1) {
                    c=entrada.read();

                    char letra=(char)c;

                    contenidoOdt+=letra;
                }

                entrada.close();

        } catch (IOException e) {

            System.out.println("No se ha encontrado el archivo");
        }
		return contenidoOdt;
	}

}
