package controlador;

import modelo.AgregarAlDocx;
import modelo.AgregarAlHtml;
import vista.VentanaConsultas;

public class ControladorGesEscHtml {
	
	public void gesEscHtml(String textoDocx) {

		AgregarAlHtml escritor = new AgregarAlHtml();

		 escritor.agregar(textoDocx); 
	}
}
