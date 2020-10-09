package controlador;

import modelo.LeerDocx;

public class ControladorGesDocx {
	private LeerDocx leerDocx;

	public String mostrarDocx() {

		leerDocx = new LeerDocx();

		return leerDocx.LecturaDocx();
	}
}
