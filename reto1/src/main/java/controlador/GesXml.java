package controlador;

import java.util.ArrayList;

import modelo.LecturaXml;
import vista.VentanaConsultas;

public class GesXml {
	
	public ArrayList mostrarPeliculas() {
		LecturaXml pelis = new LecturaXml();
		
		return pelis.getPeliculas();
	} 
}
