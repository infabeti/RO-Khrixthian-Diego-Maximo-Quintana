package controlador;

import modelo.LeerDocx;

public class ControladorGesDocx {
	
	LeerDocx leerDocx = new LeerDocx();
	
	public String mostrarDocx() {

		return leerDocx.LecturaDocx();
	}
}
