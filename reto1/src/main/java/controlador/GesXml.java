package controlador;

import javax.swing.DefaultListModel;

import modelo.LecturaXml;
import vista.VentanaConsultas;

public class GesXml {
	LecturaXml pelis = new LecturaXml();

	public DefaultListModel mostrarPeliculas() {

		return pelis.LecturaXml();
	}

}
