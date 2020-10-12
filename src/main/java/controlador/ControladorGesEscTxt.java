package controlador;

import modelo.AgregarAlTxt;

public class ControladorGesEscTxt {
	private AgregarAlTxt agregarTxt = new AgregarAlTxt();

	public String gesEscTxt() {

		return agregarTxt.agregar();
	}
}
