package controlador;

import modelo.AgregarAlHtml;
import vista.VentanaConsultas;

public class ControladorGesEscHtml {
	private AgregarAlHtml aux = new AgregarAlHtml();
	private VentanaConsultas ventana = new VentanaConsultas();
	private String textoHtml;
	public void gesEscHtml() {

		textoHtml = ventana.textPane.getText();
		aux.agregar(textoHtml); 
	}
}
