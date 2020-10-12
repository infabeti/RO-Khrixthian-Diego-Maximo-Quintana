package controlador;

import modelo.AgregarAlHtml;
import vista.VentanaConsultas;

public class ControladorGesEscHtml {

	public void gesEscHtml() {

		AgregarAlHtml aux = new AgregarAlHtml();
		String textoHtml = VentanaConsultas.textPane.getText();
		aux.agregar(textoHtml); 
	}
}
