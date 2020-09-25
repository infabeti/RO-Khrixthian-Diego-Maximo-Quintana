package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class leer_todo_html {
	
	public  String html() throws IOException {
	    URL url = new URL("http://mail.ru");
	    URLConnection uc = url.openConnection();
	    uc.connect();
	    //Creamos el objeto con el que vamos a leer
	    BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
	    String inputLine;
	    String contenido = "";
	    while ((inputLine = in.readLine()) != null) {
	        contenido += inputLine + "\n";
	    }
	    in.close();
	    return contenido;
	}

}
