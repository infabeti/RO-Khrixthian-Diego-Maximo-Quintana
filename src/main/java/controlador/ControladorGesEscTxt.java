package controlador;

import modelo.AgregarAlTxt;

public class ControladorGesEscTxt {

	private AgregarAlTxt agregarTxt;

	public ControladorGesEscTxt(AgregarAlTxt agregarTxt) {
		this.agregarTxt = agregarTxt;
	}

	public void gesEscTxt(String x) {

		agregarTxt.agregar(x);
	}

}