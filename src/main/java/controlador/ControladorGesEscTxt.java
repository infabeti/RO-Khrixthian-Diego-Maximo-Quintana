package controlador;

import modelo.AgregarAlTxt;
import vista.VentanaConsultas;

public class ControladorGesEscTxt {
	private AgregarAlTxt agregarTxt = new AgregarAlTxt();

	public void gesEscTxt() {

		AgregarAlTxt aux = new AgregarAlTxt();
		String testoTxt = VentanaConsultas.textPane.getText();
		aux.agregar(testoTxt);
	}
}
