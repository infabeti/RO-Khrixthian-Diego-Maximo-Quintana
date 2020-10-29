package controlador;

import modelo.LeerOds;

public class ControladorGesOds {

	public String[][] mostrarOds(LeerOds leerOds) {

		leerOds = new LeerOds();
		
		return leerOds.LecturadOds();
	}
}
