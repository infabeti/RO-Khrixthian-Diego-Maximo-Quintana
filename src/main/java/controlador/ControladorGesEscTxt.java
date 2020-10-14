package controlador;

import modelo.AgregarAlTxt;

public class ControladorGesEscTxt {
	private AgregarAlTxt agregarTxt = new AgregarAlTxt();
	
	public void gesEscTxt(String x) {

		agregarTxt.agregar(x); 
	}
}
