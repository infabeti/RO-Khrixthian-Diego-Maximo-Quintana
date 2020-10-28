package controlador;

import modelo.LeerOds;

public class ControladorGesOds {
	private LeerOds leerOds;

	public String[][] mostrarOds() {

		leerOds = new LeerOds();
		
		return leerOds.LecturadOds();
	}
}
